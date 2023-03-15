package week8.actionevents1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class HelloEvent2 extends JFrame  {		

	
	public HelloEvent2(String name) {

		super(name); 			
		this.setLayout(new FlowLayout());

		// setup components 
		JLabel heading = new JLabel("HelloEvent:");
		JButton button = new JButton("Click Me");
		
		button.addActionListener(new HelloEvent2Listener());		// assign reference to class that implements actionPerformed method		

		// add to JFrame's content pane
		this.add(heading);
		this.add(button);
		
		this.setSize(480,400); 									
		this.setResizable(false); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 				


	}

	public static void main(String[] args) {

		HelloEvent2 app = new HelloEvent2("Hello Event");

	}


}
