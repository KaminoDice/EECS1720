package week6;

import java.awt.*; 

public class Example1 {

	public Example1() {
		//Creating Frame           
		Frame fr=new Frame();

		//Creating a label       
		Label lb = new Label("UserId: ");	

		//add some objects to frame
		fr.add(lb);

		//Creating and adding Text Field       
		TextField t = new TextField();
		fr.add(t);
		
		//setting frame size       
		fr.setSize(500, 300); 
		
		//Setting the layout for the Frame       
		fr.setLayout(new FlowLayout());
		fr.setVisible(true); 
		
	} 
	
	public static void main(String args[]) {
		
		// note, the window "x" button wont close 
		// (we havent instructed it to - have to close hitting "stop" 
		// button in console window in eclipse
		
		Example1 ex = new Example1();
		
	}
}
