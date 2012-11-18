package parcial2012.ej1;

import java.util.List;

public class DependenciesValidator {
	private List<String> materias;
	
	public DependenciesValidator(List<String> obj){
		this.materias = obj;
	}
	
	public List<String> getMaterias(){
		return materias;
	}
	
	
}
