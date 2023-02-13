package week02;

import java.io.*;

public class DemoMatches {
	
	public static void main(String[] str) throws IOException {
		
		PrintStream output = System.out;

		String s1 = "a";
		String s2 = "b";
		String regex = "a";
		output.println(s1.matches(regex) + " : " + s2.matches(regex));
		
		s1 = "a4";
		s2 = "4a";
		regex = "[a-z][0-9]";
		output.println(s1.matches(regex) + " : " + s2.matches(regex));
		
		s1 = "abc7";
		s2 = "abcd789";
		regex = "[a-z]+[0-9]";
		output.println(s1.matches(regex) + " : " + s2.matches(regex));
		
		s1 = "abc123";
		s2 = "abcd1234";
		regex = "[^0-9]+[0-9]{1,3}";
		output.println(s1.matches(regex) + " : " + s2.matches(regex));
			
		
		
//		//postcode example
//		
//		s1 = "M3K    2G6";
//		s2 = "2G6M3K";
//		regex = "[A-Z][0-9][A-Z]\\s*[0-9][A-Z][0-9]";
//		output.println(s1.matches(regex) + " : " + s2.matches(regex));
		
		
		
	}
}
