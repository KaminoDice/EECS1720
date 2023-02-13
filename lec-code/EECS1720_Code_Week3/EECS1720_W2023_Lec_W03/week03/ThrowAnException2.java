package week03;

import java.io.FileNotFoundException;

public class ThrowAnException2 {

	public static void main(String[] args) {

		System.out.println("Here I will create and throw an exception.\n");

		//RuntimeException myException = new RuntimeException();

		FileNotFoundException myFNFE = new FileNotFoundException("Cannot find @#%%@ file!!");

		try {
			throw myFNFE;
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}
	}

}
