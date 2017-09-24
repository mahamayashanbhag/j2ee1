package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecordDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
	
		try
		{
			//loading driver
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver is loaded");
			//setting connection
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="globaldb";
			String password="globaldb";
			con=DriverManager.getConnection(url,username,password);
			System.out.println("Connected to Database");
			
			//Perform db operations
			String sql="insert into tb1 values(1005,'kiran',50000,'12-Jan-1990')";
			Statement st=con.createStatement();
			int result=st.executeUpdate(sql);
			System.out.println("Records inserted: "+result);//no.of records affected
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				//close connection
				con.close();
				System.out.println("Disconnected");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}
