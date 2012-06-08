package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;


public class Floor extends Tile implements ContentOperations, Serializable{
	
	private static final long serialVersionUID = 1L;
	private Movable content;
		
	public Floor() {
		this.content=null;
	}
	
	public Floor(Movable e) {
		this.content=e;
	}
	
	public Movable getContent() {
		return content;
	}
	
	public boolean removeContent(){
		content=null;
		return true;
	}
	
	/**
	 * If the Floor doesn't have content, it set it.
	 * If not, ask to move it.
	 * @throws PositionOutOfBoundsException 
	 */
	public boolean setContent(Movable content2, Point boxActualPlace, Cardinal cardinal) throws PositionOutOfBoundsException {
		if(this.content == null){
			this.content = content2;
			return true;
		} else if(this.content.move(boxActualPlace, cardinal)){
			this.content = content2;
			return true;
		}
		else 
			return false;
	}
	
	@Override
	public boolean setContent(Movable movable) {
		if (this.content==null){
			this.content=movable;
			return true;
		}
		return false;
	}
}
