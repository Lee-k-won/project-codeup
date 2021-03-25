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
	
    
    public void 선택하다(Object 사용자가, Object 단어예제정보목록의 단어예제정보를)
    {
    
    }
    
    public void 요청하다(Object 사용자가, Object 단어예제정보목록의 단어예제정보의 단어예제내용을)
    {
    
    }
    
    public void 저장하다(Object 단어예제정보에 단어를)
    {
    
    }
	*/
}
