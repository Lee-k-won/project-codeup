public class FileExAnswerInitController
{
	FileExInfoExtractManager fileExInfoExtractManager;
	public FileExAnswerInitController()
	{
		fileExInfoExtractManager = new FileExInfoExtractManager();
	}
	public int getLength(String fileExInfoCode)
	{
		return this.fileExInfoExtractManager.getFileExAnswerDataSet(fileExInfoCode).getLength();
	}
	public Character[] getAnswer(String fileExInfoCode)
	{
		return this.fileExInfoExtractManager.getFileExAnswerDataSet(fileExInfoCode).getAnswer();
	}
	public Integer[] getWords(String fileExInfoCode)
	{
		return this.fileExInfoExtractManager.getFileExAnswerDataSet(fileExInfoCode).getWords();
	}
	
}