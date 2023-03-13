package guiControls;

import java.awt.*;
import javax.swing.*;



public class LabelsButtons extends JFrame {		

	// constructor
	public LabelsButtons(String name) {

		// constructor will create GUI layout
		
		super(name); 	// create parent sub-object (JFrame with String arg - sets window title to String)
		

		// setup each component 
		
		// Text based JLabel
		JLabel textLabel = new JLabel("Text Label");
		textLabel.setBounds(50, 100, 200, 50);	
		
		// Text based JButtons 
		JButton textButton = new JButton("Text Button 1");
		textButton.setBounds(260, 100, 200, 50);
		
		JButton textButton2 = new JButton("Text Button 2");
		textButton2.setForeground(Color.BLUE);
		textButton2.setToolTipText("press me!");
		
		
		
		// get content pane from top level container (this is-a JFrame)
		Container pane = this.getContentPane();		

		// add components to pane
		pane.add(textLabel);
		pane.add(textButton);
		pane.add(textButton2);

		// set content pane back into this HelloSwing object
		this.setContentPane(pane);

		// setup JFrame object for display
		this.setSize(480,400); 									// frame size 480 width and 400 height  
		this.setResizable(true); 								// allow/restrict window resizing
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// close on pressing 'x' button
		this.setVisible(true); 									// now frame will be visible, by default not visible  


	}
	
	
	public static void main(String[] args) {

		
		// Create GUI layout 
		LabelsButtons frame = new LabelsButtons("Labels & Buttons");

	}

}
