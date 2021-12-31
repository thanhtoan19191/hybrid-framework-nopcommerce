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

public class Level_15_Register_Login_Pattern_Object extends BaseTest {
	
	
	private WebDriver driver;
	
	private String firstName, lastName,emailAddress,validPassword,date,month,year;
	private UserHomePageObject homePage ;
	private UserRegisterPageObject registerPage ;
	private UserLoginPageObject loginPage;
	private UserCustomerInForPageObject customerInforPage ;
	private UserAddressPageObject addressPage ;
	private UserMyProductReviewPageObject myProductReviewPage ;
	private UserRewardPointPageObject rewardPointPage ;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		
		log.info("Pre-condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		
		
		
		firstName="Automation";
		lastName="FC";
		validPassword = "123456";
		emailAddress = "auto" + generateFakeNumber() + "@mail.com";
		date="19";
		month="January";
		year="1991";
		
		
		
		
		
	}

	@Test
	public void User_01_Register_To_System() {
		log.info("User_01_Register- Step 01: Verify Home page is displayed");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("User_01_Register- Step 02: click to Register link");
		homePage.openHeaderPageByName(driver,"Register");
		registerPage=PageGeneratorManager.getUserRegisterPage(driver);
		registerPage.sleepInsecond(3);

		log.info("User_01_Register- Step 03: select male radio button");
		registerPage.clickToRadioButtonByID(driver,"gender-male");
		
		log.info("User_01_Register- Step 04: enter to first Name textbox");
		registerPage.enterToTextboxByID(driver,"FirstName",firstName);
		
		log.info("User_01_Register- Step 05:  enter to last Name textbox");
		registerPage.enterToTextboxByID(driver,"LastName",lastName);
		
		log.info("User_01_Register- Step 06:  enter to email textbox with value" + emailAddress);
		registerPage.enterToTextboxByID(driver,"Email",emailAddress);
		
		log.info("User_01_Register- Step 07:  enter to password textbox with value" + validPassword);
		registerPage.enterToTextboxByID(driver,"Password",validPassword);
		
		log.info("User_01_Register- Step 08:  enter to confirm password textbox with value" + validPassword);
		registerPage.enterToTextboxByID(driver,"ConfirmPassword",validPassword);
		
		log.info("User_01_Register- Step 09:  select item in date dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("User_01_Register- Step 10:  select item in month dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("User_01_Register- Step 11:  select item in year dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("User_01_Register- Step 12: click to Register button");
		registerPage.clickToButtonByText(driver,"Register");
		
		log.info("User_01_Register- Step 13: verify successmessage is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		log.info("User_01_Register- Step 14: click to Logout link");
		registerPage.openHeaderPageByName(driver, "Log out");
		homePage=PageGeneratorManager.getUserHomePage(driver);
		
		
	}	
		
	@Test
		public void User_02_Login_To_System() {
		log.info("User_02_Login- Step 01: click to Login link");
		
		homePage.openHeaderPageByName(driver,"Log in");
		loginPage= PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("User_02_Login- Step 02: input email textbox");
		loginPage.enterToTextboxByID(driver,"Email",emailAddress);
		
		log.info("User_02_Login- Step 03: input password textbox");
		loginPage.enterToTextboxByID(driver,"Password",validPassword);
		
		log.info("User_02_Login- Step 04: click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage=PageGeneratorManager.getUserHomePage(driver);
		
		log.info("User_02_Login- Step 05: verify my account link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		log.info("User_02_Login- Step 06: click to my account link");
		homePage.openHeaderPageByName(driver,"My account");
		customerInforPage=PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("User_02_Login- Step 07: verify page customer infor is displayed");
		verifyTrue(customerInforPage.isCustomerInforPageDisplayed()); 
	}

	

	
	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition: close browser" + browserName +"");
		cleanDriverInstance();
	}



}
