import java.sql.*;

public class WordTypeList
{
	private String wordTypeCode;
	private String wordTypeName;

	public WordTypeList()
	{
	}
	public WordTypeList(String wordTypeCode,String wordTypeName)
	{
		this.wordTypeCode=wordTypeCode;
		this.wordTypeName=wordTypeName;
		//insertWordType();
	}
	public String toString()
	{
		return "wordType: "+wordTypeName;
	}
	public void setWordTypeCode(String wordTypeCode){this.wordTypeCode=wordTypeCode;}
	public String getWordTypeCode(){return wordTypeCode;}
	public String getWordTypeName()
	{
		return this.wordTypeName;
	}
	public void setWordTypeName(String wordTypeName)
	{
		this.wordTypeName=wordTypeName;
	}



}