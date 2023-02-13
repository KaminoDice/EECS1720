package week02;

public class StringUtils {


	// OVERLOADED METHOD (tokenizeString)

	// VERSION 1
	public static String[] tokenizeString(String input) {

		System.out.println("version1");
		System.out.println("--------");

		String[] tokens = input.split(" ");					// split based on delimiter = " " (space character)
		return tokens;

	}

	// VERSION 2
	public static String[] tokenizeString(String input, char delimiter ) {

		System.out.println("version2");
		System.out.println("--------");

		String[] tokens = input.split("" + delimiter);		// use a char delimiter
		return tokens;

	}

	// VERSION 3
	public static String[] tokenizeString(String input, String delimiter) {

		System.out.println("version3");
		System.out.println("--------");

		String[] tokens = input.split(delimiter);			// use a string delimiter
		return tokens;

	}



	public static void showTokens(String[] tokens) {

		System.out.println("tokens.length = " + tokens.length);			// display how many tokens

		System.out.println("----");

		// traditional for loop
		for (int i=0; i<tokens.length; i++) {							
			System.out.println("tokens[" + i + "] = " + tokens[i]);		// display each token in tokens
		}

		System.out.println("----");


		// enhanced for loop (works for arrays and collections)
		//		int e=0;
		//		for (String element : tokens) {
		//			System.out.println("tokens[" + e + "] = " + element);
		//			e++;
		//		}

	}
	public static boolean isPalindrome(String str) {

		String remaining = str;

		while (str.length() >= 2) {

			if (str.charAt(0) != str.charAt(str.length()-1)) return false;

			str = str.substring(1, str.length()-1);

		}

		if (str.length()==0 || str.length()==1) 
			return true;
		else
			return false;

	}



	
	public static void main(String[] args) {

		// sample string inputs

		String in1 = "150, 302 ;-250, 122 ";
		String in2 = "one flew over the cuckoos nest";
		String in3 = "method val1 val2 val3 val4 val5";

		
		String[] myTokens = tokenizeString(in2);


		// invoking is possible without class name (in scope, and static)
		// if not static, can only access via an instantiation of the class (object)
		// if static generally access through class name (not needed from within same class
		showTokens(myTokens);

		
//		String in4 = "civil";	// to test isPalindrome()
//		System.out.println("isPalindrome(" + in4 + ") -> " + isPalindrome(in4) );


	}

}
