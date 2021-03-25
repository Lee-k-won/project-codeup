import java.util.*;
public class FileExResInfoDAO
{
	private ArrayList<FileExResInfo> fileExResInfoList;
	private static FileExResInfoDAO fileExResInfoDAO;
	private static int codeNum;

	static
	{
		ArrayList<FileExResInfo> test = new ArrayList<FileExResInfo>();

		test.add(new FileExResInfo("12",1,12,1423,500,400));
		test.add(new FileExResInfo("13",2,13,14231,500,400));
		test.add(new FileExResInfo("23",3,23,1423,500,400));
		test.add(new FileExResInfo("24",4,24,1423,500,400));
		test.add(new FileExResInfo("33",5,33,1423,500,400));
		test.add(new FileExResInfo("34",6,34,14231,500,400));
		test.add(new FileExResInfo("44",7,44,1423,500,400));
		test.add(new FileExResInfo("45",8,45,1423,500,400));
		test.add(new FileExResInfo("55",9,55,14231,500,400));
		test.add(new FileExResInfo("56",10,56,1423,500,400));
		test.add(new FileExResInfo("42",11,42,1423,500,400));
		test.add(new FileExResInfo("45",12,45,1423,500,400));
		test.add(new FileExResInfo("23",13,23,1423,500,400));
		test.add(new FileExResInfo("25",14,25,14231,500,400));
		test.add(new FileExResInfo("60",15,60,1423,500,400));
		test.add(new FileExResInfo("70",16,70,1423,500,400));
		test.add(new FileExResInfo("22",17,22,14231,500,400));
		test.add(new FileExResInfo("23",18,23,1423,500,400));
		test.add(new FileExResInfo("44",19,44,1423,500,400));
		test.add(new FileExResInfo("45",20,45,1423,500,400));
		test.add(new FileExResInfo("67",21,67,1423,500,400));
		test.add(new FileExResInfo("57",22,57,14231,500,400));
		test.add(new FileExResInfo("34",23,34,1423,500,400));
		test.add(new FileExResInfo("23",24,23,14231,500,400));
		test.add(new FileExResInfo("34",25,34,1423,500,400));
		test.add(new FileExResInfo("45",26,45,1423,500,400));
		test.add(new FileExResInfo("23",27,23,14231,500,400));
		test.add(new FileExResInfo("34",28,34,1423,500,400));
		test.add(new FileExResInfo("45",29,45,1423,500,400));
		test.add(new FileExResInfo("56",30,56,1423,500,400));
		test.add(new FileExResInfo("12",31,12,1423,500,400));
		test.add(new FileExResInfo("23",32,23,14231,500,400));

		fileExResInfoDAO = new FileExResInfoDAO(test);
	}

	public FileExResInfoDAO()
	{
		this.fileExResInfoList = new ArrayList<FileExResInfo>();
	}

	public FileExResInfoDAO(ArrayList<FileExResInfo> fileExResInfoList)
	{
		this.fileExResInfoList = fileExResInfoList;
	}

	public static FileExResInfoDAO getInstance()
	{
		return fileExResInfoDAO;
	}

	public ArrayList<FileExResInfo> getfileExResInfoList()
	{
		return this. fileExResInfoList;
	}

	public void setFileExResInfoList(ArrayList<FileExResInfo> fileExResInfoList)
	{
		if(fileExResInfoList != null)
		{
			this.fileExResInfoList = fileExResInfoList;
		}
	}

	public String[] provideWPMs()
	{
		String[] res = new String[this.fileExResInfoList.size()];
		Iterator<FileExResInfo> iter = this.fileExResInfoList.iterator();
		
		while(iter.hasNext())
		{
			FileExResInfo temp = iter.next();

			res[temp.getTrialNum()-1] = temp.getWpm()+"";
		}

		return res;
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
		
		String fileExInfoCode = "01"+String.valueOf(dataSet);
		codeNum++;
		return fileExInfoCode;
	}


}