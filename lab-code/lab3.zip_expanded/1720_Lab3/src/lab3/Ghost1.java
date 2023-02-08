package lab3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintStream;

import imagePackage.RasterImage;

public class Ghost1 {
	
	
	// CLASS FIELDS =======================================
	public  int x;
	public  int y;
	public  int size;
	public  int eyeRad;
	public  int pupilRad;
	public  int direction;
	public  boolean frightened;
	public  boolean eaten;
	public  Color normalCol;
	// CLASS CONSTRUCTORS =================================
	
	/**
	 * Default Constructor
	 */
	public Ghost1() {
		
		x = 0;
		y = 0;
		size = 100;
		eyeRad = size/8;
		pupilRad = eyeRad/2;
		normalCol = Color.CYAN;
		frightened = false;
		eaten = false;
		direction = Game.EAST;
		
	}
	
	/**
	 * Custom Constructor #1
	 * 
	 */
	public Ghost1(int x, int y, int size) {
		
		this.x = x;
		this.y = y;
		this.size = size;
		eyeRad = this.size/8;
		pupilRad = eyeRad/2;
		normalCol = Color.CYAN;
		frightened = false;
		eaten = false;
		direction = Game.EAST;
		
	}
	
	/**
	 * Custom Constructor #2
	 * 
	 */
	public Ghost1(int x, int y, int size, Color body, int direction) {
		
		this.x = x;
		this.y = y;
		this.size = size;
		eyeRad = this.size/8;
		pupilRad = eyeRad/2;
		this.normalCol = body;
		frightened = false;
		eaten = false;
		this.direction = direction;
		
	}
	
	
	// CLASS METHODS ======================================
	
	/**
	 * A method that outputs the state of a Ghost1 object (as per the lab3 pdf output examples)
	 * 
	 */
	public String toString() {
		
		String output = "Ghost @ (";
		output = output + String.valueOf(this.x) + ", " + String.valueOf(this.y) + "):\n\t[ size = " + String.valueOf(this.size) + " * " + String.valueOf(this.size) + " ]\n\t[ colour = " + String.valueOf(this.normalCol) + " ]\n\t";
		if (this.eaten && this.frightened) {
			output = output + "[ state = eaten ]";
		}else if (this.frightened) {
			output = output + "[ state = frightened ]";
		}else {
			output = output + "[ state = normal ]";
		}
		return output;
		
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
		System.out.println();
		Ghost1 scarey1 = new Ghost1();
		System.out.println(scarey1.toString());
		System.out.println();
		Ghost1 scarey2 = new Ghost1(0,100,100);
		System.out.println(scarey2.toString());
		System.out.println();
		Ghost1 scarey3 = new Ghost1(300,400,200);
		scarey3.normalCol = Color.LIGHT_GRAY;
		System.out.println(scarey3.toString());
		System.out.println();
		Ghost1 scarey4 = new Ghost1(580,340,180,Color.magenta, Game.SOUTH);
		System.out.println(scarey4.toString());
		System.out.println();
	}
}
