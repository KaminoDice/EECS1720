package week5;

public interface Function {
	
	/**
     * Evaluate the function at x.
     * 
     * @param x the value at which to evaluate the function
     * @return the value of the function evaluated at x
     */
    public double eval(double x);
    
    /**
     * Evaluate the function at each value of x in the given array.
     *  
     * @param x an array of values at which to evaluate the function
     * @return the array of values of the function evaluated at the given
     * values of x 
     */
    public Double[] eval(Double[] x);


}
