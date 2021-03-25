public class WPMAnalysisInfo
{
	private int trialNum;
	private int WPM;

	public WPMAnalysisInfo()
	{
	}

	public WPMAnalysisInfo(int trialNum, int WPM)
	{
		this.trialNum = trialNum;
		this.WPM = WPM;
	}

	public int getTrialNum()
	{
		return this.trialNum;
	}

	public void setTrialNum(int trialNum)
	{
		this.trialNum = trialNum;
	}

	public int getWPM()
	{
		return this.WPM;
	}

	public void setWPM(int WPM)
	{
		this.WPM = WPM;
	}

	public String toString()
	{
		String str = "trialnNum = " + trialNum + " / WPM = " + WPM;
		return str;
	}
}