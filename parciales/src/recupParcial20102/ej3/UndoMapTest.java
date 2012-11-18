package recupParcial20102.ej3;

public class UndoMapTest {
	public static void main(String[] args) {
		UndoMap<String, String> map = new HashUndoMap<String, String>();

		map.put("1", "hola");
		map.put("1", "que paso?");
		map.put("34", "mundo");
		map.put("7", "chau");

		System.out.println(map.get("34")); // Imprime "mundo"

		map.undo();
		map.undo();

		System.out.println(map.get("34")); // Imprime "null"
		System.out.println(map.get("1")); // Imprime "que paso?"

		map.undo();

		System.out.println(map.get("1")); // Imprime "hola"

		map.put("999", "fin");
		map.remove("1");

		System.out.println(map.get("1")); // Imprime "null"

		map.undo();
		System.out.println(map.get("1")); // Imprime "hola"

		map.undo();
		map.undo();
		System.out.println(map.get("1")); // Imprime "null"
		map.undo(); // Lanza IllegalStateException
	}
}
