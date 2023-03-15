package week8.actionevents1;

import java.awt.*;
import javax.swing.*;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class HelloEvent extends JFrame implements ActionListener {		
	
	
	public HelloEvent(String name) {

		super(name); 			
		this.setLayout(new FlowLayout());

		// setup components 
		JLabel heading = new JLabel("HelloEvent:");
		JButton button1 = new JButton("Click Me");
		button1.setActionCommand("B1");
		
		button1.addActionListener(this);		// assign reference to class that implements actionPerformed method		

		// add to JFrame's content pane
		this.add(heading);
		this.add(button1);
		
		this.setSize(480,400); 									
		this.setResizable(false); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 				


	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// this method is overridden (implemented) to generate a response to the button click
		
		System.out.println();
		System.out.println(e.getActionCommand());		// gets ActionCommand associated with e
		System.out.println(e.getSource());				// gets instance associated with e
		System.out.println(e.getSource().getClass()); 	// gets type of instance associated with e
		System.out.println();
		
		System.out.println("Clicked on button 1");
		
		System.out.println("Components:");
		
		Component[] comps = this.getContentPane().getComponents();
		for (Component c : comps) {
			System.out.println(c);
		}

		
	}
	
	
	public static void main(String[] args) {

		HelloEvent app = new HelloEvent("Hello Event");
		
		
		
	

	}


	

}
