package week4;

import java.awt.*;
import imagePackage.*;

public class Frogland3 {


	// make class fields non-static (i.e. instance fields)
	
	public  RasterImage frogLand ;
	public  Graphics2D gfx ;
	public  Color frogCol ;
	public  Color waterCol ;

	public Frogland3() {
		
		frogLand = new RasterImage(640,480);
		gfx = frogLand.getGraphics2D();
		frogCol = Color.GREEN;
		waterCol = new Color(0, 100, 200);

	}
	
	public void drawWorld() {
		
		frogLand.show();				
		frogLand.setTitle("Frogger");	
		gfx.setColor(waterCol);
		gfx.fillRect(0, 100, 640, 300);
		gfx.setColor(frogCol);
		gfx.fillOval(320, 400, 30, 40);
		
	}

	public static void main(String[] args) {
		
		Frogland3 world = new Frogland3();
		world.drawWorld();

	}


}
