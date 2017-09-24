package com.abc.bank.acc;

public abstract class Account 
{
		int tenure;				//Total no of years
		float principal;		//Principal Amount
		float rateOfInterest;	//Interest rate
		public void setInterest(int age,String gender)
		{
			if(gender.equals("Male"))
			{
				if(age<60)
				{
					rateOfInterest=9.8f;
				}
				else if(age>=60)
				{
					rateOfInterest=10.5f;
				}
			}
			if(gender.equals("Female"))
			{
				if(age<58)
				{
					rateOfInterest=10.2f;
				}
				else if(age>=58)
				{
					rateOfInterest=10.8f;
				}
			}
		}

		public float calculateMaturityAmount(float totalPrincipleDeposited,float maturityInterest)
		{
			float sum = totalPrincipleDeposited + maturityInterest;
			return sum;
		}

		public abstract float calculateAmountDeposited();






}
