/**
 * 
 */
package backend;

/**
 * @author daniel
 * 
 */
public class Position {
	public final int row;
	public final int column;

	/**
	 * Creates a new position
	 * 
	 * @param row
	 * @param column
	 */
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * Returns a new position which differs from the receiver in only one
	 * cardinal point by one unit.
	 * 
	 * @param d
	 *            Direction to move
	 * @return Position
	 */
	public Position move(Direction d) {
		switch (d) {
		case UP:
			return new Position(row - 1, column);
		case RIGHT:
			return new Position(row, column + 1);
		case DOWN:
			return new Position(row + 1, column);
		case LEFT:
			return new Position(row, column - 1);
		}
		return null;
	}

	/* IMPLEMENTAR HASHCODE Y EQUALS?! */
}
