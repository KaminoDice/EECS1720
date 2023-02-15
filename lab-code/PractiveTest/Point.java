============
Point.java
============


import java.io.PrintStream;
import java.util.Scanner;


// Point APP (test1b - Question 1)

/**
* This app prompts the user for a double (x) and double (y) to be entered as text
* and prints some text/values to the console.
* 
* *** Requested User Input ***
* 
* (1) two comma-delimited tokens (e.g., x,y). Let the tokens be denoted x and
* y, respectively. The comma ',' may be prefixed or suffixed with an arbitrary
* number of space characters.
* 
* (2) both x and y must be parsed as doubles
* 
* 
* *** App Behaviour: ***
* 
* If the user's input conforms to the requested format, then the app will output both
* the magnitude of the coordinate (distance from the origin) as the following string: 
* "magnitude = m" where m is the distance from (0,0) (printed as a double to 2 decimal 
* places):
* 
* Examples:		user types: "4.5,-8.12"    output: "(magnitude = 9.28)"
* 				user types: "-2.356,1.5"   output: "(magnitude = 2.79)"
* 				user types: "3.723,10.8"   output: "(magnitude = 11.42)"
*
* 
* If the user's input does not contain a ',' delimiter, then the app does a
* clean exit, with the message "Missing Comma (,)".
* 
* If the user's input does contain a ',' delimiter, but the tokens cannot
* both be parsed as doubles, then the app does a clean exit, with the message
* "Numeric Data Invalid!".
* 
* If the magnitude of the coordinate (m) is larger than 100, then the app
* should generate and catch an ArithmeticException that displays the message: 
* "Magnitude too large!", before doing a clean exit.
* 
* 
**/


public class Point {

	public static void main(String[] args) {
		
		
		
		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);
		final String PROMPT = "Enter \"x,y\" (where x and y are doubles): ";
		out.println(PROMPT);

		
		/*
		 * [1 mark] Task 1: Read the user's input and store it in a string
		 * variable.
		 * 
		 * Put your code in the appropriate block
		 * 
		 */
		
		// ==== SOLUTION TO TASK 1 HERE ======================
		
		

		String inStr = in.nextLine();
		
		
		
		
		
		
		// ==== END OF SOLUTION TO TASK 1 ====================
	
		
		
		/*
		 * [5 marks] Task 2: Read the comment block above.
		 * 
		 * Now identify and make use of a service that can be used to extract
		 * the two comma-delimited tokens from the user's input, and to store
		 * each of two tokens in its own String variable. Read the contract
		 * carefully to understand what app behaviour is and is not needed.
		 * 
		 * Print each token to the console.
		 * 
		 * Put your code in the appropriate block
		 */
		
		// ==== SOLUTION TO TASK 2 HERE ======================
		
		

		String[] tokens = inStr.split(",");
		
		String xStr = tokens[0].trim();
		String yStr = "";
		
		try {
			yStr = tokens[1].trim();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
			out.println("Missing Comma (,)");
			System.exit(0);
			
		}
		
		
		
		// ==== END OF SOLUTION TO TASK 2 ====================
		
	
		
		/*
		 * [4 marks] Task 3: Now identify and make use of a service that can be
		 * used to parse each token as a double. Declare the variables and
		 * assign the variables. Read the contract carefully to understand what
		 * app behaviour is and is not needed.  
		 * 
		 * 
		 * Put your code in the appropriate block
		 */
		
		// ==== SOLUTION TO TASK 3 HERE ======================
		
		double x=0.0;
		double y=0.0;
		
		
		try {
			x = Double.parseDouble(xStr);
			y = Double.parseDouble(yStr);
		}
		catch (NumberFormatException e) {
			
			out.println("Numeric Data Invalid!");
			System.exit(0);
		}
		
		
		
		

		// ==== END OF SOLUTION TO TASK 3 ====================
		

	
		
		/*
		 * [5 marks] Task 4: Create code that will generate and handle the final 
		 * ArithmeticException condition listed in the app behaviour description.
		 * These should ensure that the magnitude is within a value of 100
		 * 
		 * Make sure the correct message is generated for this condition
		 * and that the app does a clean exit.
		 * 
		 * Finally, output the magnitude in the string format described
		 * in the app behaviour description.  
		 * 
		 * Hint: The Math.hypot(...) method may be used to find the magnitude. 
		 * 
		 */

		// ==== SOLUTION TO TASK 4 HERE ======================
		
		double magnitude = Math.hypot(x, y);

		try {
			
			if (magnitude>100) {
				throw new ArithmeticException("Magnitude too large!");
			}
			
		}
		catch (ArithmeticException e) {
			
			out.println(e.getMessage());
			System.exit(0);
		}
				
		out.printf("(magnitude = %.2f)", magnitude);

		
		
		// ==== END OF SOLUTION TO TASK 4 ====================
		

	

		
		in.close();
		
		
		
	}

}



===========
Range.java
===========


// Range CLASS (test1b - Question 2)


/**
 * A class that represents a range of integer values. A range
 * has a minimum value and a maximum value.
 *
 */
public class Range {

	// TOTAL FOR QUESTION 2 - [15 MARKS]
	
	private static final int DEF_MIN = -1;
	private static final int DEF_MAX = 1;
	
	// FIELDS [ 2 marks ] 
	/**
	 * The minimum value of the range.
	 */
	private int minimum;
	
	
	
	
	/**
	 * The maximum value of the range.
	 */
	
	private int maximum;
	
	
	
	
	
	// DEFAULT CONSTRUCTOR  [ 2 marks ]
	
	/**
	 * Initializes this range to have a minimum value of -1
	 * and a maximum value of +1.
	 * 
	 */
	public Range() {
	
		this.minimum = Range.DEF_MIN;
		this.maximum = Range.DEF_MAX;
		
		
	}
	
	// CUSTOM CONSTRUCTOR  [ 4 marks ]
	
	/**
	 * Initializes the range to have the given minimum and maximum
	 * values.
	 * 
	 * @param min the minimum value of the range
	 * @param max the maximum value of the range
	 * @throws IllegalArgumentException if min is greater than
	 * or equal to max
	 */
	public Range(int min, int max) {
	

		if (min >= max) {
			throw new IllegalArgumentException();
		}
		
		this.minimum = min;
		this.maximum = max;
		
	
		
	}
	
	
	
	
	// ACCESSORS [ 2 marks ]
	
	
	// 2 marks
	
	/**
	 * Output the state of this Range object formatted as 
	 * the string: "(min,max)" 
	 *
	 *
	 * e.g. if Range has a min=-4 and a max=8, toString() would return:
	 * "(-4,8)"
	 * 
	 */
	public String toString() {
		
		String result = "";
		
		result += "(" + this.minimum + "," + this.maximum + ")" ;
		
		return result;
		
		
		
	}	
	
	
	
	// OTHER METHODS [ 5 marks ]
	
	// 2 marks
	
	/**
	 * Return the size of the range (i.e. max-min)
	 * 
	 */
	public int size() {
		
		return (this.maximum - this.minimum);
		
		
	}
	
	
	// 3 marks

	/**
	 * Return the value of the centre of the range
	 * (i.e. the average of min and max)
	 * 
	 */
	public double centre() {
		
		final double HALF = 0.5;
		
		return (HALF * ( this.minimum + this.maximum ) );

		
	}

	
	
	////////////////////////////////////////////////////////////////////////////
	//
	// MAIN METHOD (You may define a main method below for testing your class)
	// =====================================================================
	//
	// uncomment and use the following main method if you would like to create 
	// Range object(s) and test methods.
	// 
	// No code provided in a main method will be marked however !!
	// (note: a main is not actually needed to complete this question)
	//
	////////////////////////////////////////////////////////////////////////////
	
	
	
	public static void main(String[] args) {
		
		// not marked

		Range r1 = new Range();
		Range r2 = new Range(1, 6);
		Range r3 = new Range(-4, 14);
		
		System.out.println("r1 = " + r1.toString());
		System.out.println("r1 size = " + r1.size());
		System.out.println("r1 centre = " + r1.centre());
		
		System.out.println("r2 = " + r2.toString());
		System.out.println("r2 size = " + r2.size());
		System.out.println("r2 centre = " + r2.centre());
		
		System.out.println("r3 = " + r3.toString());
		System.out.println("r3 size = " + r3.size());
		System.out.println("r3 centre = " + r3.centre());
		
	
	}
	

	
	
}

