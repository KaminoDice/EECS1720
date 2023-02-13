package week5;

public class Square implements Function {

	
	public Square() { }
	
	@Override
	public double eval(double x) {

		return x * x;

	}

	@Override
	public Double[] eval(Double[] x) {
		
		Double[] result = new Double[x.length];
        for (int i=0; i<x.length;  i++) {
            result[i] = this.eval(x[i]);
        }
        return result;

	}
	
	
	

}
