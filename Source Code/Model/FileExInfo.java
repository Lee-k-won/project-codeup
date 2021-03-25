public class FileExInfo
{
	private String fileExInfoCode;
	private String fileExInfoName;
	private String fileExInfoContent;
	private String fileExInfoSourcePath;
	private Long fileExInfoMTime;
	private int totalWordNum;
	private int totalCharNum;

	public FileExInfo()
	{
	}
	public FileExInfo(String fileExInfoCode, String fileExInfoName, String fileExInfoContent, String fileExInfoSourcePath, Long fileExInfoMTime, int totalWordNum, int totalCharNum)
	{
		this.fileExInfoCode = fileExInfoCode;
		this.fileExInfoName= fileExInfoName;
		this.fileExInfoContent = fileExInfoContent;
		this.fileExInfoSourcePath = fileExInfoSourcePath;
		this.fileExInfoMTime = fileExInfoMTime;
		this.totalWordNum = totalWordNum;
		this.totalCharNum = totalCharNum;
	}
	public void setFileExInfoCode(String fileExInfoCode)
	{
		this.fileExInfoCode = fileExInfoCode;
	}
	public void setFileExInfoName(String fileExInfoName)
	{
		this.fileExInfoName = fileExInfoName;
	}
	public void setFileExInfoContent(String fileExInfoContent)
	{
		this.fileExInfoContent = fileExInfoContent;
	}
	public void setFileExInfoSourcePath(String fileExInfoSourcePath)
	{
		this.fileExInfoSourcePath = fileExInfoSourcePath;
	}
	public void setFileExInfoMTime(Long fileExInfoMTime)
	{
		this.fileExInfoMTime = fileExInfoMTime;
	}
	public void setTotalWordNum(int totalWordNum)
	{
		this.totalWordNum = totalWordNum;
	}
	public void setTotalCharNum(int totalCharNum)
	{
		this.totalCharNum = totalCharNum;
	}
	public String getFileExInfoCode()
	{
		return this.fileExInfoCode;
	}
	public String getFileExInfoName()
	{
		return this.fileExInfoName;
	}
	public String getFileExInfoContent()
	{
		return this.fileExInfoContent;
	}
	public String getFileExInfoSourcePath()
	{
		return this.fileExInfoSourcePath;
	}
	public Long getFileExInfoMTime()
	{
		return this.fileExInfoMTime;
	}
	public int getTotalWordNum()
	{
		return this.totalWordNum;
	}
	public int getTotalCharNum()
	{
		return this.totalCharNum;
	}
	public String toString()
	{
		return this.fileExInfoCode +" / " + this.fileExInfoName +" / " + this.fileExInfoContent +" / " + this.fileExInfoSourcePath +" / " + this.fileExInfoMTime +" / " + this.totalWordNum +" / " + this.totalCharNum;
	}
}