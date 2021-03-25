import java.sql.*;
import java.util.*;

public class WordExInfoDAO
{
	private static WordExInfoDAO instance;

	private WordExInfoDAO(){}
	static
	{
		instance=new WordExInfoDAO();
	}
	public static  WordExInfoDAO getInstance()
	{
		return instance;
	}
	public int insertWordExContent(String wordTypeCode,String wordExContent)
	{
		PreparedStatement pstmt=null;
		ConnManager dao=ConnManager.getInstance();
		int rownum=-1;

		try
		{
			String sql="insert into wordexinfo values(wordexinfo_seq.nextval,?,?)";

			pstmt=dao.getConn().prepareStatement(sql);
			pstmt.setString(1,wordTypeCode);
			pstmt.setString(2,wordExContent);

			rownum=pstmt.executeUpdate();
		}
		catch (SQLException e)
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
	public ArrayList<WordExInfo> selectWordExInfo(String wordTypeCode)
	{
		PreparedStatement pstmt=null;
		WordExInfo info=null;
		ConnManager dao=ConnManager.getInstance();
		ArrayList<WordExInfo> list=new ArrayList<WordExInfo>();

		try
		{
			String sql="select * from wordexInfo where wordtypecode=? ";

			pstmt=dao.getConn().prepareStatement(sql);

			pstmt.setString(1,wordTypeCode);

			ResultSet rs=pstmt.executeQuery();

			while(rs.next())
			{
				String infoCode=rs.getString("wordexinfocode");
				String typeCode=rs.getString("wordtypecode");
				String content=rs.getString("wordexcontent");

				info=new WordExInfo(infoCode,typeCode,content);
				list.add(info);
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
		return list;
	}

	/*public static void main(String args[])
	{
		WordExInfoDAO dao=WordExInfoDAO.getInstance();

		//System.out.println(dao.insertWordType("Ãß°¡type"));
		//System.out.println(dao.selectWordType());
		System.out.println(dao.insertWordExContent("4","Threadoo"));
		System.out.println(dao.selectWordExInfo("2"));

	}*/


}