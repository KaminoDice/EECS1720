package week4;

import java.awt.*;
import imagePackage.*;


public class Frogland0 {
	
	// Everything inside main method!   
	// no class fields
	

	public static void main(String[] args) {
		
		RasterImage frogLand = new RasterImage(640,480);
		Graphics2D gfx = frogLand.getGraphics2D();

		Color frogCol = Color.GREEN;	// use static field
		Color waterCol = new Color(0, 100, 200); // create new color

		frogLand.show();
		frogLand.setTitle("Frogger");

		gfx.setColor(waterCol);
		gfx.fillRect(0, 100, 640, 300);
		gfx.setColor(frogCol);
		gfx.fillOval(320, 400, 30, 40);


	}

}
