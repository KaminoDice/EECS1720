package week8.actionevents1;

import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




// similar to AWT inheritance example (extended Frame)

public class HelloEvent5 extends JFrame implements ActionListener {		

	JLabel heading;
	JButton button;
	
	
	// constructor
	public HelloEvent5(String name) {

		// constructor will create GUI layout

		super(name); 			// create parent sub-object
		this.setLayout(new FlowLayout());

		// setup components 
		heading = new JLabel("HelloEvent:");
		
		button = new JButton("Click Me", new ImageIcon("src/images/3d_file.png"));
		button.setActionCommand("Action click!");
		button.addActionListener(this);				

		// add components to this container (which is-a JFrame -> will add to content pane)
		this.add(heading);
		this.add(button);
		

		// setup JFrame object for display
		this.setSize(480,400); 									// frame size 480 width and 400 height  
		this.setResizable(false); 								// allow/restrict window resizing
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// close on pressing 'x' button
		this.setVisible(true); 									// now frame will be visible, by default not visible  


	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// this method is overridden (well, implemented in fact), to generate a response to the button click

		
		if (e.getSource()==this.button) {
			System.out.println(this.button.getText());
			System.out.println(e.getActionCommand());
			
		}
		else {		
			System.out.println("something other event");
			
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {

		// Create GUI layout 
		HelloEvent5 frame = new HelloEvent5("Hello Swing");

	}


	

}
