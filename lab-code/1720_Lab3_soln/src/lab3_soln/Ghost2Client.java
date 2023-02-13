package lab3_soln;
import java.awt.Color;
import java.io.PrintStream;

public class Ghost2Client {

	public static void main(String[] args) {
		
		// Client application to test Ghost2 class
		
		// Insert your code here to instantiate Ghost2 objects (and modify/print them)
		// as per instructions in the lab3 pdf
		
		System.out.println("scarey's 1-4:\n");
		
		Ghost2 scarey1 = new Ghost2(); 
		System.out.println(scarey1); 
		System.out.println();
		
		Ghost2 scarey2 = new Ghost2(); 
		scarey2.setY(scarey2.getY()+100); 
		scarey2.setBodyCol(Color.red); 
		System.out.println(scarey2); System.out.println();
		
		Ghost2 scarey3 = new Ghost2(300,400,200); 
		scarey3.setBodyCol(Color.lightGray); 
		System.out.println(scarey3);
		System.out.println();
		
		Ghost2 scarey4 = new Ghost2(580,340,180,Color.magenta,Game.SOUTH); 
		System.out.println(scarey4);
		

	}

}
