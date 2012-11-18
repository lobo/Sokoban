package recupParcial20101.ej1;

import parcial20101.ej2.Coin;

public class MessageCoffeMachineTest {
	public static void main(String[] args) {
		Display console = new ConsoleDisplay();
		Display lcd = new LCDDisplay();
		Display file = new FileDisplay();
		// .....................................................
		// .....................................................
		MessageCoffeeMachine machine = new MessageCoffeeMachine(75, display);
		machine.insertCoin(Coin.ONE_DOLLAR);
		/*
		 * Esto imprime en console , en el display LCD y en un archivo el
		 * mensaje "CoffeMachine Empty"
		 */
	}
}
