import java.util.Arrays;

package parcial20111.ej3;

public class ExamFactoryTest {
	public static void main(String[] args) {

		EnhancedExamFactory factory = new EnhancedExamFactory();
		factory.addQuestion("Pregunta 1", 0.5, true);
		factory.addQuestion("Pregunta 2", 1, false);
		factory.addQuestion("Pregunta 3", 0.2, true);
		factory.addQuestion("Pregunta 4", 0.8, true);
		factory.addQuestion("Pregunta 5", 1, true);

		Exam exam = factory.createExam(3); /*
											 * Crea un examen con 3 preguntas al
											 * azar. Para este ejemplo vamos a
											 * suponer que contiene: - Pregunta
											 * 2 - Pregunta 3 - Pregunta 5
											 */

		System.out.println(exam.evaluate(Arrays.asList(true, false, true))); // 1.0
		System.out.println(exam.evaluate(Arrays.asList(false, false, true))); // 2.0
		System.out.println(exam.evaluate(Arrays.asList(false, false, false))); // 1.0
		System.out.println(exam.evaluate(Arrays.asList(true, true, true))); // 1.2

		exam = factory.createExam(2); /*
									 * Crea un examen con 2 preguntas al azar.
									 * Para este ejemplo, contiene: - Pregunta 2
									 * - Pregunta 4
									 */

		System.out.println(exam.evaluate(Arrays.asList(false, false))); // 1.0
		factory.printRanking(); /*
								 * Imprime: Pregunta 4 (0.0) Pregunta 3 (0.25)
								 * Pregunta 2 (0.6) Pregunta 5 (0.75)
								 */
	}
}
