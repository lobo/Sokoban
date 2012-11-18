package recupParcial20111.ej1;

import java.util.Set;

public interface Bag<T> {
	/** Agrega el elemento a la bolsa. */
	public void add(T elem);

	/**
	 * Elimina el elemento de la bolsa. Si la bolsa contiene muchas veces un
	 * mismo elemento serán necesario que se remueva muchas veces dicho
	 * elemento.
	 */
	public void remove(T elem);

	/**
	 * Retorna el número de elementos equivalentes al recibido que hay en la
	 * bolsa.
	 */
	public int count(T elem);

	/** Retorna el conjunto de elementos distintos de la bolsa. */
	public Set<T> distinct();
}
