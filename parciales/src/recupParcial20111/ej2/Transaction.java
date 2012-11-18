package recupParcial20111.ej2;

public abstract class Transaction {
	private final double amount;
	private final Account account;
	private final String date;

	public Transaction(double amount, Account account, String date) {
		this.amount = amount;
		this.account = account;
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public double getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public String getDescription() {
		return amount + " on " + date;
	}

	public abstract double apply();
}
