package lab3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintStream;

import imagePackage.RasterImage;

public class Ghost3 {


	// CLASS FIELDS =======================================

	

	// CLASS CONSTRUCTORS =================================

	/**
	 * Default Constructor
	 */
	public Ghost3() {

		
	}

	/**
	 * Custom Constructor #1
	 * 
	 */
	public Ghost3(int x, int y, int size) {

		
	}

	/**
	 * Custom Constructor #2
	 * 
	 */
	public Ghost3(int x, int y, int size, Color body, int direction) {

		

	}


	// CLASS METHODS ======================================

	/**
	 * A method that outputs the state of a Ghost1 object (as per the lab3 pdf output examples)
	 * 
	 */
	public String toString() {



	}


	/** 
	 * This method renders a Ghost object into the given Graphics2D reference 
	 * (i.e. a reference to the Graphics2D component of a given app window)
	 * 
	 * In this lab, the reference should come from a RasterImage object
	 * 
	 * 
	 */
	public void render(Graphics2D g) {

		

	}

	public static void main(String[] args) {
		/*
		 * 
		 * In this task, you will add the render() and (optionally - move()) methods to your class
		 * (after first copying over your code from Q2, and renaming constructors)
		 * 
		 * see lab3 pdf for details
		 * 
		 * Use the Game.java file to test and display the requested objects, and their visual state
		 * based on modifying their properties.
		 * 
		 */


		RasterImage app = new RasterImage(600,600);
		Graphics2D gfx = app.getGraphics2D();
		
		// use the above to test your ghost objects (rendering them into a rasterimage object via gfx)


	}
}
