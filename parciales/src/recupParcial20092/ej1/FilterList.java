package recupParcial20092.ej1;

import java.util.List;

/** Modela una lista que puede ser filtrada según un criterio */
public interface FilterList<T> extends List<T> {
	public FilterList<T> filter(Criteria<T> criteria);
}

/** Significa que me estan pasando un objeto que implementa Criteria */
/** Significa que me devuelve un objeto que implementa FilterList */
