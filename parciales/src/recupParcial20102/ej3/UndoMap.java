package recupParcial20102.ej3;

/**
 * Mapa Simple que no admite claves y valores en null, y permite deshacer
 * operaciones
 */
public interface UndoMap<K, V> {
	/**
	 * Agrega un par clave-valor al mapa. Si la clave ya existe, sobreescribe el
	 * valor.
	 */
	public void put(K key, V value);

	/**
	 * Devuelve el valor asociado a la clave key. Si la clave no existe retorna
	 * null.
	 */
	public V get(K key);

	/**
	 * Elimina el par clave-valor. Si la clave no existe, no hace nada.
	 */
	public void remove(K key);

	/**
	 * Deshace la última modificación realizada al mapa (a través de los métodos
	 * put o remove). Este método puede ser invocado tantas veces como se desee,
	 * deshaciendo tantas operaciones como corresponda.
	 * 
	 * @throws IllegalStateException
	 *             cuando no hay una operación para deshacer.
	 */
	public void undo();
}
