
package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;

public class NewsPage {

	public WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	public NewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-danger\"]")
	WebElement newButton;

	@FindBy(xpath = "//textarea[@id=\"news\"]")
	WebElement inutNewsTxtArea;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement saveBtn;

	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-primary\"]")
	WebElement searchBtn;

	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-warning\"]")
	WebElement resetBtn;

	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement successAlert;

	@FindBy(xpath = "//input[@name=\"un\"]")
	WebElement newsSearchTxtBx;

	@FindBy(xpath = "//button[@class=\"btn btn-danger btn-fix\"]")
	WebElement newsSearchBtn;

	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover table-sm\"]//td[1]")
	WebElement searchItem;

	@FindBy(xpath = "//a[text()='Reset']")
	WebElement searchResetBtn;

	@FindBy(xpath = "(//i[@class=\"fas fa-edit\"])[2]")
	WebElement editNewsBtn;

	@FindBy(xpath = "//button[@name=\"update\"]")
	WebElement updateBtn;

	@FindBy(xpath = "(//a[@class=\"btn btn-sm btn btn-danger btncss\"])[1]")
	WebElement deleteNewsBtn;

	public NewsPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public String enterNews(String enterNewsValue) {
		String newsStringValue = enterNewsValue + generalUtilities.generateCurrentDateAndTime();
		inutNewsTxtArea.sendKeys(newsStringValue);
		return newsStringValue;
	}

	public NewsPage scrollToViewSaveButton() {

		generalUtilities.scrollUntilElementIsVisible(saveBtn, driver);
		return this;
	}

	public NewsPage clickOnSaveButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		generalUtilities.clickJavaScriptExecutor(saveBtn, driver);
		return this;
	}

	public boolean isSuccessAlertDisplayed() {
		return successAlert.isDisplayed();
	}

	public NewsPage searchNewlyAddedNews() {
		generalUtilities.clickJavaScriptExecutor(searchBtn, driver);
		return this;
	}

	public NewsPage clickOnSearchBox() {
		newsSearchTxtBx.click();
		return this;
	}

	public NewsPage enterSearchText(String newsValue) {
		newsSearchTxtBx.sendKeys(newsValue);
		return this;
	}

	public NewsPage clickOnSearchSubmitButton() {
		newsSearchBtn.click();
		return this;
	}

	public String verifySearchedNews() {
		String searchNews = searchItem.getText();
		return searchNews;
	}

	public NewsPage resetSearchBox() {

		generalUtilities.clickJavaScriptExecutor(searchResetBtn, driver);
		return this;
	}

	public boolean verifyResetSearchFunctionality() {
		boolean isSearchBoxExists = newsSearchTxtBx.isDisplayed();
		return isSearchBoxExists;
	}

	public String editAddedNewsItem(String enterNewsValue) {
		editNewsBtn.click();
		inutNewsTxtArea.clear();
		String updatedNews = enterNewsValue + "Update" + generalUtilities.generateCurrentDateAndTime();
		inutNewsTxtArea.sendKeys(updatedNews);
		generalUtilities.clickJavaScriptExecutor(updateBtn, driver);
		return updatedNews;
	}

	public String getUpdatedNewHeading(String enterNewsValue) {
		editNewsBtn.click();
		inutNewsTxtArea.clear();
		String updatedNews = enterNewsValue + "Update" + generalUtilities.generateCurrentDateAndTime();
		inutNewsTxtArea.sendKeys(updatedNews);
		generalUtilities.clickJavaScriptExecutor(updateBtn, driver);
		return updatedNews;
	}

	public boolean verifyAlertForUpdateFunctionality() {
		boolean updateAlert = successAlert.isDisplayed();
		return updateAlert;

	}

	public NewsPage deleteNewsItem() {
		generalUtilities.clickJavaScriptExecutor(deleteNewsBtn, driver);
		driver.switchTo().alert().accept();
		return this;

	}

}