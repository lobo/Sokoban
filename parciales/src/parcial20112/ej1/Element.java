package parcial20112.ej1;

public abstract class Element {
	public abstract int width(); // Devuelve el ancho del elemento

	public abstract int height(); // Devuelve el alto del elemento

	public abstract char contents(int row, int column);

	public ComplexElement above(Element elem) {
		ComplexElement elem1 = new ComplexElement(this, elem);
		return elem1;
	}

	public ComplexElement below(Element elem) {
		ComplexElement elem1 = new ComplexElement(elem, this);
		return elem1;
	}

	public void print() {
		for (int row = 0; row < height(); row++) {
			for (int col = 0; col < width(); col++) {
				System.out.print(contents(row, col));
			}
			System.out.println();
		}
	}
}
