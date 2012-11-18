package parcial20112.ej1;

public class TextElement extends Element {
	private String value;

	public TextElement(String value) {
		setValue(value);
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int height() {
		return 1;
	}

	@Override
	public int width() {
		return value.length();
	}

	@Override
	public char contents(int row, int column) {
		if (row != 0 || column < 0 || column >= value.length()) {
			throw new IllegalArgumentException();
		}
		return value.charAt(column);
	}
}
