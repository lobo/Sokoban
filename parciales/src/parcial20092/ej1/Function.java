package parcial20092.ej1;

/**
 * Modela una función de N parámetros de entrada y uno de salida
 * 
 */
public interface Function {
	/**
	 * Evalúa una función de N parámetros representados a través de un arreglo
	 * de Object
	 * 
	 * @param params
	 *            Parámetros a usar
	 * @return resultado de evaluar la función
	 */
	public Object evaluate(Object[] params);
}
