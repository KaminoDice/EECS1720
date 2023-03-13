package week06_processing;

import java.awt.Color;


public class FrogWorld {

	public PSketch app;		// FrogWorld "has-a" PSketch (used to access processing)
	
	public String title;
	
	public Color frogCol ;
	public Color waterCol ;

	
	public FrogWorld(PSketch app) {
		
		this.app = app;		// save PSketch (is-a PApplet ref)
						
		this.title = "Frogger 1 : ";
		this.frogCol = Color.GREEN;
		this.waterCol = new Color(0, 100, 200);

	}

	
	public void render() {
		
		
		this.app.windowTitle("myApp -> mouse = (" + app.mouseX + ", " + app.mouseY + ")");
	
		app.fill(waterCol.getRGB());		
		app.rect(0, 100, 640, 300);
		
		app.fill(frogCol.getRGB());
		app.ellipse(320, 400, 30, 40);

	}


}
