package Serializacion;

import java.io.Serializable;

public class Rectangle extends Figure implements Serializable {

	private static final long serialVersionUID = 1L;
	private float width;
	private float height;

	public Rectangle(int x, int y, int color, int width, int height) {
		super(x, y, color);
		this.width = width;
		this.height = height;
	}

	@Override
	public float getPerimeter() {
		return 2 * width + 2 * height;
	}

	@Override
	public float getArea() {
		return width * height;
	}

	@Override
	public Rectangle stretch(int factor) {
		height *= factor;
		width *= factor;
		return this;
	}

	@Override
	public String toString() {
		return super.toString() + "(w:" + width + ", h:" + height + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result + Float.floatToIntBits(width);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj) || getClass() != obj.getClass())
			return false;
		final Rectangle other = (Rectangle) obj;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height)
				|| Float.floatToIntBits(width) != Float
						.floatToIntBits(other.width))
			return false;
		return true;
	}

	@Override
	public void draw() {
		System.out.println("Draw Rectangle");
	}
}