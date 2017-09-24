package com;

import java.util.Calendar;
import java.util.Date;
public class Datedemo {

	public static void main(String[] args) {
		
		Date d=new Date();
		System.out.println(d);
		
		Calendar cal=Calendar.getInstance();
		System.out.println(+cal.get(Calendar.DATE));
	}

}
