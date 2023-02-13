package week02;

import java.util.Scanner;

public class DemoCountVowels {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		

		System.out.println("Enter a string ...");
		String s = input.nextLine().toLowerCase();
		
		int count = 0;
		
		for (int i = 0; i < s.length(); ++i) {
			
			if (s.substring(i, i + 1).matches("[aeiou]")) {
				
				count++;
			}
		}
		
		
		System.out.printf("Number of vowels = %d\n", count);
		
		input.close();

	}

}
