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



public class DocileAlien extends Alien {

	
	public DocileAlien(Point2D.Double pos) {
		
		// TO COMPLETE (Exercise03, part a)
		super(pos);
		this.setColor(Color.blue);
	}
	
	public DocileAlien(Point2D.Double pos, double width, double height) {
		
		// TO COMPLETE (Exercise03, part a)
		super(pos,width,height);
		this.setColor(Color.blue);
		
	}
	
	
	@Override
	public String toString() {

		// TO COMPLETE (Exercise03, part b)
		String result = "DocileAlien: pos= " + this.getPos() + ", size= " + this.getWidth() + ", " + this.getHeight()+", col ="+this.getColor().toString();
		return result;
		
	}
	
	public void drawAlien(Graphics2D gfx) {
		
		// TO COMPLETE (Exercise03, part c)
		int[] xPoints = new int[6];
		int[] yPoints = new int[6];
		
		int lx = (int) this.getPos().getX();
		int ly = (int) this.getPos().getY();
		int cx = (int) (lx + this.getWidth()/2);
		int cy = (int) (ly + this.getHeight()/2);
		int rx = (int) (lx + this.getWidth());
		int ry = (int) (ly + this.getHeight());
		
		xPoints[0] = lx;		yPoints[0] = ly;
		xPoints[1] = cx;		yPoints[1] = ly;
		xPoints[2] = rx;		yPoints[2] = ly;
		xPoints[3] = rx;		yPoints[3] = cy;
		xPoints[4] = cx;		yPoints[4] = ry;
		xPoints[5] = lx;		yPoints[5] = cy;
		
		gfx.setColor(this.getColor());
		gfx.setStroke(new BasicStroke(2.0f));
		
		gfx.fillPolygon(xPoints, yPoints, xPoints.length);
		
	}
	

	
	@Override
	public void advance() {
		
		// TO COMPLETE (Exercise03, part e)
		Point2D.Double pos = this.getPos();
		pos.setLocation(pos.x+20,pos.y);
		this.setPos(pos);
	}

	
	
	public static void main(String[] args) {
		// Use this to test creation (instantiation) and display of an individual
		// DocileAlien
		
		// OR - use the main method in BattleField to test

	}
		
		
	
}
