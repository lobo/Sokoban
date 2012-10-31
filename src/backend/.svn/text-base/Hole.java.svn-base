package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;


public class Hole extends Floor implements Serializable{

	private static final long serialVersionUID = 1L;

	public Hole() {
		super();
	}
	@Override
	public boolean setContent(Movable content2, Point boxActualPlace,
			Cardinal cardinal) throws PositionOutOfBoundsException {
		return content2.remove();
	}
	
	/**
	 * Call another method to remove content.
	 */
	public boolean setContent(Movable content) {
		return content.remove();
	}
}
