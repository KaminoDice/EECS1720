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
import java.awt.geom.Point2D.Double;
import java.io.PrintStream;



public class AngryAlien extends Alien {


	public AngryAlien(Point2D.Double pos) {

		// TO COMPLETE (Exercise03, part a)
		super(pos);
		this.setColor(Color.red);
	}

	public AngryAlien(Point2D.Double pos, double width, double height) {		

		super(pos,width,height);
		this.setColor(Color.red);
		// TO COMPLETE (Exercise03, part a)

	}

	@Override
	public String toString() {

		// TO COMPLETE (Exercise03, part b)
		String result = "AngryAlien: pos= " + this.getPos() + ", size= " + this.getWidth() + ", " + this.getHeight()+", col ="+this.getColor().toString();
		return result;

	}
	
	
	public void drawAlien(Graphics2D gfx) {

		// TO COMPLETE (Exercise03, part c)
		int[] xPoints = new int[4];
		int[] yPoints = new int[4];
		
		int lx = (int) this.getPos().getX();
		int ly = (int) this.getPos().getY();
		int cx = (int) (lx + this.getWidth()/2);
		int cy = (int) (ly + this.getHeight()/2);
		int rx = (int) (lx + this.getWidth());
		int ry = (int) (ly + this.getHeight());
		
		xPoints[0] = lx;		yPoints[0] = ly;
		xPoints[1] = cx;		yPoints[1] = cy;
		xPoints[2] = rx;		yPoints[2] = ly;
		xPoints[3] = cx;		yPoints[3] = ry;
		
		gfx.setColor(this.getColor());
		gfx.setStroke(new BasicStroke(2.0f));
		
		gfx.fillPolygon(xPoints, yPoints, xPoints.length);

	}



	@Override
	public void advance() {

		// TO COMPLETE (Exercise03, part e)
		Point2D.Double pos = this.getPos();
		pos.setLocation(pos.x,pos.y+60);
		this.setPos(pos);
	}




	public static void main(String[] args) {
		// Use this to test creation (instantiation) and display of an individual
		// AngryAlien

		// OR - use the main method in BattleField to test





	}



}
