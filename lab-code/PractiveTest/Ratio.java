::::::::::::::
Ratio.java
::::::::::::::

import java.io.PrintStream;
import java.util.Scanner;

// RATIO CLASS (Practice Labtest 1 - W2019 - EECS1720)

/**
 * This app prompts the user for a numeric ratio to be entered as text
 * and prints some text/values to the console.
 * 
 * *** Requested User Input ***
 * 
 * (1) two colon-delimited tokens (e.g., x:y). Let the tokens be denoted x and
 * y, respectively. The colon may be prefixed or suffixed with an arbitrary
 * number of space characters. The tokens may be any number of digits.
 * 
 * (2) each of the two tokens can be parsed as an int
 * 
 * 
 * *** App Behaviour: ***
 * 
 * If the user's input conforms to the requested format, then the app calculates
 * the ratio (i.e. x/y) and prints out this as a double.
 * 
 * If the user's input does not contain a colon-delimiter, then the app does a
 * clean exit, with the message "Missing Colon!".
 * 
 * If the user's input does contain a colon-delimiter, but the tokens cannot
 * both be parsed as ints, then the app does a clean exit, with the message
 * "Non-Numeric Data!".
 * 
 * If an exception is generated when calculating the ratio, then the app should
 * handle that exception by outputting its message to the console, and doing
 * a clean exit
 * 
**/


public class Ratio {

	public static void main(String[] args) {
		
		// TOTAL FOR QUESTION 1 - [15 MARKS]

		
		// STARTER CODE (GIVEN)
		
		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);
		
		final String PROMPT = "Enter \"x:y\" (where x and y are ints): ";
		out.println(PROMPT);
		
		
		
		/*
		 * [1 mark] Task 1: Read the user's input and store it in a string
		 * variable.
		 * 
		 * Put your code in the appropriate block
		 * 
		 */
		
		// ==== SOLUTION TO TASK 1 HERE ======================
		
		
		String sumStr = in.nextLine();
		
		
		// ==== END OF SOLUTION TO TASK 1 ====================
		
		
		
		/*
		 * [5 marks] Task 2: Read the comment block above.
		 * 
		 * Now identify and make use of a service that can be used to extract
		 * the two colon-delimited tokens from the user's input, and to store
		 * each of two tokens in its own String variable. Read the contract
		 * carefully to understand what app behaviour is and is not needed.
		 * 
		 * Print each token to the console.
		 * 
		 * Put your code in the appropriate block
		 */
		
		// ==== SOLUTION TO TASK 2 HERE ======================
		
		int idx = sumStr.indexOf(':');
		
		String tok1 = "";
		String tok2 = "";
		
		try {
			tok1 = sumStr.substring(0,idx).trim();
			tok2 = sumStr.substring(idx+1,sumStr.length()).trim();
			
			out.println("tok1 = " + tok1);
			out.println("tok2 = " + tok2);
		}
		catch (IndexOutOfBoundsException e) {
			out.println("Missing Colon!");
			System.exit(0);
		}
		
		// ==== END OF SOLUTION TO TASK 2 ====================
		
		
		/*
		 * [5 marks] Task 3: Now identify and make use of a service that can be
		 * used to parse each token as an integer. Declare the variables and
		 * assign the variables. Read the contract carefully to understand what
		 * app behaviour is and is not needed.
		 * 
		 * Put your code in the appropriate block
		 */
		
		// ==== SOLUTION TO TASK 3 HERE ======================
		
		int x = 0;
		int y = 0;

		try {
			x = Integer.parseInt(tok1);
			y = Integer.parseInt(tok2);
		} 
		catch (NumberFormatException e) {
			out.println("Non-Numeric Data!");
			System.exit(0);
		}

		
		// ==== END OF SOLUTION TO TASK 3 ====================
		

		
		
		/*
		 * [4 marks] Task 4: Now calculate the ratio as a double.  
		 * Be sure to handle any potential exceptions that might arise.
		 *
		 * If an exception could occur, your method should output the message 
		 * associated with that exception, and do a clean exit
		 * 
		 * Example output if an exception does not occur:
		 * (i)  if x=43, y=2	output => "The ratio 43:2 = 21.5"
		 * (ii) if x=43, y=10	output => "The ratio 43:10 = 4.3"
		 * (iii)if x=50, y=40	output => "The ratio 50:40 = 1.25""
		 */

		// ==== SOLUTION TO TASK 4 HERE ======================
		
		try {
			double ratio = ((double)x)/y;
			out.println("The ratio " + x + ":" + y + " = " + ratio);
			
		}
		catch (ArithmeticException e) {
			out.println(e.getMessage());
			System.exit(0);
		}
		
		
		// ==== END OF SOLUTION TO TASK 4 ====================
		

	

		
		in.close();
		
		
				
	}

}
::::::::::::::
Fraction.java
::::::::::::::
/**
 * A class that represents a fraction. A Fraction has
 * an integer numerator that may be any integer value.
 * A Fraction has an integer denominator that is
 * never equal to zero.
 *
 */
public class Fraction {

	// TOTAL FOR QUESTION 2 - [15 MARKS]
	
	
	// FIELDS [ 2 marks ] 
	
	/**
	 * The numerator of the fraction.
	 */
	private int numer;
	
	/**
	 * The denominator of the fraction.
	 */
	private int denom;
	
	
	// DEFAULT CONSTRUCTOR [ 2 marks ]
	
	/**
	 * Initializes the fraction so that its numerator is
	 * equal to 1 and its denominator is equal to 1.
	 */
	public Fraction() {

		this.numer = 1;
		this.denom = 1; 
		
	}
	
	// CUSTOM CONSTRUCTOR [ 4 marks ]
	
	/**
	 * Initializes the fraction so that its numerator is
	 * equal to the given numerator and its denominator is
	 * equal to the given denominator.
	 * 
	 * @param numer the numerator of the fraction
	 * @param denom the denominator of the fraction
	 * @throws ArithmeticException if the denominator is equal to zero.
	 */
	public Fraction(int numer, int denom) {
		
		if (denom == 0) {
			throw new ArithmeticException();
		}
		this.numer = numer;
		this.denom = denom;
	}
	
	// COPY CONSTRUCTOR [ 3 marks ]
	
	/**
	 * Initializes the fraction so that its numerator and denominator
	 * are equal to the numerator and denominator of another fraction 
	 * object
	 * 
	 * @param other the other fraction object
	 * 
	 */
	public Fraction(Fraction other) {
		
		this.numer = other.numer;
		this.denom = other.denom;
	}
	
	
	// Accessors [ 4 marks ] 
	
	/**
	 * Returns the fraction as a string delimited by /
	 * i.e. it will return "x/y" where x and y are the numerator
	 * and denominator values respectively
	 * 
	 * @return String value representing fraction delimited using /
	 */
	public String getFractionAsString() {
		
		return (this.numer + "/" + this.denom);
	}
	
	/**
	 * Returns the fraction as a string delimited by :
	 * i.e. it will return "x:y" where x and y are the numerator
	 * and denominator values respectively
	 * 
	 * @return String value representing fraction delimited using /
	 */
	public String getFractionAsRatio() {
		
		return (this.numer + ":" + this.denom);
	}

	
	

	
	
}