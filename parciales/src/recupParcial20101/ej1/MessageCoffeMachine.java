package recupParcial20101.ej1;

import parcial20101.ej2.CoffeeMachine;
import parcial20101.ej2.Coin;

public class MessageCoffeeMachine extends CoffeeMachine {
	private final Display display;

	public MessageCoffeeMachine(int price, Display display) {
		super(price);
		this.display = display;
		display.showMessage("CoffeMachine Empty");
	}

	@Override
	public void insertCoin(Coin coin) {
		try {
			super.insertCoin(coin);
			int left = getPrice() - getCurrentMoney();
			if (left > 0) {
				display.showMessage(left + " cents left.");
			} else {
				display.showMessage("Please, take your coffee");
			}
		} catch (NotEnoughCoffeeException e) {
			display.showMessage("Sorry, but the CoffeeMachine is Empty.");
		}
	}
	// . . .
}
