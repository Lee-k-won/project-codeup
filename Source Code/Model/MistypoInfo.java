public class MistypoInfo
{
	private String mistypoInfoCode;
	private String wordTypeInfoCode;
	private String fileExInfoCode;
	private String mistypo;

	public MistypoInfo()
	{
	}
	public MistypoInfo(String mistypoInfoCode, String wordTypeInfoCode, String fileExInfoCode, String mistypo)
	{
		this.mistypoInfoCode = mistypoInfoCode;
		this.wordTypeInfoCode = wordTypeInfoCode;
		this.fileExInfoCode = fileExInfoCode;
		this.mistypo = mistypo;
	}
	public void setMistypoInfoCode(String mistypoInfoCode)
	{
		this.mistypoInfoCode = mistypoInfoCode;
	}
	public void setWordTypeInfoCode(String wordTypeInfoCode)
	{
		this.wordTypeInfoCode = wordTypeInfoCode;
	}
	public void setFileExInfoCode(String fileExInfoCode)
	{
		this.fileExInfoCode = fileExInfoCode;
	}
	public void setMistypo(String mistypo)
	{
		this.mistypo = mistypo;
	}
	public String getMistypoInfoCode()
	{
		return this.mistypoInfoCode;
	}
	public String getWordTypeInfoCode()
	{
		return this.wordTypeInfoCode;
	}
	public String getFileExInfoCode()
	{
		return this.fileExInfoCode;
	}
	public String getMistypo()
	{
		return this.mistypo;
	}
	public String toString()
	{
		return this.mistypoInfoCode + " / " + this.wordTypeInfoCode + " / " + this.fileExInfoCode + " / " + this.mistypo;
	}
}