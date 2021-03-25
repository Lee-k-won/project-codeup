import java.util.*;
public class FileExInitDataSet	// init data bean
{
	int length;
	Character[] answer;
	Integer[] words;

	public FileExInitDataSet()
	{
		
	}
	public FileExInitDataSet(String data)
	{
		this.answer = toCharacterArray(data);
		this.length = answer.length;
		this.words = wordIndex(tokenizing(data));
	}
	public void setLength(int length)
	{
		this.length = length;
	}
	public void setAnswer(Character[] answer)
	{
		this.answer = answer;
	}
	public void setWords(Integer[] words)
	{
		this.words = words;
	}
	public int getLength()
	{
		return this.length;
	}
	public Character[] getAnswer()
	{
		return this.answer;
	}
	public Integer[] getWords()
	{
		return this.words;
	}
	public Integer[] wordIndex(String[] token)	// intger set »ý¼º
	{
		int index = 0;
		Integer[] word = new Integer[token.length];
		for(int i = 0 ; i < token.length ; i ++)
		{
			index += token[i].length();
			word[i] = index-1;
		}
		return word;
	}
	public String[] tokenizing(String data)
	{
		StringTokenizer words = new StringTokenizer(data," .\t()[]\"",true);
		int size = words.countTokens();
		String[] result = new String[size];
		for(int i = 0; i < size; i++)
		{
			result[i] = words.nextToken();
		}
		return result;
	}
	public Integer[] toIntegerArray(int[] data) 
	{
		int length = data.length;
		Integer[] array = new Integer[data.length];
		
		for(int i = 0; i <length ; i++)
		{
			array[i] = data[i];
		}
		
		return array;
	}
	public Character[] toCharacterArray( String s ) {

		if ( s == null ) {
		  return null;
	}

   int len = s.length();
   Character[] array = new Character[len];
   for (int i = 0; i < len ; i++) {
      array[i] = new Character(s.charAt(i));
   }

   return array;
	}


}