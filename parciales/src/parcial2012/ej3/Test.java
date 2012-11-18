package parcial2012.ej3;

public class Test {
	public static void main(String[] args) {
		SimpleList<String> list1 = new SimpleArrayList<String>();
		SimpleList<String> list2 = new SimpleArrayList<String>();
		SimpleList<String> list3 = new SimpleArrayList<String>();

		list1.append("A");
		list1.append("B");
		list1.append("C");
		list2.append("D");
		list2.append("E");
		list3.append("1");
		list3.append("2");
		list3.append("3");
		list3.append("4");

		SimpleList<String> list4 = new ConcatNSimpleList<String>();

		((ConcatNSimpleList<String>) list4).add(list1).add(list2).add(list3);

		show(list4); /* La salida es: ABCDE1234 */

		list1.append("H");
		list2.append("I");

		show(list4); /* La salida es: ABCHDEI1234 */

		Iterator<String> it = list4.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if (s.equals("B") || s.equals("D")) {
				it.remove();
			}
		}

		list4.append("J");

		show(list1); /* La salida es: ACH */
		show(list2); /* La salida es: EI */
		show(list3); /* La salida es: 1234J */
	}

	private static void show(SimpleList<String> list) {
		for (String s : list) {
			System.out.print(s);
		}
		System.out.println();
	}
}