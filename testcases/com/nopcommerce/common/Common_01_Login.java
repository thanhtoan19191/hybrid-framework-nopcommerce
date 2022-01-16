package com.nopcommerce.common;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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

public class Common_01_Login extends BaseTest {
	
	
	private WebDriver driver;
	public static Set<Cookie> loginPageCookie;
	
	private String firstName, lastName,emailAddress,validPassword;
	private UserHomePageObject homePage ;
	private UserRegisterPageObject registerPage ;
	private UserLoginPageObject loginPage;
	private UserCustomerInForPageObject customerInforPage ;
	private UserAddressPageObject addressPage ;
	private UserMyProductReviewPageObject myProductReviewPage ;
	private UserRewardPointPageObject rewardPointPage ;
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeTest(String browserName, String appURL) {
		
		log.info("Pre-condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
	
		firstName="Automation";
		lastName="FC";
		validPassword = "123456";
		emailAddress = "auto" + generateFakeNumber() + "@mail.com";
		

		log.info("Common 01- Step 01: Verify Home page is displayed");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Common 01- Step 02: click to Register link");
		registerPage = homePage.clickToRegisterLink();
		registerPage.sleepInsecond(3);

		log.info("Common 01- Step 03: enter to first Name textbox");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Common 01- Step 04:  enter to last Name textbox");
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("Common 01- Step 05:  enter to email textbox with value" + emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Common 01- Step 06:  enter to password textbox with value" + validPassword);
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Common 01- Step 07:  enter to confirm password textbox with value" + validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("Common 01- Step 08: click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Common 01- Step 09: verify successmessage is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		log.info("Common 01- Step 10: click to Logout link");
		homePage =registerPage.clickToLogoutLink();

		log.info("Common 01- Step 11: click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Common 01- Step 12: input email textbox");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Common 01- Step 13: input password textbox");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Common 01- Step 14: click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Common 01- Step 15: verify my account link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Common 01- Step 16: click to my account link");
		customerInforPage =  homePage.clickToMyAccountLink();
		
		log.info("Common 01- Step 17: verify page customer infor is displayed");
		verifyTrue(customerInforPage.isCustomerInforPageDisplayed()); 
		
		log.info("Common 01- Step 18: Get all login page cookies");
		loginPageCookie = homePage.getAllCookies(driver);
		
		log.info("Post-condition: close browser" + browserName +"");
		cleanDriverInstance();
	}

	

	




}
