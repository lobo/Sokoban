package parser;

import java.io.File;

public class GameParser {
	private final File file;
	private int width;
	private int height;

	/**
	 * Creates a new parser for the given file
	 * 
	 * @param file
	 *            The file to parse
	 */
	public GameParser(File file) {
		this.file = file;
	}
}
