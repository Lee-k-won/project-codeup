import java.sql.*;

public class ConnManager
{
	private static ConnManager instance;
	private static Connection conn;
	private String url;
	private String dbId;
	private String dbPw;

	static
	{
		instance = new ConnManager();
	}
	public static ConnManager getInstance()
	{
		return instance;
	}
	public static Connection getConn()
	{
		return conn;
	}
	private ConnManager()
	{
		this.url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		this.dbId = "betting";
		this.dbPw = "123";
		connect();
	}

	private void connect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,dbId,dbPw);
			System.out.println("DB정상 접속");
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public void disConnect()
	{
		try
		{
			if(this.conn != null) this.conn.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}

	
}