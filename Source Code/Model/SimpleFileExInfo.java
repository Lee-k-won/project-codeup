public class SimpleFileExInfo
{
	private String fileExInfoName;
	private String fileExInfoCode;
	private int fileExInfoLevel;
	
	public SimpleFileExInfo()
	{
	}

	public SimpleFileExInfo(String fileExInfoName,String fileExInfoCode,int fileExInfoLevel)
	{
		this.fileExInfoName = fileExInfoName;
		this.fileExInfoCode = fileExInfoCode;
		this.fileExInfoLevel = fileExInfoLevel;
	}

	public String getFileExInfoName()
	{
		return this.fileExInfoName;
	}

	public void setFileExInfoName(String fileExInfoName)
	{
		this.fileExInfoName = fileExInfoName;
	}

	public String getFileExInfoCode()
	{
		return this.fileExInfoCode;
	}

	public void setFileExInfoCode(String fileExInfoCode)
	{
		this.fileExInfoCode = fileExInfoCode;
	}

	public int getFileExInfoLevel()
	{
		return this.fileExInfoLevel;
	}

	public void setFileExInfoLevel(int fileExInfoLevel)
	{
		this.fileExInfoLevel = fileExInfoLevel;
	}

	public String toString()
	{
		String str = "fileExInfoName = " + fileExInfoName + " / fileExInfoCode = " + fileExInfoCode + " / fileExInfoLevel = " + fileExInfoLevel;
		return str;
	}
}