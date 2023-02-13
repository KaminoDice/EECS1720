package week03;

public class ThrowAnException1 {

	public static void main(String[] args) {
		
		System.out.println("Here I will create and throw an exception.\n");
		
		//RuntimeException myException = new RuntimeException();
		
		RuntimeException myException = new RuntimeException("EECS1720 Exception!");
		
		throw myException;

	}

}
