package lab3_soln;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintStream;

import imagePackage.RasterImage;

public class Ghost3 {


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
	public Ghost3() {

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
	public Ghost3(int x, int y, int size) {

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
	public Ghost3(int x, int y, int size, Color body, int direction) {

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

	/** 
	 * This method renders a Ghost object into the given Graphics2D reference 
	 * (i.e. a reference to the Graphics2D component of a given app window)
	 * 
	 * In this lab, the reference should come from a RasterImage object
	 * 
	 * 
	 */
	public void render(Graphics2D g) {

		if (this.frightened) { 
			g.setColor(Game.FRIGHTENED_COL);
		}
		else {
			g.setColor(this.normalCol);
		}
		
		if (!this.eaten) {
			// head & body
			g.fillArc(this.x, this.y, this.size, this.size, 0, 180);
			g.fillRect(this.x, this.y+this.size/2, this.size, this.size/2);

			// tails
			g.setColor(Color.WHITE);
			g.fillArc(this.x, this.y+3*this.size/4, this.size/2-2, this.size/2, 0, 180);
			g.fillArc(this.x+this.size/2, this.y+3*this.size/4, this.size/2-2, this.size/2, 0, 180);

			// eyes
			g.fillOval(this.x+this.size/3-this.eyeRad,this.y+this.size/4,this.eyeRad*2,this.eyeRad*2);
			g.fillOval(this.x+2*this.size/3-this.eyeRad,this.y+this.size/4,this.eyeRad*2,this.eyeRad*2);
		}
		else {
			// just eyes (no body)
			g.drawOval(this.x+this.size/3-this.eyeRad,this.y+this.size/4,this.eyeRad*2,this.eyeRad*2);
			g.drawOval(this.x+2*this.size/3-this.eyeRad,this.y+this.size/4,this.eyeRad*2,this.eyeRad*2);
		}
		
		
		// pupils
		g.setColor(Color.BLACK);
		
		if (this.frightened || this.eaten) {
			
			g.fillOval(this.x+this.size/3-this.pupilRad,this.y+this.size/4+this.pupilRad,this.pupilRad*2,this.pupilRad*2);
			g.fillOval(this.x+2*this.size/3-this.pupilRad,this.y+this.size/4+this.pupilRad,this.pupilRad*2,this.pupilRad*2);

		}
		else {
			

			switch (this.direction) {

			case Game.NORTH:
				g.fillOval(this.x+this.size/3-this.pupilRad,this.y+this.size/4,this.pupilRad*2,this.pupilRad*2);
				g.fillOval(this.x+2*this.size/3-this.pupilRad,this.y+this.size/4,this.pupilRad*2,this.pupilRad*2);
				break;
				
			case Game.SOUTH:
				g.fillOval(this.x+this.size/3-this.pupilRad,this.y+this.size/4+2*this.pupilRad,this.pupilRad*2,this.pupilRad*2);
				g.fillOval(this.x+2*this.size/3-this.pupilRad,this.y+this.size/4+2*this.pupilRad,this.pupilRad*2,this.pupilRad*2);
				break;
				
			case Game.WEST:
				g.fillOval(this.x+this.size/3-this.pupilRad*2,this.y+this.size/4+this.pupilRad,this.pupilRad*2,this.pupilRad*2);
				g.fillOval(this.x+2*this.size/3-this.pupilRad*2,this.y+this.size/4+this.pupilRad,this.pupilRad*2,this.pupilRad*2);
				break;

			default:
				// Assumes Game.EAST is default direction
				g.fillOval(this.x+this.size/3,this.y+this.size/4+this.pupilRad,this.pupilRad*2,this.pupilRad*2);
				g.fillOval(this.x+2*this.size/3,this.y+this.size/4+this.pupilRad,this.pupilRad*2,this.pupilRad*2);

			}
		}
		

		// mouth
		if (this.frightened) {
			//g.setStroke(new BasicStroke(4));
			g.setColor(Color.WHITE);
			
			g.drawArc(	this.x+this.size/2-this.eyeRad,	
					this.y+3*this.size/4-this.eyeRad, 
					this.eyeRad, this.eyeRad,0,180);

			g.drawArc(	this.x+this.size/2,					
					this.y+3*this.size/4-this.eyeRad, 
					this.eyeRad, this.eyeRad,180,180);

		}

	}

	
	/**
	 * This method attempts to move a ghost step pixels in a 
	 * given direction (L|R|U|D) = left,right,up,down respectively
	 * 
	 * the move successfully updates x,y and will return true if the ghost is still within the 
	 * rasterimage r, or false if not
	 * 
	 */
	public boolean move(char dir, int step, RasterImage r) {
		
		int newX = this.x;
		int newY = this.y;
		
		
		switch (dir) {

		case 'L':
			newX-=step; 
			break;
			
		case 'R':
			newX+=step; 
			break;
			
		case 'U':
			newY-=step; 
			break;
			
		case 'D':
			newY+=step; 

		}
		
		if (newX>=0 && newX<=r.getWidth() &&
				newY>=0 && newY<=r.getHeight() ) {
			
			this.x = newX;
			this.y = newY;
			return true;
			
		}
		
		return false;
		
		
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
		app.show();

		Ghost3 scarey1 = new Ghost3();
		scarey1.x = 50;
		scarey1.x = 50;

		scarey1.frightened = true;
		//scarey1.eaten = true;
		scarey1.direction = Game.SOUTH;
		scarey1.render(gfx);
		
		Ghost3 scarey2 = new Ghost3(300,300,200);
		scarey2.render(gfx);
		
		
		Ghost3 shadow = new Ghost3(400,100,80,Color.RED, Game.WEST);
		shadow.render(gfx);

		System.out.println(scarey1);
		System.out.println(scarey2);



	}
}
