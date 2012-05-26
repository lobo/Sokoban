/**
 * 
 */
package backend;

/**
 * @author daniel
 * 
 */
public interface Tile {
	boolean canMove(Tile destiny);

	void interact(Tile object);
}
