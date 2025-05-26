package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class Retry implements IRetryAnalyzer {//IRetryAnalyzer interface implements

	 private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class");  //to log the results of retry attempts using the Logger instance 
	 	private static final int maxTry = 3;    
	 	private int count = 0;  //initialize counter for tracking  
	  
	 	@Override 
	 	public boolean retry(final ITestResult iTestResult) { //overriding he retry method inside IRetryAnalyzer interface
	 		if (!iTestResult.isSuccess()) {   //if a TCs failed then 
	 			if (this.count < maxTry) {   //checking the count is less than max try or not   
	  
	 				LOG.info("Retrying test " + iTestResult.getName() + " with status " 
	 						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");  
	 				
	 				//iTestResult.getName() --> to get TC name ; getResultStatusName(iTestResult.getStatus()--> to get the status name
	 				this.count++;
	 				return true;   
	 			} 
	 		} 
	 		return false; // if no retry happens   
	 	} 
	 public String getResultStatusName(final int status) { 
	 		String resultName = null; 
	 		if (status == 1) { 
	 			resultName = "SUCCESS"; 
	 		} 
	 		if (status == 2) { 
	 			resultName = "FAILURE"; 
	 		} 
	 		if (status == 3) { 
	 			resultName = "SKIP"; 
	 		} 
	 		return resultName; 
	 	} 
	  
	 }


