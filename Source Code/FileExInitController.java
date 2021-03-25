public class FileExInitController
{
	private FileExInfoExtractManager fileExInfoExtractManager;

	public FileExInitController()
	{
		fileExInfoExtractManager = new FileExInfoExtractManager();
	}
	
	public String[][] getSimpleFileExInfoList(byte fileExInfoLevel)
	{
		return this.fileExInfoExtractManager.getSimpleFileExInfoList(fileExInfoLevel);
	}
	public String initFileExContents(String fileExInfoCode)
	{
		return fileExInfoExtractManager.getFileExContents(fileExInfoCode);
		
	}
	public String initRandFileExContents()
	{
		return fileExInfoExtractManager.getRandFileExContents();
	}

}