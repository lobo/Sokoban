package parcial2012.ej1;

import java.util.List;
import java.util.ArrayList;
import parcial2012.ej1.Student;


public class Course {
	private final String subjectName;
	private final List<Student> students;

	public Course(String subjectName) {
		this.subjectName = subjectName;
		this.students = new ArrayList<Student>();
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void register(Student student) {
		if (!students.contains(student)) {
			students.add(student);
		}
	}

	public List<Student> getStudents() {
		return students;
	}

	public void printStudents() {
		System.out.print("Registered students: ");
		for (Student s : students) {
			System.out.print(s.getIdentification() + " ");
		}
		System.out.println();
	}
}
