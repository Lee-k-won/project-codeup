import java.sql.*;
import java.util.*;

public class WPMAnalysisInfoDAO
{
	private static WPMAnalysisInfoDAO instance;

	static
	{
		instance = new WPMAnalysisInfoDAO();
	}

	private WPMAnalysisInfoDAO()
	{
	}

	public static WPMAnalysisInfoDAO getInstance()
	{
		return instance;
	}

	public ArrayList<WPMAnalysisInfo> selectWPMInfo()
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pre = null;
		ArrayList<WPMAnalysisInfo> ary= new ArrayList<WPMAnalysisInfo>();

		try
		{
			String sql = "SELECT * FROM wpmanalysisinfo";
			pre = conn.prepareStatement(sql);

			ResultSet re = pre.executeQuery();

			while(re.next())
			{
				int trialNum = re.getInt("trialNum");
				int WPM = re.getInt("WPM");

				System.out.println(trialNum + " / " + WPM );

				ary.add(new WPMAnalysisInfo(trialNum,WPM));
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
		WPMAnalysisInfoDAO.getInstance().selectWPMInfo();
	}
}