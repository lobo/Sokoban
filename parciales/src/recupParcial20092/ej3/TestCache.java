package recupParcial20092.ej3;

public class TestCache {
	public static void main(String[] args) {
		Cache<String, String> cache = new LimitedCache<String, String>(3);

		cache.add("Hola", "mundo");
		cache.add("Soy", "Laura");
		cache.add("key", "value");

		System.out.println(cache.get("key")); // Imprime "value"
		System.out.println(cache.get("Soy")); // Imprime "Laura"
		System.out.println(cache.get("Soy")); // Imprime "Laura"

		cache.add("K", "V"); // Se elimina "Hola" por ser la menos consultada

		System.out.println(cache.get("Hola")); // Imprime "null" porque "Hola"
												// no está

		cache.add("72.33", "POO"); // Se elimina "K" por ser la menos consultada

		System.out.println(cache.get("K")); // Imprime "null" porque "K" no está
		System.out.println(cache.get("72.33")); // Imprime "POO"
		System.out.println(cache.get("72.33")); // Imprime "POO"

		cache.add("x", "y"); // Se elimina "key" por ser la menos consultada

		System.out.println(cache.get("key")); // Imprime "null"
	}
}
