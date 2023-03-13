package layouts;

import java.awt.*;
import javax.swing.*;



public class GridLayoutDemo extends JFrame {		

	// constructor
	public GridLayoutDemo(String name) {

		// constructor will create GUI layout
		super(name); 					
		this.setLayout(new GridLayout(2,2));	

		// setup components 
		JLabel heading = new JLabel("Hello Swing Fonts/Buttons/Icons!");
		heading.setFont(new Font("SansSerif", Font.BOLD, 18));
		heading.setForeground(Color.RED);

		JLabel iconLabel = new JLabel( new ImageIcon("images/3d_file.png"));
		JButton textButton = new JButton("Button 1");
		JButton iconButton = new JButton(new ImageIcon("images/3d_trash_can.png")) ;
		//JButton iconTextButton = new JButton("Button 3", new ImageIcon("images/advertising.png") );

		Container pane = this.getContentPane();		
		// add components to pane
		pane.add(heading);
		pane.add(iconLabel);
		pane.add(textButton);
		pane.add(iconButton);
		//pane.add(iconTextButton);

		// set content pane back into this HelloSwing object
		this.setContentPane(pane);

		// setup JFrame object for display
		this.setSize(480,400); 									
		this.setResizable(true); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 									

	}
	
	
	public static void main(String[] args) {

		// Create GUI layout 
		GridLayoutDemo frame = new GridLayoutDemo("GridLayout Demo");

	}

}
