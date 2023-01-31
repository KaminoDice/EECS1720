package lab1;

// PRELIMINARY NOTES:  

// in-line comments look like this, and they do not extend over multiple lines (you need a new // per line)

/*
 * multi-line comments look like this
 * and extend over multiple lines (start one and as you type, and hit enter, the comment will 
 * automatically generate over multiple lines
 */

/*
 * blue mult-line comments look can be seen throughout and are started with a /**  
 * these will act link the green multi-line comments, however these comments are special
 * and are generally used by java to automatically generate API documentation (they have embedded tags
 * within that are used to indicate parameters for methods, return types and other details..  you will
 * learn more about how to use these in later courses.. for now they serve as a description of what
 * each method should do
 */

// In this lab, we are still getting familiar with the Eclipse IDE.  Note the "Outline" tab on the right 
// margin.  This shows a dropdown tree of all the method headers that exist in this class.  By double 
// clicking on any one of these methods, you will jump to that part of the code (it also serves as a 
// useful summary of the input parameters, and return types for each feature (field/method/constructor) 
// present in the class as the code is being fleshed out.



/**
 * Utility class with short methods reviewing fundamental Java concepts: 
 * working with primitive data types, methods, conditional logic and 
 * 
 * @author EECS1720 Winter 2023
 *
 */
public class NumUtils {

	
	/**
	 * The number of cents equal to a Canadian quarter coin.
	 */
	public static final int QUARTER_VALUE = 25;

	/**
	 * The number of degrees in a circle.
	 */
	public static final int DEGREES_IN_CIRCLE = 360;
	
	
	
	private NumUtils() {
		// empty by design (this essentially enforces the inability to create objects)
		// making this a utility class (will look at this in more detail later), for
		// now, you can ignore this method
	}

	/**
	 * Returns the maximum (most positive) value that an <code>int</code> can
	 * represent.
	 * 
	 * @return the maximum (most positive) value that an int can represent
	 */
	public static int maxInt() {
		
		// HINT: review the Wrapper class (Integer) in the java api (java.lang.Integer)
		// 
		// 		-> select the file "TestLab1.java" and run it to show the result of tests
		//		   run on all the methods in this file, then fix the files (complete them)
		//		   so that the tests pass (i.e. show green in the JUnit tab on the left margin)
		//
		//		-> note: you don't have to understand the code in the TestLab1.java file, 
		//		   however these tests generally will give you some feedback/hints as to what
		//		   is expected behaviour by a method versus actual behaviour (example: this method
		//		   initially returns 0, however it should return the maximum value an Integer can be
		//		   .. see the class definition of Integer class to figure out if there is a feature 
		//		   of that class that can be used/accessed (remember, if static, it must be accessed
		//		   through the class name - don't use a magic number here, look for an existing constant
		//		   in the Integer class)
		//
		
		return Integer.MAX_VALUE;
	}

	/**
	 * Returns the minimum positive value greater than zero that a
	 * <code>double</code> can represent.
	 * 
	 * @return the minimum positive value greater than zero that a double can
	 *         represent
	 */
	public static double minDouble() {
		
		
		
		return Double.MIN_VALUE;
	}
	/**
	 * Returns the largest number of Canadian quarters (each worth 25 cents) whose
	 * total value does not exceed the given number of cents.
	 * 
	 * @param cents
	 *            a positive number of cents
	 *            
	 * @return the largest number of Canadian quarters (each worth 25 cents) whose
	 *         total value does not exceed the given number of cents
	 */
	public static int numQuarters(int cents) {
		
		
		return cents/25;
	}

	/**
	 * Wraps an angle given in degrees so that it lies in the range of -359 degrees
	 * to 359 degrees. For example:
	 * 
	 * <pre>
	 * degrees      wrapAngle(degrees) returns
	 *  0            0
	 *  1            1
	 * -1           -1
	 *  359          359
	 * -359         -359
	 *  360          0    (wraps around to 0 degree)
	 * -360          0    (wraps around to 0 degree)
	 *  361          1    (wraps around to 1 degree)
	 * -361         -1    (wraps around to -1 degree)
	 *  725          5    (wraps around to 5 degrees)
	 * -730         -10   (wraps around to -10 degrees)
	 *  3652         52   (wraps around to 52 degrees)
	 * </pre>
	 * 
	 * @param degrees
	 *            an angle in degrees
	 *            
	 * @return the angle wrapped to the interval -359 to 359 degrees
	 */
	public static int wrapAngle(int degrees) {
		
		
		return degrees%360;
	}
	
	
	

	/**
	 * Compute the average of two values as a <code>double</code> value.
	 * 
	 * @param a
	 *            a value
	 * @param b
	 *            a second value
	 *            
	 * @return the average of the two values
	 */
	public static double avg(int a, int b) {
		double sum = (double)a + (double)b;
		
		return sum/2.0;
	}

	/**
	 * Returns the wind chill for air temperatures equal to or below 0 degrees
	 * Celcius and wind velocities equal to or greater than 5 km/h.
	 * 
	 * <p>
	 * Wind chill is an index that indicates how cold the weather feels to the
	 * average person when there is some wind. For example, if the air
	 * temperature is -5 degrees Celcius and the wind chill is -15 then it means
	 * that it feels similar to a windless day where the temperature is -15
	 * degrees Celcius.
	 * 
	 * @param airTemp
	 *            the temperature in degrees Celcius (must be 0 degrees or less)
	 * @param windSpeed
	 *            the wind speed in km/h (must be 5 km/h or greater)
	 * @return the wind chill index
	 * 
	 * @see <a href="http://climate.weather.gc.ca/glossary_e.html#w">
	 *      Environment and Climate Change Canada wind chill definition</a>
	 */
	public static double windChill(double airTemp, double windSpeed) {
		double vWind= Math.pow(windSpeed, 0.16);
		double wChill = 13.12 + 0.6215 * airTemp - 11.37 * vWind + 0.3965 * vWind * airTemp ;
		return wChill;
	}

	

	

}
