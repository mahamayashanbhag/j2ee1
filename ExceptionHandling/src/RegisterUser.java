import java.util.Scanner;
public class RegisterUser 
{
	String name;
	String country;
	Scanner s =new Scanner(System.in);
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your name");
		String name=s.nextString();
		System.out.println("Enter the country");
		String country=s.nextString();
			if(country=="india")
				throw new InvalidCountryException();
		

	}

}
