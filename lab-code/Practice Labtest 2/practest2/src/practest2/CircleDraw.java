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

//COMPLETE THE MISSING PIECES OF THE FOLLOWING CLASS (see comments for guidance)

public class CircleDraw extends JFrame {

	private static final int CANVAS_WIDTH = 400;
	private static final int CANVAS_HEIGHT = 380;

	private JLabel status;					// status label at bottom of app window
	private DrawCanvas drawCanvas;			// draw area for drawing circle & axes

	private Point2D.Double centre = null;	// centre of the circle drawn with mouse
	private double radius = 0.0;			// radius of the circle drawn with mouse

	

	public CircleDraw(String title) {

		super(title);

		
		// instantiate and configure canvas area (area in which the mouse will click/drag to draw) [3 MARKS]
		// the canvas should use the DrawCanvas class below, and the background should be DARK_GRAY.
		// the canvas width and height are provided as field constants above
		
		
		

		
		// TO COMPLETE - SET UP & REGISTER LISTENERS FOR canvas [5 MARKS]
		
		

		
		// TO COMPLETE - SET UP status JLabel [2 MARKS]
		

		
		
		
		
		
		// ALREADY DONE FOR YOU:
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
	

	public static void main(String[] args) {
		CircleDraw app = new CircleDraw("Circle Draw");
	}

	
	private class DrawCanvas extends JPanel {

		@Override
		public void paintComponent(Graphics g) {

			// TO COMPLETE - draw circle and axes if they have been initiated [10 MARKS]
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}


	// TO COMPLETE - add a listener class below that can be registered against the custom canvas to handle
	// all appropriate events for drawing the circle using the mouse clicks and movements (see URL for details)
	// [10 MARKS]
	
	
	
	
	
	
	
	
	
	
	
	



}
