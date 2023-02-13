package week5;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Log extends FloatyThing {


	public Log(Point2D.Double position, double length, double height) {

		
		super(position, length, height);
		
		this.colour = Color.ORANGE;
		

	}

	@Override
	public void draw(Graphics2D gfx) {

		Color origCol = gfx.getColor();
		gfx.setColor(this.colour);
		

		gfx.fillOval((int)this.position.getX(), (int)this.position.getY(), (int)(this.length/4), (int)this.height);
		gfx.fillRect((int)(this.position.getX()+1*this.length/8), (int)this.position.getY(), (int)(3*this.length/4), (int)this.height);
		
		gfx.setColor(Color.LIGHT_GRAY);
		gfx.fillOval((int)(this.position.getX()+3*this.length/4), (int)this.position.getY(), (int)(this.length/4), (int)this.height);
		
		gfx.setColor(this.colour);
		gfx.drawOval((int)(this.position.getX()+13*this.length/16), (int)(this.position.getY()+this.height/4), (int)(this.length/8), (int)(this.height/2));
		
		gfx.setColor(this.colour);

	}

}
