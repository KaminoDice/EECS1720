package week06_processing;

import processing.core.*;

public class PSketch extends PApplet {
	
	public FrogWorld frogger;
	
	public void settings() {
		
		// this is where the code inside "setup()" within a processing sketch gets put
		this.size(640,480);
		
		this.frogger = new FrogWorld(this);
		
	}
	
	public void draw() {
		
		// this is where the code inside "draw()" within a processing sketch gets put
		//this.windowTitle("myApp -> mouse = (" + mouseX + ", " + mouseY + ")");
		frogger.render();
		
	}
	
	public static void main(String[] args) {
		
		PSketch myApp = new PSketch();	
		myApp.runSketch();

	}

}
