package ju4_runner;

public class Calculator {
	public double add(double num1, double num2) {
		return num1 + num2;
	}
	
	public double sqrt(double x) {
		if (x < 0) {
			throw new IllegalArgumentException("음수는 제곱근을 구할 수 없다.");
		}
		return Math.sqrt(x);
	}
	
	public double div(double ed, double er) {
		if (er == 0) {
			throw new ArithmeticException("영으로 숫자를 나눌 수 없다.");
		}
		return ed/er;
	}
}
