/**
 * 
 */
package backend;

/**
 * @author daniel
 * 
 */
public class Game {
	public static final int MIN_HEIGHT = 5;
	public static final int MIN_WIDTH = 5;
	public static final int MAX_HEIGHT = 20;
	public static final int MAX_WIDTH = 20;
	private Board board;
	private Integer score;

	/**
	 * Este es el constructor, creo que va a ser medio heavy
	 */
	public Game() {
	};

	/**
	 * Returns the width of the game board.
	 * 
	 * @return Integer
	 */
	public Integer getBoardWidth() {
		return board.getWidth();
	}

	/**
	 * Returns the height of the game board.
	 * 
	 * @return Integer
	 */
	public Integer getBoardHeight() {
		return board.getHeight();
	}

	/**
	 * Returns the current game score.
	 * 
	 * @return Integer
	 */
	public Integer getScore() {
		return score;
	}
}
