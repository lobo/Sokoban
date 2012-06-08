package backend.tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

import backend.Board;
import backend.Box;
import backend.Target;

import exceptions.InvalidBoardSizeException;
import exceptions.PositionOutOfBoundsException;
import backend.Box;

public class TestTarget {

	@Test
	public void TargetWithBoxSameColor() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		Board board= new Board("My Board", new Point(10,10));
		Color color= new Color(100,100,100);
		Target myTarget = new Target(color);
		Box myBox = new Box(new Point(1,1),color, board);
		myTarget.setContent(myBox);
		
		assertTrue(myTarget.sameColor());
			
	}

}
