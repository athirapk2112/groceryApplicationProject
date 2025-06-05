package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

//to rerun failed TCs a specify no. of times
public class RetryListener implements IAnnotationTransformer {// implements IAnnotationTransformer
	public void transform(final ITestAnnotation annotation, final Class testClass, final Constructor testConstructor,
			final Method testMethod) {
		annotation.setRetryAnalyzer(retry.Retry.class);// calling the Retry class(resides code for retry action)
	}

}
