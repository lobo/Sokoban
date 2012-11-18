package recupParcial20111.ej3;

public class ReversibleMapExample {
	public static void main(String[] args) {
		ReversibleMap<Integer, String> map = new ReversibleHashMap<Integer, String>();

		map.put(1, "hola");
		map.put(2, "mundo");

		ReversibleMap<String, Integer> reverseMap = map.reverse();

		System.out.println(reverseMap.get("hola")); // imprime 1
		System.out.println(reverseMap.get("casa")); // imprime null
		System.out.println(reverseMap.containsKey("mundo")); // imprime true

		reverseMap.put("casa", 8);
		reverseMap.put("hola", 4);
		System.out.println(map.get(1)); // imprime null
		System.out.println(map.get(4)); // imprime hola
		System.out.println(map.get(8)); // imprime casa

		reverseMap.remove("hola");
		System.out.println(map.containsKey(4)); // imprime false

		map.remove(8);
		System.out.println(reverseMap.get("casa")); // imprime null

		reverseMap.put("clave", 2); // Lanza DuplicatedElementException
	}
}
