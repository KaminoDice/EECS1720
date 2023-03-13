package layouts;

import java.awt.*;
import javax.swing.*;




public class BoxLayoutDemo extends JFrame {		

	// constructor
	public BoxLayoutDemo(String name) {
		
		super(name); 						
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));	

		// setup components 
		JLabel heading = new JLabel("Hello Swing Fonts/Buttons/Icons!");
		heading.setFont(new Font("SansSerif", Font.BOLD, 18));
		heading.setForeground(Color.RED);

		JLabel iconLabel = new JLabel( new ImageIcon("images/3d_file.png") );
		JButton textButton = new JButton("Button 1");	
		JButton iconButton = new JButton(new ImageIcon("images/3d_trash_can.png")) ;
		JButton iconTextButton = new JButton("Button 3", new ImageIcon("images/3d_trash_can.png") );

		Container pane = this.getContentPane();		
		pane.add(heading);
		pane.add(iconLabel);
		pane.add(textButton);
		pane.add(iconButton);
		pane.add(iconTextButton);
		this.setContentPane(pane);

		// setup JFrame object for display
		this.setSize(480,400); 								
		this.setResizable(true); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 									

	}


	public static void main(String[] args) {

		// Create GUI layout 
		BoxLayoutDemo frame = new BoxLayoutDemo("BoxLayout Demo");

	}

}
