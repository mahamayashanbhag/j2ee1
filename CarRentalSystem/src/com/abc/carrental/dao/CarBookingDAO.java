package com.abc.carrental.dao;		

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.carrental.bean.CarBookingBean;
import com.abc.carrental.util.DBUtil;

public class CarBookingDAO 
{
	public boolean bookACar(CarBookingBean bean)
	{
		Connection con=DBUtil.getCon();
		PreparedStatement ps=null;
		int rows=0;
		try 
		{
			ps = con.prepareStatement("INSERT INTO CAR_BOOKING_TBL VALUES(?,?,?,?,?");
			ps.setString(1, bean.getBookingId());
			ps.setDate(2,bean.getDateOfHire());
			ps.setString(3,bean.getCarType());
			ps.setString(4,bean.getCustomerName());
			ps.setString(5,bean.getPhoneNumber());
			rows=ps.executeUpdate();
			con.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Error in CarBookingDao.bookACar()");
			e.printStackTrace();
		}
		if(rows>0)		return true;
		return false;
	}
	
	public boolean cancelACar(String bookingId)
	{
		Connection con=DBUtil.getCon();
		PreparedStatement ps=null;
		int rows=0;
		try
		{
			ps=con.prepareStatement("DELETE FROM CAR_BOOKING_TBL WHERE BOOKING_ID=?");
			ps.setString(1,bookingId);
			rows=ps.executeUpdate();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println("Error in CarBookingDao.cancelACar()");
			e.printStackTrace();
		}
		if(rows>0)		return true;
		return false;
	}
	public int findBookedCarsByDate(java.util.Date hireDate,String carType)
	{
		Connection con=DBUtil.getCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int counter=0;
		try
		{
			ps=con.prepareStatement("SELECT * FROM CAR_BOOKING_TBL WHERE DATE_OF_HIRE=? AND CAR_TYPE=?");
			java.sql.Date sqlDate= new java.sql.Date(hireDate.getTime());
			ps.setDate(1,sqlDate);
			ps.setString(2,carType);
			rs=ps.executeQuery();
			while(rs.next())		counter++;
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println("Error in CarBookingDao.findBookedCarsByDate()");
			e.printStackTrace();
		}
		return counter;
	}
	public int getAvailableCars(String cartype)
	{
		Connection con=DBUtil.getCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int carsAvailable=0;
		try
		{
			ps=con.prepareStatement("SELECT NUMBER_OF_CARS_AVAILABLE FROM CAR_TBL WHERE CAR_TYPE=?");
			ps.setString(1,cartype);
			rs=ps.executeQuery();
			while(rs.next())		carsAvailable=rs.getInt(1);
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println("Error in CarBookingDao.findBookedCarsByDate()");
			e.printStackTrace();
		}
		return carsAvailable;
	}
	public String getBookingID(String carType)
	{
		String id=null;
		id=carType.substring(0,1);			//First two letters
		
		Connection con=DBUtil.getCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			ps=con.prepareStatement("SELECT CAR_BOOKING_SEQUENCE.NEXTVAL FROM DUAL");
			rs=ps.executeQuery();
			while(rs.next())		id=id+rs.getInt(1);
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println("Error in CarBookingDao.getBookingID()");
			e.printStackTrace();
		}
		return id;
	}
}
