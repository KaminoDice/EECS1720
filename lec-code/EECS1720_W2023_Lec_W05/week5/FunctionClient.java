package week5;

public class FunctionClient {

	public static void main(String[] args) {
		
		Square sq = new Square();
		Reciprocal rc = new Reciprocal();
		
		double x = 4.0;
		System.out.println("x = " + x + ";  x^2 = " + sq.eval(x) );
		System.out.println("x = " + x + ";  1/x = " + rc.eval(x) );
		
		
		Double[] xArray = { 4.0, 2.5, -1.6, 3.0, -5.7 };
		
		Double[] sqArray = sq.eval(xArray);
		Double[] rcArray = rc.eval(xArray);
		
		
		System.out.printf("\n%10s | %10s | %10s\n--------------------------------------\n", "xArray", "sqArray", "rcArray");
		
		for (int i=0; i<xArray.length; i++) {
			System.out.printf("%10f | %10f | %10f\n", xArray[i], sqArray[i], rcArray[i]);
		}
		
		
		// any instance of a class that implements Function, can be assigned to a Function reference
		// the Function reference can legally invoke any of the methods declared in its API 
		// (as they are implemented by both the objects sq and rc!)
		
		Function f1 = sq;
		Function f2 = rc;
		
		x = 3.0;
		System.out.println();
		System.out.println("x = " + x + ";  x^2 = " + f1.eval(x) );
		System.out.println("x = " + x + ";  1/x = " + f2.eval(x) );
	
	}

}
