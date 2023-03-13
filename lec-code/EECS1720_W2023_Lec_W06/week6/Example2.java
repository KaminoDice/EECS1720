package week6;

import java.awt.*; 

/* We have extended the Frame class here,  thus our class "SimpleExample"      
 * would behave like a Frame  */ 

public class Example2 extends Frame {

	public Example2() { 

		Button b = new Button("Button!!");
		b.setBounds(50,50,50,50);	// setting button position on screen 

		this.add(b); 				// adding button into frame    
		this.setSize(500,300); 		// Set Frame width and height         
		this.setTitle("This is my First AWT example");  // Set title of Frame       
		this.setLayout(new FlowLayout());  // Set the layout for the Frame 

		/* By default frame is not visible so we are setting the visibility to true*/  
		this.setVisible(true);

	}
	
	public static void main(String args[]) {
		
		// again, to close this window, stop the java application hitting stop button in console
		Example2 fr = new Example2(); 

	}
}
