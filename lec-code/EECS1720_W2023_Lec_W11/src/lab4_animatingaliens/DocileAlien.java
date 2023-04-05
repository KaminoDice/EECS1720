package lab4_animatingaliens;
//import imagePackage.RasterImage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.PrintStream;
import java.util.Random;



public class DocileAlien extends Alien {

	
	public DocileAlien(Point2D.Double pos) {
		
		super(pos);
		this.setColor(Color.BLUE);
	}
	
	public DocileAlien(Point2D.Double pos, double width, double height) {
		
		super(pos,width,height);
		this.setColor(Color.BLUE);
		
	}
	
	@Override
	public String toString() {

		String result = super.toString().replace("Alien","DocileAlien");
		String colres = "" + this.getColor();
		
		result += ", col= " + colres.replace("java.awt.Color", "");
		
		return result;
		
	}
	
	@Override
	public void advance() {
		
		Point2D currentPos = this.getPos();
		
		Random rand = new Random();
		int dir = rand.nextInt(2)*2 -1;		// -1 = left , +1 = right
		//System.out.println("dir = " + dir);
		this.setPos(new Point2D.Double(currentPos.getX()+dir*20,currentPos.getY()));
		
	}

	public void drawAlien(Graphics2D gfx) {
		
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
		
		xPoints[3] = rx;		yPoints[3] = ry;
		xPoints[4] = cx;		yPoints[4] = cy;
		xPoints[5] = lx;		yPoints[5] = ry;
		
		gfx.setColor(this.getColor());
		gfx.setStroke(new BasicStroke(2.0f));
		
		gfx.fillPolygon(xPoints, yPoints, xPoints.length);
		
		
	}
	
	public static void main(String[] args) {
			
		// not used, main method in AngryAlien tests toString output for all aliens
		
		
		DocileAlien d = new DocileAlien(new Point2D.Double(100,100));
		System.out.println(d);
		d.advance();
		System.out.println(d);
		d.advance();
		System.out.println(d);
		d.advance();
		System.out.println(d);
		
	}
		
		
	
}
