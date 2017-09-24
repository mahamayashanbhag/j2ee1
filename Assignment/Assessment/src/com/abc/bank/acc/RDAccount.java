package com.abc.bank.acc;

public class RDAccount extends Account 
{
		public RDAccount(int tenure,float principal)
		{
			this.tenure=tenure;
			this.principal=principal;
		}
		
		public float calculateAmountDeposited()
		{
			float k=principal*tenure*12;
			return k;
		}
		
		public float calculateInterest()
		{
			float intr=0.0f;
			int i;
			double remainingMonth=tenure*12;
			double j;
			for(i=0;i<=tenure*12;i++)
			{
				j=remainingMonth/12;
				float k=(float) Math.pow((1+(rateOfInterest/100)/4),(4*j));
				intr += principal * (k-1);
		
				remainingMonth=remainingMonth-1;
			}
			return intr;
		}
}
