/**
 * 
 */
package recupParcial20092.ej2;

/**
 * @author daniel
 * 
 */
public class FamilyCellPhone extends CellPhone {

	FamilyCellPhoneGroup group;

	/**
	 * @param group
	 * @param string
	 */
	public FamilyCellPhone(FamilyCellPhoneGroup group, String string) {
		super(string);
		group.addPhone(string);
		this.group = group;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see recupParcial20092.ej2.CellPhone#onCall(java.lang.String)
	 */
	@Override
	protected void onCall(String toNumber) {
		// TODO Auto-generated method stub
	}

	@Override
	public void makeCall(String toNumber) {
		if (!group.canCall(toNumber)) {
			throw new NoCreditException();
		}
		super.makeCall(toNumber);
	}
}
