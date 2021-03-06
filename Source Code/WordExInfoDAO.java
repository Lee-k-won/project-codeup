import java.util.*;
import java.io.*;

public class WordExInfoDAO
{
    private ArrayList<WordExInfo> wordExInfoList;//<<단어예제정보들>>
    private static WordExInfoDAO wordExInfoDAO;
	private static int codeNum;

	static { wordExInfoDAO=new WordExInfoDAO();}//추가한것-배소연
    private WordExInfoDAO()
    {
		wordExInfoList=new ArrayList<WordExInfo>();
		loadWordExInfoList();
		
    }

	private String genCode()
	{
		int temp = codeNum;
		int digit=1;
		while(temp>=10) // 자릿수 구하기
		{
			temp /=10;
			digit++;
		}
		char[] dataSet = new char[8];
		int temp2 = codeNum;
		for(int i = 8-digit; i <8;i++)
		{
			if(digit == 1)
			{
				dataSet[7] =(char)(temp2+'0');
				break;
			}
			dataSet[i] = (char)(temp2/10+'0');
			temp2 %= 10;
		}
		for(int i = 0 ; i<8-digit;i ++)
		{
			dataSet[i] = (char)'0';
		}
		
		String fileExInfoCode = "02"+String.valueOf(dataSet);
		codeNum++;
		return fileExInfoCode;
	}
    
    private WordExInfoDAO(ArrayList<WordExInfo> wordExInfoList)
    {
		if(wordExInfoList==null){this.wordExInfoList=new ArrayList<WordExInfo>();}
		else{this.wordExInfoList=wordExInfoList;}

		loadWordExInfoList();		
    }
    public static WordExInfoDAO getInstance()
    {
		return wordExInfoDAO;
    }
    
    public void setWordExInfoDAO(ArrayList<WordExInfo> wordExInfoList)
    {
		this.wordExInfoList=wordExInfoList;
    
    }
    
    public byte add(WordExInfo wordExInfo)
    {
		wordExInfoList.add(wordExInfo);
		return 1;//성공
    }
    
   /* public byte add(String wordExCode, String wordExContent)
    {
		new WordExInfo(
    }
	*/
    
    /*public byte add(String wordExCode, String[] wordExContents)
    {
    
    }
	*/
    
    public byte add(String wordExCode, String wordExType, String[] wordExContents)//<<API추가용>>
    {
		this.wordExInfoList.add(new WordExInfo(wordExCode,wordExType,wordExContents));
		return 1;
    }
    
    public byte modify(String wordExCode, String[] wordExContents)
    {
		int cnt=0;
		for(cnt=0;cnt<wordExInfoList.size();cnt++)
		{
			if(wordExCode.equals(wordExInfoList.get(cnt).getWordExCode()))
			{
				wordExInfoList.get(cnt).setWordExContents(wordExContents);
				return 1;//수정 성공
			}
		}
		//if(cnt==wordExInfoArr.size());
		return 0;//수정 실패
    }
    
    public byte modify(String wordExCode, String wordExType)
    {
		int cnt=0;
		for(cnt=0;cnt<wordExInfoList.size();cnt++)
		{
			if(wordExCode.equals(wordExInfoList.get(cnt).getWordExCode()))
			{
				wordExInfoList.get(cnt).setWordExType(wordExType);
				return 1;//수정 성공
			}
		}
		//if(cnt==wordExInfoArr.size());
		return 0;//수정 실패
    
    }
    
    public byte remove(String wordExCode)
    {	
		int cnt=0;
		for(cnt=0;cnt<wordExInfoList.size();cnt++)
		{
			if(wordExCode.equals(wordExInfoList.get(cnt).getWordExCode()))
			{
				wordExInfoList.remove(cnt);
				return 1;//지우기 성공
			}
		}
		//if(cnt==wordExInfoArr.size());
		return 0;//지우기 실패
    }
    
    public WordExInfo search(String wordExCode)
    {
		int cnt=0;
		for(cnt=0;cnt<wordExInfoList.size();cnt++)
		{
			if(wordExCode.equals(wordExInfoList.get(cnt).getWordExCode()))
			{
				
				return wordExInfoList.get(cnt);//찾음
			}
		}
		//if(cnt==wordExInfoArr.size());
		return null;//못찾음

    
    }
    
   /* public String[] getWordExInfoData(String wordExCode)
    {
		
    
    }
	*/
    
    public String[] getWordExNameList()
    {
		if(wordExInfoList==null){return null;}//실패
		int listSize=wordExInfoList.size();
		String[] nameList=new String[listSize];
		for(int cnt=0;cnt<listSize;cnt++)
		{
			nameList[cnt]=wordExInfoList.get(cnt).getWordExType();
		}
		return nameList;

    }
    
   /* public String[] getWordExList()//<<단어목록이름, 단어목록코드>>
    {
		
    }
	*/

    public byte saveWordExInfoList()//추가-배소연
    {
		ObjectOutputStream out=null;
		try{
			out=new ObjectOutputStream(new FileOutputStream("data/wordExInfo.txt"));
			if (wordExInfoList==null)
			{return 0;}
			for(int cnt=0;cnt<wordExInfoList.size();cnt++)
			{
				out.writeObject(wordExInfoList.get(cnt));
			}
		}
		catch(IOException ee)
		{
			System.out.println("io실패");
		}
		finally
		{
			try{out.close();
			}
			catch(Exception e)
			{
			}
		}
		return 1;//성공
    }
  /* public static void main(String args[])
	{
		WordExInfoDAO dao= WordExInfoDAO.getInstance();

		String[] arr1=new String[]{"Closeable","DataInput","DataOutput","Externalizable","FileFilter",
		"FilenameFilter","Flushable","ObjectInput","ObjectInputValidation",
		"ObjectOutput","ObjectStreamConstants","Serializable","BufferedInputStream",
		"BufferedOutputStream","BufferedReader","BufferedWriter","ByteArrayInputStream",
		"ByteArrayOutputStream","CharArrayReader","CharArrayWriter","Console",
		"DataInputStream","DataOutputStream","File","FileDescriptor","FileInputStream",
		"FileOutputStream","FilePermission","FileReader","FileWriter","FilterInputStream",
		"FilterOutputStream","FilterReader","FilterWriter","InputStream","InputStreamReader",
		"LineNumberInputStream","LineNumberReader","ObjectInputStream","ObjectInputStream.GetField",
		"ObjectOutputStream","ObjectOutputStream.PutField","ObjectStreamClass","ObjectStreamField",
		"OutputStream","OutputStreamWriter","PipedInputStream","PipedOutputStream","PipedReader",
		"PipedWriter","PrintStream","PrintWriter","PushbackInputStream","PushbackReader",
		"RandomAccessFile","Reader","SequenceInputStream","SerializablePermission"};

		String[] arr2=new String[]{"Appendable","AutoCloseable","CharSequence","Cloneable",
		"Comparable","Iterable","Readable","Runnable","Thread.UncaughtExceptionHandler","Boolean",
		"Byte","Character","Character.Subset","Character.UnicodeBlock","Class","ClassLoader",
		"ClassValue","Compiler","Double","Enum","Float","InheritableThreadLocal","Integer",
		"Long","Math","Number","Object","Package","Process","ProcessBuilder","ProcessBuilder.Redirect",
		"Runtime","RuntimePermission","SecurityManager","Short","StackTraceElement","StrictMath",
		"String","StringBuffer","StringBuilder","System","Thread","ThreadGroup","ThreadLocal",
		"Throwable","Void","Character.UnicodeScript","ProcessBuilder.Redirect.Type","Thread.State",
		"ArithmeticException","ArrayIndexOutOfBoundsException","ArrayStoreException","ClassCastException",
		"ClassNotFoundException","CloneNotSupportedException","EnumConstantNotPresentException",
		"Exception","IllegalAccessException","IllegalArgumentException","IllegalMonitorStateException",
		"IllegalStateException","IllegalThreadStateException","IndexOutOfBoundsException","InstantiationException",
		"InterruptedException","NegativeArraySizeException","NoSuchFieldException","NoSuchMethodException",
		"NullPointerException","NumberFormatException","ReflectiveOperationException","RuntimeException",
		"SecurityException","StringIndexOutOfBoundsException","TypeNotPresentException","UnsupportedOperationException",
		"AbstractMethodError","AssertionError","BootstrapMethodError","ClassCircularityError","ClassFormatError",
		"Error","ExceptionInInitializerError","IllegalAccessError","IncompatibleClassChangeError",
		"InstantiationError","InternalError","LinkageError","NoClassDefFoundError","NoSuchFieldError",
		"NoSuchMethodError","OutOfMemoryError","StackOverflowError","ThreadDeath","UnknownError",
		"UnsatisfiedLinkError","UnsupportedClassVersionError","VerifyError","VirtualMachineError"};

		String[] arr3=new String[]{"Collection","Comparator","Deque","Enumeration","EventListener",
			"Formattable","Iterator","List","ListIterator","Map","Map.Entry","NavigableMap",
			"NavigableSet","Observer","Queue","RandomAccess","Set","SortedMap","SortedSet","AbstractCollection",
			"AbstractList","AbstractMap","AbstractMap.SimpleEntry","AbstractMap.SimpleImmutableEntry","AbstractQueue",
			"AbstractSequentialList","AbstractSet","ArrayDeque","ArrayList","Arrays","BitSet","Calendar","Collections",
			"Currency","Date","Dictionary","EnumMap","EnumSet","EventListenerProxy","EventObject","FormattableFlags",
			"Formatter","GregorianCalendar","HashMap","HashSet","Hashtable","IdentityHashMap","LinkedHashMap",
			"LinkedHashSet","LinkedList","ListResourceBundle","Locale","Locale.Builder","Objects","Observable",
			"PriorityQueue","Properties","PropertyPermission","PropertyResourceBundle","Random","ResourceBundle",
			"ResourceBundle.Control","Scanner","ServiceLoader","SimpleTimeZone","Stack","StringTokenizer",
			"Timer","TimerTask","TimeZone","TreeMap","TreeSet","UUID","Vector","WeakHashMap","Formatter.BigDecimalLayoutForm",
			"Locale.Category","ConcurrentModificationException","DuplicateFormatFlagsException","EmptyStackException",
			"FormatFlagsConversionMismatchException","FormatterClosedException","IllegalFormatCodePointException",
			"IllegalFormatConversionException","IllegalFormatException","IllegalFormatFlagsException","IllegalFormatPrecisionException",
			"IllegalFormatWidthException","IllformedLocaleException","InputMismatchException","InvalidPropertiesFormatException",
			"MissingFormatArgumentException","MissingFormatWidthException","MissingResourceException","NoSuchElementException",
			"TooManyListenersException","UnknownFormatConversionException","UnknownFormatFlagsException","ServiceConfigurationError"};

		dao.wordExInfoList.add(new WordExInfo("2","java.io",arr1));
		dao.wordExInfoList.add(new WordExInfo("1","java.lang",arr2));
		dao.wordExInfoList.add(new WordExInfo("3","java.util",arr3));
		
		dao.saveWordExInfoList();

	}*/
	
    public ArrayList<WordExInfo> loadWordExInfoList()///////////////////////////////////추가-배소연
    {
		ObjectInputStream in=null;
		try{
				in=new ObjectInputStream(new FileInputStream("data/wordExInfo.txt"));
				WordExInfo obj=null;
				while(true)
				{
					obj=(WordExInfo)in.readObject();
					if(wordExInfoList==null){wordExInfoList=new ArrayList<WordExInfo>();}
					wordExInfoList.add(obj);
	
				}
			}
		catch(FileNotFoundException e)
		{
			System.out.println("파일을 찾을 수 없습니다");
		}
		catch(EOFException e)
		{
		}
		catch(IOException e)
		{
			System.out.println("io실패");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("클래스를 찾을 수 없습니다");
		}
	
		return wordExInfoList;
    
    }
    
    public String[] provideAnalysisInfo()//<<통계정보를 제공하다>>
    {
		return null;
    
    }

	public String[] bringWordExInfoList(String wordExType)
	{
		int cnt=0;
		if(wordExInfoList==null)return null;
		int length=wordExInfoList.size();
		if(wordExInfoList.size()==0)return null;
		for(cnt=0;cnt<length;cnt++)
		{
			if(wordExType.equals(wordExInfoList.get(cnt).getWordExType()))
			{
				return wordExInfoList.get(cnt).getWordExContents();
			}
		}
		return null;

	}

	/*public byte saveFile()//IO
	{

	}
	public ArrayList<WordExInfo> readFile()
	{


		return null;

	}*/

	

}
