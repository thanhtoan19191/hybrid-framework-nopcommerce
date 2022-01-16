package com.nopcommerce.user;

import java.lang.reflect.Method;
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
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

@Epic("Web")
@Feature("User")
public class Level_13_Register_Login_Log_Extend_Report_Allure_HTML extends BaseTest {
	
	
	private WebDriver driver;
	
	private String firstName, lastName,emailAddress,validPassword;
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
		
		
		driver = getBrowserDriver(browserName, appURL);
		
		firstName="Automation";
		lastName="FC";
		validPassword = "123456";
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
		
	}
	
@Story("Register")
@Severity(SeverityLevel.NORMAL)
@Description("Register to system and check registered success")
	@Test
	public void User_01_Register_To_System() {
		log.info("User_01_Register- Step 01: Verify Home page is displayed");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("User_01_Register- Step 02: click to Register link");
		registerPage = homePage.clickToRegisterLink();
		registerPage.sleepInsecond(3);

		log.info("User_01_Register- Step 03: enter to first Name textbox");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("User_01_Register- Step 04:  enter to last Name textbox");
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("User_01_Register- Step 05:  enter to email textbox with value" + emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("User_01_Register- Step 06:  enter to password textbox with value" + validPassword);
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("User_01_Register- Step 07:  enter to confirm password textbox with value" + validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("User_01_Register- Step 08: click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01_Register- Step 09: verify successmessage is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		log.info("User_01_Register- Step 10: click to Logout link");
		homePage =registerPage.clickToLogoutLink();
		
		
	}	
		
@Story("Login")
@Severity(SeverityLevel.NORMAL)
@Description("Login to system and check registered success")
	@Test
		public void User_02_Login_To_System() {
		log.info("User_02_Login- Step 01: click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("User_02_Login- Step 02: input email textbox");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("User_02_Login- Step 03: input password textbox");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("User_02_Login- Step 04: click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("User_02_Login- Step 05: verify my account link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		log.info("User_02_Login- Step 06: click to my account link");
		customerInforPage =  homePage.clickToMyAccountLink();
		
		log.info("User_02_Login- Step 07: verify page customer infor is displayed");
		verifyFalse(customerInforPage.isCustomerInforPageDisplayed()); 
	}

	

	

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}



}
