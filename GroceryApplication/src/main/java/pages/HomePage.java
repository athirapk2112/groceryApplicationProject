package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Category']")
	WebElement manageCategoryLink;
	
	@FindBy(xpath="//p[text()='Manage News']")
	WebElement manageNewsLink;
	
	@FindBy(xpath="//p[text()='Manage Product']")
	WebElement manageProductLink;
	
	@FindBy(xpath="//p[text()='Manage Contact']")
	WebElement manageContactLink;
	
	public CategoryPage clickOnCategory()
	{
		manageCategoryLink.click();
		return new CategoryPage(driver);
	}
	public NewsPage clickOnManageNews()
	{
		manageNewsLink.click();
		return new NewsPage(driver);
	}
	public ProductPage clickOnManageProduct()
	{
		manageProductLink.click();
		return new ProductPage(driver);
	}
	public ManageContactPage clickOnManageContact()
	{
		manageContactLink.click();
		return new ManageContactPage(driver);
	}
}
