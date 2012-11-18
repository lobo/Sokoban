package parcial2012.ej2;

public class SubwayCentral {
	private double precio;
	
	public SubwayCentral(double precio){
		this.precio = precio;
	}

	public FixedSubwayCard buyFixedSubwayCard(int viajes) {
		FixedSubwayCard card = new FixedSubwayCard(viajes, this.precio);
		return card;
	}

	public void changePrice(double price) {
		setPrecio(price);
	}

	public RechargeableSubwayCard buyRechargeableSubwayCard() {
		RechargeableSubwayCard card = new RechargeableSubwayCard(this);
		return card;
	}
	
	public void setPrecio(double precio){
		this.precio = precio;
	}
	
	public double getPrecio(){
		return precio;
	}

}
