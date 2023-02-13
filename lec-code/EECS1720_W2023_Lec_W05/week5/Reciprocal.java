package week5;

public class Reciprocal implements Function {


	public Reciprocal() {}


	// override
	public double eval(double x) {
		return 1.0 / x;
	}


	// override
	public Double[] eval(Double[] x) {
		Double[] result = new Double[x.length];
		for (int i=0; i<x.length;  i++) {
			result[i] = this.eval(x[i]);
		}
		return result;
	}

}

