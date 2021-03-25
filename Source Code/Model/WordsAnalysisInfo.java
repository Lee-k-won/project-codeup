public class WordsAnalysisInfo
{
	private String wordExContent;
	private int accuracy;

	public WordsAnalysisInfo()
	{
	}

	public WordsAnalysisInfo(String wordExContent, int accuracy)
	{
		this.wordExContent = wordExContent;
		this.accuracy = accuracy;
	}

	public String getWordExContent()
	{
		return this.wordExContent;
	}

	public void setWordExContent(String wordExContent)
	{
		this.wordExContent = wordExContent;
	}

	public int getAccuracy()
	{
		return this.accuracy;
	}

	public void setAccuracy(int accuracy)
	{
		this.accuracy = accuracy;
	}

	public String toString()
	{
		String str = "wordExContent = " + wordExContent + " / accuracy = " + accuracy;
		return str;
	}
}