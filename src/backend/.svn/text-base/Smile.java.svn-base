package backend;

import java.awt.Point;

import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Smile extends Movable implements Serializable {

	private static final long serialVersionUID = 1L;

	public Smile(Point p, Board b) throws PositionOutOfBoundsException {
	super(p,b);
	}
		
	@Override
	public boolean remove() {
		this.getBoard().getInstanceBoardListener().gameOver();
		return false;
	}
	

	@Override
	public boolean move(Point boxActualPlace, Cardinal cardinal) {
		
		return false;
	}
}
