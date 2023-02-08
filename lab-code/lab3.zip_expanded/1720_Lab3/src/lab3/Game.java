package lab3;

import java.awt.Color;

import imagePackage.RasterImage;

public class Game {

	public static final int NORTH = 90;
	public static final int SOUTH = 270;
	public static final int EAST = 0;
	public static final int WEST = 180;

	public static final Color FRIGHTENED_COL = Color.DARK_GRAY;

	
	public static void main(String[] args) {
		
		
		// SEE lab3.pdf for details (use this method to test and display the visual output of various
		// ghost objects with various states - as per the figures in the lab3 pdf )
		
		
		int size = 100;
		
		RasterImage app = new RasterImage(4*size,4*size);
		app.show();
		
		Ghost3[] badGuys = new Ghost3[4];
		badGuys[0] = new Ghost3(app.getWidth()/4-size/2,app.getHeight()/4-size/2,size,Color.RED,Game.NORTH);		// shadow
		badGuys[1] = new Ghost3(3*app.getWidth()/4-size/2,app.getHeight()/4-size/2,size,Color.PINK,Game.SOUTH);		// pinky
		badGuys[2] = new Ghost3(3*app.getWidth()/4-size/2,3*app.getHeight()/4-size/2,size);							// inky
		badGuys[3] = new Ghost3(app.getWidth()/4-size/2,3*app.getHeight()/4-size/2,size,Color.ORANGE,Game.WEST); 	// clyde
		
		
		badGuys[0].move('L', 20);
		badGuys[1].move('D', 50);
		badGuys[2].setEaten(true);
		badGuys[3].setFrightened(true);
		
		
		for (Ghost3 baddie : badGuys) {
			baddie.render(app.getGraphics2D());
		}
		

	}

}
