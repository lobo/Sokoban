package parcial20102.ej3;

public class Reservation {
	private final String person;
	private final Event event;
	private boolean confirmed;
	private final int seats;

	public Reservation(String person, Event event, int seats) {
		this.person = person;
		this.event = event;
		this.confirmed = false;
		this.seats = seats;
	}

	public void confirm() {
		if (confirmed) {
			throw new IllegalStateException("Reservation already confirmed.");
		}
		confirmed = true;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public Event getEvent() {
		return event;
	}

	public String getPerson() {
		return person;
	}
}
