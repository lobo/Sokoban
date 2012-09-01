package backend.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import backend.Board;
import backend.Box;
import backend.Cardinal;
import backend.ContentOperations;
import backend.Game;
import backend.Movable;
import backend.Player;
import backend.Smile;
import exceptions.InvalidBoardSizeException;
import exceptions.PositionOutOfBoundsException;

public class TestBoard {
	@Before
	public void SetUp() {

	}

	@Test
	public void TestSetPositionCardinalNORTH() throws InvalidBoardSizeException {
		Cardinal c = Cardinal.NORTH;
		Point point = new Point(9, 8);
		Board board = new Board("Tere", point);
		assertTrue(board.SetPositionCardinal(new Point(1, 1), c).equals(
				new Point(0, 1)));
	}

	@Test
	public void NotValidPositioninBoard() throws InvalidBoardSizeException {
		Point point = new Point(5, 5);
		Point position = new Point(29, 39);
		Board board = new Board("Tere", point);

		assertFalse(board.validPosition(position));

	}

	@Test
	public void NotValidPositioninBoard2() throws InvalidBoardSizeException {
		Point point = new Point(5, 5);
		Point position = new Point(-5, -5);
		Board board = new Board("Tere", point);

		assertFalse(board.validPosition(position));

	}

	@Test(expected = InvalidBoardSizeException.class)
	public void ErrorCreatingNegativeBoard() throws InvalidBoardSizeException {
		Board board = new Board("New", new Point(-5, -5));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void IndexOutofBoundExceptionInBoard()
			throws InvalidBoardSizeException {
		Point point = new Point(5, 5);
		Board board = new Board("Tere", point);

		board.getBoard()[2][-2].toString();

	}

	@Test
	public void AbleToSetBoxinEmptyFloor() throws InvalidBoardSizeException,
			PositionOutOfBoundsException {
		Point point = new Point(5, 5);
		Board board = new Board("Tere", new Point(10, 10));
		Color color = new Color(255, 255, 255);
		Movable m = new Box(point, color, board);
		assertTrue(board.setContent(point, m));

	}

	@Test
	public void InitializeBoardNullContent() throws InvalidBoardSizeException {
		Point point = new Point(2, 5);
		Board board = new Board("Tere", new Point(6, 6));

		assertTrue(((ContentOperations) board.getBoard()[point.x][point.y])
				.getContent() == null);
	}

	@Test(expected = InvalidBoardSizeException.class)
	public void CannotCreateBoard2x2() throws InvalidBoardSizeException {
		Board board = new Board("Tere", new Point(2, 2));

	}

	@Test(expected = InvalidBoardSizeException.class)
	public void CannotCreateBoard25x13() throws InvalidBoardSizeException {
		Board board = new Board("Tere", new Point(2, 2));

	}

	@Test
	public void SetSmileInMatrixofTile() throws InvalidBoardSizeException,
			PositionOutOfBoundsException {

		Board board = new Board("My Board", new Point(10, 10));

		Player myPlayer = new Player("Tere", 0);
		Smile smile = new Smile(new Point(5, 5), board);
		board.setContent(smile.getPosition(), smile);
		board.setSmile(smile);
		Game myGame = new Game(board, myPlayer, "lvl0");

		assertTrue(((ContentOperations) board.getBoard()[smile.getPosition().x][smile
				.getPosition().y]).getContent() instanceof Smile);
		// board.getSmile().getPosition(),

	}

	@Test
	public void TestWinning() throws InvalidBoardSizeException {
		Board board = new Board("My Board", new Point(10, 8));
		board.setNumberOfBoxesOK(6);
		board.setNumberOfTargets(6);
		board.setNumberOfBoxes(6);

		assertTrue(board.WinOrNot());
	}

	@Test
	public void TestLosing() throws InvalidBoardSizeException {
		Board board = new Board("My Board", new Point(10, 8));
		board.setNumberOfBoxesOK(6);
		board.setNumberOfTargets(8);

		assertFalse(board.WinOrNot());

	}

	/*
	 * public static void main(String[] args) throws InvalidBoardSizeException,
	 * PositionOutOfBoundsException {
	 * 
	 * Board board= new Board("My Board", new Point(10,10)); Player myPlayer=
	 * new Player("Tere", 0); Game myGame= new Game(board, myPlayer, "Level1");
	 * 
	 * myGame.getBoard().move(myGame.getSmilePosition(),Cardinal.NORTH, myGame);
	 * System.out.println(myGame.getSmilePosition()); }
	 */

}
