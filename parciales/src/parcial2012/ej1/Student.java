package parcial2012.ej1;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private final String identification;
	private final Set<String> approvedSubjects;

	public Student(String identification) {
		this.identification = identification;
		this.approvedSubjects = new HashSet<String>();
	}

	public String getIdentification() {
		return identification;
	}

	public void addApprovedSubject(String subjectName) {
		approvedSubjects.add(subjectName);
	}

	public boolean hasApprovedSubject(String subjectName) {
		return approvedSubjects.contains(subjectName);
	}
}