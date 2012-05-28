package backend;

public class Floor implements Tile {
	private Movable content;
	private boolean ocuppied;

	public Floor() {
		this.content = null;
		this.ocuppied = false;
	}

	public Floor(Movable e) {
		this.content = e;
		this.ocuppied = true;
	}

	public Movable getContent() {
		return content;
	}

	/**
	 * Si puedo poner contenido, lo hace y retorna true sino retorna false
	 */
	public boolean setContent(Movable content) {
		if (content != null) {
			this.content = content;
			return true;
		}
		return false;
	}

	public void removeContent() {
		content = null;
		ocuppied = false;
	}

	@Override
	public boolean isAccesible() {
		if (ocuppied) {
			/** la caja se encarga de moverse */
			return true;
		}
		return false;
	}

}
