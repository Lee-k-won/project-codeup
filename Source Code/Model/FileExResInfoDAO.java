import java.sql.*;
public class FileExResInfoDAO
{
	private static FileExResInfoDAO instance;

	static
	{
		instance = new FileExResInfoDAO();
	}
	public static FileExResInfoDAO getInstance()
	{
		return instance;
	}

	private FileExResInfoDAO()
	{
		
	}
	public int insertFileExResInfo(String fileExInfoCode, Long typingTime, int typedWords, int typedChars)
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pstmt = null;
		int rowNum = 0;
		try
		{
			String sql = "INSERT INTO fileexresinfo VALUES(fileexresinfo_seq.nextVal, ?, fileexresinfo_seq.currVal,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,fileExInfoCode);
			pstmt.setLong(2, typingTime);
			pstmt.setInt(3, typedWords);
			pstmt.setInt(4, typedChars);
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
		FileExResInfoDAO dao = new FileExResInfoDAO();
		System.out.println(dao.insertFileExResInfo("1", 1000L, 30, 150));
	}
	*/
}
