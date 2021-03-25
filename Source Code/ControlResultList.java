import java.util.*;
public class ControlResultList
{
	private ResultList resultList;
	private static ControlResultList controlResultList;
	private WordExResAnalysor wordExResAnalysor;
	private String answerWord;
	private boolean accuracy;
	private long startT;
	private long endT;


	static { controlResultList=new ControlResultList();}

	private ControlResultList()
	{
		resultList=new ResultList();
		startT=-1;
		wordExResAnalysor=new WordExResAnalysor();
	}

	public static ControlResultList getInstance()
	{
		return controlResultList;
	}

	public byte controlSaveResultList()
	{
		Iterator<TempWordResult> iter = resultList.getTempWordResultList().iterator();

		while(iter.hasNext())
		{
			TempWordResult temp = iter.next();
			wordExResAnalysor.analyzeWordExRes(temp.getWordExContents(),temp.getStartT(),temp.getEndT(),temp.getAccuracy());
		}
		WordExResInfoDAO dao=WordExResInfoDAO.getInstance();
		dao.saveWordExResInfoList();

			
		return 1;
	}
	public byte controlAddTempResult(String answerWord,boolean accuracy)
	{
		this.answerWord=answerWord;
		this.accuracy=accuracy;
		if(resultList.addTempResult(new TempWordResult(startT,endT,accuracy,answerWord))==1)return 1;
		startT=-1;
		return 0;

	}
	public byte controlCharResult(long time)
	{
		if(startT==-1)
		{
			startT=time;
		}
		else {endT=time;}
		
		return 1;

	}

}