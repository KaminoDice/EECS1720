package lab4_animatingaliens;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Random;

import javax.swing.Timer;


public class AnimatedAliensModel {

	private static final int ROWS = 4;
	private static final int COLS = 5;
	
	private Alien[][]	aliens;
	private Hero		shooter;
	
	private boolean		marchRight;			// true right or false left
	
	
	private Timer 		attackTimer;
	
	
	
	public AnimatedAliensModel() {
		
		this.aliens = new Alien[ROWS][COLS];
		int offsetX = 200;
		int offsetY = 50;
				
		for (int row = 0; row<ROWS; row++) {
			for (int col = 0; col<COLS; col++) {
				
				// create and initialize position of Aliens
				Point2D.Double pos = new Point2D.Double(offsetX + col*60.0, offsetY+row*60.0);
				
				//aliens[row][col] = new Alien(pos);
				
				
				Random r = new Random();
				switch(r.nextInt(3)) {
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
		
		this.marchRight = true;
		this.attackTimer = new Timer(50, new UpdateAttackListener());
	}
	
	public void attack() {
		
		this.attackTimer.start();
		System.out.println("attacking!");
	}
	
	public void ceaseFire() {
		
		this.attackTimer.stop();
		System.out.println("* cease fire *");
		
	}

	public Alien[][] getAliens() {
		return this.aliens;
	}
	
	public Hero getShooter() {
		return this.shooter;
	}
	
	public void toggleDirection() {
		
		this.marchRight = !this.marchRight;
	}
	
	public Rectangle getAliensBoundingBox() {
		
		Rectangle bb = new Rectangle();
		bb.setBounds((int) aliens[0][0].getPos().getX(),
					  (int) aliens[0][0].getPos().getY(),
					 COLS*60,  ROWS*60);
		
		return bb;
		
	}
	
	
	public void setTimer(int offset) {
		
		this.attackTimer.setDelay(this.attackTimer.getDelay()-offset);
	}
	
	
	public void marchEnemy() {
		
		
		
		for (int col=0; col<COLS; col++) {
			for (int row=0; row<ROWS; row++) {
				
				Alien currAlien = this.aliens[row][col];
				Point2D.Double currPos = currAlien.getPos();
				
				if (marchRight) {
					currAlien.setPos(new Point2D.Double(currPos.getX()+2,currPos.getY()));
				}
				else {
					currAlien.setPos(new Point2D.Double(currPos.getX()-2,currPos.getY()));
				}
				
				
				
				
				
			}
		}
		
	}
	

	public void advanceEnemy() {
		

		for (int col=0; col<COLS; col++) {
			for (int row=0; row<ROWS; row++) {
				
				
				
			    //this.aliens[row][col].advance();
				
				
				Alien currAlien = this.aliens[row][col];
				Point2D.Double currPos = currAlien.getPos();
				
				currAlien.setPos(new Point2D.Double(currPos.getX(),currPos.getY()+2));
				
				
			}
		}
		
	}
	
	
	
	public void draw(Graphics2D gfx) {
	
		// draw aliens
		
		for (int col=0; col<COLS; col++) {
			for (int row=0; row<ROWS; row++) {
				this.aliens[row][col].drawAlien(gfx);
			}
		}

		// draw shooter
		
		this.shooter.draw(gfx);

	}
	
	
	private class UpdateAttackListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			marchEnemy();
			
			
		}
		
	}


	
	
}
