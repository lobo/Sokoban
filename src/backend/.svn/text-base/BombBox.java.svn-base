package backend;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;


public class BombBox extends Box implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int counter;
	
	public BombBox(Point p, Color c, int time, Board board) throws PositionOutOfBoundsException {
		super(p, c, board);
		this.counter=time;
	}

	/**
	 * Get's the counter of the BombBox.
	 * @return time left.
	 */
	public int getCounter() {
		return counter;
	}
	
	@Override
	public boolean move(Point boxActualPlace, Cardinal cardinal)
			throws PositionOutOfBoundsException {
		if (counter > 1) {//Cambie aca para que pierda una vez que llega al cero, no imprime el 0 igual
			if(super.move(boxActualPlace, cardinal)){
				this.counter-=1;
				return true;
			}
		}
		else{
			this.getBoard().getInstanceBoardListener().gameOver();
		}
	
		return false;
	}
}
