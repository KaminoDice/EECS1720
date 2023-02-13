package week03;

public class DivByZeroHandled {

	public static void main(String[] args) {

		try {
			int denom = 0;
			int result = 7 / denom;
			
		}
		catch (ArithmeticException e) {
			System.out.println("I caught it!");
			e.printStackTrace();
			System.out.println(e.getMessage());
			
			System.out.println(".. exiting gracefully"); 
			System.exit(0);
		}
		

		System.out.println("\nprogram finished.");


	}
}
