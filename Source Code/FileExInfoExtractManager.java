public class FileExInfoExtractManager
{
	private FileExInfoDAO fileExInfoDAO;

	public FileExInfoExtractManager()
	{
		fileExInfoDAO = FileExInfoDAO.getInstance();
	}
	public String[][] getSimpleFileExInfoList(byte fileExInfoLevel)
	{
		return this.fileExInfoDAO.getSimpleFileExInfoList(fileExInfoLevel);
	}
	public FileExInitDataSet getFileExAnswerDataSet(String fileExInfoCode)	// checker 데이터 초기화용
	{
		return new FileExInitDataSet(this.fileExInfoDAO.getFileExContents(fileExInfoCode));
	}
	public String getFileExContents(String fileExInfoCode)	// 화면 표시용
	{
		return this.fileExInfoDAO.getFileExContents(fileExInfoCode);
	}
	public String getRandFileExContents()
	{
		return this.fileExInfoDAO.getRandFileExContents();
	}
}