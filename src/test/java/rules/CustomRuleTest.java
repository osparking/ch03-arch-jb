package rules;

import org.junit.Rule;
import org.junit.Test;

public class CustomRuleTest {
	@Rule
	public CustomRule myRule = new CustomRule();
	
	@Test
	public void test() {
		System.out.println("시험 메소드 호출됨");
	}

}
