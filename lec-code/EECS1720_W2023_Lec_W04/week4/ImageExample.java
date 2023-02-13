package week4;

import java.awt.Color;
import imagePackage.RasterImage;


public class ImageExample {

	public static void main(String[] args) {

		
		RasterImage img = new RasterImage();
		
		img = new RasterImage(200,200);
		img = new RasterImage("images/yogaBike.jpg");

		img.show();
		//img.explore();


	}

}
