package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import seleniumbasics.Base;

public class FileUploadUtility extends Base{
	
	public void fileUploadUsingSendKeys(WebElement element, String filePath)
	{
			element.sendKeys(filePath);
	}
	
	public void fileUploadUsingRobotClass(WebElement element,WebElement TextBxElement,String Filepath) throws AWTException
	{
		Actions actions = new Actions(driver);
		actions.click(TextBxElement).perform();
		StringSelection strselection = new StringSelection(Filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null); 
		Robot robot = new Robot();
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
