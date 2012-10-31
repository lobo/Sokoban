package exceptions;

/**
 * There was an error during the parsing of the incoming file
 */

public class GameParserException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public GameParserException(String error) {
		super(error);
	}
}
