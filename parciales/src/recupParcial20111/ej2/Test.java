package recupParcial20111.ej2;

import javax.naming.LimitExceededException;

public class Test {
	public static void main(String[] args) {
		SpecialBank bank1 = new SpecialBank("Banco 1", 1000.0); /*
																 * Limite de
																 * retiro 1000
																 */
		Bank bank2 = new Bank("Banco 2");
		Account account1 = bank1.openAccount("001", "Juan");
		Account account2 = bank1.openAccount("002", "Ana");
		Account account3 = bank2.openAccount("003", "Pablo");
		account1.credit(3000.0, "2011-06-20");
		account2.credit(2500.0, "2011-06-20");
		account3.credit(3500.0, "2011-06-21");
		account1.debit(600, "2011-06-24");
		account1.debit(700, "2011-06-25");
		account2.debit(1000, "2011-06-25");
		account1.debit(200, "2011-06-25");
		try {
			account1.debit(200, "2011-06-25");
		} catch (LimitExceededException e) {
			System.out.println("Can't debit $200 from account 001");
		}
		try {
			account1.transfer(account2, 500, "2011-06-25");
		} catch (LimitExceededException e) {
			System.out
					.println("Can't transfer $500 from account 001 to account 002");
		}
		account2.transfer(account1, 500, "2011-06-26");
		bank1.payInterest(1.05, "2011-06-27");
		try {
			account2.transfer(account3, 500, "2011-06-27");
		} catch (LimitExceededException e) {
			System.out
					.println("Can't transfer $500 from account 002 to account 003");
		}
	}
}
