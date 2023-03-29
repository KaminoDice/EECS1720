package practest2;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.MouseInputAdapter;

public class CircleDraw extends JFrame {

	private static final int CANVAS_WIDTH = 400;
	private static final int CANVAS_HEIGHT = 380;

	private JLabel status;
	private DrawCanvas drawCanvas;

	private Point2D.Double centre = null;
	private double radius = 0.0;


	public CircleDraw(String title) {

		super(title);
		

		// setup canvas
		this.drawCanvas = new DrawCanvas();
		this.drawCanvas.setBackground(Color.DARK_GRAY);
		this.drawCanvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

		// TO COMPLETE - SET UP LISTENERS
		DrawListener drawListen = new DrawListener();
		this.drawCanvas.addMouseListener(drawListen);
		this.drawCanvas.addMouseMotionListener(drawListen);

		
		// setup status JLabel
		this.status = new JLabel("Status: ");

		// setup content pane
		Container pane = this.getContentPane();
		pane.add(this.drawCanvas, BorderLayout.CENTER);
		pane.add(this.status, BorderLayout.SOUTH);
		this.setContentPane(pane);

		// setup the app and show it	
		this.setSize(400, 400);
		this.setResizable(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);


	}

	private class DrawCanvas extends JPanel {

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);				// clears DrawCanvas
			Graphics2D g2d = (Graphics2D) g;

			// if centre has been instantiated, there is something to draw
			if (centre!=null) {
				
				// draw axes
				Shape axisX = new Line2D.Double(0,centre.getY(),drawCanvas.getWidth(),centre.getY());
				Shape axisY = new Line2D.Double(centre.getX(), 0, centre.getX(), drawCanvas.getHeight());
				g2d.setColor(Color.RED);
				g2d.draw(axisX);
				g2d.draw(axisY);
				
				// draw circle
				Shape tempCircle = new Ellipse2D.Double(centre.getX()-radius, centre.getY()-radius, radius*2, radius*2);
				g2d.setColor(Color.WHITE);
				g2d.draw(tempCircle);
			}
		}
	}


	
	private class DrawListener extends MouseInputAdapter {
		

		@Override
		public void mousePressed(MouseEvent e) {
			centre = new Point2D.Double(e.getX(), e.getY());
			radius = 0.0;

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			radius = centre.distance(new Point2D.Double(e.getX(),e.getY()));
			status.setText("Status: drawing circle " + 
					"(" +  centre.getX() + ", " + centre.getY() + ") " +
					"radius = " + radius);

			repaint();

		}

	}



	public static void main(String[] args) {
		CircleDraw app = new CircleDraw("Circle Draw");

	}

}

