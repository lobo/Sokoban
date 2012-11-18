package parcial20092.ej2;

import java.util.ArrayList;
import java.util.List;

public class CellPhoneBill {
	private final String number;
	private final List<Call> calls;

	public CellPhoneBill(String number) {
		this.number = number;
		calls = new ArrayList<Call>();
	}

	public void registerCall(String toNumber, int duration) {
		addCall(new Call(this.number, toNumber, duration));
	}

	protected void addCall(Call c) {
		calls.add(c);
	}

	public double processBill() {
		double total = 0;
		for (Call c : calls) {
			total += c.getCost();
		}
		return total;
	}

	public String getNumber() {
		return number;
	}

	public void showCalls() {
		for (Call c : calls) {
			System.out.println(c);
		}
	}
}
