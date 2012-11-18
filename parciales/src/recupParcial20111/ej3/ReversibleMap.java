package recupParcial20111.ej3;

public interface ReversibleMap<K, V> {
	/** Indica si el mapa contiene la clave recibida. */
	public boolean containsKey(K key);

	/** Retorna el valor asociado a la clave, o null si no existe la clave. */
	public V get(K key);

	/**
	 * Agrega al mapa la clave con el valor asociado (si la clave ya se
	 * encuentra en el mapa, se sobreescribe el valor). Si el valor ya se
	 * encuentra asociado a alguna otra clave se lanza la excepción
	 * DuplicatedElementException.
	 */
	public void put(K key, V value);

	/**
	 * Elimina la clave y su valor asociado del mapa. Si no existe, no hace
	 * nada.
	 */
	public void remove(K key);

	/**
	 * Obtiene un mapa reverso del mapa que recibe el mensaje. Las operaciones
	 * que se realicen sobre el objeto devuelto se propagan sobre el mapa
	 * original.
	 */
	public ReversibleMap<V, K> reverse(); /* Importante: es V,K y no K,V */
}
