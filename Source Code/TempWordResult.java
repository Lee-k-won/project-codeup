//¹è¼Ò¿¬
public class TempWordResult
{
	private long startT;
	private long endT;
	private boolean accuracy;
	private String wordExContents;

	public TempWordResult()
	{
	}
	public TempWordResult(long startT,long endT,boolean accuracy,String wordExContents)
	{
		this.startT=startT;
		this.endT=endT;
		this.accuracy=accuracy;
		this.wordExContents=wordExContents;
	}

	public long getStartT()
	{
		return this.startT;
	}

	public long getEndT()
	{
		return this.endT;
	}

	public boolean getAccuracy()
	{
		return this.accuracy;
	}

	public String getWordExContents()
	{
		return this.wordExContents;
	}
}