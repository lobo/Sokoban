package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public abstract class Tile implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * Acess the Tile and set movable content if able,
	 * if not return false.
	 * 
	 * @param m Movable to put in the Tile
	 * @return True if was able to do it, false if not.
	 * @throws PositionOutOfBoundsException 
	 */
	
	boolean isAccessible(Movable content, Point boxActualPlace, Point boxNextPlace, Cardinal cardinal) throws PositionOutOfBoundsException{
		return setContent(content, boxActualPlace, cardinal);
	}
	
	/**
	 * Sets Content in a Tile.
	 * @return True if was able to set it, False if not.
	 */
	public abstract boolean setContent(Movable content, Point boxActualPlace, Cardinal cardinal) throws PositionOutOfBoundsException;

	/**
	 * Sets the content. For parser use only.
	 */
	public abstract boolean setContent(Movable movable);
	
		
	
}