package parcial20102.ej3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookingCentral {
	private final Map<String, Event> events = new HashMap<String, Event>();
	private final List<Reservation> reservations = new ArrayList<Reservation>();

	public void book(String eventName, String person, int seats) {
		Event event = getEvent(eventName);
		Reservation reservation = getReservation(eventName, person);
		if (reservation != null) {
			throw new IllegalArgumentException(
					"Person has an unconfirmed reservation for the event.");
		}
		event.book(seats);
		reservations.add(new Reservation(person, event, seats));
	}

	public void confirm(String eventName, String person) {
		Reservation reservation = getReservation(eventName, person);

		if (reservation == null) {
			throw new IllegalArgumentException("Unknown reservation.");
		}
		reservation.confirm();
	}

	public void cancel(String eventName, String person) {
		Reservation reservation = getReservation(eventName, person);

		if (reservation == null) {
			throw new IllegalArgumentException("Invalid reservation.");
		}
		reservation.getEvent().cancel(reservation.getSeats());
		reservations.remove(reservation);
	}

	public void buy(String eventName, String person, int seats) {
		Event event = getEvent(eventName);
		event.book(seats);
		Reservation reservation = new Reservation(person, event, seats);
		reservation.confirm();
		reservations.add(reservation);
	}

	public void printConfirmations() {
		System.out.println("Tickets sold: ");
		for (Reservation reservation : reservations) {
			if (reservation.isConfirmed()) {
				reservation.print();
			}
		}
	}

	public void addEvent(Event event) {
		events.put(event.getName(), event);
	}

	protected Event getEvent(String eventName) {
		Event event = events.get(eventName);
		if (event == null) {
			throw new IllegalArgumentException("Invalid event.");
		}
		return event;
	}

	protected Reservation getReservation(String eventName, String person) {
		Event event = getEvent(eventName);
		for (Reservation reservation : reservations) {
			if (!reservation.isConfirmed()
					&& reservation.getEvent().equals(event)
					&& reservation.getPerson().equals(person)) {
				return reservation;
			}
		}
		return null;
	}
}
