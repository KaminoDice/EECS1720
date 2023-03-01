
import java.io.PrintStream;
import java.util.Scanner;

// TEST 1 (A)

// ChessMove APP (Question 1)

/**
 * This app prompts the user for a valid Chess Move (1 uppercase character representing a piece, 
 * plus 2 characters representing a square the piece is moving to), for e.g. "B:e5" means "move Bishop to e5")
 * entered in a typical chess "algebraic" annotation, which results in a printed written version of the move 
 * to the console.
 * 
 * *** Requested User Input ***
 * 
 * (1) two colon delimited tokens (i.e. in the format "c:xy"). Let the tokens be denoted c and xy, respectively. 
 * 
 * (2) c denotes a single uppercase character representing a chess piece, where each character corresponds to: 
 * 		'K'=King, 'Q'=Queen, 'B'=Bishop, 'N'=Knight, 'R'=Rook, 'P'=Pawn
 * 
 * (3) xy denotes two characters: 
 * 		x = the column on the chessboard (denoted 'a'-'h' as per the diagram on the labtest URL),
 * 		y = the row on the chessboard (denoted by digits 1-8) 
 * 
 * 
 * *** App Behaviour: ***
 * 
 * If the user's input conforms to the requested format, then the app will output 
 * the chess move represented by the algebraic notation (denoted by the ":" delimited string) 
 * in a more readable string for the move (as per the description below):
 * 
 * 
 * TASK 1: (implement the above assuming CORRECT/VALID user input)
 * 
 * Examples of output relating to valid user input:
 * ================================================
 * 
 * 				user types: "B:e5"    		output: "Bishop to e5"
 * 				user types: "N:c3"     		output: "Knight to c3"
 * 				user types: "Q:g4"     		output: "Queen to g4"
 *
 * 
 * 
 * TASK 2: (add functionality to deal with INCORRECT/INVALID user input)
 * 
 * Exceptions arising from invalid user inputs:
 * ================================================
 * 
 * (i) If the user's input has a missing or incorrect number of ':' delimiters, then the app does a
 * clean exit, with the message "Incorrect Delimiter(s)".
 * 
 * (ii) If the user's input does contain the correct ':' delimiters, but the length of each token is not
 * as expected (i.e. c=1 character, or xy=2 characters, then the app does a clean exit, with the message
 * "Unexpected token lengths".
 * 
 * (iii) If c is not an allowed chess piece character, or x,y do not represent allowed x and y position characters
 * then the app displays the message: 
 * "Invalid chess annotation", before doing a clean exit.
 * 
 * 
 **/


public class ChessMove {

	
	
	public static void main(String[] args) {

		///////////////////////////////////////
		// DO NOT MODIFY THIS SECTION OF CODE

		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);
		
		final String PROMPT = "Enter \"c:xy\" (where c is one of [KQBNRP], x is one of [a-h] and y is one of [1-8]): ";
		String nextMove;
		
		out.println(PROMPT);

		if (args.length==0)
			nextMove = in.nextLine();
		else
			nextMove = args[0];
		
		// DO NOT MODIFY ABOVE SECTION OF CODE
		////////////////////////////////////////
		
		
		
		/* TASK 1:	[4 marks]
		 * 
		 * Convert a user-typed chess annotation string into a sentence description
		 * for expected and valid user inputs as outlined in the blue comments above
		 * 
		 * The user prompt and use of scanner to capture this input is given to you above (DO NOT MODIFY THE CODE ABOVE).
		 * You now need to:
		 * 
		 * 	- Tokenize the string into two parts (best to store separately)
		 *  - Construct a new String based on the values of c and xy to output the desired 
		 *      description of the chess move to the console 
		 *      
		 *  (AGAIN - for this task, assume all inputs are valid)
		 */

		
		
		
		
		/* TASK 2: 	[6 marks]
		 * 
		 * You must now make use of TRY/CATCH + EXCEPTIONS to handle/complete task 2
		 * 
		 * Refer to Exceptions arising from invalid user input (i-iii) in the blue comments 
		 * at the top of this file, and modify your code by adding a try/catch block with 
		 * one or more exceptions that can each handle the invalid inputs described in (i-iii).
		 * 
		 * Ensure for each type of invalid input, that your main() ends gracefully without
		 * crashing and outputs the behaviour expected and outlined in (i-iii)
		 *  
		 * 
		 */
		
		
		String[] tokens = nextMove.split(":");
		String tok1,tok2;

		try {
			tok1 = tokens[0];
			tok2 = tokens[1]; 


			if (tok1.length()!=1 || tok2.length()!=2) {

				throw new RuntimeException("Unexpected token lengths");
			}

			if (!tok1.matches("[KQBNRP]") || !tok2.matches("[a-h][1-9]")) {

				throw new RuntimeException("Invalid chess annotation");
			}

			String result = "";

			switch (tok1) {
			case "K": result+="King"; break;
			case "Q": result+="Queen"; break;
			case "B": result+="Bishop"; break;
			case "N": result+="Knight"; break;
			case "R": result+="Rook"; break;
			case "P": result+="Pawn"; 
			}

			out.println(result + " to " + tok2);

		}
		catch (ArrayIndexOutOfBoundsException e) {
			out.println("Incorrect Delimiter(s)");

		}
		catch (RuntimeException e) {
			out.println(e.getMessage());

		}


		in.close();



	}

}