
import java.io.PrintStream;
import java.util.Scanner;



public class BirthDate {



	public static void main(String[] args) {



		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);

		final String PROMPT = "Enter \"mm-yyyy\" (where mm and yyyy are integers): ";
		out.println(PROMPT);



		// ==== COMPLETE ALL CODE HERE ======================


		// get line of text from user input (via Scanner object provided)
		String input  = in.nextLine();


		// tokenize input (using "-" as delimiter)
		String[] tokens = input.split("-");

		String tok1 = "";
		String tok2 = "";

		try {
			// try to assign tokens to strings
			tok1 = tokens[0];		// should have at least one string token
			tok2 = tokens[1]; 		// may throw exception on bad delimiter


			// try to parse the string tokens to convert to integers
			int mm = Integer.parseInt(tok1);		// may throw exception
			int yyyy = Integer.parseInt(tok2);		// may throw exception

			// check month is valid (if not then throw exception)
			if (mm<1 || mm>12) {
				throw new RuntimeException("Month Range Invalid!");
			}
			
			// check if year is valid (if not then throw exception)
			if (yyyy<1900 || yyyy>2019) {
				throw new RuntimeException("Year Range Invalid!");
			}
			
			// if we get here, input (mm and yyyy) should be valid
			System.out.println("Month: " + mm + ", Year: " + yyyy);

		}
		catch (ArrayIndexOutOfBoundsException e)  {
			System.out.println("Missing Dash (-)");
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid Numeric Data!");
		}
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		

		// ==================================================


		in.close();



	}

}