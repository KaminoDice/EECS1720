package lab3_soln;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintStream;

import imagePackage.RasterImage;

public class Ghost2 {


	// CLASS FIELDS =======================================

	private int x;				// centre x
	private int y;				// centre y
	private int size;			// ghost is size * size	

	private int eyeRad;			// eye radius
	private int pupilRad;		// pupil radius

	private Color normalCol;		// normal ghost colour  
	private boolean frightened;	// true if frightened
	private boolean eaten;		// true if eaten

	private int direction;		// which direction is ghost looking/moving


	// CLASS CONSTRUCTORS =================================

	/**
	 * Default Constructor
	 */
	public Ghost2() {

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
	 */
	public Ghost2(int x, int y, int size) {

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
	 */
	public Ghost2(int x, int y, int size, Color body, int direction) {

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
		result  +=  "\t[ state = " + (this.frightened?(this.eaten?"eaten":"frightened"):"normal") + " ]\n";

		return result;

	}


	// GETTERS =========
	public int getX() {

		return this.x;

	}
	public int getY() {

		return this.y;

	}
	public int getSize() {

		return this.size;

	}
	public Color getBodyCol() {

		return this.normalCol;

	}

	public int getDirection() {

		return this.direction;

	}
	
	public boolean isFrightened() {

		return this.frightened;

	}
	public boolean isEaten() {

		return this.eaten;

	}



	// SETTERS =========
	
	public void setX(int x) {

		this.x = x;

	}
	public void setY(int y) {

		this.y = y;

	}
	public void setBodyCol(Color c) {

		this.normalCol = c;

	}
	public void setDirection(int d) {

		this.direction = d;

	}
	
	public void setFrightened(boolean b) {

		this.frightened = b;

	}
	
	public void setEaten(boolean e) {

		this.eaten = e;

	}
	
	
	// MAIN METHOD === (not needed, use Ghost2Client.java instead) ============


	public static void main(String[] args) {
		/*
		 * 
		 * In this task, you will copy over the code from Q1, rename constructors, then
		 * modify the class:  
		 * 
		 * first, by locking off the fields of the ghost so they are not public,
		 * 
		 * then by adding getters/setters to support public access and mutation of some of these
		 * fields (as specified by the instructions for Q2 in the lab3 pdf, and UML diagram)
		 */


		// UN-USED, SEE GHOST2CLIENT


	}
}
