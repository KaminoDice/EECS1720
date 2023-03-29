package week10;

import java.awt.*;
import java.awt.event.MouseEvent;  
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;  

/**
 * Captures live motion (position) of mouse and updates whenever there is mouse motion
 * Outputs position into a JLabel
 * 
 * @author eecs1720
 *
 */
public class MouseLocationPaint extends JFrame implements MouseMotionListener{  
	
	private JLabel mousePosition;  
	private Color pen = Color.BLUE; 


	public MouseLocationPaint(String title){
		
		super(title);
		
		this.mousePosition = new JLabel();  				// JLabel to show mouse position
		this.mousePosition.setBounds(20,40,150,20);
		
		this.add(this.mousePosition);  					// register this MouseLocationPaint
		//this.addMouseMotionListener(this);				// instance as MouseMotionListener 
		
		Container pane = this.getContentPane();
		pane.addMouseMotionListener(this);			 
		 											

		JButton button = new JButton("something else");
		button.setBounds(100, 100, 100, 20);
		//button.addMouseMotionListener(this);
		pane.add(button);
		
//		Component glass = this.getGlassPane();
//		glass.addMouseMotionListener(this);
//		glass.setVisible(true);
//		this.setGlassPane(glass);
		
		this.setSize(400,400);  
		this.setLayout(null);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);  
		
	}  
	
	public void mouseMoved(MouseEvent e) {  
		
		// whenever mouse is moved over anything in the JFrame...
		
		// SHOW RELATIVE MOUSE POSITION
		this.mousePosition.setText("(x,y) = (" + e.getX() + ", " + e.getY() + ")"); 
		
		// SHOW ABSOLUTE SCREEN MOUSE POSITION
		//this.mousePosition.setText("(x,y) = (" + e.getXOnScreen() + ", " + e.getYOnScreen() + ")"); 
		
		// CONSOLE MESSAGE
		//System.out.println(e);
		
		
	} 
	
	public void mouseDragged(MouseEvent e) {  
		
		// CONSOLE MESSAGE
		System.out.println(e);
		
	}  
	 
	
	public static void main(String[] args) { 
		
		MouseLocationPaint frame = new MouseLocationPaint("Show Mouse Location");  
		
	}  
} 