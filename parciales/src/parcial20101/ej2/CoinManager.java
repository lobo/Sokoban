package parcial20101.ej2;

import java.util.List;

public interface CoinManager {
	/**
	 * Agrega una moneda al repositorio de monedas
	 * 
	 * @param coin
	 *            Moneda a agregar
	 */
	public void add(Coin coin);

	/**
	 * Devuelve una lista de monedas que suman la cantidad solicitada. Las
	 * mismas se sacan del repositorio
	 * 
	 * @param value
	 *            Importe solicitado
	 * @throws NoChangeException
	 *             Cuando no tiene monedas suficientes para el importe
	 *             solicitado
	 */
	public List<Coin> releaseCoins(int value) throws NoChangeException;
}
