package lab3_soln;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintStream;

import imagePackage.RasterImage;

public class Ghost1 {
	
	
	// CLASS FIELDS =======================================

	public int x;				// centre x
	public int y;				// centre y
	public int size;			// ghost is size * size	
	
	public int eyeRad;			// eye radius
	public int pupilRad;		// pupil radius
	
	public Color normalCol;		// normal ghost colour  
	public boolean frightened;	// true if frightened
	public boolean eaten;		// true if eaten
	
	public int direction;		// which direction is ghost looking/moving
	
	
	// CLASS CONSTRUCTORS =================================
	
	/**
	 * Default Constructor
	 */
	public Ghost1() {
		
		this.x = 0;
		this.y = 0;
		this.size = 100;
		
		this.eyeRad = this.size/8;
		this.pupilRad = this.eyeRad/2;
		
		this.normalCol = Color.CYAN;
		this.frightened = false;
		this.eaten = false;
		
		this.direction = Game.EAST;
		
	}
	
	/**
	 * Custom Constructor #1
	 * 
	 * @param x
	 * @param y
	 */
	public Ghost1(int x, int y, int size) {
	
		this.x = x;
		this.y = y;
		this.size = size;
		
		this.eyeRad = this.size/8;
		this.pupilRad = this.eyeRad/2;
		
		this.normalCol = Color.CYAN;
		this.frightened = false;
		this.eaten = false;
		
		this.direction = Game.EAST;
	}
	
	/**
	 * Custom Constructor #2
	 * 
	 * @param x
	 * @param y
	 * @param body
	 * @param engines
	 */
	public Ghost1(int x, int y, int size, Color body, int direction) {
		
		this.x = x;
		this.y = y;
		this.size = size;
		
		this.eyeRad = this.size/8;
		this.pupilRad = this.eyeRad/2;
		
		this.normalCol = body;
		this.frightened = false;
		this.eaten = false;
		
		this.direction = direction;
		
	}
	
	
	// CLASS METHODS ======================================
	
	/**
	 * This method is provided for you (DO NOT EDIT)
	 * it can be used to output the state of a Hero object
	 * 
	 * Assumes that class fields exist and are created as 
	 * per the UML diagram in the lab3 pdf (part 1)
	 * 
	 */
	public String toString() {
		
		String result = "";
		result 	= 	"Ghost @ (" + this.x + ", " + this.y + "):\n";
		result 	+= 	"\t[ size = " + this.size + " * " + this.size + " ]\n";
		result 	+=	"\t[ colour = " + this.normalCol + " ]\n";
		result  +=  "\t[ state = " + (this.frightened?(this.eaten?"eaten":"frightened"):"normal") + " ]";
		
		return result;
		
	}
	
	
	// MAIN METHOD ===============



	public static void main(String[] args) {
		/*
		 * 
		 * In this task, you are to create a class to support the positioning, size, 
		 * color of a Ghost object (to mimic the ghost characters in a pacman-like game)
		 * 
		 * To achieve this, you will need to:
		 * 
		 * 1. create class variables as per the UML diagram given in Question01 in the lab3 pdf 
		 * 
		 * 2. create a default constructor as per the UML diagram given (see lab3 pdf)
		 * 
		 * 3. create 2 custom constructors as per the UML diagram given, (see lab3 pdf)
		 * 
		 *
		 * 4. Use your main method as a client application to test the above (see lab3 pdf for instructions)
		 * 
		 * 5. Run the PartialTester.java to check the functionality of these classes
		 * 
		 * 
		 */
		
		
		
		
		
		
		System.out.println("scarey's 1-4:\n");
		Ghost1 scarey1 = new Ghost1(); System.out.println(scarey1); System.out.println();
		Ghost1 scarey2 = new Ghost1(); scarey2.y+=100; scarey2.normalCol=Color.red; System.out.println(scarey2); System.out.println();
		Ghost1 scarey3 = new Ghost1(300,400,200); scarey3.normalCol=Color.lightGray; System.out.println(scarey3);System.out.println();
		Ghost1 scarey4 = new Ghost1(580,340,180,Color.magenta,Game.SOUTH); System.out.println(scarey4);
		
		System.out.println("\n\nscarey5: (frightened/eaten)\n");
		
		Ghost1 scarey5 = new Ghost1(580,340,180,Color.magenta,Game.SOUTH); 
		scarey5.frightened=true; System.out.println(scarey5); System.out.println();
		scarey5.frightened=false; scarey5.eaten=true; System.out.println(scarey5);System.out.println();
		scarey5.frightened=true; scarey5.eaten=true; System.out.println(scarey5);System.out.println();
		
	}
}
