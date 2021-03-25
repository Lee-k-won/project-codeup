public class LevelInfo
{
	private String levelInfoCode;
	private int levelNum;
	private int criteria;

	public LevelInfo()
	{
	}
	public LevelInfo(String levelInfoCode, int levelNum, int criteria)
	{
		this.levelInfoCode = levelInfoCode;
		this.levelNum = levelNum;
		this.criteria = criteria;
	}
	public void setLevelInfoCode(String levelInfoCode)
	{
		this.levelInfoCode = levelInfoCode;
	}
	public void setLevelNum(int levelNum)
	{
		this.levelNum = levelNum;
	}
	public void setCriteria(int criteria)
	{
		this.criteria = criteria;
	}
	public String getLevelInfoCode()
	{
		return this.levelInfoCode;
	}
	public int getLevelNum()
	{
		return this.levelNum;
	}
	public int getCriteria()
	{
		return this.criteria;
	}
	public String toString()
	{
		return this.levelInfoCode + " / " + this.levelNum + " / " + this.criteria;
	}
}