import java.sql.*;
import java.util.*;

public class WordsAnalysisInfoDAO
{
	private static WordsAnalysisInfoDAO instance;
	
	static
	{
		instance = new WordsAnalysisInfoDAO();
	}

	private WordsAnalysisInfoDAO()
	{
	}

	public static WordsAnalysisInfoDAO getInstance()
	{
		return instance;
	}
	
	public ArrayList<WordsAnalysisInfo> selectRankingInfo()
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pre = null;
		ArrayList<WordsAnalysisInfo> ary= new ArrayList<WordsAnalysisInfo>();

		try
		{
			String sql = "SELECT * FROM wordsanalysisinfo ORDER BY accuracy DESC";
			pre = conn.prepareStatement(sql);

			ResultSet re = pre.executeQuery();

			while(re.next())
			{
				String wordExContent = re.getString("wordExContent");
				int accuracy = re.getInt("accuracy");

				System.out.println(wordExContent + " / " + accuracy );

				ary.add(new WordsAnalysisInfo(wordExContent,accuracy));
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if(pre != null)
				{
					pre.close();
				}
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}

		return ary;
	}

	public static void main(String[] args)
	{
		WordsAnalysisInfoDAO.getInstance().selectRankingInfo();
	}
}
