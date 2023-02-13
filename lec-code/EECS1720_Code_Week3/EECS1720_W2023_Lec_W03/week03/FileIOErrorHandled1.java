package week03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileIOErrorHandled1 {

	public static void main(String[] args) {


		try {
			
			File inFile = new File("./sample.txt");	

			// do an echo of input file (i.e. read all lines and output them to screen)
			Scanner inF = new Scanner(inFile);
			String oneLineText;
			System.out.println("Contents of file:");
			System.out.println("****************************");

			while (inF.hasNextLine()) {
				oneLineText = inF.nextLine();
				System.out.println(oneLineText);
			}

			inF.close();  // close the file after reading!!
		}
		catch (FileNotFoundException e) {
			// handle it
		}
		catch (NullPointerException e) {
			// handle it
		}
		catch (NoSuchElementException e) {
			// handle it
		}



	}

}
