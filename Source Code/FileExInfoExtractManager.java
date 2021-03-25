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
	public FileExInitDataSet getFileExAnswerDataSet(String fileExInfoCode)	// checker ������ �ʱ�ȭ��
	{
		return new FileExInitDataSet(this.fileExInfoDAO.getFileExContents(fileExInfoCode));
	}
	public String getFileExContents(String fileExInfoCode)	// ȭ�� ǥ�ÿ�
	{
		return this.fileExInfoDAO.getFileExContents(fileExInfoCode);
	}
	public String getRandFileExContents()
	{
		return this.fileExInfoDAO.getRandFileExContents();
	}
}