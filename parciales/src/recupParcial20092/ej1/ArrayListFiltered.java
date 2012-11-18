package recupParcial20092.ej1;

import java.util.ArrayList;

public class ArrayListFiltered<T> extends ArrayList<T> implements FilterList<T> {

	private static final long serialVersionUID = 1L;

	/**
	 * Cada elem dentro del for-each pertenece a la instancia de
	 * ArrayListFiltered que recibe el mensaje filter
	 */
	@Override
	public FilterList<T> filter(Criteria<T> criteria) {
		FilterList<T> result = new ArrayListFiltered<T>();
		for (T elem : this) {
			if (criteria.satisfies(elem)) {
				result.add(elem);
			}
		}
		return result;
	}
}
