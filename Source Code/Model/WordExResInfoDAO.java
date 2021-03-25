import java.sql.*;
import java.util.*;

public class WordExResInfoDAO
{
	private static WordExResInfoDAO instance;

	private WordExResInfoDAO(){}
	static{instance=new WordExResInfoDAO();}
	public static WordExResInfoDAO getInstance()
	{
		return instance;
	}
	public int insertWordExRes(String wordExInfoCode,String mistypoInfoCode,int cumInputNum,int mistypoNum)
	{
		int rownum=-1;
		PreparedStatement pstmt=null;
		ConnManager dao=ConnManager.getInstance();

		try
		{
			String sql="insert into wordexresinfo values(wordexresinfo_seq.nextval,?,?,?,?)";

			pstmt=dao.getConn().prepareStatement(sql);
			pstmt.setString(1,wordExInfoCode);
			pstmt.setString(2,mistypoInfoCode);
			pstmt.setInt(3,cumInputNum);
			pstmt.setInt(4,mistypoNum);

			rownum=pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt!=null)pstmt.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return rownum;
	}


	public int update(String wordExResInfoCode,int cumInputNum,int mistypoNum)
	{
		int rownum=-1;
		PreparedStatement pstmt=null;
		ConnManager dao=ConnManager.getInstance();

		try
		{
			String sql="update wordexresinfo set cumInputNum=?,mistypoNum=? where wordexresinfocode=?";

			pstmt=dao.getConn().prepareStatement(sql);
			pstmt.setInt(1,cumInputNum);
			pstmt.setInt(2,mistypoNum);
			pstmt.setString(3,wordExResInfoCode);

			rownum=pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt!=null)pstmt.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return rownum;
	}

	public WordExResInfo selectWordExInfo(String wordExInfoCode)
	{
		WordExResInfo info=null;
		PreparedStatement pstmt=null;
		ConnManager dao=ConnManager.getInstance();

		try
		{
			String sql="select * from wordexresinfo where wordexinfocode=?";

			pstmt=dao.getConn().prepareStatement(sql);
			pstmt.setString(1,wordExInfoCode);
			ResultSet rs=pstmt.executeQuery();

			while(rs.next())
			{
				String resCode=rs.getString("wordExResInfoCode");
				int cumNum=rs.getInt("cuminputnum");
				int misNum=rs.getInt("mistyponum");

				info=new WordExResInfo(resCode,wordExInfoCode,"",cumNum,misNum);
			}			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt!=null)pstmt.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return info;
	}

	public WordExResInfo selectMistypoInfo(String mistypoInfoCode)
	{
		WordExResInfo info=null;
		PreparedStatement pstmt=null;
		ConnManager dao=ConnManager.getInstance();

		try
		{
			String sql="select * from wordexresinfo where mistypoinfocode=?";

			pstmt=dao.getConn().prepareStatement(sql);
			pstmt.setString(1,mistypoInfoCode);
			ResultSet rs=pstmt.executeQuery();

			while(rs.next())
			{
				String resCode=rs.getString("wordExResInfoCode");
				int cumNum=rs.getInt("cuminputnum");
				int misNum=rs.getInt("mistyponum");

				info=new WordExResInfo(resCode,"",mistypoInfoCode,cumNum,misNum);
			}			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt!=null)pstmt.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return info;
	}

	public static void main(String args[])
	{
		WordExResInfoDAO dao=WordExResInfoDAO.getInstance();

		System.out.println(dao.insertWordExRes("1000","",20,30));
		

		//System.out.println(dao.update("11",100,50));
		//System.out.println(dao.selectMistypoInfo("10"));
		//System.out.println(dao.selectWordExInfo("1"));
	}

	
	
}