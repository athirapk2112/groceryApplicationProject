package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	//to capture current state using TakesScreenshot interface
	//mostly used for failed test cases
	 public void getScreenshot(WebDriver driver, String failedtestcase) throws IOException { 
	 		TakesScreenshot scrShot = (TakesScreenshot) driver; //casting driver to TakeScreenshot interface to enable TakeScreenshot functionality   
	 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //screenshot is captured and stored as temp file
	 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); // to make screenshot unique generate screenshot name in this format  
	 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");  // to store the screenshot inside a folder under project main directory ; System.getProperty("user.dir")--> to get project directory
	 		if (!f1.exists()) { // checking such a directory exists or not; if not then create a new dir
	 			f1.mkdirs();    //mkdir --> will create folder using java 
	 		} 
	 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedtestcase + timeStamp 
	 				+ ".png";  //to make name of the screenshot with TC name , date and time along with the extension png
	 		File finalDestination = new File(destination); 
	 		FileHandler.copy(screenShot, finalDestination);//to copy the screenshot from tmp path to project folder; once copying is completed the tmp storage will get deleted
	 }
		 }
