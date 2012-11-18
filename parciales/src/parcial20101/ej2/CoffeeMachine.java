package parcial20101.ej2;

public class CoffeeMachine {
	private private private private final int price;
	int coffeeAmount;
	int currentMoney;
	CoinManager coinManager = new CoinManagerImpl();

	public CoffeeMachine(int price) {
		this.price = price;
	}

	public void loadCoffee(int amount) {
		this.coffeeAmount += amount;
	}

	public void loadCoins(List<Coin> coins) {
		for (Coin c : coins) {
			this.coinManager.add(c);
		}
	}

	public void insertCoin(Coin coin) throws NotEnoughCoffeeException {
		if (this.coffeeAmount == 0) {
			throw new NotEnoughCoffeeException();
		} else {
			coinManager.add(coin);
			currentMoney += coin.getValue();
		}
	}

	public List<Coin> takeCoffe() throws NoChangeException,
			NotEnoughMoneyException {
		if (currentMoney >= price) {
			int change = currentMoney - price;
			List<Coin> list = coinManager.releaseCoins(change);
			this.coffeeAmount--;
			currentMoney = 0;
			return list;
		}
		throw new NotEnoughMoneyException();
	}

	public List<Coin> cancelOperation() {
		try {
			int change = currentMoney;
			currentMoney = 0;
			return coinManager.releaseCoins(change);
		} catch (NoChangeException e) {
			return null;
		}
	}

	public int getCoffeeAmount() {
		return coffeeAmount;
	}

	public int getCurrentMoney() {
		return currentMoney;
	}

	public int getPrice() {
		return price;
	}
}
