package recupParcial20102.ej1;

import java.util.ArrayList;

public class TestPhones {
	public static void main(String[] args) {
		PhoneCentral central = new PhoneCentral();
		CellPhone[] phones = new CellPhone[4];
		for (int i = 0; i < 4; i++) {
			phones[i] = new CellPhone("111" + i);
			central.addPhone(phones[i]);
		}
		List<String> options = new ArrayList<String>();
		options.add("A");
		options.add("B");
		options.add("C");
		ContestPhone contestPhone = new ContestPhone("*2020", options);
		central.addPhone(contestPhone);
		phones[0].sendMessage("1111", "Hola");
		phones[1].sendMessage("1110", "Que tal?");
		phones[0].sendMessage("*2020", "B");
		phones[1].sendMessage("*2020", "A");
		phones[2].sendMessage("*2020", "A");
		phones[3].sendMessage("*2020", "hola");
		contestPhone.closeContest();
		contestPhone.printResults();
		phones[0].sendMessage("*2020", "B");
	}
}
