package week8.actionevents1;

import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HelloEvent4 extends JFrame {		

	
	// constructor
	public HelloEvent4(String name) {

		// constructor will create GUI layout

		super(name); 			// create parent sub-object
		this.setLayout(new FlowLayout());

		// setup components 
		JLabel heading = new JLabel("HelloEvent:");
		JButton button1 = new JButton("B1: Click Me");
		JButton button2 = new JButton("B2: Click Me 2");
		
//		MyListener myListener = new MyListener("B* clicked");
//		button1.addActionListener(myListener);	
//		button2.addActionListener(myListener);
	
		button1.addActionListener(new MyListener());	
		button2.addActionListener(new MyListener("B2 clicked"));
		
		this.add(heading);
		this.add(button1);
		this.add(button2);

		this.setSize(480,400); 							
		this.setResizable(false); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 								


	}
		
		
	
	public static void main(String[] args) {

		// Create GUI layout 
		HelloEvent4 frame = new HelloEvent4("Hello Swing");

	}


	

}
