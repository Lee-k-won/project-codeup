import java.util.*;
public class FileExInfoDAO 
{
	private LinkedList<FileExInfo> fileExInfoList;
	private static FileExInfoDAO instance;
	private static int codeNum;
	static
	{
		codeNum = 0;
		instance = new FileExInfoDAO();
		instance.addFileExInfo(instance.genCode(), "GoodsInfo", "public class GoodsInfo\n	{\n	private int goodsCode;\n	private String goodsName;\n	private String manufacturer;\n	private int unitPrice;\n	private double discount;\n	public GoodsInfo(){}\n	public GoodsInfo(int goodsCode,String goodsName, String manufacturer, int unitPrice)\n	{\n		this.goodsCode = goodsCode;\n		this.goodsName = goodsName;\n		this.manufacturer = manufacturer;\n		this.unitPrice = unitPrice;\n	}\n	public GoodsInfo(int goodsCode,String goodsName, String manufacturer, int unitPrice, double discount)\n	{\n		this.goodsCode = goodsCode;\n		this.goodsName = goodsName;\n		this.manufacturer = manufacturer;\n		this.unitPrice = unitPrice;\n		this.discount = discount;\n	}\n	public int getGoodsCode()","바탕화면", (long)1,(byte)1, 100,1000);
		instance.addFileExInfo(instance.genCode(), "Accumulator", "System.out.println2", "바탕화면", (long)1,(byte)2, 100,1000);
		instance.addFileExInfo(instance.genCode(), "GoodsStock", "System.out.println3", "바탕화면", (long)1,(byte)3, 100,1000);
		instance.addFileExInfo(instance.genCode(), "Numbers", "System.out.println4", "바탕화면", (long)1,(byte)1, 100,1000);
		instance.addFileExInfo(instance.genCode(), "Rectangle", "System.out.println5", "바탕화면", (long)1,(byte)2, 100,1000);
		instance.addFileExInfo(instance.genCode(), "Square", "System.out.println6", "바탕화면", (long)1,(byte)3, 100,1000);
		instance.addFileExInfo(instance.genCode(), "Account", "System.out.println7", "바탕화면", (long)1,(byte)1, 100,1000);
		instance.addFileExInfo(instance.genCode(), "AddressBook", "System.out.println7", "바탕화면", (long)1,(byte)2, 100,1000);
		instance.addFileExInfo(instance.genCode(), "ColthingInfo", "System.out.println7", "바탕화면", (long)1,(byte)3, 100,1000);
		instance.addFileExInfo(instance.genCode(), "Bank", "System.out.println7", "바탕화면", (long)1,(byte)1, 100,1000);
		instance.addFileExInfo(instance.genCode(), "CheckingAccount", "System.out.println7", "바탕화면", (long)1,(byte)2, 100,1000);
		instance.addFileExInfo(instance.genCode(), "CreditLineAccount", "System.out.println7", "바탕화면", (long)1,(byte)3, 100,1000);
		instance.addFileExInfo(instance.genCode(), "BonusPointAccount", "System.out.println7", "바탕화면", (long)1,(byte)1, 100,1000);
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
		
		String fileExInfoCode = "00"+String.valueOf(dataSet);
		codeNum++;
		return fileExInfoCode;
	}
	private FileExInfoDAO()
	{
		this.fileExInfoList = new LinkedList<FileExInfo>();
	}
	private FileExInfoDAO(LinkedList<FileExInfo> fileExInfoList)
	{
		if(fileExInfoList == null)
			this.fileExInfoList = new LinkedList<FileExInfo>();
		else
			this.fileExInfoList = fileExInfoList;
	}
	private FileExInfoDAO(FileExInfo fileExInfo)
	{
		this.fileExInfoList = new LinkedList<FileExInfo>();
		if(fileExInfo == null)
			this.fileExInfoList.add(fileExInfo);
	}
	
	public byte addFileExInfo(FileExInfo fileExInfo)
	{
		if(fileExInfo == null)
			return 0;
		this.fileExInfoList.add(fileExInfo);
		return 1;
	}
	public byte addFileExInfo(String fileExInfoCode, String fileExName, String fileExContents, String fileExSourceRoute, long fileExSourceMTime, byte fileExInfoLevel, int wordNum, int charNum)
	{
		this.fileExInfoList.add(new FileExInfo(fileExInfoCode, fileExName, fileExContents, fileExSourceRoute, fileExSourceMTime, fileExInfoLevel, wordNum, charNum));
		return 1;
	}

	// 코드없는 add() 추가하기 genCode() 결정될 경우

	public byte modifyFileExInfo(String fileExInfoCode, FileExInfo fileExInfo)
	{
		if(fileExInfo == null)	// parameter로 전달된 fileExInfo가 null 일경우 return 0
			return 0;
		int index = indexOf(fileExInfoCode);
		if(index == -1)	// 해당되는 fileExInfoCode의 fileExInfo가 없을 경우 return -1;
			return -1;
		this.fileExInfoList.set(index, fileExInfo);
		return 1;	// 정상종료
	}
	public byte modifyFileExInfo(String fileExInfoCode, String fileExName, String fileExContents, String fileExSourceRoute, long fileExSourceMTime, byte fileExInfoLevel, int wordNum, int charNum)
	{
		int index = indexOf(fileExInfoCode);
		if(index == -1)	// 해당되는 fileExInfoCode의 fileExInfo가 없을 경우 return -1;
			return -1;
		this.fileExInfoList.set(index, new FileExInfo(fileExInfoCode, fileExName, fileExContents, fileExSourceRoute, fileExSourceMTime, fileExInfoLevel, wordNum, charNum));
		return 1;	// 정상종료
	}
	public byte modifyFileExContents(String fileExInfoCode, String fileExContents)
	{
		int index = indexOf(fileExInfoCode);
		if(index == -1)	// 해당되는 fileExInfoCode의 fileExInfo가 없을 경우 return -1;
			return -1;
		this.fileExInfoList.get(index).setFileExContents(fileExContents);
		return 1;	// 정상종료
	}
	public byte modifyFileExSourceRoute(String fileExInfoCode, String fileExSourceRoute)
	{
		int index = indexOf(fileExInfoCode);
		if(index == -1)	// 해당되는 fileExInfoCode의 fileExInfo가 없을 경우 return -1;
			return -1;
		this.fileExInfoList.get(index).setFileExSourceRoute(fileExSourceRoute);
		return 1;	// 정상종료
	}
	public byte modifyFileExSourceMTime(String fileExInfoCode, long fileExSourceMTime)
	{
		int index = indexOf(fileExInfoCode);
		if(index == -1)	// 해당되는 fileExInfoCode의 fileExInfo가 없을 경우 return -1;
			return -1;
		this.fileExInfoList.get(index).setFileExSourceMTime(fileExSourceMTime);
		return 1;	// 정상종료
	}
	public byte modifyFIleExName(String fileExInfoCode, String fileExName)
	{
		int index = indexOf(fileExInfoCode);
		if(index == -1)	// 해당되는 fileExInfoCode의 fileExInfo가 없을 경우 return -1;
			return -1;
		this.fileExInfoList.get(index).setFileExName(fileExName);
		return 1;	// 정상종료		
	}
	public byte removeFileExInfo(String fileExInfoCode)
	{
		int index = indexOf(fileExInfoCode);
		if(index == -1)	// 해당되는 fileExInfoCode의 fileExInfo가 없을 경우 return -1;
			return -1;
		this.fileExInfoList.remove(index);
		return 1;	// 정상종료		
	}
	// 레퍼런스 검색 private
	private FileExInfo searchFileExInfo(String fileExInfoCode)
	{
		return this.fileExInfoList.get(indexOf(fileExInfoCode));
	}
	public byte checkFileExSourceRoute(String fileExInfoCode, String fileExSourceRoute)
	{
		if(fileExSourceRoute == null)
			return 0;
		searchFileExInfo(fileExInfoCode).setFileExSourceRoute(fileExSourceRoute);
		return 1;	// 정상종료		
	}
	public byte checkFileExSourceMTime(String fileExInfoCode, long fileExSourceMTime)
	{
		if(fileExSourceMTime == 0)
			return 0;
		searchFileExInfo(fileExInfoCode).setFileExSourceMTime(fileExSourceMTime);
		return 1;	// 정상종료		
	}
	public String[] getDataAll()
	{
		return (String[])this.fileExInfoList.toArray();
	}
	public String getFileExContents(String fileExInfoCode)
	{
		int index = indexOf(fileExInfoCode);
		if(index == -1)	// 해당되는 fileExInfoCode의 fileExInfo가 없을 경우 return -1;
			return null;
		return this.fileExInfoList.get(index).getFileExContents(); // 정상종료	
	}
	public String getRandFileExContents()
	{
		int size = this.fileExInfoList.size();
		Random rand = new Random();
		int index = rand.nextInt(size-1);
		return this.fileExInfoList.get(index).getFileExContents();	// 랜덤하게 내용 리턴
	}
	public int indexOf(String fileExInfoCode)
	{
		int size = this.fileExInfoList.size();
		for(int i = 0; i<size; i++)
		{
			if(this.fileExInfoList.get(i).checkFileExInfoCode(fileExInfoCode) == 1)
			{
				return i;
			}
		}
		return -1;
	}
	// 간단 정보 목록 받기
	public String[][] getSimpleFileExInfoList(byte fileExInfoLevel)
	{	
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0 ; i < fileExInfoList.size(); i++)
		{
			if(this.fileExInfoList.get(i).checkFileExInfoLevel(fileExInfoLevel))
			{
				temp.add(this.fileExInfoList.get(i).getFileExName());
				temp.add(this.fileExInfoList.get(i).getFileExInfoCode());
				temp.add(Integer.toString(this.fileExInfoList.get(i).getFileExInfoLevel()));
			}
		}
		Object[] objAry = temp.toArray();
		String[] strTemp = Arrays.copyOf(objAry,objAry.length,String[].class);
		int size = strTemp.length/3;
		String[][] simpleData = new String[size][3];

		for(int i = 0; i < size; i++)
		{
			simpleData[i][0] = strTemp[i*3+0];
			simpleData[i][1] = strTemp[i*3+1];
			simpleData[i][2] = strTemp[i*3+2];
		}

		return simpleData;
	}
	public static FileExInfoDAO getInstance()
	{
		return instance;
	}
}
