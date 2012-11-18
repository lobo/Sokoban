package recupParcial20111.ej2;

public class CreditTransaction extends Transaction {
	public CreditTransaction(double amount, Account account, String date) {
		super(amount, account, date);
	}

	@Override
	public double apply() {
		return getAccount().getBalance() + getAmount();
	}

	@Override
	public String getDescription() {
		return "Credit " + super.getDescription();
	}
}
