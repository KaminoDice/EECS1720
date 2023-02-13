package week4;

import java.awt.*;
import imagePackage.*;

public class Frogland4 {


	// make class fields non-static (i.e. instance fields)

	public  RasterImage frogLand ;
	public  Graphics2D gfx ;
	public  Color frogCol ;
	public  Color waterCol ;


	// DEFAULT CONSTRUCTOR (no arguments) - can only initialize instance fields with default settings

	public Frogland4() {
		
		this.frogLand = new RasterImage(640,480);
		this.gfx = this.frogLand.getGraphics2D();
		this.frogCol = Color.GREEN;
		this.waterCol = new Color(0, 100, 200);

	}

	// add CUSTOM CONSTRUCTORS to initialize instance fields alternative ways
	
	public Frogland4(int width, int height) {
		
		this.frogLand = new RasterImage(width,height);
		this.gfx = this.frogLand.getGraphics2D();
		this.frogCol = Color.GREEN;
		this.waterCol = new Color(0, 100, 200);
	}

	public Frogland4(int width, int height, Color frogCol) {
		
		this.frogLand = new RasterImage(width,height);
		this.gfx = frogLand.getGraphics2D();
		this.frogCol = frogCol;
		this.waterCol = new Color(0, 100, 200);
	}

	public Frogland4(int width, int height, Color frogCol, Color waterCol) {
		
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

	public static void main(String[] args) {

		Frogland4 world = new Frogland4();
		world.drawWorld();
		
		Frogland4 anotherWorld = new Frogland4(800,500,Color.magenta,Color.gray);
		anotherWorld.drawWorld();

	}


}
