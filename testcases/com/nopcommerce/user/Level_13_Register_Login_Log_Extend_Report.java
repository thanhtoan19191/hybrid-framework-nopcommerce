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

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import reportConfig.ExtentTestManager;

public class Level_13_Register_Login_Log_Extend_Report extends BaseTest {
	
	
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

	@Test
	public void User_01_Register_To_System(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register- Step 01: Verify Home page is displayed");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register- Step 02: click to Register link");
		registerPage = homePage.clickToRegisterLink();
		registerPage.sleepInsecond(3);

		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register- Step 03: enter to first Name textbox");
		registerPage.inputToFirstnameTextbox(firstName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register- Step 04:  enter to last Name textbox");
		registerPage.inputToLastnameTextbox(lastName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register- Step 05:  enter to email textbox with value" + emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register- Step 06:  enter to password textbox with value" + validPassword);
		registerPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register- Step 07:  enter to confirm password textbox with value" + validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register- Step 08: click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register- Step 09: verify successmessage is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register- Step 10: click to Logout link");
		homePage =registerPage.clickToLogoutLink();
		
		ExtentTestManager.endTest();
	}	
		
	@Test
		public void User_02_Login_To_System(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login- Step 01: click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login- Step 02: inpuExtentTestManager.getTest().log(LogStatus.INFO,extbox");
		loginPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login- Step 03: input password textbox");
		loginPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login- Step 04: click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login- Step 05: verify my account link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login- Step 06: click to my account link");
		customerInforPage =  homePage.clickToMyAccountLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login- Step 07: verify page customer infor is displayed");
		verifyFalse(customerInforPage.isCustomerInforPageDisplayed()); 
		
		ExtentTestManager.endTest();
	}

	

	

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}



}
