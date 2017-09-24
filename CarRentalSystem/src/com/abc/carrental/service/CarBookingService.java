package com.abc.carrental.service;

import com.abc.carrental.bean.CarBookingBean;
import com.abc.carrental.dao.CarBookingDAO;

public class CarBookingService 
{
	public String bookACar(CarBookingBean Bean)
	{
		if(Bean==null)							return "FAILURE";
		if(Bean.getCustomerName().equals(""))	return "FAILURE";
		if(Bean.getDateOfHire().equals(""))		return "FAILURE";
		if(Bean.getPhoneNumber().length()<10)	return "FAILURE";
		
		CarBookingDAO k=new CarBookingDAO();
		int carsAvailable=k.getAvailableCars(Bean.getCarType());
		int carsBooked;
		String id;
		if(carsAvailable==0) return "NO CARS OF THE GIVEN TYPE AVAILABLE";
		else	carsBooked=k.findBookedCarsByDate(Bean.getDateOfHire(),Bean.getCarType());
		if(carsAvailable-carsBooked<=0)	return "NO CARS AVAILABLE ON GIVEN DATE";
		else		
		{
				id=k.getBookingID(Bean.getCarType());
				Bean.setBookingId(id);
				boolean result=k.bookACar(Bean);
				if(result)		return "SUCCESS";
		}
		return "FAILURE";
	}
	
	/*public String cancelACar(String bookingId)
	{
		
	}*/
}
