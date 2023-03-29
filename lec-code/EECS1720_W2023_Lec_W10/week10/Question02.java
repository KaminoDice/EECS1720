package week10;

import java.awt.Color;

public class Question02 {

	public static Picture duplicate(Picture image) {
		// method to copy an image


		int width = image.width();
		int height = image.height();

		Picture result = new Picture(width,height);


		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {

				result.setRGB(i, j, image.getRGB(i, j));

			}
		}
		return result;
	}
	
	
	
	
	public static int rgbToY(int rgb) {
		

		final double RFACTOR = 0.2989;
		final double GFACTOR = 0.5870;
		final double BFACTOR = 0.1140;
		
		// unpack r,g,b
		int r = (rgb >> 16) & 0xFF;
		int g = (rgb >>  8) & 0xFF;
		int b = (rgb >>  0) & 0xFF;
		
		int y = (int) (RFACTOR*r + GFACTOR*g + BFACTOR*b);
		return y;
	}
	

	public static Color rgbToColor(int rgb) {
		
		
		// unpack r, g, b
		int r = (rgb >> 16) & 0xFF;
		int g = (rgb >>  8) & 0xFF;
		int b = (rgb >>  0) & 0xFF;
		
		Color c = new Color(r,g,b);
		return c;
		
	}
	
	public static Picture rgbToGray(Picture image) {
		
		int width = image.width();
		int height = image.height();
		
		Picture result = new Picture(image);
		
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				
				int rgb = image.getRGB(i, j);
				
				int y = rgbToY(rgb);
				
				// repack rgb using y for each
				int rgbGray = (y << 16) + (y << 8) + (y << 0);
				
				result.setRGB(i, j, rgbGray);
				

	
			}
		}
		return result;
		
		
	}
	

	
	public static Picture zeroChannel(Picture image, char c) {
		
		int width = image.width();
		int height = image.height();
		
		Picture result = new Picture(image);
		
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				
				int rgb = image.getRGB(i, j);
			
				// unpack r, g, b
				int r = (rgb >> 16) & 0xFF;
				int g = (rgb >>  8) & 0xFF;
				int b = (rgb >>  0) & 0xFF;

				switch (c) {
				case 'r':
					r=0;
					break;
				case 'g':
					g=0;
					break;
				case 'b':
					b=0;
					break;
					
				}
				result.set(i, j, new Color(r,g,b));
				

	
			}
		}
		return result;
		
		
	}
	
	
	

	

	

	
	
	public static void main(String[] args) {
		
		
		System.out.println("num args = " + args.length);
		
		// assume arguments are entered from the command line
		if (args.length != 1) {
			
			System.out.printf("Usage: java Question01 <Image filename>", args[0]);
			return;		// exit program, 
		}

		// get input filename (already a string)
		String imageFileName = args[0];
		
		// load picture and display original
		Picture image = new Picture(imageFileName);
		image.setTitle("original");
		image.show();
		
		// load and display duplicate 
		Picture copy = duplicate(image);
		copy.setTitle("duplicate");
		copy.show();
		
		// change picture to grayscale and show
		Picture gray = rgbToGray(image);
		gray.setTitle("grayscale");
		gray.show();
		

		// rb channel
		Picture zeroG = zeroChannel(image, 'g');
		zeroG.setTitle("r_b only");
		zeroG.show();

		// bg channel
		Picture zeroR = zeroChannel(image, 'r');
		zeroR.setTitle("_bg only");
		zeroR.show();

		// rg channel
		Picture zeroB = zeroChannel(image, 'b');
		zeroB.setTitle("rg_ only");
		zeroB.show();

		// r channel
		Picture zeroGB = zeroChannel(zeroG, 'b');
		zeroGB.setTitle("r only");
		zeroGB.show();

	}

}
