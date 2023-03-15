package week8.actionevents2;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Frame;

public class MyCanvas extends Canvas {

	// default ctor is implicit

	@Override
	public void paint(Graphics g) {
		g.fillOval(100, 100, 200, 200);
		
		
		
	}

	public static void main(String[] args) {

		Frame frame = new Frame("My Drawing");

		Canvas canvas = new MyCanvas();
		canvas.setSize(400, 400);
		
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
}

