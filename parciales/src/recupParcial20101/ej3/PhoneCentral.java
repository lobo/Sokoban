package recupParcial20101.ej3;

import java.util.HashMap;
import java.util.Map;

import recupParcial20092.ej2.CellPhone;

public class PhoneCentral {
	private final Map<String, CellPhone> phones = new HashMap<String, CellPhone>();

	public PhoneCentral() {
	}

	public CellPhone newPhone(String number) {
		if (getPhone(number) != null) {
			return null;
		}
		CellPhone cellphone = new CellPhone(number, this);
		phones.put(number, cellphone);
		return cellphone;
	}

	private CellPhone getPhone(String number) {
		return phones.get(number);
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
