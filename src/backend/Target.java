
package backend;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Target extends Floor implements Colorable, Serializable{
	
	private static final long serialVersionUID = 1L;
	private Color color;
	
	public Target(Color color) {
		super();
		this.color=color;
	}
	
	@Override
	public boolean setContent(Movable content, Point boxActualPlace, Cardinal cardinal) throws PositionOutOfBoundsException {
		Boolean ableToSetContent=super.setContent(content,boxActualPlace,cardinal);
		if(ableToSetContent){
		sameColor();
		}
		return ableToSetContent;
	}
	
	/**
	 * Gets Target's color.
	 */
	public Color getColor() {
		return color;
	}
	
	/** 
	 * Verifies if the content has Target's color.
	 */
	public boolean sameColor(){
		if(this.getContent() instanceof Colorable && ((Colorable) this.getContent()).getColor().equals(this.color)){
			this.getContent().getBoard().AddNumberOfBoxesOK();
			return true;
		}
		return false;
	}
	
	
}
	

