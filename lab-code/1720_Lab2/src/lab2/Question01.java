package lab2;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * <p><pre>
 * This app prompts the user for a time. If the input adheres the
 * input requirements, then the app prints to the console the number of minutes
 * that passed since the start of that day. Otherwise, this app crashes or has
 * possibly incorrect behaviours.
 * 
 * The start of the Xth day is defined as midnight of the (X-1)th day. For
 * instance, the start of the day Tuesday Jan 2nd, 2023 is defined as the
 * midnight of Monday Jan 1st (12:00am). 
 * 
 * See http://en.wikipedia.org/wiki/12-hour_clock
 * 
 * The smallest value is 12:00, for which 0 minutes have elapsed since the start
 * of the day (i.e., 0 hours * 60 minutes + 0 minutes = 0 + 0 = 0). The largest
 * value is 11:59, for which 719 minutes have elapsed since the start of the day
 * (i.e., 11 hours * 60 minutes + 59 minutes = 660 + 59 = 719).
 * 
 * *** Required User Input ***
 * 
 * (1) two colon-delimited tokens (e.g., h:m). Let the tokens be denoted h and
 * m, respectively. The colon may be prefixed or suffixed with an arbitrary
 * number of space characters.
 * 
 * (2) each of the two tokens can be parsed as an int
 * 
 * (3) The first token, h, has a value 0 < h <=12. The second token, m, has a
 * value 0 <= m <= 59.
 * 
 * *** App Behaviour: ***
 * 
 * If the user's input conforms to the requirements, then the app prints a value
 * as described above. Otherwise, there are no guarantees about this app's
 * behaviour. It may crash, or it may output a number that is correct or
 * incorrect.
 * 
 * *** Sample 1: ***
 * 
 * Input: 11:50
 * 
 * Output: 710
 * 
 * e.g., 11 * 60 + 50 = 710
 * 
 * *** Sample 2: ***
 * 
 * Input: 12:10  (or 0:10)
 * 
 * Output: 10
 * 
 * e.g., 0 * 60 + 10 = 10 (because 12:00 am is the start of the day, see above
 * for further explanation)
 * 
 * *** Sample 3: ***
 * 
 * Input: 56
 * 
 * Output: unspecified (app may or may not crash)
 * 
 * *** Sample 4: ***
 * 
 * Input: "" (i.e., the empty string)
 * 
 * Output: unspecified (app may or may not crash)
 * 
 * *** Sample 5: ***
 * 
 * Input: asd:asd
 * 
 * Output: unspecified (app may or may not crash)
 * 
 * *** Sample 6: ***
 * 
 * Input: 14:20
 * 
 * Output: unspecified (app may or may not crash, may produce some number,
 * perhaps 140, whereas the actual number of minutes elapsed since the start of
 * the day is 14*60+20=860)
 * 
 * *** End of Samples ***
 * </pre></p>
 * 
 * 
 */
public class Question01 {

	public static final String PROMPT = "Enter \"h:m\" (where 0 < h <= 12 and 0 <= m <= 59): ";
	public static Scanner input = new Scanner(System.in);
	public static PrintStream output = System.out;

	private Question01() { 
		/* EMPTY BY DESIGN - DO NOT MODIFY */  
	}
	
	/**
	 * Returns the elapsed time (in mins) as parsed from the input String "userInput"
	 * (as per the requirements of Question01)
	 * 
	 * @param userInput
	 * 		an input String that represents a time in 12-hr clock format
	 * 
	 * @return
	 * 		a String representing the number of minutes that have elapsed since midnight		
	 */
	public static String elapsedMins1(String userInput) {

		final int MINS_PER_HOUR = 60;
		final int TWELVE = 12;
		
		
		/*
		 * Identify and make use of a method that can be used to extract
		 * the two colon-delimited tokens from the String parameter "userInput"
		 * and store each token in its own String variable. 
		 * 
		 * For the sake of this lab question, declare the variables and assign the 
		 * variables in separate statements (you will see why we need to do this in
		 * Question02). For example, the variable names "tok1" and "tok2".
		 * 
		 * Hint: you can do this using the "split" method of String, or the
		 * nextXX from Scanner.  See the java API (java.lang.String)
		 * 
		 */


		
		 /* 
		 * You may print each token to the console (to check their values)
		 * Note: you will only see these values if running this Question manually 
		 * (i.e. playing this file), as running the tester does not ask for input
		 * from the user
		 * 
		 */
		

		
		
		/*
		 * Now identify and make use of a method that can be used to parse each
		 * token as an integer (and save in its relevant variable. For the sake of 
		 * these lab questions, declare the variables and assign the variables in 
		 * separate statements (you will see why we need to do this in Question03).
		 */
		


		/*
		 * Now implement an arithmetic expression in order to derive the number
		 * of minutes that have elapsed since midnight. Convert this result to a 
		 * String and return it (this is important as the tester uses this to evaluate
		 * the method.
		 * 
		 * You may also print the result to the console (for when you run manually)
		 * 
		 * Hint: The seemingly obvious approach would be as follows: take the
		 * inputed number of hours and multiply by the number of minutes per
		 * hour (a constant), then add to this product the inputed number of
		 * minutes. However, check to see whether this works for the boundary
		 * cases (the smallest and largest possible inputs). You will need to
		 * devise a solution that works for the full range of possible inputs.
		 * 
		 * Hint: Do not use MAGIC NUMBERS (use the constants provided in this method)
		 */
		
		return "";  //this must be changed

	}





	public static void main(String[] args) {

		/*
		 * Start by reading the comment block at the start of this class
		 * definition. Ensure that you first understand this app's
		 * specification.
		 */

		/*
		 * The variables for input/output are already setup for you as class fields,
		 * and code is already provided (BELOW) to:
		 * 
		 * 	-	PROMPT the user to type the time as input via the keyboard 
		 * 	-	scan a line of input as a String
		 * 	-	pass this String to elapsedTime1() method 
		 *  -	print out the result returned from the elapsedTime1() method
		 *  
		 *  -   Now, you need to (expand) and COMPLETE the method elapsedTime1() above, 
		 *  	to process the String and return the resulting elapsed minutes since midnight (as a String)
		 *  	as per the detailed instructions at the top of this class above
		 *  
		 *  	(you can also look at the lab API link for this lab to read a nicely 
		 *  	formatted version of the specifications for each question)
		 * 
		 * Note: 
		 * 		You may run this file directly to prompt and check what your method outputs 
		 * 		for specific typed inputs, OR you can run "TestQuestions.java" to confirm that 
		 * 		your elapsedTime1() method is passing some common test inputs.  
		 * 
		 * 		when working properly, TestQuestions.java should pass all tests for (testQ1_*) 
		 * 		-> remember to click into the TestQuestions.java file and run it to see the 
		 *         test results in the JUnit pane
		 *          
		 * 		You will use a combination of both (tester & running this file) to explore how 
		 * 		each question handles various inputs. Each question essentially meets the specs 
		 * 		of the previous question, but asks you to handle something extra - so make sure
		 * 		Question01.java works first, and copy and paste the internals of your
		 * 		Question01.elapsedMins1() method into Question02.elapsedMins2() before modifying
		 * 		it to address the additional requirements of Question02 (and so on)
		 * 
		 * 		The blue comments at the top of this file outline the spec (and are equivalent
		 * 		to the documentation found in the lab API linked on the lab2.pdf file)
		 * 
		 */


		
		// THE FOLLOWING CODE IS PROVIDED (YOU SHOULD NOT NEED TO MODIFY IT)
		
		
		// prompt user to type some input
		output.println(PROMPT);
		
		// read line using Scanner and pass to elapsedMins1() method
		String userInput = input.nextLine();
		String minsSinceMidnight = elapsedMins1(userInput);
		
		// print the resulting string returned from elapsedMins1() method
		output.println(minsSinceMidnight);

		// For completeness, close the Scanner object to eliminate the compiler warning.
		input.close();



	}
}
