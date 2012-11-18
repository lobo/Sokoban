package parcial20111.ej2;

public interface RankMap<K, V> {
	/**
	 * Agrega un par clave-valor al mapa con ranking 0. Si la clave ya existe,
	 * sobreescribe el valor y el ranking se matiene.
	 */
	public void put(K key, V value);

	/**
	 * Devuelve el valor asociado a la clave key. Incrementa el ranking. Si la
	 * clave no existe retorna null.
	 */
	public V get(K key);

	/**
	 * Devuelve el ranking de la clave key. Si la clave no existe lanza la
	 * excepción NoSuchKeyException.
	 */
	public int getRank(K key);

	/**
	 * Devuelve la fecha de último acceso a la clave key. Si la clave no existe
	 * lanza la excepción NoSuchKeyException.
	 */
	public Date getLastAccess(K key);

	/**
	 * Elimina el par clave-valor. Si la clave no existe, no hace nada.
	 */
	public void remove(K key);

	/**
	 * Devuelve una lista con las claves que tienen ranking mayor a cierto valor
	 */
	public List<K> getHigher(int rank);
}