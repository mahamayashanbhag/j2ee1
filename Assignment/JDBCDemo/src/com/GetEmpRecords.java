package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetEmpRecords {

	public static void main(String[] args) {

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
			
			String sql="Select * from tb1";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
		
			while(rs.next())
			{
				System.out.println("Empno:"+rs.getInt(1)+" Name:"+rs.getString(2)+" Salary:"+rs.getDouble(3)+" DOB:"+rs.getDate(4));
			}
		
		
		
		
		
		
		}
		//Perform db operations
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
