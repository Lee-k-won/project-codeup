import java.util.*;

public class ResultManager
{
	private boolean inputToggle;	// ���͸� ġ�� �ʰ� �Է��ϴ� ���� �����ϱ����� ���
	private int extraInput;	// �ٹٲٱ� ���� �ʰ� �߰� �Է½�
	private GenBuffer<Character> answerBuffer;				// ���� ���ڵ��� ���� ����
	private GenBuffer<Boolean> isCharMistypoBuffer;	// ��� ���ڵ��� ��Ÿ ���θ� ���� ����
	private GenBuffer<Long> inputTimeBuffer;					// ��� ���ڵ��� �ֽ� �Է½ð��� ���� ����
	private GenBuffer<Integer> inputBuffer;							// ����ڰ� �Է��� ��� �Է������� ���� ����
	private GenBuffer<Integer> answerWordIndexBuffer;		// ���� �ܾ���� ������ ���� �ε����� ���� ����
	private GenBuffer<Boolean> isCheckSpeedBuffer;		// �ܾ��� �ӵ������� ����ϴ��� ���θ� ���� ����
	private GenBuffer<Boolean> isWordMistypoBuffer;		// �ܾ �������� ���θ� ���� ����
	private GenBuffer<Integer> wordMistypoNumBuffer;		// �ܾ�� �߻��� ��Ÿ�� �� ������ üũ�ϴ� ����

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
			case 8:		// �ڷΰ���
					if(!this.inputToggle)	// �Է� ����� false�� ���	 �Է¹��� ����
					{
						this.extraInput--;
						if(this.extraInput == 0)
							this.inputToggle = true;	// toggle�� true��
						break;
					}
					charIterPrev();
					byte wordMove = moveWordIter();
					if(wordMove == -1)	// �ܾ ù ���ڸ� ���� ���
					{	
						isWordMistypoBuffer.next();
						isWordMistypoBuffer.set(true);		// �ܾ� ��Ÿ üũ true��
						isWordMistypoBuffer.prev();
						isCheckSpeedBuffer.next();
						isCheckSpeedBuffer.set(true);
						isCheckSpeedBuffer.prev();
					}
					setWordMistype();
					System.out.println(isWordMistypoBuffer.get());
					break;
			case 10:		// ����
				if(!this.inputToggle) // �Է� ����� false�� ���
				{
					this.inputToggle = true;
					this.extraInput  = 0;
					break;
				}
				int tempIter = answerBuffer.getIter();	// �ӽ� iter
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
				if(check) // ���Ͱ� �߰ߵǸ� �����ٷ� iterator �̵�
				{
					setCharIter(tempIter+1);
				}

				break;
			case 32:		// �����̽���
				break;
				default :	// �Ϲ� ���� �Է�	
					if(!this.inputToggle)	// �Է� ����� false�� ���	 �Է¹��� ����
					{
						this.extraInput++;
						break;
					}
					inputBuffer.add(input);	 // ������
					if(!checkCharMistype(input))	// �Է��� �ܾ Ʋ�� ���
					{
						if(answerBuffer.getPrev() != null)
						{					
							if(answerBuffer.getPrev().equals('\n'))	// �� �ٲٱ⸦ ���� ���� ���
							{
								this.inputToggle = false;
								break;
							}
						}
					}
					inputTimeBuffer.add(time);	 // �ð����
					setIsCharMistypoBuffer(checkCharMistype(input));	// ���� ��Ÿ���� ���
					if(!checkCharMistype(input))	// ���ڰ� Ʋ�� ���
					{
						if(isWordMistypoBuffer.get())		//�ܾ�üũ���ΰ� true�� ���
						{
							isWordMistypoBuffer.set(false);		// �ܾ� ��Ÿ üũ false��
							wordMistypoNumBuffer.set(wordMistypoNumBuffer.get()+1);	// ��Ÿ�� 1 ����
							System.out.println("�ɸ�");
						}
						// �ܾ�üũ���ΰ� false�� ��� ����
						if(isCheckSpeedBuffer.get())	// �ܾ� �ӵ� üũ�� true�� ���
							isCheckSpeedBuffer.set(false);	// �ܾ�ӵ�üũ false
						// �ܾ�ӵ�üũ���ΰ� false�� ��� ����
					}		
					charIterNext();
					moveWordIter();
					this.inputBuffer.next();
					break;
		}
		System.out.print("����� �Է� ���� : ");
		System.out.println((char)(int)this.inputBuffer.getPrev());
		System.out.print("�Է� �ð� : ");
		System.out.println(this.inputTimeBuffer.getPrev());
		System.out.print("���� ���� ���� : ");
		System.out.println(this.isCharMistypoBuffer.getPrev());
		System.out.print("���� ���� index : ");
		System.out.println(this.answerWordIndexBuffer.get());
		System.out.print("�ӵ� ���� ���� Ȯ�� : ");
		System.out.println(this.isCheckSpeedBuffer.get());
		System.out.print("�ܾ� ��Ÿ ���� : ");
		System.out.println(this.isWordMistypoBuffer.get());
		System.out.print("��Ÿ�� : ");
		System.out.println(this.wordMistypoNumBuffer.get());
		System.out.print("��Ÿ iter : ");
		System.out.println(this.wordMistypoNumBuffer.getIter());
		System.out.print("�Է� ��� : ");
		System.out.println(this.inputToggle);

	//private GenBuffer<Integer> answerWordIndexBuffer;		// ���� �ܾ���� ������ ���� �ε����� ���� ����
//	private GenBuffer<Boolean> isCheckSpeedBuffer;		// �ܾ��� �ӵ������� ����ϴ��� ���θ� ���� ����
//	private GenBuffer<Boolean> isWordMistypoBuffer;		// �ܾ �������� ���θ� ���� ����
//	private GenBuffer<Integer> wordMistypoNumBuffer;		// �ܾ�� �߻��� ��Ÿ�� �� ������ üũ�ϴ� ����

		return 1;
	}
	private byte setWordMistype()	// ���� �Է������� ���� �ܾ��� ���� ���θ� �Է½�Ų��.
	{
		if(!this.answerWordIndexBuffer.hasPrev())	// �� �� ������ ���
		{
			return -1;
		}
		int prevIndex = this.answerWordIndexBuffer.getPrev();
		System.out.print("���� index : ");
		System.out.println(this.answerWordIndexBuffer.getPrev());
		int index = this.answerBuffer.getIter();
		System.out.print("���� iter : ");
		System.out.println(this.answerBuffer.getIter());
		for(int i = index ; i>prevIndex ; i--)
		{
			System.out.print(inputBuffer.get(i));
			if((int)answerBuffer.get(i) != inputBuffer.get(i))	 // ���ڰ� �ϳ��� �ٸ� ���
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

	private boolean checkCharMistype(int input)	 // ���� �Է� ���� �´� �������� üũ
	{
		char answer = answerBuffer.get();	 // ����
		if((int)answer == input)
			return true;
		return false;
	}
	private byte moveWordIter()		// ���� iter�� ���� ���乮��buffer�� iter�� �������� ����üũ�� �̵� ��Ű�ų� �����Ѵ�.
	{
		switch(checkMoveWordIter())
		{
			case 1:	// ���� �ܾ�� �̵�
				wordIterNext();
				return 1;
			case -1:	// ���� �ܾ�� �̵�
				wordIterPrev();
				return -1;
			default : 
			case 0:	// ���� �ܾ� ����
				return 0;
				
		}
	}
	private byte checkMoveWordIter()	// �ܾ��� iterator�� �̵��ؾ� �ϴ��� üũ
	{
		int answerIter = answerBuffer.getIter();
		Integer wordData = answerWordIndexBuffer.get();
		Integer prevWordData = answerWordIndexBuffer.getPrev();
		if(answerWordIndexBuffer.getPrev() != null)	// ù ���ڰ� �ƴϰ�
		{
			if(prevWordData >= answerIter)	 // ���� �ܾ�� �̵��� ���		
			return -1;
		}
		if(wordData < answerIter)	// ���� �ܾ�� �̵��� ���
			return 1;
		else	// ���� �ܾ��� ���
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