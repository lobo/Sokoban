package backend.tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

import backend.Board;
import backend.Box;
import backend.Cardinal;
import backend.Game;
import backend.Hole;
import backend.Player;
import backend.Smile;
import backend.Target;
import backend.Tile;
import backend.Wall;
import backend.ContentOperations;
import exceptions.InvalidBoardSizeException;
import exceptions.PositionOutOfBoundsException;

public class TestMoving {
	@Test
	public void MoveSmileNORTHtoEmptyFloor() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		
		Board board= new Board("My Board", new Point(15,10));
		Player myPlayer= new Player("Tere", 0);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(2);
		board.setNumberOfTargets(3);
		
		Game myGame= new Game(board, myPlayer, "lvl0");
				
		assertTrue(board.move(Cardinal.NORTH));
		
	}
	
	public void MoveSmileToSamePositionBefore() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		
		Board board= new Board("My Board", new Point(15,10));
		Player myPlayer= new Player("Tere", 0);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(2);
		board.setNumberOfTargets(3);
		
			
		board.move(Cardinal.NORTH);
		assertTrue(board.move(Cardinal.SOUTH));
	}
	
	@Test
	public void MoveToHoleandBoxBeRemoved() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		
		Board board= new Board("My Board", new Point(10,10));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,255,190);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		
		Box myBox = new Box(nextPosition, color, board);
		board.setContent(nextPosition, myBox);
		board.setTile(board.SetPositionCardinal(nextPosition, Cardinal.SOUTH),new Hole());
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		
		assertTrue(board.move(Cardinal.SOUTH));
//		assertTrue(((ContentOperations)(board.getTile(nextPosition))).getContent()==null);
	}
	
	@Test
	public void MoveBoxToHoleRemoveItandMoveSmileToo() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		
		Board board= new Board("My Board", new Point(13,9));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,255,190);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		
		Box myBox = new Box(nextPosition, color, board);
		board.setContent(nextPosition, myBox);
		board.setTile(board.SetPositionCardinal(nextPosition, Cardinal.SOUTH),new Hole());
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		
		board.move(Cardinal.SOUTH);
		
		assertFalse(smile.getPosition().equals(new Point (5,5)));
	}
	
	@Test
	public void NotAbletoMoveSmileSOUTHToWall() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		
		Board board= new Board("My Board", new Point(11,14));
		Player myPlayer= new Player("Tere", 0);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		board.setTile(nextPosition,new Wall());
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		
		assertFalse(board.move(Cardinal.SOUTH));
		
	}
	
	@Test
	public void MoveToTarget() throws PositionOutOfBoundsException, InvalidBoardSizeException{
		Board board= new Board("My Board", new Point(11,14));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,200,100);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		board.setTile(nextPosition,new Target(color));
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		
		assertTrue(board.move(Cardinal.SOUTH));
		
	}
	
	
	@Test
	public void MoveBoxToTarget() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		Board board= new Board("My Board", new Point(11,14));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,200,100);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		
		board.setTile(board.SetPositionCardinal(nextPosition, Cardinal.SOUTH),new Target(color));
		board.setContent(nextPosition, new Box(nextPosition,color, board));
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		
		assertTrue(board.move(Cardinal.SOUTH));
		
		
	}
	
	
	
	@Test
	public void MovePlayerToTileWithMovingBox() throws InvalidBoardSizeException, PositionOutOfBoundsException{
		// Si la posición es 5,5 no me deja moverme al norte, tira error (pero nadie avisa)
		
		Board board= new Board("My Board", new Point(10,10));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,255,190);
		Smile smile= new Smile(new Point(5,3), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.EAST);
		Box myBox = new Box(nextPosition, color, board);
		
		board.setContent(nextPosition, myBox);
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);

		assertTrue(board.move(Cardinal.EAST));
/*		
		assertTrue(myBox.move(myBox.getPosition(), Cardinal.EAST));
// OKEY.	
		assertTrue(board.getTile(nextPosition).setContent(board.getSmile(), nextPosition, new Point(board.SetPositionCardinal(nextPosition, Cardinal.EAST)), Cardinal.EAST));
// OKEY.
		assertTrue(board.validPosition(nextPosition));
// OKEY.
	*/	
		
	}
	
	public static void main(String[] args) throws PositionOutOfBoundsException, InvalidBoardSizeException {
		Board board= new Board("My Board", new Point(11,14));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,200,100);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		board.setTile(board.SetPositionCardinal(nextPosition, Cardinal.SOUTH),new Target(color));
		board.setContent(nextPosition, new Box(nextPosition,color, board));
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		board.move(Cardinal.SOUTH);
			
			
		/*		Board board= new Board("My Board", new Point(13,9));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,255,190);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		
		Box myBox = new Box(nextPosition, color, board);
		board.setContent(nextPosition, myBox);
		board.setTile(board.SetPositionCardinal(nextPosition, Cardinal.SOUTH),new Hole());
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		
		board.move(Cardinal.SOUTH);
		
		/*Board board= new Board("My Board", new Point(11,14));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,200,100);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		board.setTile(board.SetPositionCardinal(nextPosition, Cardinal.SOUTH),new Target(color));
		board.setContent(nextPosition, new Box(nextPosition,color, board));
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		
		board.move(Cardinal.SOUTH);
		
		/*
		
		
/*		Board board= new Board("My Board", new Point(10,10));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,255,190);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		
		Box myBox = new Box(nextPosition, color, board);
		board.setContent(nextPosition, myBox);
		board.setTile(board.SetPositionCardinal(nextPosition, Cardinal.SOUTH),new Hole());
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		
		board.move(Cardinal.SOUTH);
		
		/*Board board= new Board("My Board", new Point(6,7));
		Player myPlayer= new Player("Tere", 0);
		Color color= new Color(244,255,190);
		Smile smile= new Smile(new Point(1,1), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.EAST);
		Box myBox = new Box(nextPosition, color, board);
		
		board.setContent(nextPosition, myBox);
		
		Game myGame= new Game(board, myPlayer, "lvl0");
		board.setGame(myGame);
		
		board.move(Cardinal.EAST);
		
		/* Board board= new Board("My Board", new Point(11,12));
		Player myPlayer= new Player("Tere", 0);
		Smile smile= new Smile(new Point(5,5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		board.setNumberOfBoxes(6);
		board.setNumberOfBoxesOK(0);
		board.setNumberOfTargets(3);
		Point nextPosition= board.SetPositionCardinal(smile.getPosition(), Cardinal.SOUTH);
		System.out.println(board.getBoard()[nextPosition.x][nextPosition.y].getClass());
		*/
	}
}
