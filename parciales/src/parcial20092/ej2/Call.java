package parcial20092.ej2;

public class Call {
	private final String from;
	private final String to;
	private final int duration;
	private static final double COST_PER_SECOND = 0.01;

	public Call(String from, String to, int duration) {
		this.from = from;
		this.to = to;
		this.duration = duration;
	}

	public double getCost() {
		return duration * COST_PER_SECOND;
	}

	@Override
	public String toString() {
		return "Call from:" + from + " to: " + to + "(" + duration
				+ " seconds)";
	}
}
