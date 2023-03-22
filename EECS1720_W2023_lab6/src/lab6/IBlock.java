package lab6;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The standard 4x4 I-shaped Tetris block.
 * 
 * @author EECS1720 
 *
 */
public class IBlock extends Block {

    private ArrayList<BlockGrid> grids;
    private int gridIndex;

    /**
     * Create an I-block tetrimino at the given position and the given
     * color. The I-block is created with the starting orientation
     * as shown in the lab description.
     * 
     * @param pos the position of the I-block
     * @param col the color of the I-block
     */
    public IBlock(Point2 pos, Color col) {
    	
    		// ALREADY COMPLETED FOR YOU (FOR REFERENCE)
    	
        super(4, pos, col);
        this.grids = new ArrayList<BlockGrid>();

        System.out.println("making Iblock");
        
        BlockGrid g = this.grid;
        g.set(1, 0);
        g.set(1, 1);
        g.set(1, 2);
        g.set(1, 3);
        this.grids.add(g);

        g = new BlockGrid(4);
        g.set(0, 2);
        g.set(1, 2);
        g.set(2, 2);
        g.set(3, 2);
        this.grids.add(g);

        g = new BlockGrid(4);
        g.set(2, 0);
        g.set(2, 1);
        g.set(2, 2);
        g.set(2, 3);
        this.grids.add(g);

        g = new BlockGrid(4);
        g.set(0, 1);
        g.set(1, 1);
        g.set(2, 1);
        g.set(3, 1);
        this.grids.add(g);

        this.gridIndex = 0;
    }

    /**
     * Spins the block to the left (counter clockwise) by 90 degrees about its
     * center of rotation. The I
     * block center of rotation is 2 units right and 2 units down from the top
     * left corner of the 4x4 grid.
     * 
     */
    @Override
    public void spinLeft() {
        
    		// TO COMPLETE (modify and use the gridIndex value to select and assign the new grid from grids ArrayList) when spinning "left"
    	
    	
    	
    }

    /**
     * Spins the block to the right (clockwise) by 90 degrees about its center
     * of rotation. The I block
     * center of rotation is 2 units right and 2 units down from the top left
     * corner of the 4x4 grid.
     * 
     */
    @Override
    public void spinRight() {
        
    		// TO COMPLETE (modify and use the gridIndex value to select and assign the new grid from grids ArrayList) when spinning "left"
    	
    }

}
