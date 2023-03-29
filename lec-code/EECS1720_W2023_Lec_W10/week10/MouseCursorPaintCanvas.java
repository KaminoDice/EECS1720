package week10;

import java.awt.*;  
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * Separates the area in which graphics are drawn (Canvas) vs the rest of the GUI
 * 
 * @author eecs1720
 *
 */
public class MouseCursorPaintCanvas extends JFrame implements MouseMotionListener{  

	private JTextField penSize;
	private Canvas drawArea;
	
	public MouseCursorPaintCanvas(String title){  
		
		super(title);
		
		// drawPanel (holds canvas)
		
		JPanel drawPanel = new JPanel();
		//drawPanel.setBorder(BorderFactory.createEtchedBorder());
		
		this.drawArea = new Canvas();
		this.drawArea.setSize(400, 300);
		
		this.drawArea.addMouseMotionListener(this);
		drawPanel.add(drawArea);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		controlPanel.setPreferredSize(new Dimension(400,50));
		
		JLabel penLabel = new JLabel("pen size: ");
		this.penSize = new JTextField("5");
		
		this.penSize.setPreferredSize(new Dimension(50,20));
		
		
		// controlPanel holds pen textfield and label
		
		controlPanel.add(penLabel);
		controlPanel.add(this.penSize);
		
		this.add(drawPanel, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);
		
		
		this.setSize(300,300);    
		this.setResizable(true);
		this.pack();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);  
		
	} 
	
	
	public void mouseDragged(MouseEvent e) {  
		
		// if MOUSE_DRAGGED event continues
		
		System.out.println("Event e = " + e);		// shows drag events 
		
		// get graphics reference from Canvas (drawArea)
		Graphics g = drawArea.getGraphics();
		Graphics2D g2d = (Graphics2D) g;		// not used here
		
		
		// Paint an oval at the mouse position (if mouse is being dragged)
		g.setColor(Color.BLACK);  
		
		// Use TextField GUI to set oval size (circle)
		g.fillOval(e.getX(),e.getY(),Integer.parseInt(penSize.getText()),Integer.parseInt(penSize.getText()));
		
	}  
	
	public void mouseMoved(MouseEvent e) {
		
		// Does nothing at this point 
		
		System.out.println("Event e = " + e);		// shows move events
	}  

	public static void main(String[] args) {  
		new MouseCursorPaintCanvas("Mouse move-to-paint");  
		
	} 


}
