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
	existingEmail,validPassword,inputInvalidDataSearch;
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
	public void Search_With_Empty_Data() {
		searchPage=homePage.openSearchPage();
		searchPage.clickSearchButton();
		Assert.assertEquals(searchPage.getErrorMessageUserPage(), "Search term minimum length is 3 characters");
		

	}

	@Test
	public void Search_With_Invalid_Data() {
		searchPage=homePage.openSearchPage();
		searchPage.inputDataSearchTextBox(inputInvalidDataSearch);
		searchPage.clickSearchButton();
		Assert.assertEquals(searchPage.getErrorInvalidDataMessageUserPage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Testcase_03_Change_Password() {
	
		
	}

	@Test
	public void Testcase_04_My_Product_Review() {

		
		
		
		

	}

	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}



}
