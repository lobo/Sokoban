package Serializacion;



public class Subject {
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	
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
