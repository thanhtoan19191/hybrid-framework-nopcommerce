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
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	
	
	private WebDriver driver;
	
	private String firstName, lastName,emailAddress,validPassword;
	private UserHomePageObject homePage ;
	private UserRegisterPageObject registerPage ;
	private UserLoginPageObject loginPage;
	private UserCustomerInForPageObject customerInforPage ;
	private UserAddressPageObject addressPage ;
	private UserMyProductReviewPageObject myProductReviewPage ;
	private UserRewardPointPageObject rewardPointPage ;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName="Automation";
		lastName="FC";
		validPassword = "123456";
		emailAddress = "auto" + generateFakeNumber() + "@mail.com";
		
		
		
		
		
	}

	@Test
	public void User_01_Register_Login() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		homePage =registerPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
		
		

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInforPage =  homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed()); 
	}

	@Test
	public void User_02_Switch_Page() {
		
		// Customer infor -> address
		addressPage= customerInforPage.openAddressPage(driver);
		
		// adress -> my produtc review
		myProductReviewPage= addressPage.openMyProductReviewPage(driver);
		
		//my produtc review -> reward point
		rewardPointPage =  myProductReviewPage.openRewardPoint(driver);
		
		//reward point -> address
		addressPage= rewardPointPage.openAddressPage(driver);
		
		//address -> reward point
		rewardPointPage =addressPage.openRewardPoint(driver);
		
		//reward point -> my produtc review
		myProductReviewPage= rewardPointPage.openMyProductReviewPage(driver);
		
		//My Product review -> Address
		addressPage =  myProductReviewPage.openAddressPage(driver);
		
		customerInforPage= addressPage.openCustomerInforPage(driver);
		
		myProductReviewPage= customerInforPage.openMyProductReviewPage(driver);
	}
	
	//@Test
	public void User_03_Dynamic_Page_01() {
		
		
		//my produtc review -> reward point
		rewardPointPage =  (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");
		
		//reward point -> address
		addressPage= (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");
		
		//address -> reward point
		rewardPointPage =(UserRewardPointPageObject) addressPage.openPagesAtMyAccountByName(driver, "Reward points");
		
		//reward point -> my produtc review
		myProductReviewPage= (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");
		
		//My Product review -> custtomer infor
		
		customerInforPage= (UserCustomerInForPageObject) addressPage.openPagesAtMyAccountByName(driver, "Customer info");
		
	}
	
	@Test
	public void User_03_Dynamic_Page_02() {
		//my product review -> Address
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		//address -> reward point
		addressPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		//reward point -> address
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
	}

	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}



}
