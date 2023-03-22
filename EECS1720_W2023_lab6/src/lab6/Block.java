package lab6;


import java.awt.Color;
import java.awt.Graphics2D;
//import princeton.introcs.StdDraw;

/**
 * Abstract base class for standard Tetris blocks. Blocks can move, spin, and
 * draw themselves.
 * 
 * @author EECS1720 
 * 
 */
public abstract class Block {
	
	private static int BLOCKSIZE = 40;

    /**
     * The grid that represents the block in its current orientation.
     */
    protected BlockGrid grid;

    /**
     * The position on the playing field of the top left corner of the grid.
     */
    protected Point2 position;

    /**
     * The color of the block.
     */
    protected Color blockColor;

    /**
     * Construct a block given its grid size, position, and color.
     * <code>this.grid</code> will be a <code>BlockGrid</code> of size
     * <code>gridSize</code>-by-<code>gridSize</code> with all grid locations
     * cleared.
     * 
     * <p>
     * This constructor should be called only by direct child classes.
     * 
     * @pre. <code>gridSize > 0</code>
     * 
     * @param gridSize
     *            the size of the grid
     * @param pos
     *            the position on the playing field of the top-left corner of
     *            the grid
     * @param col
     *            the color of the block
     */
    protected Block(int gridSize, Point2 pos, Color col) {
        this.grid = new BlockGrid(gridSize);
        this.position = pos;
        this.blockColor = col;
    }

    /**
     * Draw the block to the provided Graphics2D context in its current position and
     * orientation according to its specified color.
     * 
     * @param c
     *            the color to draw with
     */
    protected void draw(Graphics2D g2d) {
    	
        for (int i = 0; i < this.grid.size(); i++) {
            for (int j = 0; j < this.grid.size(); j++) {
            	
                if (this.grid.get(i, j)) {
                    Point2 topLeft = new Point2(this.position.getX() + j*BLOCKSIZE, this.position.getY() + i*BLOCKSIZE);
                    System.out.println("reached colour set");
                    g2d.setColor(this.blockColor);
                    g2d.fillRect((int)topLeft.getX(), (int)topLeft.getY(), BLOCKSIZE, BLOCKSIZE);
                    
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect((int)topLeft.getX(), (int)topLeft.getY(), BLOCKSIZE, BLOCKSIZE);
                    
                }
            }
        }
    }


    /**
     * Moves the block to the left by 1 grid position, where each grid position is 
     * spaced BLOCKSIZE pixels apart.
     * 
     */
    public void moveLeft() {
        double x = this.position.getX();
        this.position.setX(x - BLOCKSIZE);
    }

    /**
     * Moves the block to the right by 1 grid position, where each grid position is 
     * spaced BLOCKSIZE pixels apart.
     * 
     */
    public void moveRight() {
        double x = this.position.getX();
        this.position.setX(x + BLOCKSIZE);
    }

    /**
     * Moves the block down by 1 grid position, where each grid position is 
     * spaced BLOCKSIZE pixels apart.
     * 
     */
    public void moveDown() {
        double y = this.position.getY();
        this.position.setY(y + BLOCKSIZE);
    }

    /**
     * Moves the block up by 0 grid positions.
     * 
     */
    public void moveUp() {
    }

    /**
     * Get the position on the playing field of the top-left corner of the
     * block's grid. The block's position cannot be modified using the reference
     * returned by this method.
     * 
     * @return the position on the playing field of the top-left corner of the
     *         block's grid
     */
    public Point2 getPosition() {
        return new Point2(this.position);
    }

    /**
     * Spin the object to the left (counter clockwise) about its center of
     * rotation.
     */
    public abstract void spinLeft();

    /**
     * Spin the object to the right (clockwise) about its center of rotation.
     */
    public abstract void spinRight();
}
