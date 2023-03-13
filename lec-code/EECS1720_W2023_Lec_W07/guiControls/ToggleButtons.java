package guiControls;

import java.awt.*;
import javax.swing.*;


public class ToggleButtons extends JFrame {

	// constructor
	public ToggleButtons(String name) {

		// constructor will create GUI layout
		super(name); 			// create parent sub-object
		this.setLayout(null);	// set to FlowLayout

		// CHECKBOXES
		JCheckBox chinButton 		= new JCheckBox("Chin"); 
		JCheckBox glassesButton 	= new JCheckBox("Glasses");
		JCheckBox hairButton 		= new JCheckBox("Hair"); 
		JCheckBox teethButton 		= new JCheckBox("Teeth");
				
		chinButton.setBounds(50,50,100,50);
		glassesButton.setBounds(50,100,100,50);
		hairButton.setBounds(50,150,100,50);
		teethButton.setBounds(50,200,100,50);
		
		chinButton.setSelected(false); 
		glassesButton.setSelected(true); 
		hairButton.setSelected(false); 
		teethButton.setSelected(true);


		// RADIOBUTTONS
		JRadioButton birdButton 	= new JRadioButton("cheep");
		JRadioButton catButton 		= new JRadioButton("meow");
		JRadioButton dogButton 		= new JRadioButton("woof");
		JRadioButton rabbitButton 	= new JRadioButton("whats up doc?");
		JRadioButton pigButton 		= new JRadioButton("snort");
		
		birdButton.setSelected(true);
		
		birdButton.setBounds(300, 50, 200, 50);
		catButton.setBounds(300, 100, 200, 50);
		dogButton.setBounds(300, 150, 200, 50);
		rabbitButton.setBounds(300, 200, 200, 50);
		pigButton.setBounds(300, 250, 200, 50);
		
		//Group the radio buttons (used to figure out which is clicked)
		ButtonGroup group = new ButtonGroup();
		group.add(birdButton);
		group.add(catButton);
		group.add(dogButton);
		group.add(rabbitButton);
		group.add(pigButton);

		// get content pane from top level container
		Container pane = this.getContentPane();

		// ADD CHECKBOXES
		pane.add(chinButton);
		pane.add(glassesButton);
		pane.add(hairButton);
		pane.add(teethButton);

		
		// ADD RADIOBUTTONS
		pane.add(birdButton);
		pane.add(catButton);
		pane.add(dogButton);
		pane.add(rabbitButton);
		pane.add(pigButton);

		// set content pane back into this object
		this.setContentPane(pane);

		// setup JFrame object for display
		this.setSize(480,400); 								
		this.setResizable(true); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 									

	}


	public static void main(String[] args) {

		// Create GUI layout 
		ToggleButtons frame = new ToggleButtons("Toggle Buttons");

	}

}
