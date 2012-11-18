package recupParcial20102.ej1;

import java.util.HashMap;
import java.util.Map;

public class PhoneCentral {
	private final Map<String, CellPhone> phones = new HashMap<String, CellPhone>();

	public void addPhone(CellPhone phone) {
		phones.put(phone.getNumber(), phone);
		phone.setCentral(this);
	}

	public void routeMessage(Message message) {
		CellPhone phone = phones.get(message.getTo());
		if (phone != null) {
			phone.receiveMessage(message);
		} else {
			throw new UnknownRecipientException();
		}
	}
}
