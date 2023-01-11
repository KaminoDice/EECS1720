

/**
 * This app explores the scope of a variable.  I.e. to what extent within a
 * program the variable exists and can be seen/used depending on where it 
 * is declared
 * 
 * @author EECS1720
 * 
 */
public class Question09 {

	public static void main(String[] args) {
		/*
		 * Perform the tasks from Step0a and 0b from Question01 here as well.
		 */

		/*
		 * Examine the code but do not run it (yet). You can see
		 * that there is no compiler error.  Read the following and answer
		 * the questions by adding your own comment blocks into this file
		 * 
		 * What do you predict the output will be?
		 * 
		 * BBCBB
		 * 
		 * BBCCC
		 * 
		 * 
		 * a) Were you surprised?
		 * 
		 * b) Can you explain why it is valid to reassign the value of the
		 * variable 'grade'?
		 * 
		 * c) Declare and assign a second char variable called grade2 within the
		 * innermost block and print out its value. (Suppose the second grade is
		 * an A.) Can you explain why it is an error to place a statement to
		 * print out the value of 'grade2' as the final statement in the body of
		 * the main method?
		 */



		char grade = 'B';
		System.out.print(grade);
		{
			System.out.print(grade);
			{
				grade = 'C';
				System.out.print(grade);

			}
			System.out.print(grade);
		}
		System.out.print(grade);
	}
}
