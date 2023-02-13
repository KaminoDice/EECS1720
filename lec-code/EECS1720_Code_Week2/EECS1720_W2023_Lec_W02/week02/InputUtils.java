package week02;



public class InputUtils {


	public static void showCommandLineIn(String[] args) {
		
		System.out.println("\nCommand Line Input:");
		System.out.println("===================");
		System.out.println("You entered " + args.length + " arguments:");

		// concatenates args back into a single string
		String commandLine = "";

		for (String s : args) {
			commandLine = commandLine + "\n" + s;			// commandLine += (" " + s);
		}

		System.out.println("input entered was: " + commandLine + "\n\n");

	}
	


	public static void testForPalindrome(String[] args) {

		System.out.println("\nisPalindrome() ??");
		System.out.println("============================");
		
		// expected arguments = 1 (methodname + string)
		if (args.length != 1) {
			System.out.println("incorrect number of arguments, expecting 1");
			System.out.println("usage:");
			System.out.println("\tweek02.CommandLineIn targetString\n");
		}
		else {

			// test that input argument args[1] is a palindrome

			if (StringUtils.isPalindrome(args[0])) System.out.println("Yes! " + args[0] + " is a Palindrome!");
			else System.out.println("No, "  + args[0] + " is NOT a Palindrome!");

		}
		System.out.println();

	}


	public static void main(String[] args) {

		showCommandLineIn(args);
		
		

	}

}
