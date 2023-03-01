import java.awt.Color;

// TEST 1 (A)

/**
 * A simple class to represent a Pawn ChessPiece.
 * 
 * @author EECS1720 W2023 Labtest 1
 *
 */
public class ChessPawn {

	// 1.5 marks

	/**
	 * a Color field representing the colour (white or black) of the ChessPawn
	 */
	private Color 	colour;		// WHITE or BLACK
	
	
	/**
	 * a char field representing the column (x position) of the ChessPawn
	 */
	private char 	col;		// [a-h]
	
	
	/** 
	 * an int field representing the row (y position) of the ChessPawn
	 */
	private int 	row;		// [1-8]
	



	
	/**
	 * A custom constructor for a ChessPawn that accepts a colour parameter.
	 * 
	 * 
	 * This constructor initializes to the left-most starting position
	 * on the board (depending on its colour).  I.e. position "a2" if white, and "a7" if black.
	 * 
	 * @param colour
	 * 			the desired colour of the ChessPawn
	 */
	public ChessPawn(Color colour) {

		this.colour = colour;
		this.col = 'a';
		
		if (colour == Color.white)
			this.row = 2;		// default to left-most position (a2 for white)
		if (colour == Color.black)		
			this.row = 7;		// default to left-most position (a7 for black)
		

	}

	
	/**
	 * A custom constructor for a ChessPawn that accepts a colour and position.
	 * 
	 * 
	 * Note that the ChessPawn can only be white or black colour,
	 * and must be initially positioned to row 2 (if white), and row 7 (if black).  This assumes white is 
	 * always configured at the bottom half of the board (see diagram in labtest URL for a picture of the board).
	 * 
	 * @param colour
	 * 			the colour of the ChessPawn
	 * @param col
	 * 			a char representing the column (x position) of the ChessPawn (i.e. has a value from 'a'-'h' inclusive)
	 * @param row
	 * 			an int representing the row (y position) of the ChessPawn (i.e. has a value from 1-8 inclusive)
	 * 
	 * @throws IllegalArgumentException()
	 * 		    if the colour is not valid, or the row is not the correct row for the starting position (i.e. 2 for white, 7 for black)
	 * 
	 */
	public ChessPawn(Color colour, char col, int row ) {

		boolean validColour = ( colour==Color.white || colour==Color.black );
		boolean validRow 	= ( (colour==Color.white && row==2) || (colour==Color.black && row==7) );
		
		if ( !validColour || !validRow ) {
			throw new IllegalArgumentException();
		}

		this.colour = colour;
		this.col = col;
		this.row = row;
		

	}


	

	/**
	 * a method to get the row position of a ChessPawn
	 * 
	 * @return
	 * 		an int representing the row position (1-8)
	 */
	public int getRow() {
		
		return this.row;
	}
	
	/**
	 * a method to set the row position of a ChessPawn
	 * 
	 *
	 */
	public void setRow(int row) {
		
		this.row = row;
	}
	
	
	/**
	 * a method to convert the state of a ChessPawn to a string
	 * 
	 * @return
	 * 		a string version of a ChessPawn:  in the format "P is at xY" , where x = column (char), and Y = row (int)
	 */
	public String toString() {
		
		return "P is at " + this.col + this.row;
	}
	
	
	

	
	
	
	/**
	 * a method that advances a Pawn by 1 square in the offensive direction 
	 * 
	 * 
	 * The offensive direction is toward the opponent's colour.
	 * 
	 * A white pawn would move up the board (toward higher row values), while a black pawn would move down the board (toward lower row values).
	 * Note: a pawn cannot advance if it has already reached the end of the board.
	 * 
	 */
	public void advance1() {
		
		if ( (this.colour == Color.white) && (this.row < 8) )
			this.row++;
		
		if ( (this.colour == Color.black) && (this.row > 1) )
			this.row--;
		
	}
	


	


}