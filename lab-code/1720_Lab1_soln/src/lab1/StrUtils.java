package lab1;

import java.util.Scanner;

/**
 * Utility class with short methods reviewing fundamental Java concepts
 * working with: conditional logic, branching and use of an external class (Range)
 * 
 * @author EECS1720 Winter 2023
 *
 */
public class StrUtils {

	/**
	 * The course name for EECS1720.
	 */
	public static final String COURSE_NAME = "Building Interactive Systems";

	private StrUtils() {
		// EMPTY BY DESIGN (nothing to do here)
	}

	/**
	 * Returns the course name as the string.
	 * 
	 * @return the string equal to COURSE_NAME (located in N
	 */
	public static String getCourseName() {

		return StrUtils.COURSE_NAME;
	}

	/**
	 * Returns a string representation of a <code>Range</code> that is different
	 * than the one returned by <code>Range.toString</code>.
	 * 
	 * <p>
	 * The returned string has the form <code>"range from x to y"</code> where x
	 * is the minimum value of the range and y is the maximum value of the
	 * range.
	 * 
	 * @param r
	 *            a Range instance
	 *            
	 * @return a string representation of the range
	 */
	public static String toString(Range r) {

		return "range from " + r.getMinimum() + " to " + r.getMaximum();
	}

	/**
	 * Returns the character located in the middle of the string. If
	 * <code>s</code> has an even number of characters then the middle character
	 * is taken to be the first character in the second half of the string
	 * (i.e., the middle character of the string <code>"abcd"</code> is
	 * <code>'c'</code>.
	 * 
	 * @param s
	 *            a string of length 1 or greater
	 *            
	 * @return the middle character of s
	 */
	public static char middleChar(String s) {


		// NOTE: you can assume that the String is always a non-empty string

		int middleIndex = s.length()/2;	

		return s.charAt(middleIndex);		// will need to be changed to complete
	}





	/**
	 * Returns the string formed by alternating the case of the characters in
	 * the specified string. The first character in the returned string is in
	 * lowercase, the second character is in uppercase, the third character is
	 * in lowercase, the fourth character is in uppercase, and so on.
	 * Examples:
	 * 
	 * <ul>
	 * <li><code>alternatingCaps("a")</code> returns <code>"a"</code>
	 * <li><code>alternatingCaps("ab")</code> returns <code>"aB"</code>
	 * <li><code>alternatingCaps("abc")</code> returns <code>"aBc"</code>
	 * <li><code>alternatingCaps("XYZ")</code> returns <code>"xYz"</code>
	 * <li><code>alternatingCaps("Toronto")</code> returns <code>"tOrOnTo"</code>
	 * <li><code>alternatingCaps("eecs1720")</code> returns <code>"eEcS1720"</code>
	 * </ul>
	 * 
	 * <p>
	 * The conversion of characters to lower or uppercase is identical to 
	 * that performed by the methods <code>Character.toLowerCase(int)</code>
	 * and <code>Character.toLowerCase(int)</code>
	 * 
	 * @param s
	 *            a string
	 * @return the string formed by alternating the case of the characters in s
	 */
	public static String alternatingCaps(String s) {

		// easiest way to do this is to convert both strings to upper and lower
		// then use mod (%) to check if each index is even/odd, and pull a char from upper or lower

		// if concatenating chars to form a new string, then use StringBuilder 
		// this will work more efficiently for very large strings... or can use char array

		// String objects are "immutable" i.e. they cannot be changed once created

		/////////////////////////////////////
		// approach 1: using char array created from original, then overwrite

		char[] resultChars = s.toCharArray();

		for (int i=0; i<resultChars.length; i++) {

			if (i%2==0) 
				resultChars[i] = Character.toLowerCase(s.charAt(i));
			else
				resultChars[i] = Character.toUpperCase(s.charAt(i));	
		}

		String result = new String(resultChars);	// can construct new String from char[]



		/////////////////////////////////////
		// approach 2: using StringBuilder

		StringBuilder sb = new StringBuilder();		// initially empty

		for (int i=0; i<s.length(); i++) {

			if (i%2==0) 
				sb.append( Character.toLowerCase(s.charAt(i)) );
			else
				sb.append( Character.toUpperCase(s.charAt(i)) );
		}

		result = sb.toString();


		//////////////////////////////////////
		// approach 2b: similar to approach 2
		String lower = s.toLowerCase();
		String upper = s.toUpperCase();

		StringBuilder sb2 = new StringBuilder();		// initially empty

		for (int i=0; i<s.length(); i++) {

			if (i%2==0) 
				sb2.append( lower.charAt(i) );
			else
				sb2.append( upper.charAt(i) );
		}

		result = sb2.toString();


		return result;
	}






	// THE FOLLOWING METHOD HAS NO TESTER - FOLLOW THE INSTRUCTIONS BELOW AND USE THE 
	// MAIN METHOD TO RUN AND TEST IT


	/**
	 * This method extracts the input parameters needed to run windChill() from NumUtils
	 * class.  It uses a char (mode) that indicates if the input is coming from command line
	 * input, or it is coming from keyboard input provided by the user (see Lecture 3 for
	 * more details on how to achieve both of these).
	 * 
	 * You can design your own output message that reports the windChill value that results
	 * along with the input parameters, as long as the message indicates the input 
	 * parameters (airTemp), (windSpeed) and associated (windChill) values.
	 *  
	 * @param args
	 * 				a string array passed from main (representing command line input)
	 * 
	 * @param mode
	 * 				a char that represents if the input is coming from command line ('C') or
	 * 				the keyboard ('U')
	 * 
	 */
	public static void windChillUserInputs(String[] args, char mode) {

		// if the mode char is 'C' 
		//		-> use the command line input from args (from main method) to set airTemp/windSpeed
		//
		// if the mode char is 'U' 
		//		-> use the Scanner connected to the keyboard (System.in) to ask the user
		//			to input these values

		// populate the two variables below with data passed according the the mode char above
		// i.e. this should be used to call the windChill method in NumUtils class
		double airTemp=0;			
		double windSpeed=0;	
		
		
		// if there are less/more than 2 args, print an error message and dont call windChill
		// otherwise, report the airTemp, windSpeed and windChill values

		// NOTE: you will need to convert any string values read into doubles before passing
		// them to windChill()
		
		

		if (mode=='C' || mode=='c')		{

			// trying to read command line arguments
			System.out.println("args>0, using command line inputs\n");

			if (args.length==0 || args.length!=2) {
				System.out.println("Sorry, I could not find any (or enough) command line args (should provide two numeric values");
				return;
			}
			else {

				// args.length == 2
				
				airTemp = Double.parseDouble(args[0]);
				windSpeed = Double.parseDouble(args[1]);

			}

		}
		else if (mode=='U' || mode=='u') {

			//ask user to input data
			
			Scanner in = new Scanner(System.in);
			
			boolean validInput = false;
			
			System.out.println("Please enter two (space separated) decimal values for (airTemp), and (windSpeed): ");

			if (in.hasNextDouble()) {
				airTemp = in.nextDouble();

				if (in.hasNextDouble()) {
					windSpeed = in.nextDouble();
					validInput = true;
				}
			}

			in.close();
			
			if (!validInput) {
				System.out.println(".. sorry, there was a problem with your input .. exiting");
				return;
			}
		
	
		}



		// If we get here, we now have a valid airTemp and windSpeed
		System.out.println("\nThanks!\n.. airTemp = " + airTemp + " deg. C, windSpeed = " + windSpeed + " km/h");
		System.out.println(".. calculating windChill");
		
		System.out.println(".. windChill = " + NumUtils.windChill(airTemp, windSpeed) + " deg. C" );
		System.out.printf(".. windChill = %.2f deg. C (to 2 decimal places)" , NumUtils.windChill(airTemp, windSpeed) );


	}






	// MAIN METHOD (use this to launch the windChillFromCommandLine or windChillFromUser
	// methods, which each convert inputs from either the command line or direct keyboard
	// input, and pass these into the windChillMethod.  Print a message indicating both 
	// the inputs 


	public static void main(String[] args) {

		// Use this to call the windChillUserInputs(..) method above

		if (args.length>0)
			windChillUserInputs(args, 'C');		// assume if there are CL args, use this mode

		else
			windChillUserInputs(args, 'U');		// otherwise ask user for input


	}



}
