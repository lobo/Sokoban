package parcial20112.ej1;

public class Test {
	public static void main(String[] args) {

		Element elem1 = new UniformElement(6, 2, '+');
		Element elem2 = new TextElement("hola");
		Element elem3 = new TextElement("mundo");

		Element elem4 = elem1.above(elem2);
		Element elem5 = elem3.below(elem2);

		System.out.println("elem4:");
		elem4.print();

		System.out.println("elem5:");
		elem5.print();

		((UniformElement) elem1).changeContents('.');
		((TextElement) elem3).setValue("adios");

		System.out.println("elem4:");
		elem4.print();

		System.out.println("elem5:");
		elem5.print();
	}
}
