import java.awt.Color;


//Complete your solution below for the Rectangle class (Question 1)


public class Rectangle extends Shape {
	
	
	private double width;
	private double height;
	
	
	public Rectangle() {
		
		super(Alignment.RIGHT);
		
		this.setColor(Color.RED);
		
		this.width = 10;
		this.height = 20;
		
	}
	
	
	public Rectangle(Alignment pos, double width, double height, Color col) {
		
		super(pos);
		
		this.setColor(col);  // could also use super.setColor(col);
		
		this.width = width;
		this.height = height;
		
		
	}


	@Override
	public void resize(double scale) {
		// TODO Auto-generated method stub
		if (scale < 0) throw new RuntimeException();

		else {
			this.reset();
			this.setScale(scale);
			this.width = this.width * this.getScale();
			this.height = this.height * this.getScale();
		}
	}


	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.width = this.width / this.getScale();
		this.height = this.height / this.getScale();
		this.setScale(1.0);
	}


	@Override
	public String showMe() {
		// TODO Auto-generated method stub
		

		return ("I am an Rectangle:\n\tWidth: " + this.width + "\n\tHeight: " + this.height + "\n" + this.toString() );
		
	}
	
	
}
	
	
