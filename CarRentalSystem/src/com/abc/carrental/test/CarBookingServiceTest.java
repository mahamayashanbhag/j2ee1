package com.abc.carrental.test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.abc.carrental.bean.CarBookingBean;
import com.abc.carrental.service.CarBookingService;

public class CarBookingServiceTest 
{
	CarBookingService service=null;
	@Before
	public void setUp()
	{
		service=new CarBookingService();
	}
	@After
	public void tearDown()
	{
		service=null;
	}
	@Test
	public void testBookACar()
	{
		CarBookingBean cBean=new CarBookingBean();
		cBean.setCarType("small");
		cBean.setCustomerName("Manish");
		cBean.setPhoneNumber("8951138695");
		Calendar cal=Calendar.getInstance();
		cBean.setDateOfHire((Date) cal.getTime());
		String result=service.bookACar(cBean);
		assertEquals("SUCCESS",result);
	}
	/*@Test*/
	/*public void testCancelACar()
	{
		CarBookingBean bean=new CarBookingBean();
		String Booking_Id=bean.getBookingId();
		boolean result=;
		assertEquals("SUCCESS",result);
	}*/
}
