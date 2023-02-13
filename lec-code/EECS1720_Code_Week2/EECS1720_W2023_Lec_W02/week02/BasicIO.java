package week02;

import java.util.Scanner;
import java.io.PrintStream;



public class BasicIO {

	public static void main(String[] args) {	
		int aNumber;
		String aString;

		Scanner in = new Scanner(System.in);
		PrintStream out = System.out; 

		out.println("Please enter a number:");
		aNumber = in.nextInt();
		out.println("You entered = " + aNumber);

		out.println("Please enter name: ");
		aString = in.next();
		out.println("You entered = " + aString);

		//  …
		
		
		
		// ask user to input a number
		out.println("Please enter a number between 1-10: ");

		if (in.hasNextInt()) {
			aNumber = in.nextInt(); 
		}

		// ask user to input their name
		out.println("Please enter name: ");
		if (in.hasNext()) {
			aString = in.next(); 
		}


		out.println("Please enter double: ");
		if (in.hasNextDouble()) {
			double d = in.nextDouble();
		}

		
		
	}

}

