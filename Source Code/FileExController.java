public class FileExController
{
	private FileExTempFileController fileExTempFileController;
	private FileExAnswerInitController fileExAnswerInitController;
	private FileExResultSaveController fileExResultSaveController;
	public FileExController()
	{
	}
	public FileExController(String fileExInfoCode)
	{
		this.fileExAnswerInitController = new FileExAnswerInitController();
		ResultManager resultManager = new ResultManager(fileExAnswerInitController.getLength(fileExInfoCode), fileExAnswerInitController.getAnswer(fileExInfoCode), fileExAnswerInitController.getWords(fileExInfoCode));
		this.fileExTempFileController = new FileExTempFileController(resultManager);
		this.fileExResultSaveController = new FileExResultSaveController(resultManager);
	}
	public byte saveTempResult(int data, long time)
	{
		return this.fileExTempFileController.saveTempResult(data,time);
	}
}