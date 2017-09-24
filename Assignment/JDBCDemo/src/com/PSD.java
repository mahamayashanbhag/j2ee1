package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.util.DButil;

public class PSD {

	public static void main(String[] args) 
	{
		Connection con=null;
		
		try
		{
			con=DButil.getConn();
			String sql="insert into tb1 values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, 1005);
			ps.setString(2, "Manish");
			ps.setDouble(3, 75000);
			//Date 
			String stdate="10-Aug-1999";
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			
			java.util.Date d=new java.util.Date();
			d=sdf.parse(stdate);
			java.sql.Date sdate=new java.sql.Date(d.getTime());
			ps.setDate(4,sdate);
			//end date
			
			int res=ps.executeUpdate();
			System.out.println("Rows inserted"+res);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DButil.closeconn(con);
		}

	}

}
