package recupParcial20092.ej1;

/**
 * Se pide implementar lo que considere necesario, sin modificar nada de lo
 * existente para poder aplicarle a una lista varias implementaciones de
 * Criteria en forma simultánea obteniendo como resultado la sublista de
 * elementos que cumplen con todas las condiciones.
 */

public class TestFilterList {
	public static void main(String[] args) {
		FilterList<Integer> list = new ArrayListFiltered<Integer>();

		list.add(4);
		list.add(3);
		list.add(15);
		list.add(16);
		list.add(20);
		/** Defino una clase anonima que implementa la interfaz */
		FilterList<Integer> result = list.filter(new Criteria<Integer>() {
			@Override
			public boolean satisfies(Integer obj) {
				return (obj % 2 == 0) ? true : false;
			}
		});

		/**
		 * Lo puedo imprimir porque FilterList tiene una instancia de
		 * ArrayListFiltered y esta clase extiende de ArrayList que tiene
		 * implementado el toString()
		 */
		System.out.println(result);
	}
}
