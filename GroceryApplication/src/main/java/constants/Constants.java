package constants;

public class Constants {
	
	
	public static final String LP_verifyLoginWithValidData = "Login failed for valid credentials";
	public static final String LP_verifyLoginWithInvalidData = "Login failed for Invalid Password and Valid Username";
	public static final String CP_imageFilePath =System.getProperty("user.dir")+"\\src\\test\\resources\\Images\\FriesImg.jpeg";
	public static final String excelSheetPath =System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx";
	public static final String configFile = System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties";
	public static final String assertion_AddNewCat = "Test failed: Success message is not displayed.";
	public static final String assertion_SearchCat = "Test failed: Success message is not displayed.";
	public static final String assertion_ResetCat = "Test failed:Reset Functionality is not working";
	public static final String assertion_UpdateCat = "Test failed:Updated category not added to the table";
	public static final String assertion_UpdateCatgStatusFalseMsg = "Test failed: Status updated message is not displayed";
	public static final String assertion_DeleteCatg= "Test failed: Alert message after delete category not get displayed";
	public static final String assertion_Add_News= "Test failed:Added news not added to the table" ;
	public static final String assertion_AddAlert_News= "Test failed: Success message is not displayed." ;
	public static final String assertion_ResetSearch_News="Test failed:Reset Functionality is not working";
	public static final String assertion_UpdateAlert_News="Test failed: Update alert after update action is not displayed.";
	public static final String assertion_Update_News="Test failed:Added news not added to the table";
	public static final String assertion_Delete_News="Test failed: Success alert after delete action is not displayed.";
	public static final String addNews="Big Breaking News";
	public static final String addCategory="Fries";
	public static final String assertion_UpdateAlert_Conatct="Test failed: Update alert after update action is not displayed.";

}
