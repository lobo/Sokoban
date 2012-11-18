package recupParcial20102.ej1;

import recupParcial20101.ej3.PhoneCentral;

public class CellPhone {
	private final String number;
	private PhoneCentral central;

	public CellPhone(String number) {
		this.number = number;
	}

	public void receiveMessage(Message message) {
		System.out.println("FROM: " + message.getFrom() + " TO: "
				+ message.getTo() + " MSG: " + message.getText());
	}

	public void sendMessage(String to, String text) {
		central.routeMessage(new Message(number, to, text));
	}

	public String getNumber() {
		return number;
	}

	void setCentral(PhoneCentral central) {
		this.central = central;
	}
}
