package week5;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class FloatyThing {

	private static final double LENGTH = 100.0;
	private static final double HEIGHT = 10.0;
	
	protected Point2D.Double position;
	protected Color colour;
	protected double length;
	protected double height;
	

	
	public FloatyThing() {
		
		this.colour = Color.gray;
		this.position = new Point2D.Double(0,0);
		this.length = FloatyThing.LENGTH;
		this.height = FloatyThing.HEIGHT;

	}
	
	public FloatyThing(Point2D.Double position, double length, double height) {
		
		this.colour = Color.GRAY;
		this.position = new Point2D.Double(position.x,position.y);
		this.length = length;
		this.height = height;
		
	}
	
	public void draw(Graphics2D gfx) {
		
		Color origCol = gfx.getColor();
		gfx.setColor(this.colour);
		gfx.drawRect((int)this.position.getX(), (int)this.position.getY(), (int)this.length, (int)this.height);
		gfx.setColor(this.colour);
		
	}
	
	
}
