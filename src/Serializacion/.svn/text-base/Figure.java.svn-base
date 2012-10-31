package Serializacion;


public abstract class Figure implements Drawable {
	private int x;
	private int y;
	private int color;

	public Figure() {
	}
	public Figure(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Figure(int x, int y, int color) {	
		this(x,y);
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return this.getClass().getName() + " at:(" + x + ", " + y + ")";
	}

	public int hashCode() {
		final int prime = 31;
		return ((color * prime) + x) * prime + y;
	}

	public boolean equals(Object obj) {
		if (this == obj )
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		final Figure other = (Figure) obj;
		if (color != other.color || x != other.x || y != other.y)
			return false;
		return true;
	}
	
	public abstract float getPerimeter();
	
	public abstract float getArea();
	
	public abstract Figure stretch(int factor);

}
