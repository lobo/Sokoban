package parcial20112.ej1;

public class ComplexElement extends Element {
	private final Element elem1;
	private final Element elem2;

	public ComplexElement(Element elem1, Element elem2) {
		this.elem1 = elem1;
		this.elem2 = elem2;
	}

	@Override
	public int width() {
		if (elem1.width() > elem2.width()) {
			return elem1.width();
		}
		return elem2.width();
	}

	@Override
	public int height() {
		return elem1.height() + elem2.height();
	}

	@Override
	public char contents(int row, int column) {
		if (row < elem1.height()) {
			if (column < elem1.width()) {
				return elem1.contents(row, column);
			} else {
				return ' ';
			}
		} else {
			if (column < elem2.width()) {
				return elem2.contents(0, column);
			} else {
				return ' ';
			}
		}
	}

}
