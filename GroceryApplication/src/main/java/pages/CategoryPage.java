
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

public class CategoryPage {

	public WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//input[@placeholder='Enter the Category']")
	WebElement enterCategory;

	@FindBy(xpath = "//li[@id=\"134-selectable\"]")
	WebElement selectGroup;

	@FindBy(xpath = "//input[@name='main_img']")
	WebElement fileUpload;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;

	@FindBy(xpath = "//i[@class=' fa fa-search']")
	WebElement searchbutton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	@FindBy(xpath = "//input[@placeholder='Category']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement categorySearchSubmitButton;

	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover table-sm\"]//tr[1]//td[1]")
	WebElement firstElementInCategorytable;

	@FindBy(xpath = "//a[@class=\"btn btn-default btn-fix\"]")
	WebElement searchResetButton;

	@FindBy(xpath = "//a[@class=\"btn btn-sm btn btn-primary btncss\"]")
	WebElement categoryEdit;

	@FindBy(xpath = "//button[@name=\"update\"]")
	WebElement updateCategoryButton;

	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover table-sm\"]//tr[1]//td[3]")
	WebElement statusColumn;

	@FindBy(xpath = "(//span[@class=\"badge bg-success\"])[1]")
	WebElement activeStatusLink;

	@FindBy(xpath = "(//span[@class=\"badge bg-warning\"])[1]")
	WebElement inaAtiveStatusLink;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;

	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover table-sm\"]//td[1]")
	WebElement searchItem;

	public CategoryPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public String enterCategory(String enterCategoryValue) {
		String categoryValue = enterCategoryValue + generalUtilities.generateCurrentDateAndTime();
		enterCategory.sendKeys(categoryValue);
		return categoryValue;
	}

	public CategoryPage clickOnSelectGroup() {
		selectGroup.click();
		return this;
	}

	public CategoryPage addImageToCategory() {
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(fileUpload, Constants.CP_imageFilePath);
		return this;
	}

	public CategoryPage scrollToViewSaveButton() {

		generalUtilities.scrollUntilElementIsVisible(saveButton, driver);
		return this;
	}

	public CategoryPage clickOnSaveButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		generalUtilities.clickJavaScriptExecutor(saveButton, driver);
		return this;
	}

	public boolean isSuccessAlertDisplayed() {
		return successAlert.isDisplayed();
	}

	// Search the newly added Category
	public CategoryPage searchNewlyAddedCategory() {
		generalUtilities.clickJavaScriptExecutor(searchbutton, driver);
		return this;
	}

	public CategoryPage clickOnSearchBox() {
		searchBox.click();
		return this;
	}

	public CategoryPage enterSearchText(String searchStrng) {
		// String searchText = firstElementInCategorytable.getText();
		searchBox.sendKeys(searchStrng);
		return this;
	}

	public CategoryPage clickOnSearchSubmitButton() {
		categorySearchSubmitButton.click();
		return this;
	}

	public CategoryPage resetSearchBox() {

		generalUtilities.clickJavaScriptExecutor(searchResetButton, driver);
		return this;

	}

	public String editCategoryItem(String enterCategoryValue) {
		categoryEdit.click();
		enterCategory.clear();
		String updatedStr = "Updated" + enterCategoryValue + generalUtilities.generateCurrentDateAndTime();
		enterCategory.sendKeys(updatedStr);
		generalUtilities.clickJavaScriptExecutor(updateCategoryButton, driver);
		return updatedStr;
	}

	public CategoryPage changeTheStatusOfItems() {

		generalUtilities.clickJavaScriptExecutor(activeStatusLink, driver);
		return this;
	}

	public String getUpdatedStatusofCategory() {

		String statusCat = statusColumn.getText();
		return statusCat;
	}

	public CategoryPage deleteCategory() {
		generalUtilities.clickJavaScriptExecutor(deleteButton, driver);
		driver.switchTo().alert().accept();
		return this;

	}

	public String verifySearchedCategory() {
		String searchCatgry = searchItem.getText();
		return searchCatgry;
	}

	public boolean verifyResetSearchFunctionality() {
		boolean isSearchBoxExists = searchBox.isDisplayed();
		return isSearchBoxExists;
	}

}