import java.io.*;

public class WordExInfo implements Serializable
{
    private String wordExCode;
    private String wordExType;
    private String[] wordExContents;
    public WordExInfo()
    {
    
    }
    
    public WordExInfo(String wordExCode, String wordExType, String[] wordExContents)
    {
		this.wordExCode=wordExCode;
		this.wordExType=wordExType;
		this.wordExContents=wordExContents;
    }
    
    public String getWordExCode()
    {
		return wordExCode;
    }
    
    public String[] getWordExContents()
    {
		return wordExContents;
    }
    
    public void setWordExContents(String[] wordExContents)
    {
		this.wordExContents=wordExContents;
    }
    
    public void setWordExCode(String wordExCode)
    {
		this.wordExCode=wordExCode;
    }
	public String getWordExType()
	{
		return wordExType;
	}
	public void setWordExType(String wordEXType)
	{
		this.wordExType=wordExType;
	}
	

    
   /* public byte checkWordExCode(String wordExCode)
    {	
		
    }
	*/
    
    /*public byte checkWordExCode(String wordExName)
    {
    
    }
	
    
    public void �����ϴ�(Object ����ڰ�, Object �ܾ����������� �ܾ��������)
    {
    
    }
    
    public void ��û�ϴ�(Object ����ڰ�, Object �ܾ����������� �ܾ�������� �ܾ��������)
    {
    
    }
    
    public void �����ϴ�(Object �ܾ�������� �ܾ)
    {
    
    }
	*/
}
