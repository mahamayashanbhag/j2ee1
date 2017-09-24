package com.abc.carrental.actions;

import com.abc.carrental.bean.CarBookingBean;
import com.abc.carrental.service.CarBookingService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookACarAction extends ActionSupport implements ModelDriven
{
	CarBookingBean bean=new CarBookingBean();
	
	public Object getModel()	{	return bean;}  //unimplemented function
	
	public String execute()
	{
		CarBookingService k=new CarBookingService();
		if(k.bookACar(bean).equals("SUCCESS"))	return SUCCESS;
		return ERROR;
	}
}
