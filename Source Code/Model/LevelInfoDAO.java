import java.sql.*;
import java.util.*;
public class LevelInfoDAO
{
	private static LevelInfoDAO instance;
	static
	{
		instance = new LevelInfoDAO();
	}
	private LevelInfoDAO()
	{
		
	}
	public static LevelInfoDAO getInstance()
	{
		return instance;
	}

	public LevelInfo[] selectLevelInfo()
	{
		Connection conn = ConnManager.getInstance().getConn();
		PreparedStatement pstmt = null;
		ArrayList<LevelInfo> info = null;
		try
		{
			info = new ArrayList<LevelInfo>();
			String sql = "SELECT * FROM levelinfo";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String tempLevelInfoCode = rs.getString("levelinfocode");
				int tempLevelNum = rs.getInt("levelnum");
				int tempCriteria = rs.getInt("criteria");
				info.add(new LevelInfo(tempLevelInfoCode, tempLevelNum, tempCriteria));
			}
			if(info == null)
				return null;
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
				if(conn != null) conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return info.toArray(new LevelInfo[info.size()]);
	}
	/* 단위 테스트 코드*/
	public static void main(String[] args)
	{
		LevelInfoDAO dao = LevelInfoDAO.getInstance();
		LevelInfo[] info = dao.selectLevelInfo();
		for(LevelInfo temp : info)
		{
			System.out.println(temp);

		}
	}
}