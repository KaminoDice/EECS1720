import java.awt.Color;

public class TestClient {

	public static void main(String[] args) {
		
		// DO NOT MODIFY THIS FILE, JUST RUN IT AS IS TO TEST YOUR CODE
		// if it is running correctly, the expected result should match the output for each test
		
		Square s1 = new Square();
		Square s2 = new Square(Alignment.TOP, 15.6, Color.BLUE);
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(Alignment.TOP, 15, 10, Color.BLUE);
		Shape s=s2;
		
		System.out.println();
		System.out.println("TEST 1:");
		System.out.println("=======");
		System.out.println("output:");
		System.out.println("s2 (before resize):\n " + s.showMe());
		System.out.println();
		s.resize(1.5);
		System.out.println("s2 (x1.5 resize):\n " + s.showMe());
		System.out.println();
		s.reset();
		System.out.println("s2 (after reset):\n " + s.showMe());
		System.out.println();
		
		System.out.println();
		System.out.println("TEST 2:");
		System.out.println("=======");
		System.out.println("output:");
		s=r2;
		System.out.println("r2 (before resize):\n " + s.showMe());
		System.out.println();
		s.resize(1.5);
		System.out.println("r2 (x1.5 resize):\n " + s.showMe());
		System.out.println();
		s.reset();
		System.out.println("r2 (after reset):\n " + s.showMe());
		System.out.println();
	}

}
