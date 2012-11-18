package parcial20112.ej3;

public class Participant {
	private final String name;
	private final int age;
	private Long startTime;
	private Long endTime;

	public Participant(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void start(long time) {
		startTime = time;
	}

	public void end(long time) {
		endTime = time;
	}

	public boolean hasTime() {
		return startTime != null && endTime != null;
	}

	public long getTotalTime() {
		return endTime - startTime;
	}
}
