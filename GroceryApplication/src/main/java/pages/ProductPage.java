
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
  
 public class ProductPage { 
  
 	public WebDriver driver; 
 	GeneralUtilities generalUtilities = new GeneralUtilities(); 
 	 
 	public ProductPage(WebDriver driver) { 
 		this.driver= driver; 
 		PageFactory.initElements(driver,this); 
 	} 
 	 
 	@FindBy(xpath="//a[@class=\"btn btn-rounded btn-danger\"]") 
 	WebElement newButton; 
 	
 	@FindBy(xpath="//textarea[@id=\"news\"]")
 	WebElement inutNewsTxtArea;

 	@FindBy(xpath="//button[@type=\"submit\"]")
 	WebElement saveBtn;
 	 
 	@FindBy(xpath="//a[text()='Cancel']")
 	WebElement cancelBtn;
 	
 	@FindBy(xpath="//a[@class=\"btn btn-rounded btn-primary\"]")
 	WebElement searchBtn;
 	
 	@FindBy(xpath="//a[@class=\"btn btn-rounded btn-warning\"]")
 	WebElement resetBtn;
 	
 	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
 	WebElement successAlert;
 	
 	@FindBy(xpath="//input[@name=\"un\"]")
 	WebElement newsSearchTxtBx;
 	
 	@FindBy(xpath="//button[@class=\"btn btn-danger btn-fix\"]")
 	WebElement  newsSearchBtn;
 	
 	@FindBy(xpath="//table[@class=\"table table-bordered table-hover table-sm\"]//td[1]")
 	WebElement searchItem;
 	
 	@FindBy(xpath="//a[text()='Reset']")
 	WebElement searchResetBtn;
 	
 	@FindBy(xpath="(//i[@class=\"fas fa-edit\"])[2]")
 	WebElement editNewsBtn;
 	
 	@FindBy(xpath="//button[@name=\"update\"]")
 	WebElement updateBtn;
 	
 	@FindBy(xpath="(//a[@class=\"btn btn-sm btn btn-danger btncss\"])[1]")
 	WebElement deleteNewsBtn;
 	
 	
 	public ProductPage clickOnNewButton() { 
 		newButton.click(); 
 		return this; 
 	} 

 
 }