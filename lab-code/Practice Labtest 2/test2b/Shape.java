import java.awt.Color;

public abstract class Shape implements Resizeable {
	
	// YOU ARE NOT PERMITTED TO MODIFY THIS CLASS IN ANY WAY!!
	
	private Alignment pos;
	private double scale;
	private Color col;
	
	
	public Shape(Alignment pos) {
		this.scale = 1.0;
		this.pos = pos;
		this.col = Color.GRAY;		
	}
	

	public double getScale() {
		return this.scale;
		
	}
	
	public void setScale(double scale) {
		this.scale = scale;
	}
	

	
	public void setPosition(Alignment pos) {
		this.pos = pos;
	}
	

	
	public void setColor(Color col) {
		this.col = col;
	}
	
	public String toString() {
		String result = "";
		
		result += "\tPosition: " + this.pos;
		result += "\n\tScale: " + this.scale;
		result += "\n\tColor: " + this.col;
		
		return result;
		
	}
	
	public abstract String showMe();
	
}
