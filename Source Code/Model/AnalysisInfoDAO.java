import java.sql.*;

public class AnalysisInfoDAO
{
	private static AnalysisInfoDAO instance;

	static
	{
		instance = new AnalysisInfoDAO();
	}

	public AnalysisInfoDAO()
	{
	}

	public static AnalysisInfoDAO getInstance()
	{
		return instance;
	}

	public AnalysisInfo selectAnalysisInfo()
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pre = null;
		AnalysisInfo info = null;

		try
		{
			String sql = "SELECT * FROM AnalysisInfo";
			pre = conn.prepareStatement(sql);

			ResultSet re = pre.executeQuery();

			while(re.next())
			{
				int totalWords = re.getInt("totalWords");
				int totalChars = re.getInt("totalChars");

				System.out.println(totalWords + " / " + totalChars );

				info = new AnalysisInfo(totalWords,totalChars);
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

		return info;
	}

	public static void main(String[] agrs)
	{
		AnalysisInfoDAO.getInstance().selectAnalysisInfo();
	}
}

