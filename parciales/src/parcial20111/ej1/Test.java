package parcial20111.ej1;

public class Test {
	public static void main(String[] args) {
		SimpleList<String> list1 = new SimpleArrayList<String>();
		SimpleList<String> list2 = new SimpleArrayList<String>();

		list1.append("A");
		list1.append("B");
		list1.append("C");
		list2.append("D");
		list2.append("E");

		SimpleList<String> list3 = new ConcatSimpleList<String>(list1, list2);

		for (String s : list3) { /* La salida de este for es: ABCDE */
			System.out.print(s);
		}

		list1.append("H");
		list2.append("I");

		for (String s : list3) { /* La salida de este for es: ABCHDEI */
			System.out.print(s);
		}

		Iterator<String> it = list3.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if (s.equals("B") || s.equals("D")) {
				it.remove();
			}
		}

		list3.append("J");

		for (String s : list1) { /* La salida de este for es: ACH */
			System.out.print(s);
		}
		for (String s : list2) { /* La salida de este for es: EIJ */
			System.out.print(s);
		}
	}
}
