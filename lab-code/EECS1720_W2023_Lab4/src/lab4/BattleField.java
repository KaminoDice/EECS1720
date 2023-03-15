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
		ROWS=3;
		COLS=10;
		gameBoard = new RasterImage(width, height);
		gfx = gameBoard.getGraphics2D();
		
		aliens = new Alien[ROWS][COLS];
		for(int col=0;col<COLS;col++) {
			for (int row=0; row<ROWS; row++) {
				Point2D.Double pos = new Point2D.Double(col*60.0,row*60.0);
				aliens[row][col]= new Alien(pos);
			}
		}
		
		gameBoard.show();
		gameBoard.setTitle("BattleField Ex2");
	}
	
	public void setROWS(int row) {
		this.ROWS=row;
	}
	
	public void setCOLS(int col) {
		this.COLS=col;
	}
	
	public int getROWS() {
		return this.ROWS;
	}
	
	public int getCOLS() {
		return this.COLS;
	}
	
	public BattleField(int width, int height, int n) {
		
		// TO COMPLETE (Exercise03, part d)
		ROWS=3;
		COLS=10;
		gameBoard = new RasterImage(width, height);
		gfx = gameBoard.getGraphics2D();
		
		aliens = new Alien[ROWS][COLS];
		Random seed = new Random(n);
		for(int col=0;col<COLS;col++) {
			for (int row=0; row<ROWS; row++) {
				Point2D.Double pos = new Point2D.Double(col*60.0,row*60.0);
				switch (seed.nextInt(4)){
					case 0:
						aliens[row][col]= new AngryAlien(pos);
						break;
					case 1:
						aliens[row][col]= new DocileAlien(pos);
						break;
					case 2:
						aliens[row][col]= new NeutralAlien(pos);
						break;
					case 3:
						aliens[row][col]= new Alien(pos);
						break;
				}
			}
		}
		

		gameBoard.show();
		gameBoard.setTitle("BattleField Ex3");
	}
	
	public void draw() {
		
		// TO COMPLETE (Exercise02)
		gfx.setColor(Color.white);
		gfx.fillRect(0, 0, gameBoard.getWidth(), gameBoard.getHeight());
		
		for (int i=0;i<this.aliens.length;i++) {
			for (int j=0;j<this.aliens[i].length;j++) {
				aliens[i][j].drawAlien(gfx);
			}
		}	
		
		shooter = new Hero(200,350);
		shooter.draw(gfx);
	}
	
	
	public void selectAlien(Random r) {
		int randR = r.nextInt(ROWS);
		int randC = r.nextInt(COLS);
		aliens[randR][randC].setColor(Color.red);
		aliens[randR][randC].drawAlien(gfx);
		// TO COMPLETE (Exercise02)
		
	}
	
	
	public void advanceEnemy() {
		
		// TO COMPLETE (Exercise03, part e)
		for (int i=0;i<this.aliens.length;i++) {
			for (int j=0;j<this.aliens[i].length;j++) {
				aliens[i][j].advance();
			}
		}	
		
		this.draw();
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
		BattleField battlefield2 = new BattleField(600,500);
		battlefield2.draw();
		Random r= new Random();
		battlefield2.selectAlien(r);

		BattleField battlefield3 = new BattleField(600, 500, 14);
		battlefield3.draw();
		battlefield3.advanceEnemy();
		
		//BattleField battlefield4 = new BattleField(640, 500, 14);
		//battlefield4.advanceEnemy();
		//battlefield4.draw();
	}
}
