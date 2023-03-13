package firsttest;

import processing.core.PApplet;

public class FirstExample extends PApplet {

	public void settings() {
		// USE THIS INSTEAD OF SETUP()
		size(800,600); 
	}

	public void draw() {
		background(0);
		stroke(255,0,0);
		fill(255);
		ellipse(mouseX,mouseY,30,30);
	}

	public static void main(String[] args) {
		FirstExample myApp = new FirstExample();
		myApp.runSketch();
	}
}

