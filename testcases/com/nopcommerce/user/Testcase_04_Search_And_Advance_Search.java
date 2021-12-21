package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageUIs.liveGuru.HomePageUI;
import pageUIs.nopCommerce.user.MyProductReviewPageUI;

public class Testcase_04_Search_And_Advance_Search extends BaseTest {
	
	
	private WebDriver driver;
	
	private String firstName, lastName,
	existingEmail,validPassword,inputInvalidDataSearch,inputExactlyDataSearch,inputDataSearchParentCategory,
	inputCategory,inputHPManufactor,inputAppleManufactor,inputRelativeDataSearch;
	private UserHomePageObject homePage ;
	private UserRegisterPageObject registerPage ;
	private UserLoginPageObject loginPage;
	private UserCustomerInForPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserSearchPageObject searchPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName="Automation";
		lastName="FC";
		validPassword = "123456";
		existingEmail = "auto" + generateFakeNumber() + "@mail.com";
		inputInvalidDataSearch="Mac Book Pro 2050";
		inputRelativeDataSearch="Lenovo";
		inputExactlyDataSearch="Thinkpad X1 Carbon Laptop";
		inputDataSearchParentCategory="Apple MacBook Pro";
		inputCategory="Computers";
		inputHPManufactor="HP";
		inputAppleManufactor="Apple";
	
		
		
		System.out.println("Precondition - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		
		
		System.out.println("Precondition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Precondition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Precondition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		System.out.println("Precondition - Step 05: Click to Logout link");
		homePage =registerPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();
		
	}

	@Test
	public void Testcase_01_Search_With_Empty_Data() {
		searchPage=homePage.openSearchPage();
		searchPage.clickSearchButton();
		Assert.assertEquals(searchPage.getErrorMessageUserPage(), "Search term minimum length is 3 characters");
		

	}

	@Test
	public void Testcase_02_Search_With_Invalid_Data() {
		searchPage=homePage.openSearchPage();
		searchPage.inputDataSearchTextBox(inputInvalidDataSearch);
		searchPage.clickSearchButton();
		Assert.assertEquals(searchPage.getErrorInvalidDataMessageUserPage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Testcase_03_Search_With_Relative_Data() {
		searchPage=homePage.openSearchPage();
		searchPage.inputDataSearchTextBox(inputRelativeDataSearch);
		searchPage.clickSearchButton();
		
		Assert.assertEquals(searchPage.getProductText(), "Lenovo IdeaCentre 600 All-in-One PC\n$500.00\nADD TO CART Add to compare list Add to wishlist\nLenovo Thinkpad X1 Carbon Laptop\n$1,360.00\nADD TO CART Add to compare list Add to wishlist");
		
	}

	@Test
	public void Testcase_04_Search_With_Valid_Data() {
		searchPage=homePage.openSearchPage();
		searchPage.inputDataSearchTextBox(inputExactlyDataSearch);
		searchPage.clickSearchButton();
		Assert.assertEquals(searchPage.getDataAfterSearch(), "Lenovo Thinkpad X1 Carbon Laptop");
		
	}
	
	@Test
	public void Testcase_05_Advance_Search_Parent_Category() {
		searchPage=homePage.openSearchPage();
		searchPage.inputDataSearchTextBox(inputDataSearchParentCategory);
		searchPage.checkAdvanceSearch();
		searchPage.selectCategoryDropDownList(inputCategory);
		searchPage.clickSearchButton();
		Assert.assertEquals(searchPage.getErrorInvalidDataMessageUserPage(), "No products were found that matched your criteria.");
		
	}

	@Test
	public void Testcase_06_Advance_Search_Sub_Category() {
		searchPage=homePage.openSearchPage();
		searchPage.inputDataSearchTextBox(inputDataSearchParentCategory);
		searchPage.checkAdvanceSearch();
		searchPage.selectCategoryDropDownList(inputCategory);
		searchPage.checkSubCategory();
		searchPage.clickSearchButton();
		
		Assert.assertEquals(searchPage.getProductSubCategory(), "Apple MacBook Pro 13-inch\n$1,800.00\nADD TO CART Add to compare list Add to wishlist");
		
	}
	
	@Test
	public void Testcase_07_Advance_Search_Incorrect_Manufacture() {
		searchPage=homePage.openSearchPage();
		searchPage.inputDataSearchTextBox(inputDataSearchParentCategory);
		searchPage.checkAdvanceSearch();
		searchPage.selectCategoryDropDownList(inputCategory);
		searchPage.checkSubCategory();
		searchPage.selectManufactorDropDownList(inputHPManufactor);
		searchPage.clickSearchButton();
		Assert.assertEquals(searchPage.getErrorInvalidDataMessageUserPage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Testcase_08_Advance_Search_Correct_Manufacture() {
		searchPage=homePage.openSearchPage();
		searchPage.inputDataSearchTextBox(inputDataSearchParentCategory);
		searchPage.checkAdvanceSearch();
		searchPage.selectCategoryDropDownList(inputCategory);
		searchPage.checkSubCategory();
		searchPage.selectManufactorDropDownList(inputAppleManufactor);
		searchPage.clickSearchButton();
		Assert.assertEquals(searchPage.getProductCorrectManufacture(), "Apple MacBook Pro 13-inch\n$1,800.00\nADD TO CART Add to compare list Add to wishlist");
	}
	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}



}
