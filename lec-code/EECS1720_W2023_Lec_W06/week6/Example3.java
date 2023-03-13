package week6;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Frame;

public class Example3 extends Canvas {

	// default ctor is implicit

	@Override
	public void paint(Graphics g) {
		g.fillOval(100, 100, 200, 200);
	}

	public static void main(String[] args) {

		Frame frame = new Frame("My Drawing");

		Canvas canvas = new Example3();
		canvas.setSize(400, 400);

		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
}

