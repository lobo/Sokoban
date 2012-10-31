package parser;

import java.awt.Color;
import java.awt.Point;
import java.io.*;
import exceptions.*;
import backend.*;


public class GameParser {

	private Board board;
	private Point p;
	private boolean playerExists = false;
	private static final int PLAYER = 1;
	private static final int BOX = 2;
	private static final int TARGET = 3;
	private static final int WALL = 4;
	private static final int HOLE = 5;
	private static final int BOMBBOX = 6;
	
	/**
	 * Receives a file as a parameter and verifies whether
	 * it has been written in the proper manner
	 * 
	 * @param file
	 * @return Board created using file
	 * @throws IOException
	 * @throws InvalidBoardSizeException 
	 * @throws PositionOutOfBoundsException 
	 */
	
    public Board readFiles(File file) throws IOException, InvalidBoardSizeException, PositionOutOfBoundsException{
    	
        String numbers[];
        String currentLine;
        BufferedReader bufferedReader = null;

    	try{
    		FileReader fileReader = new FileReader(file);
    		bufferedReader = new BufferedReader(fileReader);
        
    		while ((currentLine = bufferedReader.readLine()) != null) {
    			currentLine = eraseComments(currentLine);
    			currentLine = currentLine.replaceAll(" ", "");
    			if(currentLine.length() > 1){
    				numbers = currentLine.split(",");
    				if(board == null)
    					validateDimensions(numbers);
    				else{
    					validateElements(numbers);
    				}
    			}
    		}
    		return board;
    	}finally{
    		if(bufferedReader != null)
    			bufferedReader.close();
    	}
    }
    
    /**
     * Removes Comments from String
     * 
     * @param line (A String which holds a line of the given file)
     * @return string without any comments
     */
	
    public String eraseComments(String s){
    	StringBuilder aux = new StringBuilder(s);
    	
    	for(int i=0; i<s.length() ; i++){
    		if(s.charAt(i) == '#')
    			aux.delete(i, s.length());
    	}
    	
    	return aux.toString();
    }
    
    /**
     * Verifies whether the dimension given to the board is
     * of the permitted value.
     * 
     * @param numbers (A String which holds a line of the given file)
     * @throws InvalidBoardSizeException 
     */
    
    public void validateDimensions(String[] numbers) throws InvalidBoardSizeException{

		if (numbers.length != 2) 
			throw new GameParserException("The file´s dimension is in the wrong format");
		
		int rows = Integer.parseInt(numbers[0]);
		int columns = Integer.parseInt(numbers[1]);
		
		possibleDimension(rows, columns);

		p = new Point(rows,columns); 
		board = new Board("New Game", p);
    }
    
    /**
     * Verifies whether the elements given to the board is
     * of the permitted value.
     * 
     * @param numbers (A String which holds a line of the given file)
     * @throws PositionOutOfBoundsException 
     */
    
	private void validateElements(String[] numbers) throws PositionOutOfBoundsException{
		
		Tile tile = null;
		Movable movable = null;

		if (numbers.length != 7) 
			throw new GameParserException("A file´s element is in the worng format");

		int row = Integer.parseInt(numbers[0]);
		int column = Integer.parseInt(numbers[1]);
		int element = Integer.parseInt(numbers[2]);
		int timer = Integer.parseInt(numbers[3]);
		int colorR = Integer.parseInt(numbers[4]);
		int colorG = Integer.parseInt(numbers[5]);
		int colorB = Integer.parseInt(numbers[6]);
		
		p= new Point(row,column);
		
		validateElement(element);
		validatePlayer(element);
		validatePosition(p,element);
		validateBombBox(timer,element);
		validateColor(colorR, colorG, colorB, element);
		
		switch(element){
			case PLAYER:{
				movable = new Smile(p, board);
				board.setSmile((Smile)movable);
				playerExists = true;
				break;
			}
			case BOX:{
				movable = new Box(p, new Color(colorR, colorG, colorB), board);
				board.addNumberOfBoxes();
				break;
			}
			case TARGET:{
				tile = new Target(new Color(colorR, colorG, colorB));
				board.addNumberOfTargets();
				break;
			}
			case WALL:{
				tile = new Wall();
				break;
			}
			case HOLE:{
				tile = new Hole();
				break;
			}
			case BOMBBOX:{
				movable = new BombBox(p, new Color(colorR, colorG, colorB), timer, board);
				board.addNumberOfBoxes();
				break;
			}
		}
		if((tile != null) && !(board.setTile(p, tile)))
			throw new GameParserException("A Target/Hole/Wall wasn´t able to be placed on the board");
		else if((movable != null) && !(board.setContent(p, movable)))
			throw new GameParserException("A Box/Player/Bomb wasn´t able to be placed on the board");
	}
	
	/**
	 * Verifies whether that position is accessible, be it because of the point not existing
	 * within the boards dimensions or if that position is already occupied by another element.
	 * 
	 * @param p
	 * @param row
	 * @param column 
	 */
	
	public void validatePosition(Point p, int elem){
		if(!(board.validPosition(p)))
			throw new GameParserException("An element is trying to access a position that does not exist in Board");
		if((board.getContent(p)) != null && elem!=TARGET && elem!=HOLE){
			throw new GameParserException("An element is trying to access a position that is occupied by something else");
		}
	}		
	
	/**
	 * Verifies whether a element has a timer without it being a BombBox
	 * 
	 * @param timer
	 * @param element 
	 */
	
	public void validateBombBox(int timer, int element){
		if((timer != 0) && (element != BOMBBOX))
			throw new GameParserException("Only bombs are able to carry timers");
	}
	
	/**
	 * Verifies that the only element that is given a color is either a Box, BombBox
	 * or a Target. The color must also be written in the proper manner.
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 * @param elem
	 */
	public void validateColor(int red, int green, int blue, int elem){
		if((elem == PLAYER || elem == WALL || elem == HOLE) && red != 0 && blue != 0 && green != 0)
			throw new GameParserException("A non-colorable element is trying to color itself");
		if(red<0 || red>255 || green<0 || green>255 || blue<0 || blue>255)
			throw new GameParserException("Error in an element's color range");
	}
	
	/**
	 * Verifies whether the file is trying to create more than one player in a single game
	 * 
	 * @param elem
	 */
	public void validatePlayer(int elem){
		if((elem == PLAYER) && (playerExists))
			throw new GameParserException("There can´t be more than one player per game");
		else
			playerExists = true; 
	}
	
	/**
	 * Verifies whether the element given is within the game´s restrictions
	 * @param elem
	 */
	public void validateElement(int elem){
		if (elem > 6 || elem < 1) 
			throw new GameParserException("There is a non-existant element within the file");		
	}
	
	/**
	 * Verifies whether the file is creating a board with a dimension within the permitted range
	 * 
	 * @param r
	 * @param c
	 */
	public void possibleDimension(int r, int c){
		if ((r != c) || ( r < 5) || (r > 20)) 
			throw new GameParserException("The dimension does not exist within the permitted range: 5x5 - 20x20");
	}
	
}		
















