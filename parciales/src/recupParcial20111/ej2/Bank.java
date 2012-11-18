package recupParcial20111.ej2;

import java.util.HashSet;
import java.util.Set;

public class Bank {
	private final String name;
	private final Set<Account> accounts;

	public Bank(String name) {
		this.name = name;
		this.accounts = new HashSet<Account>();
	}

	public Account openAccount(String code, String client) {
		Account account = createAccount(code, client);
		if (accounts.contains(account)) {
			throw new IllegalArgumentException("Duplicated client.");
		}
		accounts.add(account);
		return account;
	}

	protected Account createAccount(String code, String client) {
		return new Account(this, code, client);
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public String getName() {
		return name;
	}
}
