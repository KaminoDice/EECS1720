package week5;


import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import imagePackage.RasterImage;

public class FloatyThingClient {
	
	public static void main(String[] args) {
		
		// THIS MAIN ACTS AS A CLIENT FOR CLASSES (FloatyThing, Crocodile and Log)
		
		RasterImage img = new RasterImage(400,400);
		Graphics2D g = img.getGraphics2D();
		
		// create some FloatyThing's
		FloatyThing thing  = new FloatyThing(new Point2D.Double(150,100), 100.0, 40.0);
		Log log = new Log(new Point2D.Double(150,150), 100.0, 40.0);
		Crocodile croc = new Crocodile(new Point2D.Double(150,200), 100.0, 40.0);

		
		// draw them
		thing.draw(g);
		log.draw(g);
		//croc.toggleVisible();
		croc.draw(g);
		
		
		
		//////////////////////////
		// IMPLICATIONS & CASTING
		
		// the Object class is the Parent/Superclass of all classes!
		// we can assign instances of any subclass to the type Object
		// this is similar to promotion (happens automatically)
		
		Object o = croc;		// croc "is-a" Crocodile object
		
		// if we have an object that is of a particular subclass, it 
		// may be "cast" up or down to any class in its ancestry
		// i.e. to any of its parents, in the chain from Object to the 
		// subclass itself
		FloatyThing f = (FloatyThing) o;    // also, it "is-a" FloatyThing
		Crocodile c = (Crocodile) o;		// and a Crocodile 
		
		f.draw(g);
		
		// display img
		img.show();
		

	}

}
