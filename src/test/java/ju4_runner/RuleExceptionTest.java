package ju4_runner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

public class RuleExceptionTest {

	private Calculator calculator = new Calculator();

	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException expectedException = ExpectedException.none(); // null; //

	@Test
	public void expectIllegalArgumentException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("음수는 제곱근을 구할 수 없다.");
		calculator.sqrt(-1);
	}
	
	@Test
	public void expectArithmaticException() {
		expectedException.expect(ArithmeticException.class);
		expectedException.expectMessage("영으로 숫자를 나눌 수 없다.");
		calculator.div(1, 0);
	}
}
