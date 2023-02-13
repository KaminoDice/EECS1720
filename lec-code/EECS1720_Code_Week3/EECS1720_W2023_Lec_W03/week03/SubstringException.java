package week03;
import java.util.Scanner;

public class SubstringException {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a fraction (x/y) ");
		System.out.println("and I will give you the quotient"); 
		String str = in.nextLine(); 

		int slash = str.indexOf("/") ; 
		String left = str.substring(0, slash); 
		String right = str.substring(slash + 1); 

		int numer = Integer.parseInt(left); 
		int denom = Integer.parseInt(right); 
		int quotient = numer/denom; 

		System.out.println("Quotient = " + quotient); 
		in.close();
		
		
	}
	
	
}
