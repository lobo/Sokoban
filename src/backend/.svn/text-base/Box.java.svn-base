package backend;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;
import backend.Board;
import backend.Cardinal;
import backend.Movable;

public class Box extends Movable implements Serializable, Colorable{
	
	private static final long serialVersionUID = 1L;
	private Color color;
	
	public Box(Point p, Color c, Board b) throws PositionOutOfBoundsException {
		super(p, b);
		color = c;
	}
	
	public Color getColor() {
		return color;
	}

	/**
	* 
	* If able, move box from one Tail(in the board) to other.
	* 
	* @param boxActualPlace
	* @param boxNextPlaumlce
	* @param cardinal
	* @return true if able to move it.
	* @throws PositionOutOfBoundsException 
	*/

	public boolean move(Point boxActualPlace, Cardinal cardinal) throws PositionOutOfBoundsException {

		Point boxNextPlace = this.getBoard().SetPositionCardinal(boxActualPlace, cardinal);
		if(this.getBoard().validPosition(boxNextPlace)){

			if (this.getBoard().getTile(boxNextPlace) instanceof ContentOperations && ((ContentOperations)this.getBoard().getTile(boxNextPlace)).getContent()==null) {

				if(this.getBoard().getTile(boxNextPlace).setContent(this, boxNextPlace, cardinal)){

					if(((ContentOperations)this.getBoard().getTile(boxActualPlace)).getContent()!=null){

						((ContentOperations)this.getBoard().getTile(boxActualPlace)).getContent().setPosition(cardinal);
						((ContentOperations)this.getBoard().getTile(boxActualPlace)).removeContent();
						return true;
					} 
					return true;
				}

			} else if(((ContentOperations)this.getBoard().getTile(boxActualPlace)).getContent() == null){
				return true;
			}
		} return false;	
	}	


	/**
	* Removes the Box from the game.
	*/
	public boolean remove(){
		this.getBoard().lessNumberOfBoxes();
		((ContentOperations)this.getBoard().getTile(this.getPosition())).removeContent();
		return true;
	}
	
		
}