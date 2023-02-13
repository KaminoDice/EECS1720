package week5;

import java.awt.geom.Point2D;

public class AggregationExample {

	
	private Point2D.Double startPoint;
	private Point2D.Double endPoint;
	
	
	public AggregationExample(Point2D.Double startPoint, Point2D.Double endPoint) {
		
		this.startPoint = startPoint;   // using alias
		this.endPoint = endPoint;		// using alias
		
	}
	
	
	public Point2D.Double getStartPoint() {
		
		return this.startPoint;     // returning an alias
	}
	
	public void setStartPoint(Point2D.Double startPoint) {
		
		this.startPoint = startPoint;   // using an alias
		
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
		
		AggregationExample obj1 = new AggregationExample(s,e);
		
		System.out.print(obj1.toString());
		
		Point2D.Double s2 = obj1.getStartPoint();
		s2.setLocation(-1, -1);
		
		System.out.print(obj1.toString());
		

	}

}
