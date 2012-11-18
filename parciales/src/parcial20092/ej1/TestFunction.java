package parcial20092.ej1;

public class TestFunction {
	public static void main(String[] args) {
		Function f = new CacheableFunction(new MyFunction());
		System.out.println("Prueba 1:");
		System.out.println(f.evaluate(new Object[] { "Hola", "mundo" }));
		System.out.println("Prueba 2:");
		System.out.println(f.evaluate(new Object[] { "lalalala" }));
		System.out.println("Prueba 3:");
		System.out.println(f.evaluate(new Object[] { "Hola", "mundo" }));
		System.out.println("Prueba 4:");
		System.out.println(f.evaluate(new Object[] { "mundo", "Hola" }));
	}
}
