package ju4_runner;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CustomTestRunner.class)
public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		double result = calculator.add(10, 20);
		assertEquals(result, result, 0);
	}

}
