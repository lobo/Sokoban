package parcial20102.ej3;

public class Event {
	private final String name;
	private int emptySeats;

	public Event(String name, int emptySeats) {
		this.name = name;
		this.emptySeats = emptySeats;
	}

	public String getName() {
		return name;
	}

	public void book(int seats) {
		if (seats > emptySeats) {
			throw new IllegalArgumentException(
					"Event has not enoug empty places");
		}
		this.emptySeats -= seats;
	}

	public void cancel(int seats) {
		this.emptySeats += seats;
	}

	@Override
	public int hashCode() { // Código de hashcode correcto
	}

	@Override
	public boolean equals(Object obj) { // Código de equals correcto
	}
}