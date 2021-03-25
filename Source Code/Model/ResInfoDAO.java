import java.sql.*;

public class ResInfoDAO
{
	private static ResInfoDAO instance;

	static
	{
		instance = new ResInfoDAO();
	}

	private ResInfoDAO()
	{
	}

	public static ResInfoDAO getInstance()
	{
		return instance;
	}

	public ResInfo selectResInfo(String fileExInfoCode)
	{
		ResInfo res = null;
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pre = null;

		try
		{
			String sql = "SELECT * FROM resinfo where fileexinfocode = ?";
			pre = conn.prepareStatement(sql);

			pre.setString(1,fileExInfoCode);

			ResultSet re = pre.executeQuery();

			while(re.next())
			{
				long minTypingTime = re.getLong("mintypingtime");
				String fileExInfoCode1 = re.getString("fileexinfocode");

				res = new ResInfo(minTypingTime,fileExInfoCode1);

				System.out.println(minTypingTime + " / " + fileExInfoCode1);
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

		return res;
	}

	public static void main(String[] args)
	{
		ResInfoDAO.getInstance().selectResInfo("1");
	}
}