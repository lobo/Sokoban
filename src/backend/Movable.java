package backend;

import java.awt.Point;
import java.io.Serializable;
import exceptions.PositionOutOfBoundsException;


public abstract class Movable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Point position;
	private Board board;
	
	public Movable(Point p, Board board) throws PositionOutOfBoundsException {
		if (board.validPosition(p)){
			position=p;
		} else throw new PositionOutOfBoundsException();
		
		this.board=board;
	}
	
	/**
	 * Sets a new position for the movable
	 * @param direction Cardinal with the direction of movement
	 */
	public void setPosition(Cardinal direction){
		if((board.validPosition(position))){
			position.x+=direction.getDirX();
			position.y+=direction.getDirY();
		}
	}
	
	/**
	 * Move Boxes to another Tile in the direction the cardinal says.
	 * @param boxActualPlace
	 * @param cardinal
	 * @throws PositionOutOfBoundsException
	 */
	public abstract boolean move(Point boxActualPlace, Cardinal cardinal) throws PositionOutOfBoundsException;

	/**
	 * Removes the movable from the game.
	 */
	public abstract boolean remove();

	/**
	 * Gets the board.
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * Gets the position.
	 */
	public Point getPosition() {
		return position;
	}
	
}
	


