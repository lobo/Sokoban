package parcial20101.ej1;

public class IgnoreNullsListTest {
	public static void main(String[] args) {
		IgnoreNullsList<Integer> list = new IgnoreNullsList<Integer>();
		list.add(1);
		list.add(null);
		list.add(2);
		list.add(5);
		list.add(null);
		list.add(3);
		list.add(null);
		Iterator<Integer> it = list.ignoreNullsIterator();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
			if (num == 2)
				it.remove();
		}
		System.out.println("---------------------------");
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
