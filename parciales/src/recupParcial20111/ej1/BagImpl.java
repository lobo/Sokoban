package recupParcial20111.ej1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class BagImpl<T> implements Bag<T> {
	private final Map<T, Integer> values = new HashMap<T, Integer>();

	@Override
	public void add(T elem) {
		if (values.get(elem) == null) {
			values.put(elem, 1);
		} else {
			values.put(elem, values.get(elem) + 1);
		}
	}

	@Override
	public int count(T elem) {
		if (values.get(elem) == null) {
			return 0;
		} else {
			return values.get(elem);
		}
	}

	@Override
	public void remove(T elem) {
		if (values.get(elem) == null) {
			throw new NoSuchElementException();
		} else if (values.get(elem) == 1) {
			values.remove(elem);
		} else {
			values.put(elem, values.get(elem) - 1);
		}
	}

	@Override
	public Set<T> distinct() {
		return new HashSet<T>(values.keySet());
	}
}
