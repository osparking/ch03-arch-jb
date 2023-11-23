package ju4_runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomTestRunner extends Runner {
	
	private Class<?> testedClass;

	@Override
	public Description getDescription() {
		return Description.createTestDescription(testedClass, 
				this.getClass().getSimpleName() + " 설명");
	}

	@Override
	public void run(RunNotifier notifier) {
		System.out.println("Running tests with " + 
				this.getClass().getSimpleName() + ": " + testedClass);
		
		try {
			Object testObject = 
					testedClass.getDeclaredConstructor().newInstance();
			
			for (Method method : testedClass.getMethods()) {
				if (method.isAnnotationPresent(Test.class)) {
					notifier.fireTestStarted(Description
							.createTestDescription(testedClass, method.getName()));
					method.invoke(testObject);
					notifier.fireTestFinished(Description
							.createTestDescription(testedClass, method.getName()));
				}
			}
		} catch (InstantiationException | IllegalAccessException |
				InvocationTargetException | IllegalArgumentException | 
				NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}
}
