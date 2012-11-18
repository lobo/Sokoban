package parcial20111.ej3;

import java.util.ArrayList;

public class Exam {

	private final List<Question> questions = new ArrayList<Question>();

	void addQuestion(Question question) {
		questions.add(question);
	}

	public double evaluate(List<Boolean> answer) {
		double result = 0.0F;
		for (int i = 0; i < questions.size(); i++) {
			if (questions.get(i).evaluate(answer.get(i))) {
				result += questions.get(i).getValue();
			}
		}
		return result;
	}

	public void print() {
		for (Question q : questions) {
			System.out.println(q.getCaption());
		}
	}
}
