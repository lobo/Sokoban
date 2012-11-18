/**
 * 
 */
package recupParcial20092.ej2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author daniel
 * 
 */
public class FamilyCellPhoneGroup {

	private int numberofCalls;
	private final Set<String> set;

	public FamilyCellPhoneGroup(int i) {
		this.numberofCalls = i;
		this.set = new HashSet<String>();
	}

	/**
	 * @return
	 */
	public int getAvailableCalls() {
		return numberofCalls;
	}

	/**
	 * @param i
	 */
	public void loadCredit(int i) {
		if (i > 0) {
			numberofCalls += i;
		}
	}

	/**
	 * 
	 */
	public void showPhones() {
		for (String phone : set) {
			System.out.println(phone);
		}
	}

	/**
	 * @param string
	 */
	public void addPhone(String string) {
		set.add(string);
	}

	/**
	 * @param toNumber
	 * @return
	 */
	public boolean canCall(String toNumber) {
		if (set.contains(toNumber)) {
			return true;
		} else if (getAvailableCalls() != 0) {
			numberofCalls--;
			return true;
		}
		return false;
	}

}
