package week6;

import java.awt.*;
import javax.swing.*;

public class Example4 extends JFrame {

	// similar to AWT inheritance example (analogous to extending Frame)

	public Example4(String name) { 	// constructor creates GUI
		super(name);		// create parent sub-object
		this.setLayout(null); 		// set to not use any layout manager

		JButton button = new JButton("Press me!");
		button.setBounds(100, 50, 100, 50); 	// position/size button

		JLabel heading = new JLabel("Hello");
		heading.setBounds(100, 150, 100, 50); 	// position/size label 

		this.add(button); 			// adds JComponents to content pane
		this.add(heading); 

		// setup JFrame object for display
		this.setSize(480,400); 			    // frame size 480 width and 400 height  
		this.setResizable(true); 		    // allow/restrict window resizing
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close on 'x'
		this.setVisible(true); 			    // make frame visible
	}

	public static void main(String[] args) {
		
		// Create GUI layout 
		Example4 frame = new Example4("Hello Swing");
	}
	
	
}