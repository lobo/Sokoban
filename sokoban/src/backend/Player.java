package backend;

import java.awt.Point;

/**
 * Falta el move del jugador.
 */
public class Player extends Movable {

	public Player(Point p) {
		super(p);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove() {
		/**
		 * GAME OVER.
		 */
		return true;
	}

	/**
	 * Necesito poder acceder al Board.
	 */
	@Override
	public void move(Cardinal c) {
		if (Board(this.position).isAccesible) {
			setPosition(c);
		}
	}
}
