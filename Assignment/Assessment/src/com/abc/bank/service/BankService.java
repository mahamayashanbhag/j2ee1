package com.abc.bank.service;
import com.abc.bank.acc.*;
public class BankService 
{
	public boolean validateData(float principal,int tenure,int age,String gender)
	{
		boolean res=true;
		if(principal<500)
		{
			try
			{
				res=false;
			}
			finally
			{
				System.out.println("Invalid Data");
			}
		}
		if(tenure==5 || tenure == 10)
		{
			
		}
		else
		{
			try
			{
				res=false;
			}
			finally
			{
				System.out.println("Invalid Data");
			}
		}
		if(gender.equals("Male") || gender.equals("Female"))
		{
			
		}
		else
		{
			try
			{
				res=false;
			}
			finally
			{
				System.out.println("Invalid Data");
			}
		}
		return res;
	}

	public void calculate(float principal,int tenure,int age,String gender)
	{
		boolean k=validateData(principal,tenure,age,gender);
		if(k)
		{
			RDAccount a=new RDAccount(tenure,principal);
			a.setInterest(age,gender);
			float totalPrincipleDeposited;
			float maturityInterest;
			totalPrincipleDeposited=a.calculateAmountDeposited();
			maturityInterest=a.calculateInterest();
			System.out.println("Calculated Interest:"+maturityInterest);
			System.out.println("Calculated Amount Deposited:"+totalPrincipleDeposited);
			System.out.println("Calculated Maturity Amount:"+a.calculateMaturityAmount(maturityInterest,totalPrincipleDeposited));
			
		}
	}


}
