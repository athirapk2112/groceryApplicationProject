package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import pages.LoginPage;

public class LoginTest extends Base {

	LoginPage login;

	@Test(groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		login = new LoginPage(driver);
		login.loginByUsingExcelData();

		Assert.assertTrue(login.isHomePageLoaded(), Constants.LP_verifyLoginWithValidData);
	}

	@Test(groups = { "smoke" })
	public void verifyUserLoginWithInValidCredentials() throws IOException {
		login = new LoginPage(driver);
		login.loginByUsingExcelDataForInvalidCredentials();

		Assert.assertTrue(login.isIncorrectCredentailsAlertDisplayed(), Constants.LP_verifyLoginWithInvalidData);

	}

	@Test(dataProvider = "InvalidPasswordValidUsername")
	public void verifyUserLoginWithInvalidPasswordValidUsername(String username, String password) {
		login = new LoginPage(driver);
		login.enterUserNameOnUsernamefield(username).enterPasswordOnPasswordfield(password).clickOnLoginBtn();
		Assert.assertTrue(login.isIncorrectCredentailsAlertDisplayed(), Constants.LP_verifyLoginWithInvalidData);

	}

	@DataProvider(name = "InvalidPasswordValidUsername")
	public Object[][] invalidPwdCheck() {
		return new Object[][] { { "admin", "adminn" }, { "admin", "a##3hj" }, { "admin", "1q2w3e4rr" } };

	}
}
