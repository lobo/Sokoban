package recupParcial20092.ej2;

public abstract class CellPhone {
	private final String number;
	private boolean isEnabled;

	public CellPhone(String number) {
		this.number = number;
		this.isEnabled = true;
	}

	public void enable() {
		this.isEnabled = true;
	}

	public void disable() {
		this.isEnabled = false;
	}

	public void makeCall(String toNumber) {
		if (!isEnabled) {
			throw new DisabledCellPhoneException();
		}
		onCall(toNumber);
	}

	public String getNumber() {
		return number;
	}

	protected abstract void onCall(String toNumber);

	@Override
	public String toString() {
		return number;
	}

	@Override
	public int hashCode() {
		return number.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CellPhone)) {
			return false;
		}
		return number.equals(((CellPhone) obj).number);
	}
}
