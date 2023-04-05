package lab4_animatingaliens;

//import imagePackage.RasterImage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.PrintStream;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BattleField extends JFrame {

	private static final int ROWS = 3;
	private static final int COLS = 10;

	private Canvas gameBoard;
	private Graphics2D gfx;
	private Alien[][] aliens;
	private Hero shooter;


	public BattleField(int width, int height) {

		super("BattleField");
		// setup JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
		this.pack();           
		this.setVisible(true);

		Canvas gboard = new Canvas();
		gboard.setPreferredSize(new Dimension(width,height));
		this.gameBoard = gboard;
		this.gfx = (Graphics2D) gboard.getGraphics();

		this.aliens = new Alien[ROWS][COLS];
		for (int row = 0; row<ROWS; row++) {
			for (int col = 0; col<COLS; col++) {

				// create and initialize position of Aliens
				Point2D.Double pos = new Point2D.Double(col*60.0, row*60.0);
				aliens[row][col] = new Alien(pos);
			}
		}

		this.shooter = new Hero(200,350);

		//window setup
		Container contentPane = this.getContentPane();
		contentPane.add(this.gameBoard);
		this.setContentPane(contentPane);

		
		this.draw();
		

	}

	public BattleField(int width, int height, int n) {

		this.gameBoard = new Canvas();
		this.gameBoard.setSize(width,height);
		this.gfx = (Graphics2D) this.gameBoard.getGraphics();


		this.aliens = new Alien[ROWS][COLS];
		for (int row = 0; row<ROWS; row++) {
			for (int col = 0; col<COLS; col++) {

				// create and initialize position of Aliens
				Point2D.Double pos = new Point2D.Double(col*60.0, row*60.0);

				Random r = new Random();
				switch(r.nextInt(n)) {
				case 0: 
					aliens[row][col] = new AngryAlien(pos);
					break;
				case 1:
					aliens[row][col] = new NeutralAlien(pos);
					break;
				case 2:
					aliens[row][col] = new DocileAlien(pos);
					break;

				}

			}
		}

		this.shooter = new Hero(200,350);

		//window setup
		Container contentPane = this.getContentPane();
		contentPane.add(this.gameBoard);
		this.setContentPane(contentPane);

		// setup JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
		this.pack();           
		this.setVisible(true);
		
		this.draw();
	}

	public class GameBoard extends Canvas {
		
		public void paint(Graphics g) {
			
			draw();
		}
		
		
	}
	
	
	public void draw() {

		Graphics2D gfx = (Graphics2D) this.gameBoard.getGraphics();
		
		gfx.setBackground(Color.WHITE);
		gfx.clearRect(0, 0, this.gameBoard.getWidth(), this.gameBoard.getHeight());

		for (int col=0; col<COLS; col++) {
			for (int row=0; row<ROWS; row++) {
				this.aliens[row][col].drawAlien(this.gfx);
			}
		}

		this.shooter.draw(gfx);
		this.repaint();

	}


	public void selectAlien(Random r) {

		int randCol = (int) (r.nextDouble()*COLS);
		int randRow = (int) (r.nextDouble()*ROWS);
		Alien randAlien = this.aliens[randRow][randCol];
		randAlien.setColor(Color.RED);

		randAlien.drawAlien(this.gfx);


	}


	public void advanceEnemy() {

		for (int col=0; col<COLS; col++) {
			for (int row=0; row<ROWS; row++) {
				this.aliens[row][col].advance();
			}
		}

	}

	public static void main(String[] args) {

		BattleField b = new BattleField(640,480,3);

		b.draw();
		//		Random r = new Random();
//		// b.selectAlien(r);
//
//
//		// uncomment to check movement of aliens
//		//		b.advanceEnemy();
//		//		b.draw();





	}
}
