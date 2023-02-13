package week4;

import java.awt.*;
import imagePackage.RasterImage;



public class Frogland1 {
	
	
	// variables from main moved into class definition (outside any methods)
	// these are now CLASS FIELDS  (static currently)
	
	public static RasterImage frogLand = new RasterImage(640,480);
	public static Graphics2D gfx = frogLand.getGraphics2D();
	public static Color frogCol = Color.GREEN;
	public static Color waterCol = new Color(0, 100, 200);

	

	public static void main(String[] args) {
		

		frogLand.show();
		frogLand.setTitle("Frogger");

		gfx.setColor(waterCol);
		gfx.fillRect(0, 100, 640, 300);
		gfx.setColor(frogCol);
		gfx.fillOval(320, 400, 30, 40);


	}

}
