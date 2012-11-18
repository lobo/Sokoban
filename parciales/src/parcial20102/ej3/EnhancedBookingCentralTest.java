package parcial20102.ej3;

public class EnhancedBookingCentralTest {
	public static void main(String[] args) {
		BookingCentral central = new EnhancedBookingCentral(2, 1);

		central.addEvent(new Event("Evento 1", 10));
		central.addEvent(new Event("Evento 2", 10));
		central.addEvent(new Event("Evento 3", 10));
		central.addEvent(new Event("Evento 4", 10));
		central.addEvent(new Event("Evento 5", 10));
		central.addEvent(new Event("Evento 6", 10));

		central.book("Evento 1", "Mariano", 1);
		central.book("Evento 2", "Mariano", 1);

		try {
			central.book("Evento 3", "Mariano", 1);
		} catch (BlacklistedCustomerException e) {
			System.out
					.println("A- Person cannot have more than 2 pending reservations.");
		}

		central.buy("Evento 3", "Mariano", 1);

		try {
			central.book("Evento 4", "Mariano", 1);
		} catch (BlacklistedCustomerException e) {
			System.out
					.println("B- Person cannot have more than 2 pending reservations.");
		}

		central.confirm("Evento 1", "Mariano");
		central.book("Evento 4", "Mariano", 1);
		central.confirm("Evento 4", "Mariano");

		central.cancel("Evento 2", "Mariano");
		try {
			central.book("Evento 5", "Mariano", 1);
		} catch (BlacklistedCustomerException e) {
			System.out
					.println("C- Person cannot make reservation: too many previous cancellations.");
		}

		central.buy("Evento 5", "Mariano", 1);
		central.book("Evento 6", "Mariano", 1);
		central.printConfirmations();
	}
}
