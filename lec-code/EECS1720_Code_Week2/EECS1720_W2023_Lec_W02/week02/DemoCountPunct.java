package week02;

import java.util.Scanner;

public class DemoCountPunct {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a string ...");
		String s = input.nextLine();

		int count = 0;

		for (int i = 0; i < s.length(); ++i) {

			if ( s.substring(i, i + 1).matches("\\p{Punct}") ) {

				count++;
			}
		}

		System.out.printf("Number of punctuation characters = %d\n", count);
		input.close();

	}

}
