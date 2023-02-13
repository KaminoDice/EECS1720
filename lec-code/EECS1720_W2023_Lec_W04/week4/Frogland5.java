package week4;

import java.awt.*;
import imagePackage.*;

public class Frogland5 {


	// make class fields non-static (i.e. instance fields)

	private  RasterImage frogLand ;
	private  Graphics2D gfx ;
	private  Color frogCol ;
	private  Color waterCol ;


	// DEFAULT CONSTRUCTOR (no arguments) - can only initialize instance fields with default settings

	public Frogland5() {
		this.frogLand = new RasterImage(640,480);
		this.gfx = this.frogLand.getGraphics2D();
		this.frogCol = Color.GREEN;
		this.waterCol = new Color(0, 100, 200);

	}

	// add CUSTOM CONSTRUCTORS to initialize instance fields alternative ways
	
	public Frogland5(int width, int height) {
		this.frogLand = new RasterImage(width,height);
		this.gfx = this.frogLand.getGraphics2D();
		this.frogCol = Color.GREEN;
		this.waterCol = new Color(0, 100, 200);
	}

	public Frogland5(int width, int height, Color frogCol) {
		this.frogLand = new RasterImage(width,height);
		this.gfx = frogLand.getGraphics2D();
		this.frogCol = frogCol;
		this.waterCol = new Color(0, 100, 200);
	}

	public Frogland5(int width, int height, Color frogCol, Color waterCol) {
		this.frogLand = new RasterImage(width,height);
		this.gfx = this.frogLand.getGraphics2D();
		this.frogCol = frogCol;
		this.waterCol = waterCol;
	}



	public void drawWorld() {
		frogLand.show();				
		frogLand.setTitle("Frogger");	
		gfx.setColor(this.waterCol);
		gfx.fillRect(0, 100, 640, 300);
		gfx.setColor(this.frogCol);
		gfx.fillOval(320, 400, 30, 40);

	}

	// Add Getters and Setters (for encapsulation)
	public Color getFrogCol() {
		return this.frogCol;
	}
	
	public Color getWaterCol() {
		return this.waterCol;
	}
	
	public void setFrogCol(Color frogCol) {
		this.frogCol = frogCol;
	}
	
	public void setWaterCol(Color waterCol) {
		this.waterCol = waterCol;
	}
	
	
	public static void main(String[] args) {

		Frogland5 world = new Frogland5();
		world.drawWorld();
		
		Frogland5 anotherWorld = new Frogland5(800,500,Color.magenta,Color.gray);
		anotherWorld.drawWorld();

		// mutate the frog color to pink!!
		anotherWorld.setFrogCol(Color.pink);
		anotherWorld.drawWorld();
	}


}
