import java.sql.*;
public class FileExInfoDAO
{
	private static FileExInfoDAO instance;

	static
	{
		instance = new FileExInfoDAO();
	}
	public static FileExInfoDAO getInstance()
	{
		return instance;
	}

	private FileExInfoDAO()
	{
		
	}
	public int insertFileExInfo(String fileExInfoName, String fileExInfoContent, String fileExInfoSourcePath, long fileExInfoMTime, int totalWordNum, int totalCharNum)
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pstmt = null;
		int rowNum = 0;
		try
		{
			String sql = "INSERT INTO fileexinfo(fileexinfocode, fileexinfoname, fileexinfocontent, fileexinfosourcepath, fileexinfomtime,totalwordnum, totalcharnum) VALUES(fileexinfo_seq.nextVal, "+"?"+","+"?"+","+"?"+","+"?"+","+"?"+","+"?"+")";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,fileExInfoName);
			pstmt.setString(2,fileExInfoContent);
			pstmt.setString(3,fileExInfoSourcePath);
			pstmt.setLong(4,fileExInfoMTime);
			pstmt.setInt(5,totalWordNum);
			pstmt.setInt(6,totalCharNum);
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
	public int deleteFileExInfo(String fileExInfoCode)
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pstmt = null;
		int rowNum = 0;
		try
		{
			String sql = "DELETE FROM fileexinfo WHERE fileexinfocode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,fileExInfoCode);
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
	public FileExInfo selectFileExInfo(String fileExInfoCode)
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pstmt = null;
		FileExInfo dataSet = null;
		int rowNum = 0;
		try
		{
			String sql = "SELECT * FROM fileexinfo WHERE fileexinfocode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,fileExInfoCode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String tempFileExInfoCode = rs.getString("fileExInfoCode");
				String tempFileExInfoName= rs.getString("fileexinfoname");
				String tempFileExInfoContent= rs.getString("fileexinfocontent");
				String tempFileExInfoSourcePath = rs.getString("fileexinfosourcepath");
				long tempFileExInfoMTime = rs.getLong("fileexinfomtime");
				int tempTotalWordNum = rs.getInt("totalwordnum");
				int tempTotalCharNum = rs.getInt("totalcharnum");
				dataSet = new FileExInfo();
				dataSet.setFileExInfoCode(tempFileExInfoCode);
				dataSet.setFileExInfoName(tempFileExInfoName);
				dataSet.setFileExInfoContent(tempFileExInfoContent);
				dataSet.setFileExInfoSourcePath(tempFileExInfoSourcePath);
				dataSet.setFileExInfoMTime(tempFileExInfoMTime);
				dataSet.setTotalWordNum(tempTotalWordNum);
				dataSet.setTotalCharNum(tempTotalCharNum);
			}
		
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
		return dataSet;
	}

	/* 단위테스트 코드 */
	
	public static void main(String[] args)
	{
		FileExInfoDAO dao = FileExInfoDAO.getInstance();
		
		/*
		ExampleFactory factory = new ExampleFactory();
		int rowNum = dao.insertFileExInfo("fileex12",factory.sourceCodeData.toString(), "C:\test\fileEx12.java",1432792827043L, 142,1285);
		System.out.println(rowNum);
		*/
		//System.out.println(dao.deleteFileExInfo("11"));
		
		FileExInfo output = dao.selectFileExInfo("12");
		System.out.println(output);
	}
	
}
