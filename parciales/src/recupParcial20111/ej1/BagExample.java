package recupParcial20111.ej1;

public class BagExample {
	public static void main(String[] args) {
		IterableBagImpl<String> bag = new IterableBagImpl<String>();
		bag.add("perro");
		bag.add("perro");
		bag.add("perro");
		bag.add("gato");
		bag.add("raton");
		bag.add("raton");
		for (String s : bag) {
			// imprime: gato raton raton perro perro perro
			System.out.println(s);
		}
		removeOnce(bag, "perro");
		removeOnce(bag, "gato");
		for (String s : bag) {
			// imprime: raton raton perro perro
			System.out.println(s);
		}
	}

	private static void removeOnce(IterableBagImpl<String> bag, String elem) {
		Iterator<String> it = bag.iterator();
		while (it.hasNext()) {
			if (it.next().equals(elem)) {
				it.remove();
				return;
			}
		}
	}
}
