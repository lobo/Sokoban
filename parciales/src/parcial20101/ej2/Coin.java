package parcial20101.ej2;

public enum Coin {
	ONE_DOLLAR(100), FIFTY_CENTS(50), TWENTYFIVE_CENTS(25), TEN_CENTS(10), FIVE_CENTS(
			5);
	private int value;

	private Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
