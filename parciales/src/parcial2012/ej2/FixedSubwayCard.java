package parcial2012.ej2;

public class FixedSubwayCard extends Card {
	private int viajes;
	private double precio;
	
	public FixedSubwayCard(int viajes, double precio){
		this.viajes = viajes;
		this.precio = precio;
	}
	
	@Override
	public void register(String string) {
		if (viajes > 0) {
			super.getList().add(new Viaje(precio, string));
			viajes--;
		}
		else {
			throw new RideDeniedException();
		}
	}
	
	public void setViajes(int viajes) {
		this.viajes = viajes;
	}

}
