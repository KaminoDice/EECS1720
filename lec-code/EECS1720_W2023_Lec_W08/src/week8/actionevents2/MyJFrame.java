package week8.actionevents2;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import java.awt.Frame;

public class MyJFrame extends JFrame {

	// default ctor is implicit
	public MyJFrame(String title) {
		
		super(title);
		
		Canvas myCanvas = new MyCanvas();
		myCanvas.setSize(400, 400);

		this.add(myCanvas);
		this.pack();
		this.setVisible(true);
		this.setResizable(true);
		
		
		
	}


	public static void main(String[] args) {

		
		JFrame frame = new MyJFrame("MyJFrame");
		
		
	}
}

