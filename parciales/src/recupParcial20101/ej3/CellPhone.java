package recupParcial20101.ej3;

public class CellPhone {
	private final String number;
	private final PhoneCentral central;

	public CellPhone(String number, PhoneCentral central) {
		super();
		this.number = number;
		this.central = central;
	}

	public void receiveMessage(Message message) {
		System.out.println("FROM: " + message.getFrom() + " TO: "
				+ message.getTo() + " MSG: " + message.getText());
	}

	public void sendMessage(String to, String text) {
		central.routeMessage(new Message(number, to, text));
	}
}
