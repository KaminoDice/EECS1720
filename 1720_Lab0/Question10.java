
/**
 * This app explores the effect of some operators on int types
 * 
 * @author EECS1720
 * 
 */
public class Question10 {

	public static void main(String[] args) {
		/*
		 * Perform the tasks from Step0a and 0b from Question01 here as well.
		 */

		/*
		 * Consider the following code. For each variable,
		 * the goal is to increment its initial value of 5 by 1, to produce the
		 * value 6. 
		 * 
		 * Two of the techniques fail to do so. Can you explain why
		 * they fail? Type up your answer as a comment into this file.
		 * 
		 * Remember to save your files frequently
		 * 
		 */


		int a = 5;
		a = a + 1;
		System.out.println(a);

		int c = 5;
		c = c + 1 / 2 + 1 / 2;
		System.out.println(c);

		int d = 5;
		d += 5;
		System.out.println(d);

	}
}
