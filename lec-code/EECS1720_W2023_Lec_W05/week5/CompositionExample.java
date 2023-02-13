package week5;

import java.awt.geom.Point2D;

public class CompositionExample {

	
	private Point2D.Double startPoint;
	private Point2D.Double endPoint;
	
	
	public CompositionExample(Point2D.Double startPoint, Point2D.Double endPoint) {
		
		// create a new copy of each object referred to by each argument, 
		// then assign these new objects to their relevant class fields
		
		// this way, only the current object being initialized will have references to these 
		// new objects (i.e. the copies are not shared with anyone)
		
		
		this.startPoint = new Point2D.Double(startPoint.getX(), startPoint.y);    // copy of startPoint
		this.endPoint = new Point2D.Double(endPoint.x, endPoint.y);          // copy of endPoint
		
	}
	
	
	public Point2D.Double getStartPoint() {
		
		// return a reference to a copy of the field (not direct reference to the same object)
		// this way, a client never gets a reference to the same object the field refers to
		
		return ( new Point2D.Double(this.startPoint.x, this.startPoint.y) );
	}
	
	public void setStartPoint(Point2D.Double startPoint) {
		
		// create a new copy of the object referred to by the argument
		// this way, this class field refers to a different object than the one passed from the client 
		this.startPoint = new Point2D.Double(startPoint.x, startPoint.y);
		
	}
	
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		result.append("start: " + this.startPoint.toString() + "\n");
		result.append("final: " + this.endPoint.toString() + "\n\n");
		
		return result.toString();
		
	}
	
	
	
	public static void main(String[] args) {
		
		Point2D.Double s = new Point2D.Double(5,4);
		Point2D.Double e = new Point2D.Double(10,-5);
		
		CompositionExample obj1 = new CompositionExample(s,e);
		
		System.out.print(obj1.toString());
		
		Point2D.Double s2 = obj1.getStartPoint();
		s2.setLocation(-1, -1);
		
		System.out.print(obj1.toString());
		

	}

}
