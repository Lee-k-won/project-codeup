public class FileExResInfo
{
	private String fileExResInfoCode;
	private String fileExInfoCode;
	private int trialNum;
	private Long typingTime;
	private int typedWords;
	private int typedChars;

	public FileExResInfo()
	{
	}
	public FileExResInfo(String fileExResInfoCode, String fileExInfoCode, int trialNum, Long typingTime, int typedWords, int typedChars)
	{
		this.fileExResInfoCode = fileExResInfoCode;
		this.fileExInfoCode = fileExInfoCode;
		this.trialNum = trialNum;
		this.typingTime = typingTime;
		this.typedWords = typedWords;
		this.typedChars = typedChars;
	}

	public void setFileExResInfoCode(String fileExResInfoCode)
	{
		this.fileExResInfoCode =fileExResInfoCode;
	}
	public void setFileExInfoCode(String fileExInfoCode)
	{
		this.fileExInfoCode= fileExInfoCode;
	}
	public void setTrialNum(int trialNum)
	{
		this.trialNum = trialNum;
	}
	public void setTypingTime(Long typingTime)
	{
		this.typingTime = typingTime;
	}
	public void setTypedWords(int typedWords)
	{
		this.typedWords = typedWords;
	}
	public void setTypedChars(int typedChars)
	{
		this.typedChars = typedChars;
	}
	public String getFileExResInfoCode()
	{
		return this.fileExResInfoCode;
	}
	public String getFileExInfoCode()
	{
		return this.fileExInfoCode;
	}
	public int getTrialNum()
	{
		return this.trialNum;
	}
	public Long getTypingTime()
	{
		return this.typingTime;
	}
	public int getTypedWords()
	{
		return this.typedWords;
	}
	public int getTypedChars()
	{
		return this.typedChars;
	}
	public String toString()
	{
		return this.fileExResInfoCode + " / " + this.fileExInfoCode + " / " + this.trialNum + " / " + this.typingTime + " / " + this.typedWords + " / " + this.typedChars;
	}
}