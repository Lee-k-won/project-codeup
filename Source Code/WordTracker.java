import java.util.*;

public class WordTracker 
{	
	private  ArrayList<char[]> source;
	private int charIter;
	private int wordIter;
	public char[] data;

	public WordTracker()
	{
		
	}
	public WordTracker(ArrayList<char[]> source)
	{
		this.source = source;
		this.charIter = 0;
		this.wordIter = 0;
	}
	public void setSource(ArrayList<char[]> source)
	{
		this.source = source;
	}
	public ArrayList<char[]> getSource()
	{
		return this.source;
	}
	public byte setData()
	{
	}
}
