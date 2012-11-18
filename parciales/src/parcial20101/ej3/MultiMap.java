package parcial20101.ej3;

public interface Multimap<K, V> {
	/**
	 * Asocia la clave key con el objeto value
	 * 
	 * @param key
	 *            Clave
	 * @param value
	 *            Valor asociado
	 */
	public void put(K key, V value);

	/**
	 * Obtiene todos los objetos asociados a la clave key
	 * 
	 * @param key
	 *            Clave buscada
	 * @return La colección de objetos o null si la clave no existe
	 */
	public Collection<V> get(K key);

	/**
	 * Devuelve el tamaño de la colección
	 */
	public int size();

	/**
	 * Elimina la asociación entre key y value. Si no existe la asociación no
	 * hace nada.
	 * 
	 * @param key
	 *            Clave buscada
	 * @param value
	 *            Valor asociado
	 */
	public void remove(K key, V value);

	/**
	 * Elimina todas las asociaciones de la clave key.
	 * 
	 * @param key
	 *            Clave buscada
	 */
	public void remove(K key);
}
