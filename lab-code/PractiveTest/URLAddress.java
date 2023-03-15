import java.io.PrintStream;
import java.util.Scanner;


// URLAddress APP (test1f - Question 1) 

/**
 * This app prompts the user for a valid URL address (a set of 4 ints (a,b,c,d) to be 
 * entered as text) and then prints these as text/values to the console.
 * 
 * *** Requested User Input ***
 * 
 * (1) four colon-delimited tokens (e.g., a:b:c:d). Let the tokens be denoted a,b,c and
 * d, respectively. 
 * 
 * (2) all a,b,c and d must be parsed as ints
 * 
 * 
 * *** App Behaviour: ***
 * 
 * If the user's input conforms to the requested format, then the app will output 
 * the corresponding URL address as a string prefixed by "URL = http://" followed by the
 * numbers delimited by '.'
 * 
 * An address is the loopback address if a:b:c:d = 127:0:0:1 
 * The URL will be indicated as the string: "URL = http://localhost" if the IP address
 * is the loopback address.
 * 
 * 
 * 
 * TASK 1: (implement the above assuming CORRECT/VALID user input)
 * 
 * Examples of output relating to valid user input:
 * ================================================
 * 
 * Examples:		user types: "198:68:3:1"    output: "URL = http://198.68.3.1"
 * 				user types: "3:250:1:0"     output: "URL = http://3.250.1.0"
 * 				user types: "127:0:0:1"     output: "URL = http://localhost"
 *
 * 
 * 
 * TASK 2:  (add functionality to deal with INCORRECT/INVALID user input)
 * 
 * Exceptions arising from invalid user inputs:
 * ================================================
 * 
 * (i) If the user's input does not contain sufficient ':' delimiters, then the app exits 
 * cleanly, with the message "Wrong number of colons (:)".
 * 
 * (ii) If the user's input does contain sufficient ':' delimiters, but not all the desired 
 * tokens (a-d) can be parsed as ints, then the app exits cleanly with the message:
 * "Numeric error in address!".
 * 
 * (iii) If any of the tokens (a-d) are not in the valid range (i.e. have a value of 0-255), 
 * then the app should generate and catch a RuntimeException that displays the message: 
 * "One or more IP values are invalid", before exiting cleanly.
 * 
 * 
 **/


public class URLAddress {

	public static void main(String[] args) {


		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);

		final String PROMPT = "Enter \"a:b:c:d\" (where a-d are ints): ";
		out.println(PROMPT);


		/* TASK 1:	[4 marks]
		 * 
		 * Convert a user-typed ip address into the output format outlined above
		 * in the blue comments (TASK 1 section).  This should work for all expected 
		 * and valid user inputs as outlined in the blue comments above
		 * 
		 * The user prompt and use of scanner to capture this input is given to you 
		 * above (DO NOT MODIFY THE CODE ABOVE).
		 * 
		 * You now need to:
		 * 
		 * 	- Tokenize the string into four parts (best to store separately)
		 *  - Construct a new String based on the values of a-d to output in the desired ip format 
		 *      
		 *  (AGAIN - for this task, assume all inputs are valid)
		 */


		String result =  "URL = http://";
		String[] token = in.nextLine().split(":");
		
		try {
			if (token.length != 4) {
				throw new RuntimeException("Wrong Input");
			}else if ((token[0].matches("[1][2][7]")) && (token[1].matches("0")) && (token[2].matches("0")) && (token[3].matches("1"))) {
				result += "localhost";
			}else {
				for (int i=0;i<4;i++) {
					int tkNum = Integer.parseInt(token[i]);
					if (!((tkNum>=0) && (tkNum<256))) {
						throw new RuntimeException("Wrong Input");
					}
					if (i<3) {
						result += tkNum;
						result += ":";
					}else {
						result += tkNum;
					}
					
				}
			}
			out.println(result);
		} catch (RuntimeException e) {
			out.println(e.getMessage());
		}
				
		
		
		
		
		/* TASK 2: 	[6 marks]
		 * 
		 * You must now make use of TRY/CATCH + EXCEPTIONS to handle/complete task 2
		 * 
		 * Refer to Exceptions arising from invalid user input (i-iii) in the blue comments 
		 * at the top of this file, and add to/modify your code by adding a try/catch block with 
		 * one or more exceptions that can each handle the invalid inputs described in (i-iii).
		 * 
		 * It is up to you which exceptions to make use of, however keep in mind that 
		 * depending on the methods you use to parse the tokens into numeric form, certain
		 * exceptions could possibly be thrown and must be handled.
		 * 
		 * Ensure for each type of invalid input, that your main() ends gracefully without
		 * crashing and outputs the behaviour expected and outlined in (i-iii)
		 *  
		 * 
		 */





		in.close();



	}

}
