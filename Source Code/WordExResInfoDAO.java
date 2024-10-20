import java.util.*;
import java.io.*;
public class WordExResInfoDAO
{
	private ArrayList<WordExResInfo> wordExResInfoList;
	private static WordExResInfoDAO wordExResInfoDAO;
	private static int codeNum;

	static
	{
		/*ArrayList<WordExResInfo> test = new ArrayList<WordExResInfo>();
		ArrayList<Long> timeLog = new ArrayList<Long>();

		test.add(new WordExResInfo("12","word",100,50,timeLog));
		test.add(new WordExResInfo("23","file",150,30,timeLog));
		test.add(new WordExResInfo("34","qkqh",27,9,timeLog));
		test.add(new WordExResInfo("45","dlgl",1000,765,timeLog));
		test.add(new WordExResInfo("56","asdf",33,11,timeLog));

		wordExResInfoDAO = new WordExResInfoDAO(test);	*/
		wordExResInfoDAO=new WordExResInfoDAO();
	}

	private WordExResInfoDAO()
	{
		this.wordExResInfoList = new ArrayList<WordExResInfo>();
		loadWordExResInfoList();
	}
	
	private WordExResInfoDAO(ArrayList<WordExResInfo> wordExResInfoList)
	{
		if(wordExResInfoList == null)
		{
			this.wordExResInfoList = new ArrayList<WordExResInfo>();
		}
		else
		{
			this.wordExResInfoList = wordExResInfoList;
		}
		loadWordExResInfoList();

	}
	
	public static WordExResInfoDAO getInstance()
	{
		return wordExResInfoDAO;	
	}
	
	public ArrayList<WordExResInfo> getWordExResInfoList()
	{
		return this.wordExResInfoList;
	}
	
	public void setWordExResInfoList(ArrayList<WordExResInfo> wordExResInfoList)
	{
		if(wordExResInfoList == null)
		{
			this.wordExResInfoList = new ArrayList<WordExResInfo>();
		}
		else
		{
			this.wordExResInfoList = wordExResInfoList;
		}
	}
	/*
	public String genWordExResInfoCode()
	{
		
	}

	public WordExResInfoDAO searchWordExResInfo(String wordExResInfoCode)
	{
	
	}
	
	public WordExResInfoDAO searchWordExResInfo(String wordExContents)
	{
	
	}
	*/
	
	public byte addWordExResInfo(WordExResInfo wordExResInfo)
    {	
		if(wordExResInfoList!=null)
		{
			wordExResInfoList.add(wordExResInfo);
			return 1;
		}
		else return 0;
    }
	
	public byte addWordExResInfo(String wordExResInfoCode, String wordExContents, int totalInputNum, int totalMistypedNum, ArrayList<Long> timeLog)
    {
		if(wordExResInfoList==null){wordExResInfoList=new ArrayList<WordExResInfo>();}
		wordExResInfoList.add(new WordExResInfo(wordExResInfoCode,wordExContents,totalInputNum,totalMistypedNum,timeLog));
		return 1;
    }
	
	public byte addWordExResInfo(String wordExContents, int totalInputNum, int totalMistypedNum, ArrayList<Long> timeLog)
    {
		String wordExCode=genCode();
		if(wordExResInfoList==null){wordExResInfoList=new ArrayList<WordExResInfo>();}
		wordExResInfoList.add(new WordExResInfo(wordExCode,wordExContents,totalInputNum,totalMistypedNum,timeLog));
		return 1;
    }
	
	public byte modifyWordExResInfoCode(String wordExResInfoCode, String changeWordExResInfoCode)
    {
		if(wordExResInfoList==null){return 0;}
		int cnt=0;
		for(cnt=0;cnt<wordExResInfoList.size();cnt++)
		{
			if(wordExResInfoCode.equals(wordExResInfoList.get(cnt).getWordExResInfoCode()))
			{wordExResInfoList.get(cnt).setWordExResInfoCode(changeWordExResInfoCode);
			return 1;}
		}
		return 0;
    }
	
	public byte modifyWordExContents(String wordExResInfoCode, String wordExContents)
    {
		if(wordExResInfoList==null){return 0;}
		int cnt=0;
		for(cnt=0;cnt<wordExResInfoList.size();cnt++)
		{
			if(wordExResInfoCode.equals(wordExResInfoList.get(cnt).getWordExResInfoCode()))
			{wordExResInfoList.get(cnt).setWordExContents(wordExContents);
			return 1;}
		}
		return 0;
    }
	
	public byte modifyTotalInputNum(String wordExResInfoCode, int totalInputNum)
    {	
		if(wordExResInfoList==null){return 0;}
		int cnt=0;
		for(cnt=0;cnt<wordExResInfoList.size();cnt++)
		{
			if(wordExResInfoCode.equals(wordExResInfoList.get(cnt).getWordExResInfoCode()))
			{wordExResInfoList.get(cnt).setTotalInputNum(totalInputNum);
			return 1;}
		}
		return 0;
    }
	
	public byte modifyTotalMistypedNum(String wordExResInfoCode, int totalMistypedNum)
    {
		if(wordExResInfoList==null){return 0;}
		int cnt=0;
		for(cnt=0;cnt<wordExResInfoList.size();cnt++)
		{
			if(wordExResInfoCode.equals(wordExResInfoList.get(cnt).getWordExResInfoCode()))
			{wordExResInfoList.get(cnt).setTotalMistypedNum(totalMistypedNum);
			return 1;}
		}
		return 0;
    }
	
	 public byte modifyTimeLog(String wordExResInfoCode, ArrayList<Long> timeLog)
    {
		if(wordExResInfoList==null){return 0;}
		int cnt=0;
		for(cnt=0;cnt<wordExResInfoList.size();cnt++)
		{
			if(wordExResInfoCode.equals(wordExResInfoList.get(cnt).getWordExResInfoCode()))
			{wordExResInfoList.get(cnt).setTimeLog(timeLog);
			return 1;}
		}
		return 0;
    }
	
	public byte modifyWordExResInfoList(String wordExResInfoCode, WordExResInfo wordExResInfo)
    {
		if(wordExResInfoList==null){return 0;}
		int cnt=0;
		for(cnt=0;cnt<wordExResInfoList.size();cnt++)
		{
			if(wordExResInfoCode.equals(wordExResInfoList.get(cnt).getWordExResInfoCode()))
			{wordExResInfoList.set(cnt,wordExResInfo);
			return 1;}
		}
		return 0;
    }
	
	public byte deleteWordExResInfo(String wordExResInfoCode)
    {
		if(wordExResInfoList==null){return 0;}
		int cnt=0;
		for(cnt=0;cnt<wordExResInfoList.size();cnt++)
		{
			if(wordExResInfoCode.equals(wordExResInfoList.get(cnt).getWordExResInfoCode()))
			{
				wordExResInfoList.remove(cnt);
				return 1;}
		}
		return 0;
    }
	
	public byte deleteWordExResInfo(WordExResInfo wordExResInfo)
    {
		boolean success=wordExResInfoList.remove(wordExResInfo);
		if (success==true)return 1;
		else return 0;
    }
	
	public ArrayList<String> provideMistypedWords(int probability)
    {
		int cnt=0;
		ArrayList<String>mistypedWords=new ArrayList<String>();
		//String mistypedWord=null;
		for(cnt=0;cnt<wordExResInfoList.size();cnt++)
		{
			String mistypedWord=wordExResInfoList.get(cnt).provideMistypedWords(probability);
			if(mistypedWord !=null)
			{
				mistypedWords.add(mistypedWord);
			}
		}
		if(mistypedWords.size()!=0)return mistypedWords;
		else return null;
    }
	
	 public byte appendResult(String wordExContents, long timeLog, int mistypedNo, int inputNo)
    {
		
		int index=searchWordExInfo(wordExContents);
		if (index!=-1)
		{
			wordExResInfoList.get(index).appendResult(timeLog,mistypedNo,inputNo);
		}
		else{  
			ArrayList<Long>temp=new ArrayList<Long>();
			temp.add(timeLog);
			
			String wordExCode = genCode();
			wordExResInfoList.add(new WordExResInfo(wordExCode,wordExContents,inputNo,mistypedNo,temp));
		}

		return 1;    
    }
	
	public int searchWordExInfo(String wordExContents)
    {
		int cnt=0;
		if(wordExContents==null){return -1;}
		//if(wordExResInfoList==null){return -1;}
		for(cnt=0;cnt<wordExResInfoList.size();cnt++)
		{
			if(wordExContents.equals(wordExResInfoList.get(cnt).getWordExContents()))
			{
				return cnt;
			}	
		}
		return -1; 
    }
	

	public WordExResInfo searchWordExResInfo(String wordExResInfoCode)
	{
		Iterator<WordExResInfo> iter = this.wordExResInfoList.iterator();

		while(iter.hasNext())
		{
			WordExResInfo temp = iter.next();

			if(temp.getWordExResInfoCode().equals(wordExResInfoCode))
			{
				return temp;
			}
		}
		return null;
	}

	public String[][] provideSortinginfo()
	{
		Iterator<WordExResInfo> iter = this.wordExResInfoList.iterator();
		String[][] res = new String[this.wordExResInfoList.size()][2];
		
		int i = 0;
		while(iter.hasNext())
		{
			WordExResInfo temp = iter.next();

			res[i][0] = temp.getWordExResInfoCode();
			res[i][1] = temp.getLapseRateInfo();

			i++;
		}

		return res;
	}
	
	public String[] provideWordsAnalysisInfo()
	{
		String[] res = new String[2];
		int totalWords = 0;
		int totalChars = 0;

		Iterator<WordExResInfo> iter = this.wordExResInfoList.iterator();
		
		while(iter.hasNext())
		{
			WordExResInfo temp = iter.next();

			totalWords += (temp.getTotalInputNum()+temp.getTotalMistypedNum());
			totalChars += temp.getWordExContents().length() * (temp.getTotalInputNum()+temp.getTotalMistypedNum());
		}
		res[0] = totalWords+"";
		res[1] = totalChars+"";

		return res;
	}

	public String[][] provideRankingAnalysisInfo()
	{
		String[][] data = this.provideSortinginfo();
		
		return new WordSortCode(data).getSortingInfo();	
	}

	public String provideWordExContents(String wordExResInfoCode)
	{
		return this.searchWordExResInfo(wordExResInfoCode).getWordExContents();
	}


	class WordSortCode
	{
		private String[][] sortingInfo;

		public WordSortCode()
		{
		}
		
		public WordSortCode(String[][] sortingInfo)
		{
			this.sortingInfo = sortingInfo;
		}

		public String[][] getSortingInfo()
		{
			String[] temp;
			for(int i = 0 ; i < this.sortingInfo.length ; i++)
			{
				for(int j = i+1 ; j <this.sortingInfo.length ; j++)
				{
					if(Integer.parseInt(this.sortingInfo[i][1]) < Integer.parseInt(this.sortingInfo[j][1]))
					{
						 temp = this.sortingInfo[i];
						 this.sortingInfo[i] = this.sortingInfo[j];
						 this.sortingInfo[j] = temp;
					}
				}
			}

			for(int i = 0 ; i < this.sortingInfo.length ; i++)
			{
				this.sortingInfo[i][0] = provideWordExContents(this.sortingInfo[i][0]);
			}

			return this.sortingInfo;
		}
	}

	public byte saveWordExResInfoList()
    {
		ObjectOutputStream out=null;
		try{
			out=new ObjectOutputStream(new FileOutputStream("data/wordExResInfo.txt"));
			if(wordExResInfoList==null){return 0;}//실패

			for(int cnt=0;cnt<wordExResInfoList.size();cnt++)
			{
				out.writeObject(wordExResInfoList.get(cnt));
			}
		}
		catch(IOException e)
		{
			System.out.println("output실패");
		}
		finally{
			try{out.close();}
			catch(Exception e){}
		}
		return 1;//성공
	}


	
    
    public ArrayList<WordExResInfo> loadWordExResInfoList()///////////////////////////////////
    {
		ObjectInputStream in=null;

		try{
			in=new ObjectInputStream(new FileInputStream("data/wordExResInfo.txt"));
			WordExResInfo obj=null;
			while(true)
			{
				obj=(WordExResInfo)in.readObject();
				if(wordExResInfoList==null){wordExResInfoList=new ArrayList<WordExResInfo>();}
				wordExResInfoList.add(obj);
			}
		}
		catch(FileNotFoundException e)
		{System.out.println("파일못찾음");}
		catch(EOFException e)
		{}
		catch(IOException e)
		{System.out.println("input실패");}
		catch(ClassNotFoundException e)
		{System.out.println("클래스를  찾을 수 없음");}
		return wordExResInfoList;

		
    }

	private String genCode()
	{
		int temp = codeNum;
		int digit=1;
		while(temp>=10) // 자릿수 구하기
		{
			temp /=10;
			digit++;
		}
		char[] dataSet = new char[8];
		int temp2 = codeNum;
		for(int i = 8-digit; i <8;i++)
		{
			if(digit == 1)
			{
				dataSet[7] =(char)(temp2+'0');
				break;
			}
			dataSet[i] = (char)(temp2/10+'0');
			temp2 %= 10;
		}
		for(int i = 0 ; i<8-digit;i ++)
		{
			dataSet[i] = (char)'0';
		}
		
		String fileExInfoCode = "03"+String.valueOf(dataSet);
		codeNum++;
		return fileExInfoCode;
	}
}
