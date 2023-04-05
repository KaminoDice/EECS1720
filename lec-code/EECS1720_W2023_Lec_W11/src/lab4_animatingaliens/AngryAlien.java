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
import java.awt.geom.Point2D.Double;
import java.io.PrintStream;



public class AngryAlien extends Alien {
	
	public AngryAlien(Point2D.Double pos) {
		super(pos);
		this.setColor(Color.RED);
	}
	
	public AngryAlien(Point2D.Double pos, double width, double height) {		
		super(pos, width, height);
		this.setColor(Color.RED);
	}
	
	

	@Override
	public String toString() {

		String result = super.toString().replace("Alien","AngryAlien");
		String colres = "" + this.getColor();
		
		result += ", col= " + colres.replace("java.awt.Color", "");
		
		return result;
		
	}
	
	
	// does not override drawAlien (as it maintains same look and feel as normal alien)
	
	
	
	@Override
	public void advance() {
		
		Point2D currentPos = this.getPos();
		this.setPos(new Point2D.Double(currentPos.getX(),currentPos.getY()+60));
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		// tests toString output for all alien types
		
		Alien a = new Alien(new Point2D.Double(100,300));
		Alien a1 = new AngryAlien(new Point2D.Double(100,300));
		Alien a2 = new NeutralAlien(new Point2D.Double(100,300),65.7,131.56);
		Alien a3 = new DocileAlien(new Point2D.Double(100,200),11.5,-56.3);

		System.out.println(a.toString());
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		
		

	}
		
		
	
}
