package backend.tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import exceptions.InvalidBoardSizeException;

import backend.Board;
import backend.Game;
import backend.Box;
import backend.ContentOperations;
import backend.Floor;
import backend.Movable;

public class TestConstructors {
	

	
	
	@Test
	public void InitializeFloorContentNull(){
		assertTrue(((ContentOperations)new Floor()).getContent()==null);
	}

}
