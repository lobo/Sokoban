package parcial20112.ej1;

public class UniformElement extends Element {
	private final int width, height;
	private char contents;

	public UniformElement(int width, int height, char contents) {
		this.width = width;
		this.height = height;
		this.contents = contents;
	}

	@Override
	public int width() {
		return width;
	}

	@Override
	public int height() {
		return height;
	}

	@Override
	public char contents(int row, int column) {
		if (row < 0 || column < 0 || row >= height || column >= width) {
			throw new IllegalArgumentException();
		}
		return contents;
	}

	public void changeContents(char value) {
		contents = value;
	}
}
