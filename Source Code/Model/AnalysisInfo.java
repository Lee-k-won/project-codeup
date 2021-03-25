public class AnalysisInfo
{
	private int totalWords;
	private int totalChars;

	public AnalysisInfo()
	{
	}

	public AnalysisInfo(int totalWords, int totalChars)
	{
		this.totalWords = totalWords;
		this.totalChars = totalChars;
	}

	public int getTotalWords()
	{
		return this.totalWords;
	}

	public void setTotalWords(int totalWords)
	{
		this.totalWords = totalWords;
	}

	public int getTotalChars()
	{
		return this.totalChars;
	}

	public void setTotalChars(int totalChars)
	{
		this.totalChars = totalChars;
	}

	public String toString()
	{
		String str = "totalWords = " + totalWords + " / totalChars = " + totalChars;
		return str;
	}
}