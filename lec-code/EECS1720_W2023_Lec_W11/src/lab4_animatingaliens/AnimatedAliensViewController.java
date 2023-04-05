package lab4_animatingaliens;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;


// THIS CLASS MERGES THE VIEW AND CONTROLLER 
// FUNCTION INTO ONE (USES ANIMATEDALIENMODEL as the MODEL)

// please refer to lecture 22 (video) - which works through aspects of building/modifying this class


public class AnimatedAliensViewController extends JFrame implements ActionListener, KeyListener {

	// Define named-constants
	private static final int CANVAS_WIDTH 	= 640;
	private static final int CANVAS_HEIGHT 	= 480;
	private static final int UPDATE_PERIOD 	= 50; // milliseconds	


	private AnimatedAliensModel model;
	
	private BattleArena gameBoard;
	private JLabel 		status;
	private JLabel		console;

	private Timer 		updateGameBoardTimer; 


	public AnimatedAliensViewController() {

		super("Animated Aliens");

		
		
		Container contentPane = this.getContentPane();   // BorderLayout is default
		


		this.gameBoard = new BattleArena(CANVAS_WIDTH,CANVAS_HEIGHT);

		this.status = new JLabel("Welcome");
		this.status.setOpaque(true);
		this.status.setBackground(Color.DARK_GRAY);
		this.status.setForeground(Color.YELLOW);
		
		this.console = new JLabel("action:\t\thealth=10\tenemies=20");
		this.console.setOpaque(true);
		this.console.setBackground(Color.DARK_GRAY);
		this.console.setForeground(Color.GREEN);

		contentPane.add(this.status,BorderLayout.NORTH);
		contentPane.add(this.gameBoard,BorderLayout.CENTER);
		contentPane.add(this.console,BorderLayout.SOUTH);

		this.model = new AnimatedAliensModel();
		
		this.updateGameBoardTimer = new Timer(50, this);
		this.updateGameBoardTimer.start();
		
		
		this.addKeyListener(this);
		this.requestFocus();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}





	// private class to encapsulate BattleField as a specialized Canvas (for ease of drawing)
	// if you want no layout (absolute), canvas is convenient, if you want a layout.. perhaps
	// extend JPanel instead for this class

	private class BattleArena extends Canvas {


		public BattleArena(int width, int height) {

			super();
			this.setPreferredSize(new Dimension(width,height));

		}

		@Override
		public void paint(Graphics g) {

			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;		// g & g2d give access to drawing functionality

			// draw BattleArena

			g2d.setBackground(Color.PINK);
			model.draw(g2d);

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		
		
		
		case KeyEvent.VK_M:
			// march
			model.attack();
			
			break;
			
		case KeyEvent.VK_S:
			
			model.setTimer(20);
		
			break;
			
		case KeyEvent.VK_D:
			// cease fire
			model.toggleDirection();
		
			break;
		
		case KeyEvent.VK_C:
			// cease fire
			model.ceaseFire();
		
			break;
			
			
		case KeyEvent.VK_LEFT:
			// hero left
			Hero shooter = model.getShooter();
			
			shooter.move('L', 10);
			gameBoard.repaint();
			break;
			
		case KeyEvent.VK_RIGHT:
			// hero left
			Hero shooter2 = model.getShooter();
			
			shooter2.move('R', 10);
			gameBoard.repaint();
			break;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		gameBoard.repaint();
		
	}
	

	
	public static void main(String[] args) {



		AnimatedAliensViewController view 	= new AnimatedAliensViewController();







	}




}
