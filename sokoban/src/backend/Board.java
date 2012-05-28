/**
 * 
 */
package backend;

import java.awt.Point;

import exceptions.PositionOutOfBoundsException;

/**
 * podemos borrar lo de llenar con Tiles vacios? No necesitamos hacerlo en TODO
 * el board, sino que en el caso que necesitamos llenar serian los vacios(donde
 * no haya ni Hole, ni Target) con Floors.
 * 
 * Point.x=FILA. Point.y=COLUMNA.
 * 
 * @Tere.
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
	public Tile getTile(Point p) {
		if (!validPosition(p)) {
			throw new PositionOutOfBoundsException();
		}
		return content[p.x][p.y];
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
	public boolean validPosition(Point p) {
		return (p.x >= 0 && p.x < height && p.y >= 0 && p.y < width);
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