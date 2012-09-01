package Serializacion;

public class Subject {

	private final String code;
	private final String name;

	public Subject(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Materia: " + code + " - " + name;
	}
}
