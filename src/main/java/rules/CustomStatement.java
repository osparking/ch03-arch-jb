package rules;

import java.io.PrintStream;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import lombok.AllArgsConstructor;
import space.jbpark.utility.MyUtil;

@AllArgsConstructor
public class CustomStatement extends Statement {
	private Statement base;
	private Description description;
	private static final PrintStream ps = MyUtil.getPrintStream();
	
	@Override
	public void evaluate() throws Throwable {
		String name = this.getClass().getSimpleName() + 
				" " + description.getMethodName();
		ps.println(name + " 작업 개시" );
		
		try {
			base.evaluate();
		} finally {
			ps.println(name + " 작업 종료");
		}
	}
}
