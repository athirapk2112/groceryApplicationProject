
package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	CategoryPage category;
	public String categoryValue, updatedCategoryValue;

	@Test(priority = 1, groups = { "smoke" })
	public void verifyAddNewCategoryWithValidDetails() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		category = homepage.clickOnCategory().clickOnNewButton();
		categoryValue = category.enterCategory(Constants.addCategory);
		category.clickOnSelectGroup().addImageToCategory().scrollToViewSaveButton().clickOnSaveButton();
		Assert.assertTrue(category.isSuccessAlertDisplayed(), Constants.assertion_AddNewCat);
	}

	@Test(priority = 2, groups = { "smoke" })
	public void searchCategory() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		category = homepage.clickOnCategory().searchNewlyAddedCategory().clickOnSearchBox()
				.enterSearchText(categoryValue).clickOnSearchSubmitButton();
		String searchStrg = category.verifySearchedCategory();
		Assert.assertEquals(searchStrg, categoryValue, Constants.assertion_SearchCat);
	}

	@Test(priority = 3)

	public void resetSearch() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		category = homepage.clickOnCategory().searchNewlyAddedCategory().clickOnSearchBox()
				.enterSearchText(categoryValue).clickOnSearchSubmitButton().resetSearchBox();
		boolean searchBxexists = category.verifyResetSearchFunctionality();
		Assert.assertFalse(searchBxexists, Constants.assertion_ResetCat);

	}

	@Test(priority = 4)
	public void updateCategory() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		category = homepage.clickOnCategory();
		updatedCategoryValue = category.editCategoryItem(categoryValue);
		Assert.assertTrue(category.isSuccessAlertDisplayed(),
				"Test failed: Update alert after update action is not displayed.");

		category = homepage.clickOnCategory().searchNewlyAddedCategory().clickOnSearchBox()
				.enterSearchText(updatedCategoryValue).clickOnSearchSubmitButton();
		String searchStrg = category.verifySearchedCategory();
		Assert.assertEquals(searchStrg, updatedCategoryValue, Constants.assertion_UpdateCat);
	}

	@Test(priority = 5)
	public void changeStatusOfItem() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		category = homepage.clickOnCategory().searchNewlyAddedCategory().clickOnSearchBox()
				.enterSearchText(categoryValue).clickOnSearchSubmitButton();
		category.changeTheStatusOfItems();
		String updatedStatus = category.getUpdatedStatusofCategory();
		Assert.assertEquals(updatedStatus, "Inactive", Constants.assertion_UpdateCat);
		Assert.assertTrue(category.isSuccessAlertDisplayed(), Constants.assertion_UpdateCatgStatusFalseMsg);
	}

	@Test(priority = 6)
	public void deleteCategoryItem() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		category = homepage.clickOnCategory().searchNewlyAddedCategory().clickOnSearchBox()
				.enterSearchText(updatedCategoryValue).clickOnSearchSubmitButton().deleteCategory();
		Assert.assertTrue(category.isSuccessAlertDisplayed(), Constants.assertion_DeleteCatg);
	}

}
