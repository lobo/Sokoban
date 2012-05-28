package backend;

public class Color {

	private int colorR;
	private int colorG;
	private int colorB;

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Color)) {
			return false;
		}
		return this.equals((Color) obj);
	}

	public boolean equals(Color c) {
		return this.R == c.R && this.G == c.G && this.B == c.B;

	}
}
