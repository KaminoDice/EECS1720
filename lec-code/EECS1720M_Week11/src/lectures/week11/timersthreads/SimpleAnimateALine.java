package lectures.week11.timersthreads;

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*;    // Using Swing's components and containers


/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */

public class SimpleAnimateALine extends JFrame {

	// Define constants for the various dimensions
	public static final int CANVAS_WIDTH = 400;
	public static final int CANVAS_HEIGHT = 140;
	public static final Color LINE_COLOR = Color.BLACK;
	public static final Color CANVAS_BACKGROUND = Color.LIGHT_GRAY;
	
	// Define constants for directional movement
	private static final int STATIONARY = 0;
	private static final int MOVE_LEFT = 1;
	private static final int MOVE_RIGHT = 2;

	// The moving line from (x1, y1) to (x2, y2), 
	// initially position at the center
	private int x1 = CANVAS_WIDTH / 2;
	private int y1 = CANVAS_HEIGHT / 8;
	private int x2 = x1;
	private int y2 = CANVAS_HEIGHT / 8 * 7;

	// buttons
	private JButton btnLeft;
	private JButton btnRight;
	
	// timer
	private Timer animateTimer;
	private int animateHow;


	// The custom drawing canvas (an inner class extends JPanel)
	private DrawCanvas canvas; 


	// Constructor to set up the GUI components and event handlers
	public SimpleAnimateALine(String title) {
		
		super(title);
		
		// setup the timer and moveDirection
		int delay = 100; // milliseconds
		this.animateTimer = new Timer(delay, new UpdateListener());
		this.animateHow = SimpleAnimateALine.STATIONARY; 
		
		// Set up a panel for the buttons
		JPanel btnPanel = new JPanel(new FlowLayout());

		this.btnLeft = new JButton("animate <--");
		this.btnRight = new JButton("animate -->");

		ButtonListener actionHandler = new ButtonListener();

		this.btnLeft.addActionListener(actionHandler);
		this.btnRight.addActionListener(actionHandler);

		btnPanel.add(btnLeft);
		btnPanel.add(btnRight);


		// Set up a custom drawing JPanel
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

		// Add both panels to this JFrame's content-pane
		this.add(canvas, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);

		// "super" JFrame fires KeyEvent
		this.addKeyListener(new MoveKeyListener());

		// setup JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
		this.pack();           
		this.setVisible(true);

		// set the focus to JFrame to receive KeyEvent
		this.requestFocus();   
	}


	/**
	 * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
	 */
	private class DrawCanvas extends JPanel {

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			setBackground(CANVAS_BACKGROUND);
			g.setColor(LINE_COLOR);

			g.drawLine(x1, y1, x2, y2); // Draw the line


		}
	}


	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JButton clicked = (JButton) e.getSource();

			if (clicked == btnLeft) {
//				x1 -= 10;
//				x2 -= 10;
				
				// set animateHow to MOVE_LEFT
				animateHow = SimpleAnimateALine.MOVE_LEFT;
				animateTimer.start();
			}

			if (clicked == btnRight) {
//				x1 += 10;
//				x2 += 10;
				
				// set animateHow to MOVE_RIGHT
				animateHow = SimpleAnimateALine.MOVE_RIGHT;
				animateTimer.start();
				
			}

			//canvas.repaint();
			requestFocus();
			
		}

	}

	private class MoveKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {

			switch(e.getKeyCode()) {

			case KeyEvent.VK_LEFT:
				x1 -= 10;
				x2 -= 10;
				canvas.repaint();
				break;

			case KeyEvent.VK_RIGHT:
				x1 += 10;
				x2 += 10;
				canvas.repaint();
				break;
			
			case KeyEvent.VK_SPACE:
				if (animateTimer.isRunning()) {
					animateHow = SimpleAnimateALine.STATIONARY;
					animateTimer.stop();
					System.out.println("stopped");
				}
				break;
				
			}
			
		}
		
		

		@Override
		public void keyTyped(KeyEvent e) {
			// do nothing

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// do nothing

		}
	}
	
	private class UpdateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// dont really need to check source of event

			switch (animateHow) {
			
			case SimpleAnimateALine.MOVE_LEFT:
				
				System.out.println("moving left");
				
				x1 -= 10;
				x2 -= 10;
				
				if ((x1-10) < 0 ) {
					animateHow = SimpleAnimateALine.STATIONARY;
					animateTimer.stop();
					System.out.println("stopped");
					
					
					
				}
				
				break;
				
			case SimpleAnimateALine.MOVE_RIGHT:
				
				System.out.println("moving right");
				
				x1 += 10;
				x2 += 10;
				
				if ((x1+10) > SimpleAnimateALine.CANVAS_WIDTH ) {
					animateHow = SimpleAnimateALine.STATIONARY;
					animateTimer.stop();
					System.out.println("stopped");
				}
				break;
				
			
			default:
				
				// do nothing if stationary or anything other that MOVE_LEFT or MOVE_RIGHT
				
			}
			

			canvas.repaint();
			requestFocus();
			
			
		}
		
	}


	// The entry main() method
	public static void main(String[] args) {

		new SimpleAnimateALine("Animate A Line"); // Let the constructor do the job

	}
}

