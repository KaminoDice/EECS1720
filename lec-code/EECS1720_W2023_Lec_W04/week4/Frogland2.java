package week4;

import java.awt.*;
import imagePackage.*;

public class Frogland2 {


	public static RasterImage frogLand ;
	public static Graphics2D gfx ;
	public static Color frogCol ;
	public static Color waterCol ;

	public Frogland2() {
		
		frogLand = new RasterImage(640,480);
		gfx = frogLand.getGraphics2D();
		frogCol = Color.GREEN;
		waterCol = new Color(0, 100, 200);

	}

	public static void main(String[] args) {
		
		Frogland2 world = new Frogland2();
		
		frogLand.show();				// not possible (without above line), as no instance created, 
		frogLand.setTitle("Frogger");	// so no constructor has been run to initialize fields
		
		
		
		
		
		gfx.setColor(waterCol);
		gfx.fillRect(0, 100, 640, 300);
		gfx.setColor(frogCol);
		gfx.fillOval(320, 400, 30, 40);

	}


}
