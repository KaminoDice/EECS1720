package week6;

import java.awt.*; 

/* We have extended the Frame class here,  thus our class "SimpleExample"      
 * would behave like a Frame  */ 

public class Example2b extends Frame {

	public Example2b() { 

		this.setSize(500,500); // Set Frame width and height         
		this.setTitle("Some example GUI controls"); // Set title of Frame
		this.setLayout(null); // Set the layout for the Frame 

		// example GUI controls (positioned and added to Frame)
		Button b = new Button("Button!!");
		b.setBounds(50,50,100,50); 		// setting button position on screen 
		this.add(b); 			// adding button into frame 

		TextField t = new TextField("Please type here..");
		t.setBounds(50,110,200,30);
		this.add(t);

		Label l = new Label("Label!!", Label.CENTER);
		l.setBounds(50,150,80,50);
		l.setBackground(Color.magenta);
		l.setForeground(Color.yellow);
		this.add(l);

		List items = new List(2,false);
		items.add("banana");
		items.add("laser");
		items.add("bfg");
		items.add("peanut");
		items.setBounds(50,250,100,50);
		this.add(items);

		Choice c = new Choice();
		c.add("red");
		c.add("green");
		c.add("blue");
		c.setBounds(50, 320, 100, 50);
		this.add(c);	
		
		this.setVisible(true);


	}
	
	public static void main(String args[]) {
		
		// again, to close this window, stop the java application hitting stop button in console
		Example2b fr = new Example2b(); 

	}
}
