package parcial20092.ej2;

public class TestCellPhoneBill {
	public static void main(String[] args) {
		FriendCellPhoneBill bill = new FriendCellPhoneBill("1234");

		bill.setPercentage(0.5);

		bill.registerCall("1111", 200);
		bill.registerCall("2222", 100);

		// Muestra "Costo: 3.0" ya que son 300 segundos por el costo (0.01)
		System.out.println("Costo: " + bill.processBill());

		bill.addFriend("1111");

		// Muestra "Costo: 3.0" ya que no se agregaron nuevas llamadas
		System.out.println("Costo: " + bill.processBill());

		bill.setPercentage(0.25);
		bill.registerCall("1111", 400);

		// Muestra "Costo: 4.0" porque se agregó una llamada de 400 segundos
		// pero solo se cobra el 25% de la misma por ser número amigo
		System.out.println("Costo: " + bill.processBill());

		bill.removeFriend("1111");
		bill.registerCall("1111", 400);

		// Muestra "Costo: 8.0" porque a lo anterior se agrega una nueva llamada
		// de 400 segundos y el numero dejó de ser amigo
		System.out.println("Costo: " + bill.processBill());

		bill.showCalls(); // Muestra lo siguiente
							// Call from:1234 to: 1111(200 seconds)
							// Call from:1234 to: 2222(100 seconds)
							// Call from:1234 to: 1111(400 seconds)0.25%
							// Call from:1234 to: 1111(400 seconds)

		bill.addFriend("1111");
		bill.addFriend("2222");
		bill.addFriend("3333");

		// Muestra "Costo: 9.0" porque a lo anterior se agrega una nueva llamada
		// de 400 segundos y el numero es amigo
		bill.registerCall("3333", 400);
		System.out.println("Costo: " + bill.processBill());

		bill.addFriend("4444"); // Se produce TooManyFriendsException
	}
}
