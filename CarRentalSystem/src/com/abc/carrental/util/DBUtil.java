package com.abc.carrental.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
	public static Connection getCon()
	{
		Connection con=null;
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","globaldb","globaldb");
			
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Error @ DBUtil CNFE");
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			System.out.println("Error @ DBUtil SQLE");
			e.printStackTrace();
		}
		return con;
	}
}
