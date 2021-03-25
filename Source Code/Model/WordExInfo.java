import java.sql.*;

public class WordExInfo
{
	private String wordExInfoCode;
	private String wordTypeCode;
	private String wordExContent;

	public WordExInfo(){}
	public WordExInfo(String wordExInfoCode,String wordTypeCode,String wordExContent)
	{
		this.wordExInfoCode=wordExInfoCode;
		this.wordTypeCode=wordTypeCode;
		this.wordExContent=wordExContent;
	}
	public void setWordTypeCode(String wordTypeCode){this.wordTypeCode=wordTypeCode;}
	public void setWordExContent(String wordExContent){this.wordExContent=wordExContent;}
	public void setWordExInfoCode(String wordExInfoCode){this.wordExInfoCode=wordExInfoCode;}
	
	public String getWordExInfoCode(){return wordExInfoCode;}
	public String getWordTypeCode(){return wordTypeCode;}
	public String getWordExContent(){return wordExContent;}
	public String toString()
	{
		return "wordTypeCode: "+wordTypeCode+"/wordExContent: "+wordExContent;
	}



}