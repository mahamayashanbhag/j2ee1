package com.abc.bank.main;
import com.abc.bank.service.*;

public class MainClass {

	public static void main(String[] args)  
	{
		int tenure=3;
		float principal=1000;
		int age=23;
		String gender="Male";
		BankService b=new BankService();
		b.calculate(principal, tenure, age, gender);
	}

}
