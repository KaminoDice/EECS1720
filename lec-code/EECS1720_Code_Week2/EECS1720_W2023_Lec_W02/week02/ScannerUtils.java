package week02;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerUtils {


	public static void scanStringInput(String str) {

		// scans an input string and counts 
		Scanner in = new Scanner(str);

		while(in.hasNext()) {
			System.out.println(in.next());

		}

	}


	public static void scanKeyboardInput() {

		Scanner in = new Scanner(System.in);			// connected to keyboard

		System.out.print("Please enter a set of space separated values: ");

		int countIntegers = 0;
		int countReals = 0;

		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<Double> realList = new ArrayList<Double>();

		Scanner line = new Scanner(in.nextLine());

		while (line.hasNext()) {

			// look ahead
			if (line.hasNextInt()) {
				countIntegers++;
				intList.add(line.nextInt());
			}
			else if (line.hasNextDouble()) {
				countReals++;
				realList.add(line.nextDouble());
			}
			else {
				line.next();
			}
		}


		in.close();

		System.out.println("found " + countIntegers + " integers, and " + countReals + " reals");
		System.out.println("\nints:  \n" + intList.toString());
		System.out.println("\nreals: \n" + realList.toString());

	}


	public static void main(String[] args) {

		if (args.length == 1)
			scanStringInput(args[0]);
		else
			scanKeyboardInput();

	}

}
