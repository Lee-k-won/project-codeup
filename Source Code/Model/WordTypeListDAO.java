import java.sql.*;
import java.util.*;

public class WordTypeListDAO
{
	private static WordTypeListDAO instance;

	private WordTypeListDAO(){}
	static
	{
		instance=new WordTypeListDAO();
	}
	public static WordTypeListDAO getInstance()
	{
		return instance;
	}
	public int insertWordType(String wordTypeName)
	{
		int rownum=-1;
		PreparedStatement pstmt=null;
		ConnManager dao=ConnManager.getInstance();


		try
		{
			String sql="insert into wordtypeList values(wordtypelist_seq.nextval,?)";
			pstmt=dao.getConn().prepareStatement(sql);

			pstmt.setString(1,wordTypeName);

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
				dao.disConnect();//
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return rownum;
	}

	public ArrayList<WordTypeList> selectWordType()
	{
		//String[] arr=null;
		ArrayList<WordTypeList> list=new ArrayList<WordTypeList>();
		WordTypeList type=null;
		PreparedStatement  pstmt=null;
		ConnManager dao=ConnManager.getInstance();


		try
		{
			String sql="select * from wordtypeList";
			pstmt= dao.getConn().prepareStatement(sql);

			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				String code=rs.getString("wordtypecode");
				String name=rs.getString("wordtypename");
				type=new WordTypeList(code,name);
				list.add(type);
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
			try{
				if(pstmt!=null) pstmt.close();
			}
			catch(SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return list;
	}

	public int deleteWordType(String wordTypeCode)
	{
		int rownum=-1;
		ConnManager dao=null;
		PreparedStatement pstmt=null;

		try
		{
			String sql="delete from wordtypelist where wordtypecode=?";

			pstmt=dao.getConn().prepareStatement(sql);
			pstmt.setString(1,wordTypeCode);
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



	public int updateWordType(String wordTypeCode,String wordTypeName)
	{
		int rownum=-1;
		ConnManager dao=null;
		PreparedStatement pstmt=null;

		try
		{
			String sql="update wordtypelist set wordtypename=? where wordtypecode=?";


			pstmt=dao.getConn().prepareStatement(sql);
			pstmt.setString(1,wordTypeName);
			pstmt.setString(2,wordTypeCode);
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

	/*public static void main(String args[])
	{
		WordTypeListDAO dao=WordTypeListDAO.getInstance();

		//System.out.println(dao.insertWordType("Ãß°¡type"));
		//System.out.println(dao.selectWordType());
		System.out.println(dao.deleteWordType("5"));
		//System.out.println(dao.updateWordType("4","java.io"));

		
		
	}*/
	

}