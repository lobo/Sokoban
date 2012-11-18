package recupParcial20092.ej2;

public class TestCellPhone {
	public static void main(String[] args) {
		// Crea un grupo con crédito para 2 llamadas.
		FamilyCellPhoneGroup group = new FamilyCellPhoneGroup(2);

		// Crea y agrega tres celulares al grupo.
		CellPhone phone1 = new FamilyCellPhone(group, "111-111");
		CellPhone phone2 = new FamilyCellPhone(group, "222-222");
		CellPhone phone3 = new FamilyCellPhone(group, "333-333");

		phone1.makeCall("222-222"); // Estas dos llamadas no se cobran porque
		phone2.makeCall("111-111"); // son internas al grupo
		phone3.makeCall("555-555");

		// Crea otro grupo con crédito para 2 llamadas.
		FamilyCellPhoneGroup group2 = new FamilyCellPhoneGroup(2);

		// Imprime 1
		System.out.println(group.getAvailableCalls());

		// Imprime 2
		System.out.println(group2.getAvailableCalls());

		// Agrega crédito para 2 llamadas.
		group.loadCredit(2);

		phone1.makeCall("444-444");
		phone2.makeCall("777-777");
		phone3.makeCall("888-888");

		group.showPhones();
		// Imprime:
		// 333-333
		// 222-222
		// 111-111
		phone1.makeCall("555-555"); // Lanza NoCreditException
	}
}
