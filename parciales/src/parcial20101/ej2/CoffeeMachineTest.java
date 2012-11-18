package parcial20101.ej2;

import java.util.ArrayList;

public class CoffeMachineTest {
	public static void main(String[] args) {
		CoffeeMachine machine = new CoffeeMachine(75);
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(Coin.TEN_CENTS);
		coins.add(Coin.TEN_CENTS);
		coins.add(Coin.FIVE_CENTS);
		coins.add(Coin.TWENTYFIVE_CENTS);
		machine.loadCoins(coins);
		List<Coin> change;
		System.out.println("-----------------------------"); // Aún no se ha
																// cargado café.
		try {
			machine.insertCoin(Coin.ONE_DOLLAR); // Lanza excepción por no tener
													// café.
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			machine.cancelOperation();
		}

		System.out.println("-----------------------------");
		machine.loadCoffee(5); // Se cargan 5 unidades de café.

		System.out.println("-----------------------------");
		try {
			machine.insertCoin(Coin.FIFTY_CENTS); // Se ingresan monedas.
			machine.insertCoin(Coin.FIFTY_CENTS);
			change = machine.takeCoffe(); // Se pide un café y se recibe
											// el vuelto.
			System.out.println("Change:" + change);
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			machine.cancelOperation();
		}

		System.out.println("-----------------------------");
		try {
			machine.insertCoin(Coin.FIFTY_CENTS); // Se ingresan monedas.
			machine.insertCoin(Coin.FIFTY_CENTS);
			machine.insertCoin(Coin.FIFTY_CENTS); // Esta moneda sobra, pero se
													// acepta.
			change = machine.takeCoffe(); // Se pide un café y se recibe el
											// vuelto.
			System.out.println("Change:" + change);
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			machine.cancelOperation();
		}

		System.out.println("-----------------------------");
		try {
			machine.insertCoin(Coin.ONE_DOLLAR); // Se ingresa una moneda.
			change = machine.takeCoffe(); // Se pide un café pero la operación
											// lanza excepción por falta de
											// cambio.
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			machine.cancelOperation(); // se cancela la operación.
		}

		System.out.println("-----------------------------");
		try {
			machine.insertCoin(Coin.FIVE_CENTS); // Se ingresa una moneda
													// insuficiente
			change = machine.takeCoffe(); // Se pide un café pero la operación
			                        // lanza excepción por dinero insuficiente
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			machine.cancelOperation(); se cancela la operación.
		}
	}
}
