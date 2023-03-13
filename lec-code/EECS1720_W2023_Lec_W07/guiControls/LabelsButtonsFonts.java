package guiControls;

import java.awt.*;
import javax.swing.*;



public class LabelsButtonsFonts extends JFrame {		

	// constructor
	public LabelsButtonsFonts(String name) {

		// constructor will create GUI layout
		super(name); 			// create parent sub-object
		this.setLayout(null);	// no layout manager used (placing all elements manually)
		
		// setup each component 
		
		// Text based JLabel
		JLabel textLabel = new JLabel("Label with Font");
		textLabel.setFont(new Font("SansSerif", Font.BOLD|Font.ITALIC, 18));
		textLabel.setForeground(Color.GREEN);
		textLabel.setBounds(50, 100, 200, 50);	
		textLabel.setToolTipText("I am a Label!");
		
		// Text based JButton 
		JButton textButton = new JButton("Text Button 1");
		textButton.setBounds(260, 100, 200, 50);
		
		JButton textButton2 = new JButton("Text Button 2");
		textButton2.setForeground(Color.BLUE);
		textButton2.setFont(new Font("Monospaced", Font.PLAIN, 22));
		textButton2.setToolTipText("press me!");
		textButton2.setBounds(260, 160, 200, 50);
		

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

		// Available fonts?
		String[] availFonts = Toolkit.getDefaultToolkit().getFontList();
		
		for (int i=0; i<availFonts.length; i++) 
			System.out.println(availFonts[i]);
		
		// Create GUI layout 
		LabelsButtonsFonts frame = new LabelsButtonsFonts("Labels & Buttons");

	}

}
