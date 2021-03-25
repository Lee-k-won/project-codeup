public class FileExInfo
{
	private String fileExInfoCode;
	private String fileExName;
	private String fileExContents;
	private String fileExSourceRoute;
	private long fileExSourceMTime;
	private byte fileExInfoLevel;
	private int wordNum;
	private int charNum;

	public FileExInfo()
	{
	}
	public FileExInfo(String fileExInfoCode, String fileExName, String fileExContents, String fileExSourceRoute, long fileExSourceMTime, byte fileExInfoLevel, int wordNum, int charNum)
	{
		this.fileExInfoCode = fileExInfoCode;
		this.fileExName = fileExName;
		this.fileExContents = fileExContents;
		this.fileExSourceRoute = fileExSourceRoute;
		this.fileExSourceMTime = fileExSourceMTime;
		this.fileExInfoLevel = fileExInfoLevel;
		this.wordNum = wordNum;
		this.charNum = charNum;
	}
	public String getFileExInfoCode()
	{
		return this.fileExInfoCode;
	}
	public String getFileExName()
	{
		return this.fileExName;
	}
	public String getFileExContents()
	{
		return this.fileExContents;
	}
	public String getFileExSourceRoute()
	{
		return this.fileExSourceRoute;
	}
	public long getFileExSourceMTime()
	{
		return this.fileExSourceMTime;
	}
	public byte getFileExInfoLevel()
	{
		return this.fileExInfoLevel;
	}
	public int getWordNum()
	{
		return this.wordNum;
	}
	public int getCharNum()
	{
		return this.charNum;
	}
	public void setFileExInfoCode(String fileExInfoCode)
	{
		this.fileExInfoCode = fileExInfoCode;
	}
	public void setFileExName(String fileExName)
	{
		this.fileExName = fileExName;
	}
	public void setFileExContents(String fileExContents)
	{
		this.fileExContents = fileExContents;
	}
	public void setFileExSourceRoute(String fileExSrouceRoute)
	{
		this.fileExSourceRoute = fileExSourceRoute;
	}
	public void setFileExSourceMTime(long fileExSourceMTime)
	{
		this.fileExSourceMTime = fileExSourceMTime;
	}
	public void setFileExInfoLevel(byte fileExInfoLevel)
	{
		this.fileExInfoLevel = fileExInfoLevel;
	}
	public void setWordNum(int wordNum)
	{
		this.wordNum = wordNum;
	}
	public void setCharNum(int charNum)
	{
		this.charNum = charNum;
	}

	/* user defined methods */

	public boolean checkFileExInfoLevel(byte checkFileExInfoLevel)
	{
		return this.fileExInfoLevel <= checkFileExInfoLevel;
	}
	public byte checkFileExSourceMTime(long fileExSourceMTime)	// 생성시간 비교
	{
		if(fileExSourceMTime == this.fileExSourceMTime)
			return 1;
		else
			return 0;
	}
	
	public byte checkFileExSourceRoute(String fileExSourceRoute) // 원본 루트 비교
	{
		if(fileExSourceRoute.equals(this.fileExSourceRoute))
			return 1;
		else
			return 0;
	}
	public byte checkFileExInfoCode(String fileExInfoCode)	// 파일 정보 코드 비교
	{
		if(fileExInfoCode.equals(this.fileExInfoCode))
			return 1;
		else
			return 0;
	}	
	// 예제 길이를 측정하여 parameter 값보다 작거나 같을 경우 return 1
	public byte checkFileExContentsLength(int fileExContentsLength)
	{
		if(this.fileExContents.length()<= fileExContentsLength)
			return 1;
		else
			return 0;
	}
	public byte modifyFileExName(String fileExName)	// 이름 수정
	{
		if(fileExName.equals(this.fileExName))	// 기존 이름과 같을 경우 return 0
			return 0;
		else
			this.fileExName = fileExName;	// 기존 이름과 다를 경우 return 1
		return 1;
	}
	public int getFileExContentsLength()
	{
		return this.fileExContents.length();
	}
}