


// PwdLock CLASS (test1f - Question 2)


/**
 * A class to represent a lock that can only be
 * unlocked via a preset string code (password).
 * 
 */
 

// Extra Notes:
// ============
//  The code is stored with a PwdLock object when it is instantiated 
//  The PwdLock object also stores a boolean to indicate if it is currently 
//  in a locked or unlocked state 
//
//	** see the diagram on the labtest URL page for the appropriate field 
//	   names and method signatures you should use
//

public class PwdLock {

	// TOTAL FOR QUESTION 2 - [10 MARKS] 
	
	
	// FIELDS [ 1.5 marks ] 
	/**
	 * A boolean to indicate if the lock is locked (true) 
	 * or unlocked (false)
	 */
	private boolean locked;

	
	/**
	 * A String representing the code needed to unlock the lock.
	 * The code should be a string of at least 4 characters, and no
	 * more than 10 characters, and can include any character.
	 */
	private String code;

	/**
	 * A boolean representing whether the lock is currently open (true)
	 * or closed (false)
	 */
	private boolean open;
	
	
	// CONSTRUCTOR 1  [ 1.5 marks ]
	
	/**
	 * Initializes the lock to be in the unlocked state, open and
	 * have a code of "1234"
	 * 
	 */
	public PwdLock() {
		
		this.locked = false;
		this.open = true;
		this.code = "1234";
		
	}
	
	
	// CONSTRUCTOR 2  [ 3 marks ]
	
	/**
	 * Initializes the lock to have the code and locked state
	 * provided. If unlocked the lock should initially be open,
	 * otherwise if locked, the lock should initially be closed.
	 * 
	 * @param code a String code of 4-10 characters to use to unlock the lock
	 * @param locked a boolean that is true if locked, or false if unlocked
	 * 
	 * @throws IllegalArgumentException if the code is a String of
	 * less than 4 characters or more than 10 characters
	 */
	public PwdLock(String code, boolean locked) {
		this.locked = locked;
		if (!locked) {
			this.open = true;
		}else {
			this.open = false;
		}
		
		if(code.matches(".{4,10}+")) {
			this.code = code;
		}else {
			throw new IllegalArgumentException("less than 4 characters or more than 10 characters");
		}
		
		
		
	}
	
	
	
	// ACCESSORS/MUTATORS [ 4 marks ]
	
	/**
	 *  A method to return if the lock is locked or not
	 *
	 */
	public boolean isLocked() {
		
		return this.locked;
	}
	

	/**
	 *  A method to set the lock to the locked state
	 *  and close the lock
	 *
	 */
	public void closeAndLock() {
		

		this.locked = true;
		this.open = false;
	}
	

	/**
	 * A method to set the lock to the unlocked state and open the lock
	 * if the code provided is correct.
	 * 
	 * (i.e. equal to the code used to initialize the lock). 
	 * 
	 * If locked, and the code is correct, then the lock will be set 
	 * to unlocked, and will be opened.
	 * 
	 * If unlocked, the lock will remain unchanged.
	 */
	public void unlockAndOpen(String code) {
		
		if(!this.locked && code == this.code) {
			this.locked = false;
			this.open = true;
		}

		
		
		
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////
	//
	// MAIN METHOD (You may define a main method below for testing your class)
	// =====================================================================
	//
	// use the following main method if you would like to create 
	// PwdLock object(s) and tests for your methods.
	// 
	// No code provided in a main method will be marked however !!
	// (note: a main is not actually needed to complete this question)
	//
	////////////////////////////////////////////////////////////////////////////
	
	
	
	public static void main(String[] args) {
		
		
		// write your tests here (not marked)
	
	
	}
	

	
	
}
