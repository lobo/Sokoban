package recupParcial20092.ej3;

public interface Cache<K, V> {
	/**
	 * Agrega el par clave-valor al cache
	 */
	public void add(K key, V value);

	/**
	 * Devuelve el valor asociado a una clave o null si la clave no existe
	 */
	public V get(K key);

	/**
	 * Devuelve la cantidad de claves almacenadas
	 */
	public int size();
}
