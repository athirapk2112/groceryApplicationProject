
package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;

public class NewsTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	NewsPage newspage;
	public String newsValue, updatedNewsValue;

	@Test(priority = 1)
	public void verifyAddNews() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		newspage = homepage.clickOnManageNews().clickOnNewButton();
		newsValue = newspage.enterNews("Big Breaking News");
		newspage.scrollToViewSaveButton().clickOnSaveButton();
		Assert.assertTrue(newspage.isSuccessAlertDisplayed(), "Test failed: Success message is not displayed.");
	}

	@Test(priority = 2)
	public void searchCategory() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		System.out.println("New heading : " + newsValue);
		newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox().enterSearchText(newsValue);
		newspage.clickOnSearchSubmitButton();
		String searchStrg = newspage.verifySearchedNews();
		Assert.assertEquals(searchStrg, newsValue, "Test failed:Added news not added to the table");
	}

	@Test(priority = 3)
	public void resetSearch() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		newspage = newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox()
				.enterSearchText(newsValue);
		newspage.clickOnSearchSubmitButton().resetSearchBox();
		boolean searchBxexists = newspage.verifyResetSearchFunctionality();
		Assert.assertFalse(searchBxexists, "Test failed:Reset Functionality is not working");
	}

	@Test(priority = 4)
	public void updateNews() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox().enterSearchText(newsValue);
		newspage.clickOnSearchSubmitButton();
		updatedNewsValue = newspage.editAddedNewsItem(newsValue);
		Assert.assertTrue(newspage.verifyAlertForUpdateFunctionality(),
				"Test failed: Update alert after update action is not displayed.");

		newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox()
				.enterSearchText(updatedNewsValue);
		newspage.clickOnSearchSubmitButton();
		String searchStrg = newspage.verifySearchedNews();
		Assert.assertEquals(searchStrg, updatedNewsValue, "Test failed:Added news not added to the table");
	}

	@Test(priority = 5)
	public void deleteNewsItem() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox()
				.enterSearchText(updatedNewsValue);
		newspage.clickOnSearchSubmitButton().deleteNewsItem();
		Assert.assertTrue(newspage.isSuccessAlertDisplayed(),
				"Test failed: Success alert after delete action is not displayed.");

	}

}
