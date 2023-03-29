package week10;

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*;    // Using Swing's components and containers


/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */

public class SimpleMoveALineKey extends JFrame {

	// Define constants for the various dimensions
	public static final int CANVAS_WIDTH = 400;
	public static final int CANVAS_HEIGHT = 140;
	public static final Color LINE_COLOR = Color.BLACK;
	public static final Color CANVAS_BACKGROUND = Color.LIGHT_GRAY;

	// The moving line from (x1, y1) to (x2, y2), 
	// initially position at the center
	private int x1 = CANVAS_WIDTH / 2;
	private int y1 = CANVAS_HEIGHT / 8;
	private int x2 = x1;
	private int y2 = CANVAS_HEIGHT / 8 * 7;

	// buttons
	private JButton btnLeft;
	private JButton btnRight;

	// The custom drawing canvas (an inner class extends JPanel)
	private DrawCanvas canvas; 


	// Constructor to set up the GUI components and event handlers
	public SimpleMoveALineKey() {

		// Set up a panel for the buttons
		JPanel btnPanel = new JPanel(new FlowLayout());

		this.btnLeft = new JButton("<--");
		this.btnRight = new JButton("-->");

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
		this.setTitle("Move a Line");
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
		public void paint(Graphics g) {

			super.paint(g);

			setBackground(CANVAS_BACKGROUND);
			g.setColor(LINE_COLOR);

			g.drawLine(x1, y1, x2, y2); // Draw the line


		}
	}


	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			System.out.println(e);
			
			JButton clicked = (JButton) e.getSource();

			if (clicked == btnLeft) {
				x1 -= 10;
				x2 -= 10;
			}

			if (clicked == btnRight) {
				x1 += 10;
				x2 += 10;
			}

			canvas.repaint();
			requestFocus(); 		// change the focus to JFrame to receive KeyEvent
		}

	}

	private class MoveKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {

			System.out.println(e);
			
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


	// The entry main() method
	public static void main(String[] args) {

		new SimpleMoveALineKey(); // Let the constructor do the job

	}
}

