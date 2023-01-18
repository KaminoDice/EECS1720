package lab1;



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
		String cName = lab1.StrUtils.COURSE_NAME;
		//String cName = "Building Interactive Systems";
		return cName;
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
		
		return "";
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
		
		
		return 'a';		// will need to be changed to complete
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
		
		return "";
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
		double airTemp;			
		double windSpeed;		
		
		
		
		
		
		// if there are less/more than 2 args, print an error message and dont call windChill
		// otherwise, report the airTemp, windSpeed and windChill values
		
		// NOTE: you will need to convert any string values read into doubles before passing
		// them to windChill()
		
		
		
		
		
		
	}
	
	
	
	
	
	
	// MAIN METHOD (use this to launch the windChillFromCommandLine or windChillFromUser
	// methods, which each convert inputs from either the command line or direct keyboard
	// input, and pass these into the windChillMethod.  Print a message indicating both 
	// the inputs 
	
	
	public static void main(String[] args) {
		
		// Use this to call the windChillUserInputs(..) method above
		
		
		
		
	}
	
	
	
}
