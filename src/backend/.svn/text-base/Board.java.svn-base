package backend;

import java.awt.Point;
import java.io.Serializable;

import javax.swing.text.AbstractDocument.Content;

import exceptions.InvalidBoardSizeException;
import exceptions.PositionOutOfBoundsException;

public class Board implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final int MIN_HEIGHT = 5;
	public static final int MIN_WIDTH = 5;
	public static final int MAX_HEIGHT = 20;
	public static final int MAX_WIDTH = 20;
	
	private final Tile[][] board;
	private final int height;
	private final int width;
 	private Game game;
	private String title;
	private Smile smile;
	
	private int numberOfTargets;
	private int numberOfBoxes;
	private int numberOfBoxesOK;
	
	private transient BoardListener instanceBoardListener;
	
	public Board(String title, Point point) throws InvalidBoardSizeException {
		this.width = (int) point.getX();
		this.height = (int) point.getY();
		
		this.numberOfBoxes=0;
		this.numberOfBoxesOK=0;
		this.numberOfTargets=0;
		
		this.setTitle(title);
		
		if(width>=MIN_WIDTH && height>=MIN_HEIGHT && width<=MAX_WIDTH && height<=MAX_HEIGHT){
		board = new Tile[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = new Floor();
			}
		}
		} else throw new InvalidBoardSizeException();
			
	}

	/**
	 * The method try to move content from a Tile to other tile
	 * in the board in the direction Cardinal says.
	 * @param from Point where the movement starts.
	 * @param cardinal direction of movement
	 * @return True if was able to move, false if not
	 * @throws PositionOutOfBoundsException 
	 */

	//TODO move ya no tiene game
	public boolean move(Cardinal cardinal) throws PositionOutOfBoundsException {
		
		Boolean AbletoMove;
		Point toPoint = SetPositionCardinal(smile.getPosition(),cardinal);
		
		if (validPosition(toPoint) && board[toPoint.x][toPoint.y].setContent(smile, toPoint, cardinal)) {
				((ContentOperations)board[smile.getPosition().x][smile.getPosition().y]).removeContent();
				smile.setPosition(cardinal);
				game.getPlayer().addScore();
				
				AbletoMove=true;
				} else AbletoMove=false;
		
		if(WinOrNot()){
			instanceBoardListener.win(title, game.getPlayer().getScore());
		}
		
		return AbletoMove;
	}

	
	/**
	 * Returns the height of the board
	 * 
	 * @return int
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns the width of the board
	 * 
	 * @return int
	 */
	public int getWidth() {
		return width;
	}


	/**
	 * Checks that the position given falls inside the board boundaries
	 * 
	 * @param p
	 *            the position to be checked
	 * @return boolean
	 */
	public boolean validPosition(Point p) {
		return (p.x >= 0 && p.x < height && p.y >= 0 && p.y < width);
	}

	/**
	 * If instance of Tile in the position is Floor (or subclass), 
	 * return the content. If not, null.
	 * @param position Point with the position
	 * @return Movable if has content, null if not.
	 */
	
	public Movable getContent(Point position) {
		Tile myTile=board[(int) position.getX()][(int) position.getY()];
		return (myTile instanceof ContentOperations?((ContentOperations)myTile).getContent():null);
	}
	
	/**
	 * Set a Tile if it's a Floor the Board in the position given, for Parser use. @see GameParser
	 * 
	 * @return true if was able to set the Tile, false if not.
	 */
	public boolean setTile(Point position,Tile tile){
		if(board[position.x][position.y] instanceof Floor){
			if(((ContentOperations)board[position.x][position.y]).getContent() != null){
				tile.setContent(((ContentOperations)board[position.x][position.y]).getContent());
			}
			board[position.x][position.y]=tile;
			return true;
		}
	return false;
	}
	

	/**
	 * Returns the Tile in a position of the Board.
	 * 
	 * @return Tile in the position
	 */
	public Tile getTile(Point position) {
		return board[position.x][position.y];
	}
	
	/**
	 * New point with the position I want to go.
	 * 
	 * @param p Actual point
	 * @param c Cardinal with the direction
	 * @return New instance of point with the new position.
	 */
	public Point SetPositionCardinal(Point p, Cardinal c){
		return (new Point((int)p.getX()+c.getDirX(),((int)p.getY()+c.getDirY())));
	}
	
	/**
	 * Calculate if the number of Boxes over Targets is the same as the number of Targets in the Board
	 * @return True if Player had win, False if not.
	 */
	public boolean WinOrNot(){
		return ((numberOfBoxesOK==numberOfTargets)&&(numberOfBoxes==numberOfTargets));
	}

	/**
	 * Reduce the variable with the numberOfBoxes in one unit.
	 */
	public void lessNumberOfBoxes() {
		numberOfBoxes-=1;
	}

	/**
	 * Add one unit to the variable that save the number of boxes actually over a same Color's target. 
	 */
	public void AddNumberOfBoxesOK() {
		this.numberOfBoxesOK+=1;
	}
	
	/**
	 * Add one unit to the variable with the number of Targets in the Board.
	 * For Parser's use. @see Parser
	 */
	public void addNumberOfTargets() {
		this.numberOfTargets += 1;
	}
	
	/**
	 * Add one unit to the variable with the number of Boxes in game.
	 */
	public void addNumberOfBoxes() {
		this.numberOfBoxes += 1;
	}
	

	/**
	 * For parser use. If Tile's content is null, setContent with instance of movable.
	 */
	public boolean setContent(Point p, Movable movable) {
		if(board[p.x][p.y] instanceof ContentOperations && ((ContentOperations)board[p.x][p.y]).getContent()==null){
			board[p.x][p.y].setContent(movable);
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the game.
	 * @return Game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Sets the game.
	 * @param game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Gets Board's title.
	 * @return Board's title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets Board's title.
	 * @param Board's title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the number of Targets in the Board.
	 * @return number of Targets in the Board.
	 */
	public int getNumberOfTargets() {
		return numberOfTargets;
	}

	/**
	 * Gets the number of boxes.
	 * @return Number of Boxes.
	 */
	public int getNumberOfBoxes() {
		return numberOfBoxes;
	}
	
	/**
	 * Sets the number of boxes of the board.
	 * @param numberOfBoxes
	 */

	public void setNumberOfBoxes(int numberOfBoxes) {
		this.numberOfBoxes = numberOfBoxes;
	}
	
	/**
	 * Gets the Board (Tile's matrix)
	 * @return Tile[][]
	 */
	public Tile[][] getBoard() {
		return board;
	}

	/**
	 * Sets the number of Boxes over a same color's target.
	 * @param numberOfBoxesOK
	 */
	public void setNumberOfBoxesOK(int numberOfBoxesOK) {
		this.numberOfBoxesOK = numberOfBoxesOK;
	}
	
	/**
	 * Set's the number of Targets on the board.
	 * @param numberOfTargets
	 */
	public void setNumberOfTargets(int numberOfTargets) {
		this.numberOfTargets = numberOfTargets;
	}
	
	/**
	 * Set the smile in game.
	 * @param smile
	 */
	public void setSmile(Smile smile) {
		this.smile = smile;
	}

	/**
	 * Gets the smile in game.
	 * @return the Smile.
	 */
	public Smile getSmile() {
		return smile;
	}

	/**
	 * Gets the BoardListener instance (Win or Game Over).
	 * @see BoardListener
	 * @return instance of Board Listener.
	 */
	public BoardListener getInstanceBoardListener() {
		return instanceBoardListener;
	}

	/**
	 * Set's Board Listener.
	 * @see BoardListener
	 * @param instanceBoardListener
	 */
	public void setInstanceBoardListener(BoardListener instanceBoardListener) {
		this.instanceBoardListener = instanceBoardListener;
	}
}
