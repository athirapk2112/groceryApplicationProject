
package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;

public class ManageContactTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	CategoryPage category;
	ManageContactPage manageContactPage;
	public String newsValue, updatedNewsValue;

	@Test()
	public void updateContact() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		manageContactPage = homepage.clickOnManageContact().clickOnEditButton();
		manageContactPage.inputPrimaryDetails().scrollToViewUpdateButton();
		boolean alertDisplayed = manageContactPage.isSuccessAlertDisplayed();
		Assert.assertTrue(alertDisplayed, Constants.assertion_UpdateAlert_Conatct);
	}
}
