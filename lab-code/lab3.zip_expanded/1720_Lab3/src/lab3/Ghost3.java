package lab3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintStream;

import imagePackage.RasterImage;

public class Ghost3 {


	// CLASS FIELDS =======================================
	private int x;
	private int y;
	private int size;
	private int eyeRad;
	private int pupilRad;
	private int direction;
	private boolean frightened;
	private boolean eaten;
	private Color normalCol;
	

	// CLASS CONSTRUCTORS =================================

	/**
	 * Default Constructor
	 */
	public Ghost3() {
		
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
	public Ghost3(int x, int y, int size) {

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
	public Ghost3(int x, int y, int size, Color body, int direction) {

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
		

	/** 
	 * This method renders a Ghost object into the given Graphics2D reference 
	 * (i.e. a reference to the Graphics2D component of a given app window)
	 * 
	 * In this lab, the reference should come from a RasterImage object
	 * 
	 * 
	 */
	public void render(Graphics2D g) {
		
		if(this.eaten) {
			g.setColor(Color.BLACK);
			g.drawOval(x+size/3-eyeRad, y+size/3-eyeRad, 2*eyeRad, 2*eyeRad);
			g.drawOval(x+2*size/3-eyeRad, y+size/3-eyeRad, 2*eyeRad, 2*eyeRad);
		}else if(this.frightened){
				g.setColor(Game.FRIGHTENED_COL);	
				g.fillOval(x , y, size, size);
				g.fillRect(x, y+size/2 , size, size/2);
				
				g.setColor(Color.WHITE);
				g.fillArc(x, y+3*size/4, size/2, size/2, Game.EAST, Game.WEST);
				g.fillArc(x+size/2, y+3*size/4, size/2, size/2, Game.EAST, Game.WEST);
				
				g.fillArc(x+size/3, y+size/2, size/3, size/4, Game.EAST, Game.WEST);
		}else{
				g.setColor(normalCol);
				g.fillOval(x , y, size, size);
				g.fillRect(x, y+size/2 , size, size/2);
				
				g.setColor(Color.WHITE);
				g.fillArc(x, y+3*size/4, size/2, size/2, Game.EAST, Game.WEST);
				g.fillArc(x+size/2, y+3*size/4, size/2, size/2, Game.EAST, Game.WEST);
		}

		
		g.setColor(Color.WHITE);
		g.fillOval(x+size/3-eyeRad, y+size/3-eyeRad, 2*eyeRad, 2*eyeRad);
		g.fillOval(x+2*size/3-eyeRad, y+size/3-eyeRad, 2*eyeRad, 2*eyeRad);
		
		g.setColor(Color.BLACK);
		if(this.frightened || this.eaten) {
			g.fillOval(x+size/3-pupilRad, y+size/3-pupilRad, 2*pupilRad, 2*pupilRad);
			g.fillOval(x+2*size/3-pupilRad, y+size/3-pupilRad, 2*pupilRad, 2*pupilRad);
		}else if (this.direction == Game.EAST) {
			g.fillOval(x+size/3, y+size/3-pupilRad, 2*pupilRad, 2*pupilRad);
			g.fillOval(x+2*size/3, y+size/3-pupilRad, 2*pupilRad, 2*pupilRad);
		}else if(this.direction == Game.WEST) {
			g.fillOval(x+size/3-pupilRad*2, y+size/3-pupilRad, 2*pupilRad, 2*pupilRad);
			g.fillOval(x+2*size/3-pupilRad*2, y+size/3-pupilRad, 2*pupilRad, 2*pupilRad);
		}else if(this.direction == Game.NORTH) {
			g.fillOval(x+size/3-pupilRad, y+size/3-2*pupilRad, 2*pupilRad, 2*pupilRad);
			g.fillOval(x+2*size/3-pupilRad, y+size/3-2*pupilRad, 2*pupilRad, 2*pupilRad);
		}else if(this.direction == Game.SOUTH) {
			g.fillOval(x+size/3-pupilRad, y+size/3, 2*pupilRad, 2*pupilRad);
			g.fillOval(x+2*size/3-pupilRad, y+size/3, 2*pupilRad, 2*pupilRad);
		}
	}
	
	public boolean move(char dir, int step) {
		boolean isOut = false;
		if(dir == 'L') {
			this.setDirection(Game.WEST);
			this.setX(this.getX() - step);
		}else if(dir == 'R') {
			this.setDirection(Game.EAST);
			this.setX(this.getX() + step);
		}else if(dir == 'U') {
			this.setDirection(Game.NORTH);
			this.setY(this.getY() - step);
		}else if(dir == 'D') {
			this.setDirection(Game.SOUTH);
			this.setY(this.getY() + step);
		}
		
		if (this.getX()<0 || this.getY()<0 ) {
			isOut = true;
		}
		
		return isOut;
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
		Ghost3 scarey3 = new Ghost3();
		
		scarey3.move('R', 150);
		scarey3.move('D', 150);
		scarey3.setFrightened(true);
		scarey3.render(gfx);
		
		app.show();
	}
}
