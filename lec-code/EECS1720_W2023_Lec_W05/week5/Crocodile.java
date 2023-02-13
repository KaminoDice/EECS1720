package week5;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import imagePackage.RasterImage;

public class Crocodile extends FloatyThing {

	private boolean isVisible;
	
	
	public Crocodile(Point2D.Double position, double length, double height) {

		super(position, length, height);
		
		this.colour = Color.GREEN;
		this.isVisible = true;

	}



	@Override
	public void draw(Graphics2D gfx) {

		Color origCol = gfx.getColor();
		gfx.setColor(this.colour);
		
		if (this.isVisible) { 
			gfx.fillRect((int)this.position.getX(), (int)this.position.getY(), (int)(this.length/4), (int)this.height);
			gfx.fillRect((int)(this.position.getX()+3*this.length/8), (int)this.position.getY(), (int)(this.length/4), (int)this.height);
			
			gfx.fillRect((int)(this.position.getX()+6*this.length/8), (int)this.position.getY(), (int)(this.length/4), (int)(this.height/4));
			gfx.fillRect((int)(this.position.getX()+6*this.length/8), (int)(this.position.getY()+3*this.height/4), (int)(this.length/4), (int)(this.height/4));
			gfx.fillRect((int)(this.position.getX()+6*this.length/8), (int)this.position.getY(), (int)(this.length/8), (int)this.height);
			
		}
		else {
			gfx.drawRect((int)this.position.getX(), (int)this.position.getY(), (int)(this.length/4), (int)this.height);
			gfx.drawRect((int)(this.position.getX()+3*this.length/8), (int)this.position.getY(), (int)(this.length/4), (int)this.height);
			
			gfx.fillRect((int)(this.position.getX()+6*this.length/8), (int)this.position.getY(), (int)(this.length/4), (int)(this.height/4));
			gfx.fillRect((int)(this.position.getX()+6*this.length/8), (int)(this.position.getY()+3*this.height/4), (int)(this.length/4), (int)(this.height/4));
			gfx.fillRect((int)(this.position.getX()+6*this.length/8), (int)this.position.getY(), (int)(this.length/8), (int)this.height);
			
		}
		
		gfx.setColor(this.colour);

	}
	
	public void toggleVisible() {
		
		this.isVisible = !this.isVisible;
		
		
		
	}

	



}
