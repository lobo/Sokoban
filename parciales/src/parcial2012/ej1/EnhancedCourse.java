package parcial2012.ej1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnhancedCourse extends Course{
	private int capacidad = 0;
	private List<String> necesarias;
	
	public EnhancedCourse(String curso){
		super(curso);
	}
	
	public void addValidator(QuotaValidator quota){
		capacidad += quota.getCapacidad();
	}
	
	public void addValidator(DependenciesValidator dependencies){
		necesarias = dependencies.getMaterias();
	}
	
	@Override
	public void register(Student student){
		int cant = 0;
		System.out.println(necesarias);
		if ((super.getStudents()).size() < capacidad) {
			for(String subject: necesarias){
				if (student.hasApprovedSubject(subject)) {
					cant++;
				}
				else{
					break;
				}
			}
			if (necesarias.size() == cant) {
				register(student);
			}
		}
	}
}
