import java.util.*;
import java.io.*;
public class WordExResInfo implements Serializable
{
	private String wordExResInfoCode;
	private String wordExContents;
	private int totalInputNum;
	private int totalMistypedNum;
	private ArrayList<Long> timeLog;
	
	public void WordExResInfo()
	{
	
	}
	
	public WordExResInfo(String wordExResInfoCode, String wordExContents, int totalInputNum, int totalMistypedNum, ArrayList<Long> timeLog)
	{
		this.wordExResInfoCode = wordExResInfoCode;
		this.wordExContents = wordExContents;
		this.totalInputNum = totalInputNum;
		this.totalMistypedNum = totalMistypedNum;
		if(timeLog == null)
		{
			this.timeLog = new ArrayList<Long>();
		}
		else
		{
			this.timeLog = timeLog;	
		}
	}
	
	public WordExResInfo(String wordExContents, int totalInputNum, int totalMistypedNum, ArrayList<Long> timeLog)
	{
		//코드 생성하는 부분 만들면 반드시 코드 생성 추가!
		this.wordExContents=wordExContents;
		this.totalInputNum=totalInputNum;
		this.totalMistypedNum=totalMistypedNum;
		this.timeLog=timeLog; 	
	}
	
	public void setWordExResInfoCode(String wordExResInfoCode)
	{
		this.wordExResInfoCode = wordExResInfoCode;
	}
	
	public String getWordExResInfoCode()
	{
		return this.wordExResInfoCode;
	}
	
	public void setWordExContents(String wordExContents)
	{
		this.wordExContents = wordExContents;	
	}
	
	public String getWordExContents()
	{
		return this.wordExContents;
	}
	
	public void setTotalInputNum(int totalInputNum)
	{
		this.totalInputNum = totalInputNum;
	}
	
	public int getTotalInputNum()
	{
		return this.totalInputNum;
	}
	
	public void setTotalMistypedNum(int totalMistypedNum)
	{
		this.totalMistypedNum = totalMistypedNum;
	}
	
	public int getTotalMistypedNum()
	{
		return this.totalMistypedNum;
	}
	
	public void setTimeLog(ArrayList<Long> timeLog)
	{
		if(timeLog != null)
		{
			this.timeLog = timeLog;
		}
		else
		{
			this.timeLog = new ArrayList<Long>();
		}
	}
	
	public ArrayList<Long> getTimeLog()
	{
		return this.timeLog;
	}
		
	public String provideMistypedWords(int probability)
    {
		if ( ((totalMistypedNum/totalInputNum)*100)>=probability)
		{
			return this.wordExContents;
		}
		else return null;
    }
    
    public byte appendResult(long timeLog, int mistypedNo,int inputNo)
    {
		this.timeLog.add(timeLog);
		this.totalMistypedNum+=mistypedNo;
		this.totalInputNum+=inputNo;
		return 1;//성공!!!!!!
    
    }
    
    private String genWordExResInfoCode()
    {
		return null;//구현할것
    
    }
	public String getLapseRateInfo()
	{
		return (int)((double)totalMistypedNum / (double)totalInputNum * 100) + "";	
	}
		
}
