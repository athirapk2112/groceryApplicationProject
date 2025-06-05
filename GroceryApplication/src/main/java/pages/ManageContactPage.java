
package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageContactPage {

	public WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class=\"btn btn-sm btn btn-primary btncss\"]")
	WebElement editBtn;

	@FindBy(xpath = "//input[@id=\"phone\"]")
	WebElement phoneTxtBox;

	@FindBy(xpath = "//input[@id=\"email\"]")
	WebElement emailTxtBox;

	@FindBy(xpath = "//textarea[@name=\"address\"]")
	WebElement addressTxtArea;

	@FindBy(xpath = "//textarea[@name=\"del_time\"]")
	WebElement delTimeTxtArea;

	@FindBy(xpath = "//input[@id=\"del_limit\"]")
	WebElement delLimitTxtBx;

	@FindBy(xpath = "//button[@name=\"Update\"]")
	WebElement btnUpdate;

	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement successUpdateAlert;

	public ManageContactPage clickOnEditButton() {
		generalUtilities.clickJavaScriptExecutor(editBtn, driver);
		return this;
	}

	public ManageContactPage inputPrimaryDetails() {
		FakerUtility fakerUtility = new FakerUtility();
		String phoneNo = fakerUtility.generatePhoneNumber();
		String address = fakerUtility.generateAddress();
		String email = fakerUtility.generateEmail();
		phoneTxtBox.clear();
		emailTxtBox.clear();
		addressTxtArea.clear();
		phoneTxtBox.sendKeys(phoneNo);
		emailTxtBox.sendKeys(email);
		addressTxtArea.sendKeys(address);
		return this;
	}

	public ManageContactPage scrollToViewUpdateButton() {

		generalUtilities.scrollUntilElementIsVisible(btnUpdate, driver);
		return this;
	}

	public boolean isSuccessAlertDisplayed() {
		return successUpdateAlert.isDisplayed();
	}

}