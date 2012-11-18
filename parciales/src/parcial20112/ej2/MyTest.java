package parcial20112.ej2;

import java.util.Iterator;

public class MyTest {

	public static void main(String[] args) {
		SpecialList<String> list = new SpecialArrayList<String>();

		list.add("ABC");
		list.add("X");
		list.add("1234");
		list.add("HAZ");

		Function<String, Integer> f = new Function<String, Integer>() {
			public Integer apply(String t) {
				return t.length();
			};
		};

		Iterable<Integer> iterable1 = list.iterable(f);
		for (Integer i : iterable1) {
			System.out.println(i); // Esto imprime en distintas lineas: 3 1 4 3
		}

		list.add("ZZZZZZZZ");

		Iterator<Integer> it = iterable1.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println(i); // Esto imprime en distintas lineas: 3 1 4 3
									// 8
			if (i % 2 == 0) {
				it.remove();
			}
		}

		for (String s : list) {
			System.out.println(s); // Esto imprime en distintas líneas: ABC X
									// HAZ
		}
	}
}
