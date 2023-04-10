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



public class NeutralAlien extends Alien {

	public NeutralAlien(Point2D.Double pos) {	
		super(pos);
		this.setColor(Color.GREEN);
		
	}
	
	
	public NeutralAlien(Point2D.Double pos, double width, double height) {		
		super(pos, width, height);
		this.setColor(Color.GREEN);
	}
	
	@Override
	public String toString() {

		String result = super.toString().replace("Alien","NeutralAlien");
		String colres = "" + this.getColor();
		
		result += ", col= " + colres.replace("java.awt.Color", "");
		
		return result;
		
	}
	
	@Override
	public void advance() {
		
		Point2D currentPos = this.getPos();
		this.setPos(new Point2D.Double(currentPos.getX(),currentPos.getY()+20));
		
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
		xPoints[1] = cx;		yPoints[1] = cy;
		xPoints[2] = rx;		yPoints[2] = ly;
		
		xPoints[3] = rx;		yPoints[3] = ry;
		xPoints[4] = cx;		yPoints[4] = ry;
		xPoints[5] = lx;		yPoints[5] = ry;
		
		gfx.setColor(this.getColor());
		gfx.setStroke(new BasicStroke(2.0f));
		
		gfx.fillPolygon(xPoints, yPoints, xPoints.length);
		
		
	}
	
	public static void main(String[] args) {
		
		// not used, main method in AngryAlien tests toString output for all aliens
		
	}
		
		
	
}
