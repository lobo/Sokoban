/**
 * 
 */
package backend;

public class Hole extends Floor {

	public Hole() {
		super();
	}

	@Override
	public boolean setContent(Movable content) {
		return content.remove();
	}
}
