package lab6;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The standard 3x3 S-shaped Tetris block.
 * 
 * @author EECS1720
 *
 */
public class SBlock extends Block {

    private ArrayList<BlockGrid> grids;
    private int gridIndex;

    /**
     * Create an S-block tetrimino at the given position and the given
     * color. The S-block is created with the starting orientation
     * as shown in the lab description.
     * 
     * @param pos the position of the S-block
     * @param col the color of the S-block
     */
    public SBlock(Point2 pos, Color col) {
        
    		//  TO COMPLETE
    	
    }

    /**
     * Spins the block to the left (counter clockwise) by 90 degrees about its
     * center of rotation. The S
     * block center of rotation is 1.5 units right and 1.5 units down from the
     * top left corner of the 3x3 grid.
     * 
     */
    @Override
    public void spinLeft() {
        
    		// TO COMPLETE (modify and use the gridIndex value to select and assign the new grid from grids ArrayList) when spinning "left"
    	
    	
    }

    /**
     * Spins the block to the right (clockwise) by 90 degrees about its center
     * of rotation. The S block
     * center of rotation is 1.5 units right and 1.5 units down from the top
     * left corner of the 3x3 grid.
     * 
     */
    @Override
    public void spinRight() {
        
    		// TO COMPLETE (modify and use the gridIndex value to select and assign the new grid from grids ArrayList) when spinning "left"
    		
    	
    }

}
