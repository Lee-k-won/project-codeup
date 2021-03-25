
//¹è¼Ò¿¬
public class WordExResAnalysor
{
	private ResultStoreManager resultStoreManager;

	public WordExResAnalysor()
	{
	
	}
	public byte analyzeWordExRes(String answerWord,long startT,long endT,boolean accuracy)
	{	
		int mistypedNo=0;
		long timeLog=endT=startT;

		if(accuracy==false)mistypedNo=1;
		WordExResInfoDAO dao=WordExResInfoDAO.getInstance();
		
		if(dao.appendResult(answerWord,timeLog,mistypedNo,1)==1)return 1;

		return 0;
	}




}