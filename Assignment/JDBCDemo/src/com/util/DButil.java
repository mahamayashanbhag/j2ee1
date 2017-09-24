package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil 
{
	private static final String driverName="oracle.jdbc.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String username="globaldb";
	private static final String password="globaldb";
	
	public static Connection getConn()
	{
		Connection con=null;
		try
		{
			Class.forName(driverName);
			con=DriverManager.getConnection(url,username,password);
			
		}
		catch(ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeconn(Connection con)
	{
		if(con!=null)
		{
			try
			{
				con.close();
			
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
