package parcial20111.ej3;

public class Question {
	private final String caption;
	private final boolean answer;
	private final double value;

	public Question(String caption, double value, boolean answer) {
		this.caption = caption;
		this.value = value;
		this.answer = answer;
	}

	public String getCaption() {
		return caption;
	}

	public double getValue() {
		return value;
	}

	public boolean evaluate(boolean answer) {
		return this.answer == answer;
	}

	@Override
	public int hashCode() {
		return caption.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Question)) {
			return false;
		}
		Question other = (Question) obj;
		return caption.equals(other.caption);
	}

}
