package week03;

import java.util.Scanner;

public class DivByZeroOrBadInput {
	
	
	public static boolean matchesInt(String num) {
		
		String regex = "";			// ?? what regex checks if string is an int?
		
		return num.matches(regex);  // InputMismatchException is detected by something similar to this
		
	}
	

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the first integer:");
		//System.out.println("-> int? = " + matchesInt(in.next()));
		
		int a = in.nextInt();
		
		System.out.println("Enter the second:");
		//System.out.println("-> int? = " + matchesInt(in.next()));
		
		int b = in.nextInt();

		int c = a / b;
		System.out.println("Their quotient is: " + c);
		
		
		in.close();

	}

}


