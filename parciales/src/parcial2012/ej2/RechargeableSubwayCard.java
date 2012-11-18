package parcial2012.ej2;

import java.util.ArrayList;

public class RechargeableSubwayCard extends Card {
	private double saldo;
	private SubwayCentral central;
	
	public RechargeableSubwayCard(SubwayCentral central) {
		super();
		this.central = central;
		this.saldo = 0;
	}

	@Override
	public void register(String string) {
		if (saldo >= central.getPrecio()) {
			super.getList().add(new Viaje(central.getPrecio(), string));
			saldo -= central.getPrecio();
		}
		else {
			throw new RideDeniedException();
		}
	}

	public void charge(double carga) {
		saldo = carga;
		super.getList().add(new Viaje("Recarga " + "($-" + carga + ")"));
	}

}
