package week8.actionevents1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class HelloEvent3 extends JFrame  {		

	private JLabel heading;
	private JButton button;
	
	public HelloEvent3(String name) {

		super(name); 			
		this.setLayout(new FlowLayout());

		// setup components 
		heading = new JLabel("HelloEvent:");
		button = new JButton("Click Me");

		button.addActionListener(new HelloEvent2Listener());		// assign reference to class that implements actionPerformed method		
		button.addActionListener(new HelloEvent3Listener());
		
		// add to JFrame's content pane
		this.add(heading);
		this.add(button);

		
		this.setSize(480,400); 									
		this.setResizable(false); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 				


	}

	public static void main(String[] args) {

		HelloEvent3 app = new HelloEvent3("Hello Event");

	}
	
	class HelloEvent3Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("HelloEvent3: Clicked on button");

			
		}
	
	}


}
