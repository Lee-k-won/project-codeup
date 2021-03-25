import java.sql.*;
public class MistypoInfoDAO
{
	private static MistypoInfoDAO instance;

	static
	{
		instance = new MistypoInfoDAO();
	}
	public static MistypoInfoDAO getInstance()
	{
		return instance;
	}

	private MistypoInfoDAO()
	{
		
	}
	public int insertMistypoInfo(String fileExInfoCode, String mistypo)
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pstmt = null;
		int rowNum = 0;
		try
		{
			String sql = "INSERT INTO mistypoinfo VALUES(mistypoinfo_seq.nextVal,'1',?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,fileExInfoCode);
			pstmt.setString(2, mistypo);
			rowNum = pstmt.executeUpdate();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return rowNum;
	}
	/* 단위테스트 코드 */
	/*
	public static void main(String[] args)
	{
		MistypoInfoDAO dao = MistypoInfoDAO.getInstance();
		System.out.println(dao.insertMistypoInfo("9", "GregorianCalendar"));
	}
	*/
}
