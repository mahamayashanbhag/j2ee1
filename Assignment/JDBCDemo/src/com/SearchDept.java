package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DButil;

public class SearchDept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter emp no.");
		int empno=sc.nextInt();
		sc.close();
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			con=DButil.getConn();
			String sql="Select * from tb1 where empno=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,empno);
			ps.executeQuery();
			rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getString("name")+" "+rs.getString(3));
			}
			else
			{
				System.out.println("Dept does not exist");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
