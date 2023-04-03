package lab6;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class TetrisBlockDemo extends JFrame implements ActionListener, KeyListener, MouseListener {

	public static final Color LINE_COLOR = Color.BLACK;
	public static final Color CANVAS_BACKGROUND = Color.LIGHT_GRAY;
	
	public static final int CANVAS_WIDTH = 10*40;		// tetris canvas width (grid spaces * BLOCKWIDTH)
	public static final int CANVAS_HEIGHT = 20*40;		// tetris canvas height (grid spaces * BLOCKWIDTH)
	
	
	private Canvas playingField;			// area to draw tetrimino within
	private Graphics2D g2d;				// reference to graphics2D 

	private Timer timer;					// a timer to create falling animation of the block 
	private Block block;					// a block (will hold an IBlock, JBlock or SBlock (one at any given time)
	private boolean isFalling;			// a variable to indicate if a block is currently falling (true) or stationary (false)

	public TetrisBlockDemo(String name) {

		super(name);
		
		// ULTIMATELY THIS CONSTRUCTOR SHOULD BE MODIFIED TO REGISTER LISTENERS FOR HANDLING KEY & MOUSE EVENTS, as well as FALLING ANIMATION
				

		this.playingField = new TetrisCanvas();
		this.playingField.setSize(10*40,20*40);
		this.g2d = (Graphics2D) this.playingField.getGraphics();
		
		this.add(this.playingField,BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);

		this.block = TetrisBlockDemo.randomBlock();
		this.isFalling = false;
		
		
		
		this.setFocusable(true);
		

		this.addKeyListener(this);
		this.addMouseListener(this);
		
		this.requestFocus();
		
		this.timer=new Timer(500, this);
		this.timer.start();
		
	}
	
	
	private class TetrisCanvas extends Canvas {
		
		
		// ALREADY COMPLETE, DO NOT MODIFY
		
		

		// TetrisCanvas() is implied
		public void TetrisCanvas() {
		
			
		}
		
		@Override
		public void paint(Graphics g) {

			super.paint(g);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(CANVAS_BACKGROUND);
			
			// draw block (will dynamically dispatch to particular block type)
			block.draw(g2d);

		}

	}
	

	public static Block randomBlock() {
		
		// ALREADY COMPLETE (DO NOT MODIFY)
		
		Random r = new Random();
		int val = r.nextInt(3);
		Block b = null;
		
		switch (val) {
		case 0:
			b = new IBlock(new Point2(4, 20), Color.CYAN);
			break;
		case 1:
			b = new JBlock(new Point2(4, 20), Color.BLUE);
			break;
		case 2:
			b = new SBlock(new Point2(4, 20), Color.GREEN);
			break;
		}
		System.out.println(b);
		return b;
	}

	
	// EXERCISE 2 (HANDLE THE KEY PRESSES NEEDED TO SPIN, MOVE OR SET A BLOCK TO FALLING STATE)
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {

	}


	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
    
		switch (key) {
			case KeyEvent.VK_A:
				block.moveLeft();
				break;
			case KeyEvent.VK_D:
				block.moveRight();
				break;
			case KeyEvent.VK_J:
				block.spinLeft();
				break;
			case KeyEvent.VK_L:
				block.spinRight();
				break;
			case KeyEvent.VK_S:
				isFalling = !isFalling;
				break;
		}
		this.requestFocusInWindow();
		this.playingField.repaint();
		//System.out.println(key+" Pressed ");

	}


	@Override
	public void keyReleased(KeyEvent e) {
		

	}
	
	

	// EXERCISE 3 (HANDLE THE MOUSE EVENTS NEEDED TO SPIN A BLOCK)
	


	@Override
	public void mouseClicked(MouseEvent e) {
		
		double distance = e.getX() - block.getPosition().getX();
        
        if (distance < 0) {
            block.spinLeft();
        } else{
            block.spinRight();
        }
        
        System.out.println("mouse X: "+e.getX()+" block X: "+block.getPosition().getX());
        
        this.requestFocusInWindow();
        this.playingField.repaint();
		
	}


	@Override
	public void mousePressed(MouseEvent e) {

		
	}


	@Override
	public void mouseReleased(MouseEvent e) {

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
	
	
	// EXERCISE 4 (HANDLE THE ANIMATION OF A BLOCK AS IT FALLS)
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// METHOD TO COMPLETE (USES isFalling VARIABLE TO UPDATE THE POSITION OF THE CURRENT TETRIMINO BLOCK)
		// THIS METHOD SHOULD BE ATTACHED TO (REGISTERED AGAINST A TIMER OBJECT)
		
		System.out.print("timer event: ");
	

		if (isFalling) {

			System.out.println(" falling");
			
			// ADD STATEMENTS HERE TO UPDATE BLOCK POSITION IF FALLING
			block.moveDown();
			

			System.out.println("   -> pos: " + block.getPosition().getY());
			
			if (block.getPosition().getY() > CANVAS_HEIGHT) {
				
				// INSTANTIATE A NEW RANDOM BLOCK IF THE PREVIOUS BLOCK FALLS OFF BOTTOM OF THE SCREEN/PLAYING FIELD
				isFalling = false;
				block = TetrisBlockDemo.randomBlock();
				
			}
		}
		else {
			System.out.println(" stopped");
		}
		
		playingField.repaint();
	}
	

	
	
	/**
	 * Main method to instantiate a TetrisBlockDemo, which should display and process input events to spin and allow a block to fall
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		TetrisBlockDemo test = new TetrisBlockDemo("Tetris Block Test");
	
	}

}






