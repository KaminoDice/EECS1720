package lab3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintStream;

import imagePackage.RasterImage;

public class Ghost2 {


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
	public Ghost2() {
		
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
	 */
	public Ghost2(int x, int y, int size) {
		
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
	public Ghost2(int x, int y, int size, Color body, int direction) {
		
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
	
	public void setFrightened(boolean f) {
		this.frightened = f;
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


		

	}
}
