package lab1;

/**
 * Utility class with short methods reviewing fundamental Java concepts
 * working with: conditional logic, branching and use of an external class (Range)
 * 
 * @author EECS1720 Winter 2023
 *
 */
public class LogicUtils {

	private LogicUtils() {
		// EMPTY BY DESIGN (nothing to do here)
	}
	
	
	/**
	 * Determine if an integer <code>x</code> is odd.
	 * 
	 * @param x
	 *            a value
	 *            
	 * @return true if x is odd and false otherwise
	 */
	public static boolean isOdd(int x) {
		
		// odd if there is a remainder when dividing by 2
		// even if there is no remainder when dividing by 2
		
		return (x%2==1);
	}

	/**
	 * Determine if the point <code>(x, y)</code> is exactly on the perimeter of
	 * a circle with center <code>(0, 0)</code> and having radius equal to
	 * <code>1</code>.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 *            
	 * @return true if (x, y) is exactly on the perimeter of the unit circle,
	 *         and false otherwise
	 */
	public static boolean isOnUnitCircle(double x, double y) {
		
		// can make use of Math class here
		// specifically the hypot() method (or can explicitly do calc using Math.sqrt() and * or Math.pow()
		
		// each of these computes the same thing (only need to do one):
		double dist1 = Math.sqrt( x*x + y*y );
		double dist2 = Math.sqrt( Math.pow(x, 2) + Math.pow(y,2) );
		double dist3 = Math.pow( (x*x + y*y), 0.5);
		
		double dist = Math.hypot(x, y);	  // if a method exists that does what you need, use it!
		
		return (dist==1.0);   	// true if dist is equal to 1.0
								// note: the tester allows for discrepancies due to decimal places
	}

	/**
	 * Determine if the point <code>(x, y)</code> is inside the unit square. The
	 * unit square is the square whose sides have length 1, whose bottom left
	 * corner has coordinates (0, 0), and whose top right corner has coordinates
	 * (1, 1). A point on the perimeter of the unit square is considered to be
	 * inside the square.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 *            
	 * @return true if (x, y) is inside the unit square, and false otherwise
	 */
	public static boolean isInsideUnitSquare(double x, double y) {
		
		boolean isInsideX = (x>=0.0 && x<=1.0);
		boolean isInsideY = (y>=0.0 && y<=1.0);
		
		return ( isInsideX && isInsideY );
	}

	/**
	 * Determine if the point <code>(x, y)</code> is outside the unit square.
	 * The unit square is the square whose sides have length 1, whose bottom
	 * left corner has coordinates (0, 0), and whose top right corner has
	 * coordinates (1, 1). A point on the perimeter of the unit square is
	 * considered to be inside the square.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 *            
	 * @return true if (x, y) is outside the unit square, and false otherwise
	 */
	public static boolean isOutsideUnitSquare(double x, double y) {
		
		// again, we just wrote a method for the inside of a square, 
		// better to use it if we can!
		
		// is outside if not inside (=> i.e. !inside)
		
		return !isInsideUnitSquare(x,y) ;
	}

	
	
	/**
	 * Determine if a value <code>x</code> is strictly inside the given
	 * <code>Range</code>. A value exactly at the minimum or maximum of the
	 * range is considered outside of the range.
	 * 
	 * @param x
	 *            a value
	 * @param range
	 *            a Range to check
	 *            
	 * @return the value 1 if x is strictly inside the given Range, and 0
	 *         otherwise
	 */
	public static int contains(double x, Range range) {
		
		// HINT: look at the Range class (java file or API documentation link), 
		// 		 to see how to access/use a Range object (or type "range." and this
		//		 will pull up a dropdown menu of all the legal features that can
		//       be used/called from a Range object reference
		
		int isInRange = 0;
		
		// assume not in range, then set if in range
		if ( x>range.getMinimum() && x<range.getMaximum() ) {
			isInRange = 1;
		}
		
		return isInRange;
	}

	/**
	 * Compares two <code>Range</code> instances by their widths.
	 * 
	 * @param r1
	 *            a Range
	 * @param r2
	 *            a second Range
	 *            
	 * @return the value 0 if both Range instances have equal width; -1 if r1 is
	 *         narrower than r2; and 1 if r1 is wider than r2
	 */
	public static int compareTo(Range r1, Range r2) {
		
		double w1 = r1.getMaximum()-r1.getMinimum();	// width of r1
		double w2 = r2.getMaximum()-r2.getMinimum();	// width of r2
		
		int result = 0;		// assume equal, change if not
		if (w1<w2) result = -1;
		if (w2<w1) result = 1;
			
		return result;
	}

}
