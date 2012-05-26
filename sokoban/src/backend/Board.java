/**
 * 
 */
package backend;

/**
 * @author daniel
 * 
 */
public class Board {
	private final Tile[][] content;
	private final int height;
	private final int width;

	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		content = Tile[width][height];
		fillEmptyTiles();
	}

	/**
	 * Returns the tile at the given position
	 * 
	 * @param p
	 * @return Tile
	 */
	public Tile getTile(Position p) {
		if (!validPosition(p)) {
			throw new PositionOutOfBoundsException();
		}
		return content[p.row][p.column];
	}

	/**
	 * Returns the height of the board
	 * 
	 * @return int
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns the width of the board
	 * 
	 * @return int
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Checks that the position given falls inside the board boundaries
	 * 
	 * @param p
	 *            the position to be checked
	 * @return boolean
	 */
	public boolean validPosition(Position p) {
		return (p.row >= 0 && p.row < height && p.column >= 0 && p.column < width);
	}

	/**
	 * Fills the board with empty tiles
	 */
	private void fillEmptyTiles() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				content[i][j] = /** Llenar con tiles vacios */
			}
		}
	}
}