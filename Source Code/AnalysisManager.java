public class AnalysisManager
{
	public AnalysisManager()
	{
	}

	public String[] provideWordsAnalysisInfo()
	{
		return WordExResInfoDAO.getInstance().provideWordsAnalysisInfo();
	}

	public String[] provideWPMAnalysisInfo()
	{
		return FileExResInfoDAO.getInstance().provideWPMs();
	}

	public String[][] provideRankingAnalysisInfo()
	{
		return WordExResInfoDAO.getInstance().provideRankingAnalysisInfo();
	}

	public static void main(String[] args)
	{
		AnalysisManager test = new AnalysisManager();

		System.out.println(test.provideWordsAnalysisInfo());
		System.out.println(test.provideWPMAnalysisInfo());
		System.out.println(test.provideRankingAnalysisInfo());
	}
}