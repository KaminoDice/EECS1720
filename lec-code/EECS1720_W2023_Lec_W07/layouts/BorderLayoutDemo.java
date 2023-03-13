package layouts;

import java.awt.*;
import javax.swing.*;



public class BorderLayoutDemo extends JFrame {		

	// constructor
	public BorderLayoutDemo(String name) {

		// constructor will create GUI layout

		super(name); 			
		this.setLayout(new BorderLayout()); 
		
		// setup components 
		JLabel heading = new JLabel("Hello Swing Fonts/Buttons/Icons!");
		heading.setFont(new Font("SansSerif", Font.BOLD, 18));
		heading.setForeground(Color.RED);

		JLabel iconLabel = new JLabel( new ImageIcon("images/3d_file.png"));
		JButton textButton = new JButton("Button 1");
		JButton iconButton = new JButton(new ImageIcon("images/3d_trash_can.png")) ;
		JButton iconTextButton = new JButton("Button 3", new ImageIcon("images/3d_trash_can.png") );
		
		// get content pane from top level container (i.e. from HelloSwing (which is-a JFrame) )
		Container pane = this.getContentPane();	
		
		// add components to pane
//		pane.add(jp, BorderLayout.PAGE_START);
//		pane.add(iconLabel, BorderLayout.LINE_START);
//		pane.add(textButton, BorderLayout.LINE_END);
//		pane.add(iconButton, BorderLayout.CENTER);
//		pane.add(iconTextButton, BorderLayout.PAGE_END);

		pane.add(heading, BorderLayout.NORTH);
		pane.add(iconLabel, BorderLayout.WEST);
		pane.add(textButton, BorderLayout.EAST);
		pane.add(iconButton, BorderLayout.CENTER);
		pane.add(iconTextButton, BorderLayout.SOUTH);

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
		BorderLayoutDemo frame = new BorderLayoutDemo("BorderLayout Demo");

	}

}
