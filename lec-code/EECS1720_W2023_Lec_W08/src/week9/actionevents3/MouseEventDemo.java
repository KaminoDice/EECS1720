package week9.actionevents3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

public class MouseEventDemo extends JFrame implements MouseListener {

	private JLabel 		mouseArea;
	private JTextArea 	messageArea;
	private JTextField tf;
	
	
	public MouseEventDemo(String title) {

		super(title);
		Container pane = this.getContentPane();

		// create a mouse interaction component (using a JLabel here)
		this.mouseArea = new JLabel("Try Mouse Events in this Area", JLabel.CENTER);
		
		this.mouseArea.setPreferredSize(new Dimension(640,200));
		this.mouseArea.setBackground(Color.PINK);
		this.mouseArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
																							
		// create a message component (scrollable JTextArea) to show mouse events
		this.messageArea = new JTextArea();
		this.messageArea.setEditable(false);
		
		
        JScrollPane scrollPane = new JScrollPane(this.messageArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(640, 200));
        
        // register this class as the mouseListener for mouseArea
		this.mouseArea.addMouseListener(this);			// note addActionListener(..) not defined for JLabel
		
        
        
        
		pane.add(this.mouseArea, BorderLayout.NORTH);
		pane.add(scrollPane, BorderLayout.CENTER);
		

		// setup and show frame
		this.setSize(640, 480);
		this.setResizable(true); 
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}



	public static void main(String[] args) {
		
		MouseEventDemo frame = new MouseEventDemo("MouseEvent Demo");

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		this.messageArea.append("Mouse clicked (# clicks = " + e.getClickCount() + "); " 
				+ " detected on " + e.getComponent().getClass().getName() + ".\n");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		this.messageArea.append("Mouse pressed (# clicks = " + e.getClickCount() + "); " 
				+ " detected on " + e.getComponent().getClass().getName() + ".\n");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		this.messageArea.append("Mouse released (# clicks = " + e.getClickCount() + "); " 
				+ " detected on " + e.getComponent().getClass().getName() + ".\n");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		this.messageArea.append("Mouse entered " 
				+ " detected on " + e.getComponent().getClass().getName() + ".\n");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		this.messageArea.append("Mouse exited " 
				+ " detected on " + e.getComponent().getClass().getName() + ".\n");


	}

}
