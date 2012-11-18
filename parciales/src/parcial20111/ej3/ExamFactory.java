import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

package parcial20111.ej3;

public class ExamFactory {
	private final Set<Question> questions = new HashSet<Question>();

	/** Agrega una posible pregunta de examen. */
	public void addQuestion(String caption, double value, boolean answer) {
		add(new Question(caption, value, answer));
	}

	protected void add(Question q) {
		if (questions.contains(q)) {
			throw new IllegalArgumentException("Duplicated question.");
		}
		questions.add(q);
	}

	/** Obtiene la lista completa de preguntas disponibles. */
	public Iterable<Question> getQuestions() {
		return questions;
	}

	/**
	 * Crea un nuevo examen, tomando la cantidad de preguntas recibida por
	 * parámetro al azar.
	 */
	public Exam createExam(int quantity) {
		if (quantity > questions.size()) {
			throw new IllegalArgumentException("Not enough questions.");
		}
		Exam exam = new Exam();
		List<Question> examQuestions = new ArrayList<Question>(questions);
		for (int i = 0; i < quantity; i++) {
			int index = (int) (Math.random() * examQuestions.size());
			exam.addQuestion(examQuestions.remove(index));
		}
		return exam;
	}
}