package parcial20102.ej2;

public class EvaluatorTest {
	public static void main(String[] args) {
		SimpleExpression exp1 = new SimpleExpression(true);
		SimpleExpression exp2 = new SimpleExpression(false);

		Expression exp3 = exp1.not();
		Expression exp4 = exp1.or(exp2);
		Expression exp5 = exp3.and(exp4);
		Expression exp6 = exp3.or(exp4);
		Expression exp7 = exp4.not();

		System.out.println(exp1.evaluate()); // true
		System.out.println(exp3.evaluate()); // false
		System.out.println(exp4.evaluate()); // true
		System.out.println(exp5.evaluate()); // false

		exp1.setValue(false);

		System.out.println(exp3.evaluate()); // true
		System.out.println(exp4.evaluate()); // false
		System.out.println(exp5.evaluate()); // false

		exp2.setValue(true);

		System.out.println(exp5.evaluate()); // true
	}
}
