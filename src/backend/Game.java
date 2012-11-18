package backend;

import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;
	private Player player;
	private final Board board;
	private String levelname;

	public Game(Board board, Player player, String levelname)
			throws PositionOutOfBoundsException {

		board.setGame(this);
		this.board = board;
		this.levelname = levelname;
		this.player = player;
	}

	/**
	 * Sets player.
	 * 
	 * @param playerName
	 */
	public void setPlayer(String playerName) {
		this.player = new Player(playerName);
	}

	/**
	 * Gets Player's Name.
	 */
	public String getPlayerName() {
		return player.getName();
	}

	/**
	 * Returns the current game score.
	 * 
	 * @return Integer
	 */
	public int getScore() {
		return player.getScore();
	}

	/**
	 * Gets the Player.
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Gets the Board.
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Gets Level's name.
	 */
	public String getLevelname() {
		return levelname;
	}

	/**
	 * Sets level's name.
	 */
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

}
