package automationCore;

import org.testng.annotations.Test;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {

	public WebDriver driver;
	Properties prop;
	FileInputStream fileinpStream;

	@BeforeMethod
	@Parameters("browsers")
	public void initializeBrowser(String browser) throws Exception {
		prop = new Properties();
		fileinpStream = new FileInputStream(Constants.configFile);
		prop.load(fileinpStream);

		if (browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else
			throw new Exception("Invalid Browser");

		driver.get(prop.getProperty("baseurl"));
		driver.manage().window().maximize();
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.implicitWait(driver);

	}

	@AfterMethod
	public void driverQuit(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshotUtility = new ScreenshotUtility();
			screenshotUtility.getScreenshot(driver, itestresult.getName());
		}

		driver.quit();
	}

}
