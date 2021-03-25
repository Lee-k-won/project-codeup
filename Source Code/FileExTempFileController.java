public class FileExTempFileController
{
	ResultManager resultManager;
	public FileExTempFileController()
	{
		
	}
	public FileExTempFileController(ResultManager resultManager)
	{
		this.resultManager = resultManager;
	}
	public byte saveTempResult(int data, long time)
	{
		return this.resultManager.saveTempResult(data,time);
	}
}