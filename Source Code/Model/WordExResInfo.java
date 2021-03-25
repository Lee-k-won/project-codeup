public class WordExResInfo
{
	private String wordExResInfoCode;
	private String wordExInfoCode;
	private String mistypoInfoCode;
	private int cumInputNum;
	private int mistypoNum;

	public WordExResInfo(){}
	public WordExResInfo(String wordExResInfoCode,String wordExInfoCode,String mistypoInfoCode,int cumInputNum,int mistypoNum)
	{
		this.wordExResInfoCode=wordExResInfoCode;
		this.wordExInfoCode=wordExInfoCode;
		this.mistypoInfoCode=mistypoInfoCode;
		this.cumInputNum=cumInputNum;
		this.mistypoNum=mistypoNum;
	}
	public void setWordExInfoCode(String wordExInfoCode){this.wordExInfoCode=wordExInfoCode;}
	public void setMistypoInfoCode(String mistypoInfoCode){this.mistypoInfoCode=mistypoInfoCode;}
	public void setCumInputNum(int cumInputNum){this.cumInputNum=cumInputNum;}
	public void setMistypoNum(int mistypoNum){this.mistypoNum=mistypoNum;}

	public String getWordExInfoCode(){return wordExInfoCode;}
	public String getMistypoInfoCode(){return mistypoInfoCode;}
	public int getCumInputNum(){return cumInputNum;}
	public int getMistypoNum(){return mistypoNum;}

	public String toString()
	{
		return ("wordExInfoCode: "+wordExInfoCode+ "/mistypoInfoCode: "+mistypoInfoCode+   "/cumInputNum: "+cumInputNum+   "/mistypoNum: "+mistypoNum);
	}
	

}