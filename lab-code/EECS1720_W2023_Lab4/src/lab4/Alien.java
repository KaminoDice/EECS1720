package lab4;


import imagePackage.RasterImage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.PrintStream;

// functionality to draw an Alien, given a position and Graphics2D object 
//
// Note: in this implementation, Alien is a COMPOSITION of Point2D
// 								 Alien is an AGGREGATION of Color


public class Alien {
	
	
	private Point2D.Double pos;
	private Color col;
	private double width;
	private double height;
	
	
	/**
	 * Create a new black Alien of width 50 and height 40 at a specified position
	 * 
	 * @param pos the position of the Alien object
	 */
	public Alien(Point2D.Double pos) {
		this.pos = new Point2D.Double(pos.getX(),pos.getY());
		this.col = Color.BLACK;
		this.width = 50;
		this.height = 40;
		
	}
	
	/**
	 * Create a new Alien of size width and height, at a specified position and colour
	 * 
	 * @param pos the position of the Alien
	 * @param width the width of the Alien
	 * @param height the height of the Alien
	 */
	public Alien(Point2D.Double pos, double width, double height) {
		
		this.pos = new Point2D.Double(pos.getX(),pos.getY());
		this.width = width;
		this.height = height;
		this.col = col;
		
		
	}
	
	/** 
	 * Create a new Alien that is a copy of an existing Alien
	 * 
	 *  
	 * @param other the Alien to make a copy of
	 * 
	 */
	public Alien(Alien other) {
		this.pos = new Point2D.Double(other.pos.getX(),other.pos.getY());
		this.col = other.col;
		this.width = other.width;
		this.height = other.height;
		
		
	}
	
	
	public Color getColor() {
		
		return this.col;
	}
	
	public void setColor(Color col) {
		this.col = col;
	}
	
	
	public double getWidth() {
		return this.width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public Point2D.Double getPos() {
		
		Point2D.Double copy = new Point2D.Double(this.pos.x, this.pos.y);
		return copy;
		
	}
	
	public void setPos(Point2D.Double pos) {
		
		Point2D.Double copy = new Point2D.Double(pos.getX(), pos.getY());
		this.pos = copy;
	}
	
	
	public void drawAlien(Graphics2D gfx) {
		
		int[] xPoints = new int[6];
		int[] yPoints = new int[6];
		
		int lx = (int) this.pos.getX();
		int ly = (int) this.pos.getY();
		int cx = (int) (lx + this.width/2);
		int cy = (int) (ly + this.height/2);
		int rx = (int) (lx + this.width);
		int ry = (int) (ly + this.height);
		
		xPoints[0] = lx;		yPoints[0] = ly;
		xPoints[1] = cx;		yPoints[1] = cy;
		xPoints[2] = rx;		yPoints[2] = ly;
		xPoints[3] = rx;		yPoints[3] = cy;
		xPoints[4] = cx;		yPoints[4] = ry;
		xPoints[5] = lx;		yPoints[5] = cy;
		
		gfx.setColor(this.col);
		gfx.setStroke(new BasicStroke(2.0f));
		
		gfx.fillPolygon(xPoints, yPoints, xPoints.length);
		
		
	}
	
	@Override
	public String toString() {
		
		String result = "Alien: pos= " + this.pos + ", size= " + this.width + ", " + this.height;
		return result;
		
	}
	
	
	
	public void advance() {
		
		// TO COMPLETE (Exercise03, part e
		Point2D.Double pos = this.getPos();
		pos.setLocation(pos.x,pos.y+20);
		this.setPos(pos);
		
	}
	

	public static void main(String[] args) {
		
		/*
		 * Basic tester for the Alien parent class 
		 * 
		 * 
		 */
		
		PrintStream out = System.out;
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
		RasterImage gameBoard = new RasterImage(640,480);
		gameBoard.show();
		Graphics2D g = gameBoard.getGraphics2D();
		
		Alien a1 = new Alien(new Point2D.Double(100, 100));
		Alien a2 = new Alien(new Point2D.Double(200, 100),100,150);
		a2.setColor(Color.RED);
		
		Alien a3 = new Alien(a1);
		a3.setColor(Color.ORANGE);
		a3.setPos(new Point2D.Double(100, 300));
		
		out.println("dim = " + gameBoard.getWidth() + ", " + gameBoard.getHeight());
		a1.drawAlien(g);  out.println("a1 = " + a1);
		a2.drawAlien(g);  out.println("a2 = " + a2);
		a3.drawAlien(g);  out.println("a3 = " + a3);
		
		
		
		
		
	}
}
