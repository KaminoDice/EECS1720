package week10;

import java.awt.Color;




public class ImageManip {

	public static Picture brighten(Picture image, char colour) {

		final double BFACTOR = 1.1;

		int width = image.width();
		int height = image.height();

		Picture result = new Picture(image);

		for(int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {

				int rgb = image.getRGB(i, j);

				// unpack r, g, b
				int r = (rgb >> 16) & 0xFF;
				int g = (rgb >>  8) & 0xFF;
				int b = (rgb >>  0) & 0xFF;

				// switch on colour to make brighter (default is all)
				switch (colour) {
				case 'r':
					r = (int) (r * BFACTOR);
					break;
				case 'g':
					g = (int) (g * BFACTOR);
					break;
				case 'b':
					b = (int) (b * BFACTOR);
					break;
				default:
					// all colours
					r = (int) (r * BFACTOR);
					g = (int) (g * BFACTOR);
					b = (int) (b * BFACTOR);		
				}

				// clamp r,g,b to 255 max!
				if (r>255) r=255;
				if (g>255) g=255;
				if (b>255) b=255;

				result.set(i, j, new Color(r,g,b));


			}
		}


		return result;


	}

	
	public static Picture flip(Picture image, String direction) {
		// method to flip an image along (horizontally/vertically)
		// horizontally (left/right)
		// vertically (up/down)
		
		int width = image.width();
		int height = image.height();
		
		Picture result = new Picture(width,height);
		
		switch (direction) {
		case "h": 
		case "H": 
		case "horizontally":

			System.out.println("flipping image horizontally");
			for (int i=0; i<width; i++) {
				for (int j=0; j<height; j++) {
					
					// iOld = (width-1)-i  (go from width-1 to 0)
					int iOld = (width-1)-i;
					result.setRGB(i, j, image.getRGB(iOld, j));
					
				}
			}
			break;
			
		case "v":
		case "V":
		case "vertically":
			
			System.out.println("flipping image vertically");
			for (int i=0; i<width; i++) {
				for (int j=0; j<height; j++) {
					
					// jOld = (height-1)-j  (go from height-1 to 0)
					int jOld = (height-1)-j;
					result.setRGB(i, j, image.getRGB(i, jOld));
					
				}
			}
			break;
			
		default:
			// do nothing
		
		}
		
		 
		
		return result;
	}
	
	
	public static Picture crop(Picture image, int x, int y, int newWidth, int newHeight) {
		
		int width = image.width();
		int height = image.height();
		
		Picture result = new Picture(newWidth,newHeight);
		
		for (int i=0; i<newWidth; i++) {
			for (int j=0; j<newHeight; j++) {
				
				// another way to use Color object
				
				int red = image.get(i+x, j+y).getRed();
				int blue= image.get(i+x, j+y).getBlue();
				int green= image.get(i+x, j+y).getGreen();
				
				result.set(i,j,new Color(red,green,blue));
				
																		// restrict ranges? 
				
				image.set(i+x, j+y, new Color(0,green,0));				// paint single channel?
				
			}
		}
		
		// grabbed all pixels, set image to result
		return result;
	
		
		
	}
	
public static Picture blend(Picture image1, Picture image2) {
		
		int width = image1.width();
		int height = image1.height();
		
		if (width != image2.width()  ||  height != image2.height()) System.exit(1); 
		
		Picture result = new Picture(width,height);
		
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				
				// another way to use Color object
				
				int red = (int) ( image1.get(i, j).getRed()*0.5 + image2.get(i, j).getRed()*0.5 )  ;
				int blue= (int) (image1.get(i, j).getBlue()*0.5 + image2.get(i, j).getBlue()*0.5);
				int green= (int) (image1.get(i, j).getGreen()*0.5 + image2.get(i, j).getGreen()*0.5);
				
				result.set(i,j,new Color(red,green,blue));
	
				
			}
		}
		
		// grabbed all pixels, set image to result
		return result;
	
		
		
	}
	
	public static Picture blendGradient(Picture image1, Picture image2) {
		
		int width = image1.width();
		int height = image1.height();
		
		if (width != image2.width()  ||  height != image2.height()) System.exit(1); 
		
		Picture result = new Picture(width,height);
		
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				
				// another way to use Color object
				
				int red = (int) ( image1.get(i, j).getRed()*(i/(double)width) + image2.get(i, j).getRed()*(1-i/(double)width) )  ;
				int blue= (int) (image1.get(i, j).getBlue()*(i/(double)width) + image2.get(i, j).getBlue()*(1-i/(double)width));
				int green= (int) (image1.get(i, j).getGreen()*(i/(double)width) + image2.get(i, j).getGreen()*(1-i/(double)width));
				
				result.set(i,j,new Color(red,green,blue));
	
				
			}
		}
		
		// grabbed all pixels, set image to result
		return result;
	
		
		
	}
	
	
	public static Picture flipRegion(Picture orig, String dir, int x0, int width, int y0, int height) {

		Picture result = new Picture(orig);
		
		// do flip
		
		
		
		
		return result;
		
		
		
		
	}
	
	
	
	public static Picture chromaKey(Picture foreground, Picture background) {
		
		// check both images same size
		int width = foreground.width();
		int height = foreground.height();
		
		if (width!= background.width() || height!= background.height()) 
		{
			System.out.println("Error, sizes of images dont match");
			System.exit(1);		// force program quit
		}
		
		Picture result  = new Picture(width,height);

		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {

				int rgb = foreground.getRGB(i, j);

				// unpack r, g, b
				int r = (rgb >> 16) & 0xFF;
				int g = (rgb >>  8) & 0xFF;
				int b = (rgb >>  0) & 0xFF;

				if (g > 250) {
					// green dominates, pixel, treat as background
					result.setRGB(i, j, background.getRGB(i, j));
				}
				else
					result.setRGB(i, j, foreground.getRGB(i, j));

			}
		}

		return result;
		
		
		
	}
	


	
	
	public static void main(String[] args) {


		Picture iPic = new Picture("./temple.jpg");
		iPic.show();
//	
//		Picture imag2 = new Picture(50,100);
//		imag2.show();
//		
		// brighten red
		brighten(brighten(iPic, 'g'), 'r').show();
		
		
		// crop image
//		Picture cropPic = crop(iPic, 50,100,128,150);
//		//Picture cropPic = crop(iPic, 0,0,iPic.width(),iPic.height());
//		iPic.show();
//		cropPic.show();
		

		// Flip picture ??  vertical or horizonally
		//flip(iPic, "vertically").show();
		
		
		
		// Flip region?
		//flipRegion(iPic, "v", 0, iPic.width(), iPic.height()/2, iPic.height()/2).show();
		
		
		
		// ChromaKey
//		Picture alien = new Picture("./alienChromaKey.jpg");
//		Picture field = new Picture("./field.jpg");
//		alien.show();
//		field.show();
//		Picture composite = chromaKey(alien, field);
//		
//		alien.setTitle("alien"); alien.show();	
//		field.setTitle("field"); field.show();	
//		composite.setTitle("chromakeyed"); composite.show();
//		
	}

}
