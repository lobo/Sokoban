package Serializacion;


public class Person {

	private String firstName;
	private String lastName;
	private Integer identification = 0;
	
	public Person(Integer identification, String firstname, String lastName) {
		this.identification = identification;
		this.lastName = lastName;
		this.firstName = firstname;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Integer getIdentification() {
		return identification;
	}	
	
	@Override
	public String toString() {
		return identification + " - " + firstName + ", " + lastName;
	}
}
