
//¹è¼Ò¿¬
public class ControlWordEx
{
	private WordExResAnalysor wordExResAnalysor;

	public String[] manageInputWordEx(String wordExType)
	{
		WordExInfoDAO dao=WordExInfoDAO.getInstance();
		String[] wordExArr=dao.bringWordExInfoList(wordExType);
		if(wordExArr!=null)
		return wordExArr;
		
		else return null;

	}
	public byte manageSaveResult(TempWordResult[] tempWordResultArr)
	{


		return 1;
	}
}