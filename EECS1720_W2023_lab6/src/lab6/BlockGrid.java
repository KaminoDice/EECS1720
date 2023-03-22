package lab6;


/**
 * A grid used to represent a Tetris block shape. The grid size is
 * <code>n</code>-by-<code>n</code> where <code>n &gt;= 1</code>. Each grid
 * location is accessed using integer indices for the row and column (where the
 * indices are zero based). The following image shows a <code>3</code>-by-
 * <code>3</code> grid with its indices:
 * 
 * <p>
 * <img src="./BlockGrid.png" alt="">
 * 
 * <p>
 * Each grid location is either set (<code>true</code>) or clear (
 * <code>false</code>). Use the <code>set</code> method to set a grid position.
 * Use the <code>clear</code> method to clear a grid position. The following
 * image shows the S-block shape where the green grid positions are set and the
 * white grid positions are clear.
 * 
 * <p>
 * <img src="./SBlock.png" alt="">
 * 
 * @author EECS1720
 * 
 */
public class BlockGrid {
  private int size;
  private boolean[][] grid;

  /**
   * Create a grid of size <code>n</code>-by-<code>n</code>. All of the grid
   * positions are set to <code>false</code>.
   * 
   * @param n
   *          the size of the grid
   * 
   * @throws IllegalArgumentException
   *           if n &lt; 1
   */
  public BlockGrid(int n) {
    if (n < 1) {
      throw new IllegalArgumentException("grid size must be 1 or greater");
    }
    this.size = n;
    this.grid = new boolean[n][n];
    this.clearAll();
  }

  /**
   * Clears all of the grid locations.
   */
  public final void clearAll() {
    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size; j++) {
        this.grid[i][j] = false;
      }
    }
  }

  /**
   * Get the grid size.
   * 
   * @return the grid size
   */
  public int size() {
    return this.size;
  }

  /**
   * Gets the state of a grid location using zero-based row and column indices.
   * 
   * @param row
   *          the row index of the desired grid location
   * @param col
   *          the column index of the desired grid location
   * @return <code>true</code> if the grid location is set, <code>false</code>
   *         otherwise
   * @throws IndexOutOfBoundsException
   *           if row &lt; 0, row &gt;= size(),
   *           col &lt; 0, or col &gt;= size()
   */
  public boolean get(int row, int col) {
    this.checkRange(row, col);
    return this.grid[row][col];
  }

  /**
   * Sets a grid location.
   * 
   * @param row
   *          the row index of the desired grid location
   * @param col
   *          the column index of the desired grid location
   * @throws IndexOutOfBoundsException
   *           if row &lt; 0, row &gt;= size(),
   *           col &lt; 0, or col &gt;= size()
   */
  public void set(int row, int col) {
    this.checkRange(row, col);
    this.grid[row][col] = true;
  }

  /**
   * Clears a grid location.
   * 
   * @param row
   *          the row index of the desired grid location
   * @param col
   *          the column index of the desired grid location
   * @throws IndexOutOfBoundsException
   *           if row &lt; 0, row &gt;= size(),
   *           col &lt; 0, or col &gt;= size()
   */
  public void clear(int row, int col) {
    this.checkRange(row, col);
    this.grid[row][col] = false;
  }

  private void checkRange(int row, int col) {
    if (row < 0 || row >= this.size) {
      throw new IndexOutOfBoundsException("row is out of range: " + row
          + " on a grid of size: " + this.size);
    }
    if (col < 0 || col >= this.size) {
      throw new IndexOutOfBoundsException("col is out of range: " + col
          + " on a grid of size: " + this.size);
    }
  }
}
