import java.util.*;

public class ResultManager
{
	private boolean inputToggle;	// 엔터를 치지 않고 입력하는 것을 방지하기위한 토글
	private int extraInput;	// 줄바꾸기 하지 않고 추가 입력시
	private GenBuffer<Character> answerBuffer;				// 정답 문자들을 가진 버퍼
	private GenBuffer<Boolean> isCharMistypoBuffer;	// 모든 문자들의 오타 여부를 가진 버퍼
	private GenBuffer<Long> inputTimeBuffer;					// 모든 문자들의 최신 입력시간을 가진 버퍼
	private GenBuffer<Integer> inputBuffer;							// 사용자가 입력한 모든 입력정보를 가진 버퍼
	private GenBuffer<Integer> answerWordIndexBuffer;		// 정답 단어들의 마지막 글자 인덱스를 가진 버퍼
	private GenBuffer<Boolean> isCheckSpeedBuffer;		// 단어의 속도정보를 사용하는지 여부를 가진 버퍼
	private GenBuffer<Boolean> isWordMistypoBuffer;		// 단어가 정답인지 여부를 가진 버퍼
	private GenBuffer<Integer> wordMistypoNumBuffer;		// 단어에서 발생한 오타가 몇 개인지 체크하는 버퍼

	public ResultManager()
	{
	}
	public ResultManager(int length, Character[] answer, Integer[] word)
	{
		inputToggle = true;
		extraInput = 0;
		this.answerBuffer = new GenBuffer<Character>(length, answer);
		this.isCharMistypoBuffer = new GenBuffer<Boolean>(true, length);
		this.inputTimeBuffer = new GenBuffer<Long>((long)0, length);
		this.inputBuffer = new GenBuffer<Integer>(0,10000);
		this.answerWordIndexBuffer = new GenBuffer<Integer>(word.length, word);
		this.isCheckSpeedBuffer = new GenBuffer<Boolean>(true, word.length);
		this.isWordMistypoBuffer = new GenBuffer<Boolean>(true, word.length);
		this.wordMistypoNumBuffer = new GenBuffer<Integer>(0, word.length);
	}
	public void setInputToggle(boolean inputToggle)
	{
		this.inputToggle = inputToggle;
	}
	public boolean getInputToggle()
	{
		return this.inputToggle;
	}
	public boolean init(int length, Character[] answer, Integer[] word)
	{
		this.answerBuffer.init(answer.length, answer);
		Boolean[] data1 = new Boolean[answer.length];
		Arrays.fill(data1, true);
		this.isCharMistypoBuffer.init(answer.length, data1);
		Long[] data2 = new Long[answer.length];
		Arrays.fill(data2, 0);
		this.inputTimeBuffer.init(answer.length, data2);

		this.answerWordIndexBuffer.init(word.length, word);
		Boolean[] data3 = new Boolean[word.length];
		Arrays.fill(data3, true);
		this.isCheckSpeedBuffer.init(word.length, data3);
		Boolean[] data4 = new Boolean[word.length];
		Arrays.fill(data4, true);
		this.isWordMistypoBuffer.init(word.length, data4);
		Integer[] data5 = new Integer[word.length];
		Arrays.fill(data5, 0);
		this.wordMistypoNumBuffer.init(word.length, data5);
		return true;
	}
	public byte  saveTempResult(int input, long time)
	{
		switch(input)
		{
			case 8:		// 뒤로가기
					if(!this.inputToggle)	// 입력 토글이 false일 경우	 입력받지 않음
					{
						this.extraInput--;
						if(this.extraInput == 0)
							this.inputToggle = true;	// toggle을 true로
						break;
					}
					charIterPrev();
					byte wordMove = moveWordIter();
					if(wordMove == -1)	// 단어가 첫 문자를 지날 경우
					{	
						isWordMistypoBuffer.next();
						isWordMistypoBuffer.set(true);		// 단어 오타 체크 true로
						isWordMistypoBuffer.prev();
						isCheckSpeedBuffer.next();
						isCheckSpeedBuffer.set(true);
						isCheckSpeedBuffer.prev();
					}
					setWordMistype();
					System.out.println(isWordMistypoBuffer.get());
					break;
			case 10:		// 엔터
				if(!this.inputToggle) // 입력 토글이 false일 경우
				{
					this.inputToggle = true;
					this.extraInput  = 0;
					break;
				}
				int tempIter = answerBuffer.getIter();	// 임시 iter
				boolean check = false;
				while(tempIter <=  answerBuffer.getLength())
				{
					answerBuffer.next();
					if(answerBuffer.get() == '\n')
					{
						check = true;
						break;
					}
					tempIter++;
				}
				if(check) // 엔터가 발견되면 다음줄로 iterator 이동
				{
					setCharIter(tempIter+1);
				}

				break;
			case 32:		// 스페이스바
				break;
				default :	// 일반 문자 입력	
					if(!this.inputToggle)	// 입력 토글이 false일 경우	 입력받지 않음
					{
						this.extraInput++;
						break;
					}
					inputBuffer.add(input);	 // 내용기록
					if(!checkCharMistype(input))	// 입력한 단어가 틀린 경우
					{
						if(answerBuffer.getPrev() != null)
						{					
							if(answerBuffer.getPrev().equals('\n'))	// 줄 바꾸기를 하지 않은 경우
							{
								this.inputToggle = false;
								break;
							}
						}
					}
					inputTimeBuffer.add(time);	 // 시간기록
					setIsCharMistypoBuffer(checkCharMistype(input));	// 문자 오타여부 기록
					if(!checkCharMistype(input))	// 문자가 틀린 경우
					{
						if(isWordMistypoBuffer.get())		//단어체크여부가 true일 경우
						{
							isWordMistypoBuffer.set(false);		// 단어 오타 체크 false로
							wordMistypoNumBuffer.set(wordMistypoNumBuffer.get()+1);	// 오타수 1 증가
							System.out.println("걸림");
						}
						// 단어체크여부가 false일 경우 유지
						if(isCheckSpeedBuffer.get())	// 단어 속도 체크가 true일 경우
							isCheckSpeedBuffer.set(false);	// 단어속도체크 false
						// 단어속도체크여부가 false일 경우 유지
					}		
					charIterNext();
					moveWordIter();
					this.inputBuffer.next();
					break;
		}
		System.out.print("사용자 입력 문자 : ");
		System.out.println((char)(int)this.inputBuffer.getPrev());
		System.out.print("입력 시간 : ");
		System.out.println(this.inputTimeBuffer.getPrev());
		System.out.print("문자 오류 여부 : ");
		System.out.println(this.isCharMistypoBuffer.getPrev());
		System.out.print("문자 정답 index : ");
		System.out.println(this.answerWordIndexBuffer.get());
		System.out.print("속도 측정 여부 확인 : ");
		System.out.println(this.isCheckSpeedBuffer.get());
		System.out.print("단어 오타 여부 : ");
		System.out.println(this.isWordMistypoBuffer.get());
		System.out.print("오타수 : ");
		System.out.println(this.wordMistypoNumBuffer.get());
		System.out.print("오타 iter : ");
		System.out.println(this.wordMistypoNumBuffer.getIter());
		System.out.print("입력 토글 : ");
		System.out.println(this.inputToggle);

	//private GenBuffer<Integer> answerWordIndexBuffer;		// 정답 단어들의 마지막 글자 인덱스를 가진 버퍼
//	private GenBuffer<Boolean> isCheckSpeedBuffer;		// 단어의 속도정보를 사용하는지 여부를 가진 버퍼
//	private GenBuffer<Boolean> isWordMistypoBuffer;		// 단어가 정답인지 여부를 가진 버퍼
//	private GenBuffer<Integer> wordMistypoNumBuffer;		// 단어에서 발생한 오타가 몇 개인지 체크하는 버퍼

		return 1;
	}
	private byte setWordMistype()	// 현재 입력정보로 현재 단어의 오답 여부를 입력시킨다.
	{
		if(!this.answerWordIndexBuffer.hasPrev())	// 맨 앞 문자일 경우
		{
			return -1;
		}
		int prevIndex = this.answerWordIndexBuffer.getPrev();
		System.out.print("이전 index : ");
		System.out.println(this.answerWordIndexBuffer.getPrev());
		int index = this.answerBuffer.getIter();
		System.out.print("정답 iter : ");
		System.out.println(this.answerBuffer.getIter());
		for(int i = index ; i>prevIndex ; i--)
		{
			System.out.print(inputBuffer.get(i));
			if((int)answerBuffer.get(i) != inputBuffer.get(i))	 // 문자가 하나라도 다를 경우
			{

				isWordMistypoBuffer.set(false);
				return 0;
			}
		}
		System.out.println();
		isWordMistypoBuffer.set(true);
		return 1;
	}
	private byte setIsWordMistypoBuffer(boolean condition)
	{
		isWordMistypoBuffer.set(condition);
		return 1;
	}
	private byte setIsCharMistypoBuffer(boolean condition)
	{	
		isCharMistypoBuffer.set(condition);
		return 1;
	}

	private boolean checkCharMistype(int input)	 // 문자 입력 값이 맞는 문자인지 체크
	{
		char answer = answerBuffer.get();	 // 정답
		if((int)answer == input)
			return true;
		return false;
	}
	private byte moveWordIter()		// 문자 iter를 현재 정답문자buffer의 iter를 기준으로 조건체크후 이동 시키거나 유지한다.
	{
		switch(checkMoveWordIter())
		{
			case 1:	// 다음 단어로 이동
				wordIterNext();
				return 1;
			case -1:	// 이전 단어로 이동
				wordIterPrev();
				return -1;
			default : 
			case 0:	// 현재 단어 유지
				return 0;
				
		}
	}
	private byte checkMoveWordIter()	// 단어의 iterator를 이동해야 하는지 체크
	{
		int answerIter = answerBuffer.getIter();
		Integer wordData = answerWordIndexBuffer.get();
		Integer prevWordData = answerWordIndexBuffer.getPrev();
		if(answerWordIndexBuffer.getPrev() != null)	// 첫 문자가 아니고
		{
			if(prevWordData >= answerIter)	 // 이전 단어로 이동할 경우		
			return -1;
		}
		if(wordData < answerIter)	// 다음 단어로 이동할 경우
			return 1;
		else	// 현재 단어일 경우
			return 0;
	}
	private byte charIterNext()
	{
		answerBuffer.next();
		isCharMistypoBuffer.next();
		inputTimeBuffer.next();
		return 1;
	}
	private byte charIterPrev()
	{
		answerBuffer.prev();
		isCharMistypoBuffer.prev();
		inputTimeBuffer.next();
		return 1;
	}
	private void setCharIter(int index)
	{
		answerBuffer.setIter(index);
		isCharMistypoBuffer.setIter(index);
		inputTimeBuffer.setIter(index);
	}
	private byte wordIterNext()
	{
		this.answerWordIndexBuffer.next();
		this.isCheckSpeedBuffer.next();
		this.isWordMistypoBuffer.next();
		this.wordMistypoNumBuffer.next();
		return 1;
	}
	private byte wordIterPrev()
	{		
		this.answerWordIndexBuffer.prev();
		this.isCheckSpeedBuffer.prev();
		this.isWordMistypoBuffer.prev();
		this.wordMistypoNumBuffer.prev();
		return 1;
	}

}