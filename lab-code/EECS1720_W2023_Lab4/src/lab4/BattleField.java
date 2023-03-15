package lab4;
import imagePackage.RasterImage;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.PrintStream;
import java.util.Random;

public class BattleField {

	// CLASS FIELDS (Exercise02) - please conform to UML diagram in lab4 pdf!!
	private int ROWS;
	private int COLS;
	private RasterImage gameBoard;
	private Graphics2D gfx;
	private Alien[][] aliens;
	private Hero shooter;
	
	
	
	public BattleField(int width, int height) {
		
		// TO COMPLETE (Exercise02)
		
		
	}
	
	
	
	public BattleField(int width, int height, int n) {
		
		// TO COMPLETE (Exercise03, part d)
		
		
	}
	
	public void draw() {
		
		// TO COMPLETE (Exercise02)
		
		
	}
	
	
	public void selectAlien(Random r) {
		int randR = r.nextInt(ROWS);
		int randC = r.nextInt(COLS);
		aliens[randR][randC].setColor(Color.red);
		aliens[randR][randC].drawAlien(g);
		// TO COMPLETE (Exercise02)
		
	}
	
	
	public void advanceEnemy() {
		
		// TO COMPLETE (Exercise03, part e)
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		/*
		 *	Simplified solution to lab 2 (BattleField): 		
		 * 
		 * 		- need to reorganize this into a class that can be instantiated (as per lab4 pdf)
		 * 
		 */

		
		
		final int ROWS = 3;
		final int COLS = 10;
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		RasterImage gameBoard = new RasterImage(640,480);
		gameBoard.show();
		gameBoard.setTitle("BattleField");
		Graphics2D g = gameBoard.getGraphics2D();

		Alien[][] aliens = new Alien[ROWS][COLS];		// 2D array of Aliens
		

		for (int col=0; col<COLS; col++) {
			for (int row=0; row<ROWS; row++) {

				// create and initialize position of Aliens
				Point2D.Double pos = new Point2D.Double(col*60.0, row*60.0);
				aliens[row][col] = new Alien(pos);
				aliens[row][col].drawAlien(g);
			}
		}

		Hero shooter = new Hero(200,350);
		shooter.draw(g);
		

		// include here statements to instantiate BattleField and advanceEnemy 
		// (when the class is complete as per lab4 requirements)
		// 
		// this relates to STEP 2, Exercise02 and onwards...
		

		



	}
}
