public class FileExResInfo
{
	private String fileExResInfoCode;
	private int trialNum;
	private int wpm;
	private long typingTime;
	private int typedWords;
	private int typedChars;

	public FileExResInfo()
	{
	}

	public FileExResInfo(String fileExResInfoCode, int trialNum,int wpm, long typingTime, int typedWords, int typedChars)
	{
		this.fileExResInfoCode = fileExResInfoCode;
		this.trialNum = trialNum;
		this.wpm = wpm;
		this.typingTime = typingTime;
		this.typedWords = typedWords;
		this.typedChars = typedChars;
	}

	public String getFileExResInfoCode()
	{
		return this.fileExResInfoCode;
	}

	public void setFileExResInfoCode(String fileExResInfoCode)
	{
		this.fileExResInfoCode = fileExResInfoCode;
	}

	public int getTrialNum()
	{
		return this.trialNum;
	}

	public void setTrialNum(int trialNum)
	{
		this.trialNum = trialNum;
	}

	public int getWpm()
	{
		return this.wpm;
	}

	public void setWpm(int wpm)
	{
		this.wpm = wpm;
	}

	public long getTypingTime()
	{
		return this.typingTime;
	}

	public void setTypingtime(long typingTime)
	{
		this.typingTime = typingTime;
	}

	public int getTypedWords()
	{
		return this.typedWords;
	}

	public void setTypedWords(int typedWords)
	{
		this.typedWords = typedWords;
	}

	public int getTypedChars()
	{
		return this.typedChars;
	}

	public void setTypedChars(int typedChars)
	{
		this.typedChars = typedChars;
	}

}