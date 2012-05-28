package backend;

import java.awt.Point;

public class Box extends Movable implements Colorable {
	private final Color color;

	public Box(Point p, Color c) {
		super(p);
		color = c;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public boolean remove() {
		setPositionOut();
		/**
		 * Cuando remuevo puedo verificar la cantidad de cajas existentes para
		 * ver si tiro un game over o no.
		 */
		return true;
	}

	@Override
	public void move(Cardinal c) {
		if (Board(this.position).isAccesible) {
			setPosition(c);
		}

	}
}
