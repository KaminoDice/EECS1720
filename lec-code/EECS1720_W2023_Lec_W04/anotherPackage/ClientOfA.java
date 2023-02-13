package anotherPackage;

import week4.A;

public class ClientOfA {

	public static void main(String[] args) {
		
		int localVar = 5;

		localVar = A.field1;   	// ok
		A.field1 = 6; 			// ok

		localVar = A.method1(localVar); // ok


		System.out.println(localVar);

	}

}
