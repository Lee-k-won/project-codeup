import java.sql.*;
import java.util.*;

public class SimpleFileExInfoDAO
{
	private static SimpleFileExInfoDAO instance;

	static
	{
		instance = new SimpleFileExInfoDAO();
	}

	public SimpleFileExInfoDAO()
	{
	}

	public static SimpleFileExInfoDAO getInstance()
	{
		return instance;
	}

	public ArrayList<SimpleFileExInfo> selectSimpleFileExInfo()
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pre = null;
		ArrayList<SimpleFileExInfo> ary= new ArrayList<SimpleFileExInfo>();

		try
		{
			String sql = "SELECT * FROM SimpleFileExInfo ORDER BY fileexinfolevel, fileexinfoname";
			pre = conn.prepareStatement(sql);

			ResultSet re = pre.executeQuery();

			while(re.next())
			{
				String fileExInfoName = re.getString("fileexinfoname");
				String fileExInfoCode = re.getString("fileexinfocode");
				int fileExInfoLevel = re.getInt("fileexinfolevel");

				System.out.println(fileExInfoName + " / " + fileExInfoCode + " / " + fileExInfoLevel );

				ary.add(new SimpleFileExInfo(fileExInfoName,fileExInfoCode,fileExInfoLevel));
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
		SimpleFileExInfoDAO.getInstance().selectSimpleFileExInfo();
	}
}