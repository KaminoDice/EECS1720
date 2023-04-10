package lab4_animatingaliens;
//import imagePackage.RasterImage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.PrintStream;

public class Hero {
	
	// CLASS VARIABLES
	
		// copy paste and modify code from Hero2 class to here
	
	private double x;
	private double y;
	
	private double width;
	private double height;
	
	private Color body;
	private Color engines;
	
	
	public Hero() {
		
		this.x = 0;
		this.y = 0;
		this.width = 50;
		this.height = 40;
		this.body = Color.BLACK;
		this.engines = Color.RED;
		
	}
	
	public Hero(double x, double y) {
		
		this.x = x;
		this.y = y;
		this.width = 50;
		this.height = 40;
		this.body = Color.BLACK;
		this.engines = Color.RED;
		
	}
	
	public Hero(double x, double y, Color body, Color engines) {
		
		this.x = x;
		this.y = y;
		this.width = 50;
		this.height = 40;
		this.body = body;
		this.engines = engines;
		
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setBody(Color body) {
		this.body = body;
	}
	
	public void setEngines(Color engines) {
		this.body = engines;
	}
	
	public void draw(Graphics2D gfx) {
		
		// now complete this method
		
		// clear screen
		
		
		gfx.setColor(this.body);
		
		gfx.fillRect((int)(this.x + this.width*2/5), (int)this.y, 
				(int)(this.width/5), (int)(this.height*0.75));
		
		gfx.setColor(this.engines);
		
		gfx.fillRect((int)(this.x + this.width/5), (int)this.y + (int)(this.height/2), 
				(int)(this.width/5), (int)(this.height/2));
		
		gfx.fillRect((int)(this.x + this.width*3/5), (int)this.y + (int)(this.height/2),
				(int)(this.width/5), (int)(this.height/2));
		
	}
	
	
	public void move(char dir, int step) {
		
		double oldX = this.getX();
		double oldY = this.getY();
		
		switch (dir) {
		case 'l':
		case 'L':
			// this code does not check for when hero is moving off screen
			this.x = oldX - step;
			break;
			
		case 'r':
		case 'R':
			this.x = oldX + step;
			break;
		}
		
		
	}
	
	
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
		result 	= 	"Hero @ (" + this.x + ", " + this.y + "):\n";
		result 	+= 	"\t[ width= " + this.width + ", height= " + this.height + " ]\n";
		result 	+=	"\t[ body= " + this.body + " ]\n";
		result  +=  "\t[ engines= " + this.engines + " ]\n";
		
		return result;
		
	}
	
	

	public static void main(String[] args) {

		/*
		 * TESTER FOR HERO CLASS
		 */

//		RasterImage canvas = new RasterImage(600,400);
//		Graphics2D g = canvas.getGraphics2D();
//		
//		canvas.show();
//		canvas.setTitle("Heros");
//
//		int centreX = canvas.getWidth()/2;
//		int centreY = canvas.getHeight()/2;
//		
//		Hero shooter = new Hero(centreX,centreY);
//		shooter.draw(g);
//		
//		System.out.println(shooter.toString());
//		
//		g.setBackground(Color.WHITE);
//		g.clearRect(0, 0, 600, 400);
//		shooter.move('l', 50);
//		shooter.draw(g);
		
		
		
		
		
	}
}
