package parcial20092.ej1;

/**
 * Modela una función que retorna la longitud promedio de un conjunto de strings
 */
public class MyFunction implements Function {
	@Override
	public Object evaluate(Object[] params) {
		System.out.println("Evaluando MyFunction");
		Double total = 0.0;
		for (int i = 0; i < params.length; i++) {
			String s = (String) params[i];
			total += s.length();
		}
		return total / params.length;
	}
}
