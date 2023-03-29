package week10;

import java.awt.Color;

public class Question03 {

	
	public static Picture sepiaImage(Picture image) {

		int width = image.width();
		int height = image.height();

		Picture result  = new Picture(image);

		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {

				int rgb = image.getRGB(i, j);

				// unpack r, g, b
				int r = (rgb >> 16) & 0xFF;
				int g = (rgb >>  8) & 0xFF;
				int b = (rgb >>  0) & 0xFF;

				// darken shadows
				if (r<60) {
					r = (int) (r * 0.9);
					g = (int) (g * 0.9);
					b = (int) (b * 0.9);
				}
				// make midtones more brown
				else if (r<190) {
					b = (int) (b * 0.7);
				}
				// make highlights more yellow
				else {
					b = (int) (b * 0.9);
				}

				// repack r,g,b
				result.set(i, j, new Color(r,g,b));

			}
		}

		return result;

	}



	
	
	public static int getRGBAverage(int rgb) {
		
		// unpack r, g, b
		int r = (rgb >> 16) & 0xFF;
		int g = (rgb >>  8) & 0xFF;
		int b = (rgb >>  0) & 0xFF;
		
		int average = (r+g+b)/3;
		return average;
		
	}

	
	
	
	public static Picture edgeImage(Picture image, int threshold) {

		int width = image.width();
		int height = image.height();

		Picture edge = new Picture(width,height);  // black image


		for (int i=0; i<width-1; i++) {
			for (int j=0; j<height-1; j++) {

				// get gray value for this pixel
				int topYAvg = getRGBAverage(Question02.rgbToY(image.getRGB(i, j)));
				int bottomYAvg =  getRGBAverage(Question02.rgbToY(image.getRGB(i, j+1)));
				int rightYAvg = getRGBAverage(Question02.rgbToY(image.getRGB(i+1, j)));


				if ( 	( Math.abs(topYAvg-bottomYAvg) > threshold ) ||
						( Math.abs(topYAvg-rightYAvg)   > threshold )    ) {
					edge.set(i, j, Color.BLACK);
				}
				else {
					edge.set(i, j, Color.WHITE);
				}

			}
		}

		return edge;


	}

	

	public static void main(String[] args) {

		Picture orig = new Picture(args[0]);
		orig.setTitle("original");
		orig.show();
		
		int width =  orig.width();
		int height = orig.height();
		System.out.println("w = " + width + ", h = " + height);
		
		if (args.length==1) {
			// create sepia image
			Picture sepia = sepiaImage(orig);
			sepia.setTitle("sepia image");
			sepia.show();
			
		}
		
		if (args.length == 2) {

			int thresh = Integer.parseInt(args[1]);

			// create edge image
			Picture edge = edgeImage(orig, thresh);
			edge.setTitle("edge image");
			edge.show();
		}
	



	}

}
