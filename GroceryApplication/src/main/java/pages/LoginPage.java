package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtility;

public class LoginPage {
	public String username, password;

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name=\"username\"]")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement loginBtn;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement welcomeLbl;
	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	WebElement incorrectMsgAlert;

	public LoginPage enterUserNameOnUsernamefield(String username) {
		usernamefield.sendKeys(username);
		return new LoginPage(driver);
	}

	public LoginPage enterPasswordOnPasswordfield(String password) {
		passwordfield.sendKeys(password);
		return new LoginPage(driver);
	}

	public HomePage clickOnLoginBtn() {
		loginBtn.click();
		return new HomePage(driver);
	}

	public boolean isHomePageLoaded() {
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		expWait.until(ExpectedConditions.visibilityOf(welcomeLbl));
		return welcomeLbl.isDisplayed();
	}

	public boolean isIncorrectCredentailsAlertDisplayed() {
		return incorrectMsgAlert.isDisplayed();
	}

	public HomePage loginByUsingExcelData() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		usernamefield.sendKeys(username);
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		passwordfield.sendKeys(password);
		loginBtn.click();
		return new HomePage(driver);
	}

	public HomePage loginByUsingExcelDataForInvalidCredentials() throws IOException {

		for (int i = 2; i < 3; i++) {
			for (int j = 1; j < 2; j++) {
				username = ExcelUtility.getStringData(i, j, "LoginPage");
			}
		}

		for (int i = 1; i < 2; i++) {
			for (int j = 1; j < 2; j++) {
				password = ExcelUtility.getStringData(i, j, "LoginPage");
			}
		}
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginBtn.click();
		return new HomePage(driver);
	}

}
