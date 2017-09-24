import java.util.Scanner;

public class Array
{

	public static void main(String[] args)
	{
		System.out.println("Enter the size of the array");
		Scanner s =new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		System.out.println("Enter the index of the element to be accessed");
		n=s.nextInt();
		try
		{
				System.out.println(a[n]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
			
		}
	}

}
