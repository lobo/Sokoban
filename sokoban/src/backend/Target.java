package backend;

/**
 * Falla porque todavia la clase element(mejor dicho la caja) no tiene el metodo
 * getColor.
 */
public class Target extends Floor implements Colorable {
	private final Color color;

	public Target(Color color) {
		super();
		this.color = color;
	}

	@Override
	public boolean isAccesible() {
		// TODO Auto-generated method stub
		return super.isAccesible();
	}

	@Override
	public Color getColor() {
		return color;
	}

	public boolean sameColor() {
		if (this.getContent() instanceof Box
				&& (this.getContent()).getColor().equals(color)) {
			return true;
		}
		return false;
	}

}
