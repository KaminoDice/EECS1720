package guiControls;

import java.awt.*;
import javax.swing.*;


public class LabelsButtonsIcons extends JFrame {		

	// constructor
	public LabelsButtonsIcons(String name) {

		// constructor will create GUI layout
		super(name);
		getContentPane().setLayout(null);	// no layout manager used (placing all elements manually)
		
		// setup each component 
		
		// Text based JLabel
		JLabel heading = new JLabel("Normal Label");
		heading.setForeground(Color.RED);
		heading.setBounds(50, 50, 150, 50);	
		
		
		// Icon based JLabel
		JLabel iconLabel = new JLabel("olah", new ImageIcon("images/3d_file.png"), JLabel.CENTER );
		iconLabel.setBounds(200, 50, 250, 50);
		
		// Text based Button 
		JButton textButton = new JButton("Button with text");
		textButton.setBounds(50, 150, 150, 50);
		
		// Icon based Button
		Icon myicon = new ImageIcon("images/3d_trash_can.png");
		
		JButton iconButton = new JButton(myicon) ;
		iconButton.setBounds(200, 150, myicon.getIconWidth(), myicon.getIconHeight());
		
		iconButton.setBounds(200, 110, iconButton.getIcon().getIconWidth(), iconButton.getIcon().getIconHeight());
		iconButton.setPreferredSize(null);
		
		// Icon based Button with text
		JButton iconTextButton = new JButton("Button with text+icon", new ImageIcon("images/advertising.png") );
		iconTextButton.setBounds(200, 250, 250, 50);
		iconTextButton.setBounds(200, 110+iconButton.getIcon().getIconHeight(), 250, iconTextButton.getIcon().getIconHeight());
		
	
		Container pane = this.getContentPane();		

		// add components to pane
		pane.add(heading);
		pane.add(iconLabel);
		pane.add(textButton);
		pane.add(iconButton);
		pane.add(iconTextButton);

		// set content pane back into this HelloSwing object
		this.setContentPane(pane);

		// setup JFrame object for display
		this.setSize(480,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 									
		
	}
	
	
	public static void main(String[] args) {

		
		
		// Create GUI layout 
		LabelsButtonsIcons frame = new LabelsButtonsIcons("Icons");

	}

}
