package recupParcial20101.ej3;

public class Message {
	private final String from;
	private final String to;
	private final String text;

	public Message(String from, String to, String text) {
		super();
		this.from = from;
		this.to = to;
		this.text = text;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getText() {
		return text;
	}
}
