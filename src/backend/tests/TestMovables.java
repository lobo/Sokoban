package backend.tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidBoardSizeException;
import exceptions.PositionOutOfBoundsException;

import backend.Board;
import backend.Box;
import backend.Movable;

public class TestMovables {
	
	@Before
	public void SetUp() throws InvalidBoardSizeException{
		Point point= new Point(6,8);
		Board board = new Board("Tere", point);
	}
	
	@Test
	public void InitializeColorAndBox() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		Point point= new Point(6,8);
		Board board = new Board("Tere", point);
		Color color = new Color(255,255,255);
		Movable m=new Box(new Point(1,1), color, board);
	}
	
	@Test (expected=PositionOutOfBoundsException.class)
	public void CannotPutMovableOutsideBoard() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		Point point= new Point(6,8);
		Board board = new Board("Tere", point);
		Color color = new Color(255,255,255);
		Movable m=new Box(new Point(9,1), color, board);
	}

}