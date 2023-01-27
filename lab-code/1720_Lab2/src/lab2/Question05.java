package lab2;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * <p><pre>
 * This app prompts the user for a time (in the form h:m:am or
 * h:m:AM or h:m:pm or h:m:PM). If the input adheres the input requirements,
 * then the app prints to the console the number of minutes that passed since
 * the start of that day or otherwise the specified feedback message. Otherwise,
 * this app crashes or has possibly incorrect behaviours.
 * 
 * The start of the Xth day is defined as midnight of the (X-1)th day. For
 * instance, the start of the day Tuesday Jan 2nd, 2023 is defined as the
 * midnight of Monday Jan 1st (12:00am). 
 * 
 * See http://en.wikipedia.org/wiki/12-hour_clock
 * 
 * The smallest value is 12:00:am, for which 0 minutes have elapsed since the
 * start of the day (i.e., 0 hours * 60 minutes + 0 minutes = 0 + 0 = 0).
 * 
 * 
 * The value 12:00:pm refers to noon, for which 720 minutes have elapsed since
 * the start of the day (i.e., 12 hours * 60 minutes + 0 minutes = 720 + 0 =
 * 720). For hours, the meridiem "pm" starts at 12 and finishes at 11. The
 * largest value is 11:59:pm, for which 1439 minutes have elapsed since the
 * start of the day (i.e., 23 hours * 60 minutes + 59 minutes = 1380 + 59 =
 * 1439). When the hour 12 is reached after 11, this marks the start of the next
 * day and is not within the day's range of times.
 * 
 * *** Required User Input ***
 * 
 * (1) an input that *ideally* contains three colon-delimited tokens (e.g.,
 * h:m:ind). Let the tokens be denoted h, m, and ind, respectively. But possibly
 * not. If the first and second colons are present, then the colon may be
 * prefixed or suffixed with an arbitrary number of space characters.
 * 
 * (2) if the first colon-delimiter is present, then each of the two tokens can
 * *ideally* be parsed as an int. But possibly not.
 * 
 * (2b) If the second colon-delimiter is present, then the third token *ideally*
 * will be "am" or "pm" (case-insensitive). But possibly not.
 * 
 * (3) if the first token, h, can be parsed as an int, then it *ideally* has a
 * value 0 < h <=12, but possibly not. If the second token, m, can be parsed as
 * an int, then *ideally* it has a value 0 <= m <= 59, but possibly not.
 * 
 * 
 * *** App Behaviour: ***
 * 
 * If the user's input does not contain two colon-delimiters, then the app does
 * a clean exit, with the message "Missing Colon!".
 * 
 * If the user's input does contain two colon-delimiters, but the first two
 * tokens cannot both be parsed as ints, then the app does a clean exit, with
 * the message "Non-Numeric Data!". If the third token is not am or pm
 * (case-insensitive), then the app does a clean exit, with the message "Invalid
 * AM/PM indicator!".
 * 
 * If the user's input contains two colon-delimiters and the tokens can be
 * parsed as specified above, and the first first tokens adhere to requirement
 * (3), then this app prints a value as described above. Otherwise, the app does
 * a clean exit, with the message "Values out of range!".
 * 
 * If the user input is not ideal for several reasons (e.g., does not have a
 * colon, nor can the tokens be parsed as ints, then the app's behaviour will be
 * determined by the order specified above.
 * 
 * *** Sample 1: ***
 * 
 * Input: 11:50:am
 * 
 * Output: 710
 * 
 * e.g., 11 * 60 + 50 = 710
 * 
 * *** Sample 2a: ***
 * 
 * Input: 12:10:am (or 0:10:am)
 * 
 * Output: 10
 * 
 * e.g., 0 * 60 + 10 = 10 (because 12:00 am is the start of the day, see above
 * for further explanation)
 * 
 * *** Sample 2b: ***
 * 
 * Input: 12:10:pm
 * 
 * Output: 730
 * 
 * e.g., 12 * 60 + 10 = 730 (because 12:00 pm is the middle of the day, see
 * above for further explanation)
 * 
 * *** Sample 2b: ***
 * 
 * Input: 0:10:pm
 * 
 * Output: Values out of range!
 * 
 * e.g., 12 * 60 + 10 = 730 (because 12:00 pm is the middle of the day, see
 * above for further explanation)
 * 
 * *** Sample 3: ***
 * 
 * Input: 56
 * 
 * Output: Missing Colon!
 * 
 * *** Sample 4: ***
 * 
 * Input: "" (i.e., the empty string)
 * 
 * Output: Missing Colon!
 * 
 * *** Sample 5: ***
 * 
 * Input: asd:asd
 * 
 * Output: Non-numeric data!
 * 
 * *** Sample 6: ***
 * 
 * Input: 14:20
 * 
 * Output: Values out of range!
 * 
 * *** Sample x: ***
 * 
 * Input: 16:35:am
 * 
 * Output: Values out of range!
 * 
 * *** Sample x: ***
 * 
 * Input: 2:30:PP
 * 
 * Output: Invalid AM/PM indicator!
 *
 * *** End of Samples ***
 * 
 * </pre></p>
 */
public class Question05 {

	final static String PROMPT = "Enter \"h:m:ind\" (where 0 < h <= 12 and 0<=m< 60 and ind=AM or PM (case-insensitive)> ";public static final String PROMPT2 = "Enter \"h:m:xx\" (where 0 <= h <= 12 and 0 <= m < 60): ";
	
	public static Scanner input = new Scanner(System.in);
	public static PrintStream output = System.out;


	private Question05() { 
		/* EMPTY BY DESIGN - DO NOT MODIFY */  
	}

	/**
	 * Returns the elapsed time (in mins) as parsed from the input String "userInput"
	 * (as per the requirements of Question05)
	 * 
	 * @param userInput
	 * 		an input String that represents a time in 12-hr clock format
	 * 
	 * @return
	 * 		a String representing the number of minutes that have elapsed since midnight		
	 */
	public static String elapsedMins5(String timeStr) {

		final int MINS_PER_HOUR = 60;
		final int TWELVE = 12;

		/*
		 * Step 1: Cut and paste your solution from Question04 here (reduce the
		 * comments as appropriate).
		 */

		/*
		 * Step 2: Read the comment block above. You will see that the
		 * specification of the app has been changed so that the user needs to
		 * include a third token (to deal with am/pm). 
		 * 
		 * 
		 * Solve this exercise by adding on to the structure of Question04.
		 * 
		 * Your solution should still work for input that 
		 * 
		 */



	
		return "";		// this must be changed


	}




	public static void main(String[] args) {
		

		// THE FOLLOWING CODE IS PROVIDED (YOU SHOULD NOT NEED TO MODIFY IT)


		// prompt user to type some input
		output.println(PROMPT);

		// read line using Scanner and pass to elapsedMins1() method
		String userInput = input.nextLine();
		String minsSinceMidnight = elapsedMins5(userInput);

		// print the resulting string returned from elapsedMins1() method
		output.println(minsSinceMidnight);

		// For completeness, close the Scanner object to eliminate the compiler warning.
		input.close();


	}
}
