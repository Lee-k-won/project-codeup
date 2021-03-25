public class ResInfo
{
	private long minTypingTime;
	private String fileExInfoCode;

	public ResInfo()
	{
	}

	public ResInfo(long minTypingTime, String fileExInfoCode)
	{
		this.minTypingTime = minTypingTime;
		this.fileExInfoCode = fileExInfoCode;
	}

	public long getMinTypingTime()
	{
		return this.minTypingTime;
	}

	public void setMingTypingTime(long minTypingTime)
	{
		this.minTypingTime = minTypingTime;
	}

	public String getFileExInfoCode()
	{
		return this.fileExInfoCode;
	}

	public void setFileExInfoCode(String fileExInfoCode)
	{
		this.fileExInfoCode = fileExInfoCode;
	}
}