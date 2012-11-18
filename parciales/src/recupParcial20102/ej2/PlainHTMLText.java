package recupParcial20102.ej2;

public class PlainHTMLText implements HTMLText {
	private String text;

	public PlainHTMLText(String text) {
		this.text = text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String getSource() {
		return text;
	}
}
