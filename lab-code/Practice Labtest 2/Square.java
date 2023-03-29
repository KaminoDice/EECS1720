import java.awt.Color;


//Complete your solution below for the Square class (Question 1)


public class Square extends Shape {
	
	
	private double length;
	
	
	public Square() {
		
		super(Alignment.LEFT);
		
		this.length = 10;
		
	}
	
	
	public Square(Alignment pos, double length, Color col) {
		
		super(pos);
		
		this.setColor(col);  // could also use super.setColor(col);
		
		this.length = length;
		
		
	}


	@Override
	public void resize(double scale) {
		// TODO Auto-generated method stub
		
		if (scale < 0) throw new RuntimeException();

		else {
			this.reset();
			this.setScale(scale);
			this.length = this.length * this.getScale();
		}
	}


	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.length = this.length / this.getScale();
		this.setScale(1.0);
		
	}


	@Override
	public String showMe() {
		// TODO Auto-generated method stub
		
		return ("I am Square:\n\tLength: " + this.length + "\n" + this.toString() );
		
		
	}
	
	
}


