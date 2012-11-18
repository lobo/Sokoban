package recupParcial20102.ej1;

import recupParcial20102.ej2.PlainHTMLText;

public class Test {
	public static void main(String[] args) {
		PlainHTMLText text = new PlainHTMLText("Hola");
		// HTMLText boldText = ...
		// HTMLText italicText = ...
		System.out.println(boldText.getSource());
		System.out.println(italicText.getSource());
		// HTMLText boldItalicText = ...
		System.out.println(boldItalicText.getSource());
		text.setText("ITBA");
		System.out.println(boldText.getSource());
		System.out.println(italicText.getSource());
		System.out.println(boldItalicText.getSource());
		// HTMLText linkText = ...
		// HTMLText linkBoldText1 = ...
		// HTMLText linkBoldText2 = ...
		System.out.println(linkText.getSource());
		System.out.println(linkBoldText1.getSource());
		System.out.println(linkBoldText2.getSource());
		text.setText("Ejemplo");
		System.out.println(linkBoldText1.getSource());
		System.out.println(linkBoldText2.getSource());
	}
}
