package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();   
	public synchronized static ExtentReports createExtentReports() {    //synch: for thread safety

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //create a path for saving the extent report
		
		reporter.config().setReportName("GroceryApplication");  //to set report name
		extentReports.attachReporter(reporter);   //to attach the spark report configuration to extent report instance to generate extent report
		extentReports.setSystemInfo("Organization", "Obsqura");  //pass system level info
		extentReports.setSystemInfo("Name", "ATHIRA PK ");
		return extentReports;   
	}

}
