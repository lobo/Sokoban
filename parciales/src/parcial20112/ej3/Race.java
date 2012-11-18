package parcial20112.ej3;

import java.util.HashMap;
import java.util.Map;

public class Race {
	private final Map<String, Participant> participants = new HashMap<String, Participant>();

	/**
	 * Agrega a un participante a la carrera, especificando el nombre y la edad.
	 */
	public void addParticipant(String name, int age) {
		if (participants.containsKey(name)) {
			throw new IllegalArgumentException("Duplicated participant!");
		}
		participants.put(name, new Participant(name, age));
	}

	/** Registra la hora en la que un participante pasa por la largada. */
	public void registerStartTime(String participant, long time) {
		getParticipant(participant).start(time);
	}

	/** Registra la hora en la que un participante cruza la meta. */
	public void registerEndTime(String participant, long time) {
		getParticipant(participant).end(time);
	}

	/** Obtiene el tiempo total de carrera del participante. */
	public double getTotalTime(String participant) {
		return getParticipant(participant).getTotalTime();
	}

	/** Obtiene un participante existente a partir de su nombre. */
	protected Participant getParticipant(String name) {
		Participant participant = participants.get(name);
		if (participant == null) {
			throw new IllegalArgumentException("Invalid participant name");
		}
		return participant;
	}

	/**
	 * Imprime la lista de todos los participantes inscriptos, indicando el
	 * nombre y el tiempo neto de cada uno.
	 */
	public void printParticipants() {
		printParticipants(participants.values());
	}

	/**
	 * Imprime por consola el nombre y el tiempo neto de un grupo de
	 * participantes.
	 */
	protected void printParticipants(Iterable<Participant> part) {
		for (Participant p : part) {
			System.out.println(p.getName() + " "
					+ (p.hasTime() ? p.getTotalTime() : "--"));
		}
	}
}
