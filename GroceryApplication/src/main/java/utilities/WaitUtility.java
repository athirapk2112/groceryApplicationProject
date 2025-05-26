 package utilities; 
  
 import java.time.Duration; 
 import java.util.NoSuchElementException; 
  
 import org.openqa.selenium.WebDriver; 
 import org.openqa.selenium.WebElement; 
 import org.openqa.selenium.support.ui.ExpectedConditions; 
 import org.openqa.selenium.support.ui.FluentWait; 
 import org.openqa.selenium.support.ui.Wait; 
 import org.openqa.selenium.support.ui.WebDriverWait; 
  
 public class WaitUtility { 
 	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue, 
 			int total) { 
 		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total)) 
 				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class); 
 		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue)); 
 	} 
 	public void waitForWebElementAlert(WebDriver driver) { 
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
 		wait.until(ExpectedConditions.alertIsPresent()); 
 	} 
 	public void waitForWebElementToBeClickable(WebDriver driver,WebElement element) { 
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
 		wait.until(ExpectedConditions.elementToBeClickable(element)); 
 	} 
 	public void waitForWebElementToBeSelected(WebDriver driver,WebElement element) { 
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
 		wait.until(ExpectedConditions.elementToBeSelected(element)); 
 	} 
 	public void waitForTitleContainsString(WebDriver driver,String title) { 
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
 		wait.until(ExpectedConditions.titleContains(title)); 
 	} 
 	public void waitUntilElementToBeVisible(WebDriver driver,WebElement element) { 
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
 		wait.until(ExpectedConditions.visibilityOf(element)); 
 	} 
 	 
 	public void implicitWait(WebDriver driver) { 
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
 	} 
 }