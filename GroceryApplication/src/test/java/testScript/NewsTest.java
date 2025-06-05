
package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
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
		newsValue = newspage.enterNews(Constants.addNews);
		newspage.scrollToViewSaveButton().clickOnSaveButton();
		Assert.assertTrue(newspage.isSuccessAlertDisplayed(), Constants.assertion_AddAlert_News);
	}

	@Test(priority = 2)
	public void searchAddedNews() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
				newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox().enterSearchText(newsValue);
		newspage.clickOnSearchSubmitButton();
		String searchStrg = newspage.verifySearchedNews();
		Assert.assertEquals(searchStrg, newsValue,Constants.assertion_Add_News);
	}

	@Test(priority = 3)
	public void resetSearch() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox()
				.enterSearchText(newsValue);
		newspage.clickOnSearchSubmitButton().resetSearchBox();
		boolean searchBxexists = newspage.verifyResetSearchFunctionality();
		Assert.assertFalse(searchBxexists, Constants.assertion_ResetSearch_News);
	}

	@Test(priority = 4)
	public void updateNews() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox().enterSearchText(newsValue);
		newspage.clickOnSearchSubmitButton();
		updatedNewsValue = newspage.editAddedNewsItem(newsValue);
		Assert.assertTrue(newspage.verifyAlertForUpdateFunctionality(),
				Constants.assertion_UpdateAlert_News);

		newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox()
				.enterSearchText(updatedNewsValue);
		newspage.clickOnSearchSubmitButton();
		String searchStrg = newspage.verifySearchedNews();
		Assert.assertEquals(searchStrg, updatedNewsValue, Constants.assertion_Update_News);
	}

	@Test(priority = 5)
	public void deleteNewsItem() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		newspage = homepage.clickOnManageNews().searchNewlyAddedNews().clickOnSearchBox()
				.enterSearchText(updatedNewsValue);
		newspage.clickOnSearchSubmitButton().deleteNewsItem();
		Assert.assertTrue(newspage.isSuccessAlertDisplayed(),
				Constants.assertion_Delete_News);

	}

}
