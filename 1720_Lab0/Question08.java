
/**
 * This app explores the numeric value associated with a char
 * 
 * @author EECS1720
 * 
 */
public class Question08 {

	public static void main(String[] args) {
		/*
		 * Perform the tasks from Step0a and 0b from Question01 here as well.
		 */

		/*
		 * Q8Step 1 : Assign the values of the char variables as
		 * described for each. You may need to refer to lecture 3 notes for this.
		 */

	
		// here we see that var1 is assigned the character 'z'. The unicode
		// character for z has
		// hexadecimal value 007A, which is 122 as a decimal value
		char var1;
		var1 = 'z';

		// Observe what happens when we construct an assignment statement from a
		// char to an int.
		// The char variable has an unsigned numeric value, which gets promoted
		// to an integer representation.
		int codePointValue = var1;

		System.out.println(var1);
		System.out.println(codePointValue);

		// the character '=' has unicode value 61, which is HALF of the unicode
		// value for 'z'. We want to print out the '=' character by dividing 'z'
		// in half. An expression to derive this value is shown in the
		// statement below.
		
		// Uncomment the statement; observe that there is a compiler error!
		// WHY does this error occur? HOW can we modify the statement to avoid
		// the error and obtain the result we want?

		// char var2 = var1 / 2;
		// output.println(var2);

	}
}
