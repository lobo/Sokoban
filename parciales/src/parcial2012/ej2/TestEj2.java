package parcial2012.ej2;

public class TestEj2 {
	public static void main(String[] args) {
		SubwayCentral central = new SubwayCentral(1.1); // El precio del pasaje
														// es $1.10
		FixedSubwayCard card1 = central.buyFixedSubwayCard(3); // Se compran 3
																// viajes
		try {
			card1.register("Bulnes"); // Registra un viaje desde Bulnes
			card1.register("9 de julio");
			central.changePrice(2.5); // El precio del pasaje pasa a $2.50
			card1.register("Bulnes");
			card1.printTransactions();
			card1.register("9 de julio");
		} catch (RideDeniedException e) {
			System.out.println("No hay saldo suficiente.");
		}
		central.changePrice(1.1);

		RechargeableSubwayCard card2 = central.buyRechargeableSubwayCard(); // Tarjeta
																			// recargable
		card2.charge(4.0); // Se le cargan $4 a la tarjeta
		try {
			card2.register("Carlos Gardel");
			central.changePrice(2.5);
			card2.register("Alem");
			card2.printTransactions();
			card2.register("Catedral");
		} catch (RideDeniedException e) {
			System.out.println("No hay saldo suficiente.");
		}
		card2.charge(3.0);
		try {
			card2.register("Catedral");
			card2.printTransactions();
			card2.register("Carranza");
		} catch (RideDeniedException e) {
			System.out.println("No hay saldo suficiente.");
		}
	}

}
