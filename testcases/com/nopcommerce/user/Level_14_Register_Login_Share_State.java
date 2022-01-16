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

import com.nopcommerce.common.Common_01_Login;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_14_Register_Login_Share_State extends BaseTest {
	
	
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
		
		log.info("Pre-condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		homePage=PageGeneratorManager.getUserHomePage(driver);
		
		
		firstName="Automation";
		lastName="FC";
		validPassword = "123456";
		emailAddress = "auto" + generateFakeNumber() + "@mail.com";
		
		
		
		
		
	}

	
		
	@Test
		public void User_01_Login_To_System() {
		log.info("User_02_Login- Step 01: click to Login link");
		
		loginPage = homePage.clickToLoginLink();
		
		log.info("User_02_Login- Step 02: Set login page cookie");
		loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
		loginPage.sleepInsecond(5);
		loginPage.refreshCurrentPage(driver);
		homePage = loginPage.openHomePage();
		
		
		log.info("User_02_Login- Step 03: verify my account link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		log.info("User_02_Login- Step 04: click to my account link");
		customerInforPage =  homePage.clickToMyAccountLink();
		
		log.info("User_02_Login- Step 05: verify page customer infor is displayed");
		verifyTrue(customerInforPage.isCustomerInforPageDisplayed()); 
	}

	

	
	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition: close browser" + browserName +"");
		cleanDriverInstance();
	}



}
