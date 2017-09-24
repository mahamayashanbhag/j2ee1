import java.util.Scanner;
public class Square {
	public static void main(String[] m){
		Scanner s =new Scanner(System.in);
		try{
			int n=Integer.parseInt(s.next());
			System.out.println("Square of number is"+n*n);
		}
		catch(NumberFormatException e){
			System.out.println("Input integers");
			
		}
	}
		
}
