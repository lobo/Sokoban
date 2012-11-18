package parcial2012.ej3;

import java.util.ArrayList;

public class SimpleArrayList<T> extends ArrayList<T> implements SimpleList<T> {
	@Override
	public void append(T elem) {
		add(elem);
	}
}