package recupParcial20111.ej2;

public class DebitTransaction extends Transaction {
	public DebitTransaction(double amount, Account account, String date) {
		super(amount, account, date);
	}

	@Override
	public double apply() {
		return getAccount().getBalance() - getAmount();
	}

	@Override
	public String getDescription() {
		return "Debit " + super.getDescription();
	}
}
