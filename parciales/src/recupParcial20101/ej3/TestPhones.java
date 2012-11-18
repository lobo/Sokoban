package recupParcial20101.ej3;

public class TestPhones {
	public static void main(String[] args) {
		EnhancedPhoneCentral central = new EnhancedPhoneCentral();
		CellPhone[] phones = new CellPhone[4];
		for (int i = 0; i < 4; i++) {
			phones[i] = central.newPhone("111" + i);
		}
		try {
			phones[0].sendMessage("1111", "Hola");
			phones[1].sendMessage("1110", "Que tal?");
			phones[2].sendMessage("1110", "Buen dia");
			phones[2].sendMessage("1117", "Buen dia");
		} catch (UnknownRecipientException e) {
			System.out.println("Alguna llamada falló");
		}
		central.showStats();
	}
}
