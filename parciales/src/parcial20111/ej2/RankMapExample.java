package parcial20111.ej2;

public class RankMapExample {
	public static void main(String[] args) {
		RankMap<String, String> map = new RankHashMap<String, String>();
		map.put("google", "www.google.com");
		map.put("gmail", "gmail.google.com");
		map.put("iol", "www.iol.itba.edu.ar");

		map.remove("iol");
		map.get("gmail");

		map.get("gmail");
		map.get("google");
		map.get("google");
		map.get("google");
		map.get("google");
		map.get("google");
		map.get("google");
		map.get("google");
		map.get("google");

		Date access = map.getLastAccess("gmail");
		System.out.println("gmail fue consultado el " + access.getDate() + "/"
				+ (access.getMonth() + 1));
		System.out.println("gmail fue consultado " + map.getRank("gmail")
				+ " veces");

		for (String s : map.getHigher(4)) {
			System.out.println(s);
		}

		try {
			System.out.println("iol fue consultado " + map.getRank("iol")
					+ " veces");
		} catch (NoSuchKeyException e) {
			System.out.println("No existe la clave iol");
		}
		try {
			System.out.println("iol fue consultado el"
					+ map.getLastAccess("iol"));
		} catch (NoSuchKeyException e) {
			System.out.println("No existe la clave iol");
		}
	}
}
