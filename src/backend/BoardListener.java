package backend;

public interface BoardListener {
	/**
	 * Run when the player win's.
	 * @param LevelName name of the played level
	 * @param score winning score
	 */
	void win(String LevelName, int score);
	
	/**
	 * Run when Player loses.
	 */
	void gameOver();
}

