package week8.actionevents1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {
	
	private String actionString;
	
	
	public MyListener() {
		this.actionString = "";
	}
	
	
	public MyListener(String actionString) {
		
		
		this.actionString = actionString;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// this method is overridden (implemented) to generate a response to the button click
		
		System.out.println();
		System.out.println(e.getActionCommand());	// gets ActionCommand associated with e
		System.out.println(e.getSource());			// gets instance associated with e
		System.out.println();
		
		System.out.println(this.actionString);
		
	}

}
