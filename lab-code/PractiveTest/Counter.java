

public class Counter {

	// TOTAL FOR QUESTION 2 - [10 MARKS]
	
	
	// FIELDS 
	/**
	 * The name of this counter.
	 */
	public String name;
	
	/**
	 * The value of this counter.
	 */
	private int value;
	
	
	
	
	
	// CUSTOM CONSTRUCTOR 1 
	
	/**
	 * Initialize this counter to have the given name and a
	 * value of 0.
	 * 
	 * @param name the non-null name of this counter
	 */
	public Counter(String name) {
		
		this.name = name;
		this.value = 0;
		
	}
	
	
	// CUSTOM CONSTRUCTOR 2 
	
	/**
	 * Initialize this counter to have the given name and value.
	 * 
	 * @param name a non-empty name for this counter
	 * @param value the initial value of this counter
	 * @throws IllegalArgumentException if value is less than zero or the name is an empty string
	 */
	public Counter(String name, int value) {
		
		// do this first, so that no fields are set if arguments are invalid
		// constructor will exit 
		if (value<0 || name.isEmpty()) {
			throw new IllegalArgumentException();
			
		}
		
		this.name = name;
		this.value = value;
		
	}
	
	
	
	
	
	// ACCESSORS 
	
	
	
	
	/**
	 * Output the state of this Counter object to show its name and value
	 * formatted as "Counter[name] = value" 
	 * 
	 * e.g. if Counter has a name "clock" and a value "5", toString() would return:
	 * "Counter[clock] = 5"
	 * 
	 */
	public String toString() {
		
		return ("Counter[" + this.name + "] = " + this.value);
		
		
	}	
	
	
	
	// MUTATORS 
	

	
	/**
	 * Method to increment (increase) the counter value by 1
	 * 
	 */
	public void countUp() {
		
		this.value++; 
		
	}
	
	
	

	
	/**
	 * Method to decrement (decrease) the counter value by 1.
	 * 
	 * 
	 * The method should ensure that the value never goes below 0. 
	 * Any attempt to decrement further will keep the value at 0.
	 * 
	 */
	public void countDown() {

		this.value--;
		
		if (this.value < 0) {
			this.value = 0;		// keep at zero if becomes negative
		}
	}
	
	

	
	
	
	public void main(String[] args) {

		// nothing really required here
	
	}
	

	
	
}