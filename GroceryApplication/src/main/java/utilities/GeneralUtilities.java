package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	// basic selenium commands like dropdown handling, alert,etc

	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void scrollDownUsingJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;// casting instance of webDriver instance into the
															// JavascriptExecutor interface to use the class methods
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void selectSingleCheckbox(WebElement element) {
		boolean ischeckboxselect = element.isSelected();
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void selectMultipleCheckbox(List<WebElement> elements) {
		for (WebElement a : elements) {
			if (!a.isSelected()) {
				a.click();
			}

		}

	}

	public void simpleAlertAccept(WebElement element, WebDriver driver) {
		element.click();
		driver.switchTo().alert().accept();
	}

	public void confirmationAlertAccept(WebElement element, WebDriver driver) {
		element.click();
		driver.switchTo().alert().accept();
	}

	public void confirmationAlertDismiss(WebElement element, WebDriver driver) {
		element.click();
		driver.switchTo().alert().dismiss();
	}

	public void promptAlertAccept(WebElement element, WebDriver driver) {
		element.click();
		driver.switchTo().alert().dismiss();
	}

	public String promptAlertgetText(WebElement element, String inputString, WebDriver driver) {
		driver.switchTo().alert().sendKeys(inputString);
		String txtInsideAlert = driver.switchTo().alert().getText();
		return txtInsideAlert;

	}

	public void promptAlertDismiss(WebElement element, WebDriver driver) {
		element.click();
		driver.switchTo().alert().dismiss();
	}

	public String tableElementSearch(String searchString, WebElement tableElement) {
		List<WebElement> list = (List<WebElement>) tableElement;
		int flag = 0;
		for (WebElement a : list) {
			if (a.getText().equalsIgnoreCase(searchString)) {
				flag = 1;
				break;
			}

		}

		if (flag == 1)
			return searchString + " found in the table";
		else
			return searchString + " not found in the table";

	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

	public void scrollUntilElementIsVisible(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();", element);
	}

}
