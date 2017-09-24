package com.abc.carrental.bean;

import java.sql.Date;



public class CarBookingBean 
{
	private String bookingId;
	private Date dateOfHire;
	private String carType;
	private String customerName;
	private String phoneNumber;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public Date getDateOfHire() {
		return dateOfHire;
	}
	public void setDateOfHire(Date date) {
		this.dateOfHire = date;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
