package layouts;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutDemo extends JFrame {

	public GridBagLayoutDemo(String name) {

		super(name);
		this.setLayout(new GridBagLayout());

		Container pane = this.getContentPane();

		// can reuse this to set constraints for each component we want to add
		GridBagConstraints c = new GridBagConstraints();

		JButton button = new JButton("Button 1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(button, c);

		button = new JButton("Button 2"); 
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.weightx = 0.5; 
		c.gridx = 1; 
		c.gridy = 0; 
		pane.add(button, c);

		button = new JButton("Button 3"); 
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.weightx = 0.5; 
		c.gridx = 2; 
		c.gridy = 0; 
		pane.add(button, c);

		button = new JButton("Long-Named Button 4"); 
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.ipady = 40; //make this component tall 
		c.weightx = 0.0; 
		c.gridwidth = 3; 
		c.gridx = 0; 
		c.gridy = 1; 
		pane.add(button, c);

		button = new JButton("5"); 
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.ipady = 0; // reset to default
		c.weighty = 1.0; 
		
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(10,0,0,0);
		c.gridx = 1; 
		c.gridy = 2; 
		c.gridwidth = 2; 
		pane.add(button, c);

		
		this.setContentPane(pane);
		
		// setup JFrame object for display
		this.setSize(480,400); 									// frame size 480 width and 400 height  
		this.setResizable(true); 								// allow/restrict window resizing
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// close on pressing 'x' button
		this.setVisible(true);

	}


	public static void main(String[] args) {

		GridBagLayoutDemo demo = new GridBagLayoutDemo("GridBagLayout Demo");
		

	}

}
