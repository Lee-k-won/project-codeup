public class WordCheckController
{
	WordTracker tracker;
	WordTimer timer;
	WordChecker checker;
	WordConditions conditions;
	WordCheckDataManager dataManager;

	public WordCheckController()
	{
		tracker = new WordTracker();
		timer = new WordTimer();
		checker = new WordChecker();
		conditions = new WordConditions();
		dataManager = new WordCheckDataManager();
	}


}