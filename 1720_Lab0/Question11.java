
/**
 * This app explores the increment operator (pre and post fix versions)
 * 
 * @author EECS1720
 * 
 */
public class Question11 {

	public static void main(String[] args) {
		/*
		 * Perform the tasks from Step0a and 0b from Question01 here as well.
		 */

		/*
		 * Pre and postfix versions of ++.
		 * 
		 * ++ either before or after a value will serve to increment its value
		 * by 1. Run the code below to demonstrate.
		 */

;

		int a = 5;
		a++; // this is the POSTFIX version of increment
		System.out.println(a);

		int b = 5;
		++b; // this is the PREFIX version of increment
		System.out.println(b);

		/*
		 * So how does the PREFIX and POSTFIX increment operators differ? The
		 * difference is demonstrated only when we ASSIGN the result of the
		 * increment operator to another variable. This is illustrated by the
		 * statements below (which you should uncomment and run)
		 */

		// int c = 5;
		// int x = c++; // this is the POSTFIX version of increment
		// System.out.println(x);
		//
		// int d = 5;
		// int y = ++d; // this is the PREFIX version of increment
		// System.out.println(y);

	}
}
