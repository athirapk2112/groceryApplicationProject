package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationCore.Base;
import utilities.ExtentReportUtility;

//this is an interface used to listen events and act upon

public class Listeners extends Base implements ITestListener{//ITestListener interface has a lot of methods, Listeners class override the ITestListener interface methods
	ExtentTest test;   
 	ExtentReports extent = ExtentReportUtility.createExtentReports();   //
  
 	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();  //for thread safety when parallel run ha[ppens
  
 	public void onTestStart(ITestResult result) {    //implementing the ITestListener methods
  
 		ITestListener.super.onTestStart(result);   //parent method invokation 
 		test = extent.createTest(result.getMethod().getMethodName());   
 		extentTest.set(test);  	}  
 	public void onTestSuccess(ITestResult result) { 
  
 		ITestListener.super.onTestSuccess(result); 
 		extentTest.get().log(Status.PASS, "Test Passed"); //whenever a test is success and log the test status in report
 	} 
  
 	public void onTestFailure(ITestResult result) { 
  
 		ITestListener.super.onTestFailure(result); 
 		extentTest.get().log(Status.FAIL, "Test Failed"); 
 		extentTest.get().fail(result.getThrowable()); 
 		WebDriver driver = null; 
 		String testMethodName = result.getMethod().getMethodName(); 
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (IllegalArgumentException e) { 
  
 			e.printStackTrace(); 
 		} catch (IllegalAccessException e) { 
  
 			e.printStackTrace(); 
 		} catch (NoSuchFieldException e) { 
  
 			e.printStackTrace(); 
 		} catch (SecurityException e) { 
  
 			e.printStackTrace(); 
 		} 
  
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (Exception e) { 
 		} 
 	} 
   
  
 	public void onTestSkipped(ITestResult result) {
  
 	ITestListener.super.onTestSkipped(result); 
 		extentTest.get().log(Status.SKIP, "Test Skipped"); 
 		//String testMethodName = result.getMethod().getMethodName(); 
 	} 
  
 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   
 		ITestListener.super.onTestFailedButWithinSuccessPercentage(result); 
 	} 
  
 	public void onTestFailedWithTimeout(ITestResult result) {  //Called if a test fails due to a timeout 
  
 		ITestListener.super.onTestFailedWithTimeout(result); 
 	} 
  
 	public void onStart(ITestContext context) {  //Called at the start of a test context (e.g., suite or test tag in testng.xml). 
  
 		ITestListener.super.onStart(context); 
 	} 
  
 	public void onFinish(ITestContext context) {   //Called at the end of the test context. 
  
 		ITestListener.super.onFinish(context);  //Called at the end of the test context. 
 		extent.flush();  //extent.flush() saves and writes all the collected logs and test details into the final report. 
 	} 
 }

