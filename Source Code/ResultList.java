//¹è¼Ò¿¬
import java.util.*;

public class ResultList
{
	private ArrayList<TempWordResult> tempWordResultList;
	
	public ArrayList<TempWordResult> getTempWordResultList()
	{
		return this.tempWordResultList;
	}

	public ResultList()
	{
		tempWordResultList=new ArrayList<TempWordResult>();
	}
	public ResultList(ArrayList<TempWordResult> tempWordResultList)
	{
		this.tempWordResultList=tempWordResultList;
	}
	public byte addTempResult(TempWordResult tempWordResult)
	{
		if(tempWordResultList==null){new ResultList();}
		tempWordResultList.add(tempWordResult);
		
		return 1;
	}	
}