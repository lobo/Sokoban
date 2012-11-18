package parcial2012.ej1;

import java.util.ArrayList;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		Student s1 = new Student("45001");
		s1.addApprovedSubject("pi"); // El alumno tiene aprobada pi

		Student s2 = new Student("45002");
		s2.addApprovedSubject("poo");

		Student s3 = new Student("45003");
		s3.addApprovedSubject("poo");

		Student s4 = new Student("45004");
		Student s5 = new Student("45005");
		Student s6 = new Student("45006");

		QuotaValidator quotaValidator = new QuotaValidator(2);

		EnhancedCourse mate1 = new EnhancedCourse("mate1");
		mate1.addValidator(quotaValidator);
		mate1.register(s1);
		mate1.register(s2); // Pasan las validaciones
		mate1.register(s3); // Falla por falta de cupo

		System.out.println("MATE1: ");
		mate1.printStudents();

		EnhancedCourse eda = new EnhancedCourse("eda");
		eda.addValidator(quotaValidator);
		List<String> dependencies = new ArrayList<String>();

		dependencies.add("poo");
		eda.addValidator(new DependenciesValidator(dependencies));

		eda.register(s1); // Falla porque no tiene aprobado poo
		eda.register(s2);
		eda.register(s3); // Pasan las validaciones
		eda.register(s4);
		eda.register(s5);
		eda.register(s6); // Fallan por falta de cupo

		System.out.println("\nEDA: ");
		eda.printStudents();
	}
}
