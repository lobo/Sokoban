package recupParcial20111.ej2;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private final String code;
	private final String client;
	private final Bank bank;
	private double balance;
	private final List<Transaction> transactions = new ArrayList<Transaction>();

	protected Account(Bank bank, String code, String client) {
		this.bank = bank;
		this.code = code;
		this.client = client;
	}

	public void credit(double amount, String date) {
		onTransaction(new CreditTransaction(amount, this, date));
	}

	public void debit(double amount, String date) {
		onTransaction(new DebitTransaction(amount, this, date));
	}

	protected void onTransaction(Transaction tr) {
		double newBalance = tr.apply();
		if (newBalance < 0) {
			throw new IllegalStateException("Not enough money.");
		}
		this.balance = newBalance;
		transactions.add(tr);
		System.out.println(tr.getDescription() + "--> Account " + code
				+ ": Balance: " + balance);
	}

	public void transfer(Account target, double amount, String date) {
		debit(amount, date);
		target.credit(amount, date);
	}

	public void reApplyTransactions() {
		balance = 0;
		for (Transaction tr : transactions) {
			balance = tr.apply();
		}
	}

	public Bank getBank() {
		return bank;
	}

	public String getClient() {
		return client;
	}
	/*
	 * Omitimos aquí el hashcode e equals. Asumir que están escritos
	 * correctamente
	 */
}
