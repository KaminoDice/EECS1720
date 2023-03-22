package lab6;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The standard 3x3 J-shaped Tetris block.
 * 
 * @author EECS1720
 *
 */
public class JBlock extends Block {

    private ArrayList<BlockGrid> grids;
    private int gridIndex;

    /**
     * Create a J-block tetrimino at the given position and the given
     * color. The J-block is created with the starting orientation
     * as shown in the lab description.
     * 
     * @param pos the position of the J-block
     * @param col the color of the J-block
     */
    public JBlock(Point2 pos, Color col) {
        
    	// TO COMPLETE
    	
    	
    }

    /**
     * Spins the block to the left (counter clockwise) by 90 degrees about its
     * center of rotation. The J
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
     * of rotation. The J block
     * center of rotation is 1.5 units right and 1.5 units down from the top
     * left corner of the 3x3 grid.
     * 
     */
    @Override
    public void spinRight() {
    	
    		// TO COMPLETE (modify and use the gridIndex value to select and assign the new grid from grids ArrayList) when spinning "left"
    	
    	
    }

}
