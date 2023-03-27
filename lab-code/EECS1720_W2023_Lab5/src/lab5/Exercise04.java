package lab5;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Exercise04 extends JFrame {
	
	private int clickCount;
	
	private JLabel clickedLabel;
	private JButton countUpButton; 
	// BUILD THIS FROM SCRATCH (more info in week 8 lectures for events/event handling and action events)
	
	public Exercise04(String title) {
		
		super(title);
		
		
		this.clickCount = 0;
		this.clickedLabel = new JLabel("Button Clicked " + this.clickCount + " Times");
		this.countUpButton.addActionListener(this);
		
		Container pane = this.getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(this.clickedLabel);
		pane.add(this.countUpButton);
		this.setContentPane(pane);
		
		setSize(300,100);									 
		setResizable(true);									
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		

		Exercise04 app = new Exercise04("Click Count");

	}
	@Override
	public String toString() {
		return "Counting Up!  [count = " + this.clickCount + "]";
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		
		if (e.getSource() == this.countUpButton) {
			
			this.clickCount++;
			
			System.out.println(this.toString());
			
			this.clickedLabel.setText("Button Clicked " + this.clickCount + " Times");
		}
		
	}
}
