package week10;

import java.awt.*;  
import java.awt.event.*;

import javax.swing.JFrame;

/**
 * 
 * Draws ovals at mouse location directly into JFrame's graphics object
 * 
 * @author eecs1720
 *
 */
public class MouseCursorPaint extends JFrame implements MouseMotionListener{  

	public MouseCursorPaint(String title){  
		
		super(title);
		
		// note there are NO GUI Panels/Canvases or Components added
		// this is because a JFrame has a  Graphics component that we can get a reference to directly
		
		// If we want to restrict drawing to a part of the GUI, then can add a JPanel/Canvas (as in Lab 7)
		// and get reference to its Graphics component
		
		// register this instance of MouseCursorPaint as MouseMotionListener
		this.addMouseMotionListener(this);  

		
		this.setSize(300,300);  
		this.setLayout(null);  
		this.setResizable(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);  
		
	} 
	
	
	public void mouseMoved(MouseEvent e) {
		
		// Does nothing at this point 
		
		//System.out.println("Event e = " + e);		// shows move events
	}  
	
	
	public void mouseDragged(MouseEvent e) {  
		
		// if MOUSE_DRAGGED event continues
		
		//System.out.println("Event e = " + e);		// shows drag events 
		
		// note that g may be cast down to (Graphics2D) - since Graphics2D is a child of Graphics
		Graphics g = this.getGraphics();
		Graphics2D g2d = (Graphics2D) g;		// not used here
		
		
		// Paint a blue oval at the mouse position (if mouse is being dragged)
		g.setColor(Color.BLACK);  
		g.fillOval(e.getX(),e.getY(),5,5);
		
	}  
	


	public static void main(String[] args) {  
		new MouseCursorPaint("Mouse move-to-paint");  
		
	} 


}
