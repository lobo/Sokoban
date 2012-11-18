package parcial2012.ej2;

import java.util.ArrayList;
import java.util.List;

public abstract class Card {
	private List<Viaje> list;
	
	public Card(){
		list = new ArrayList<Viaje>();
	}
	
	public abstract void register(String string);

	public void printTransactions(){
		for (Viaje estacion : list) {
			System.out.println(estacion);
		}
	}

	public List<Viaje> getList() {
		return list;
	}

	public void setList(List<Viaje> list) {
		this.list = list;
	}
}
