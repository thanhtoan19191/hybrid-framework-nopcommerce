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
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_08_Switch_Role extends BaseTest {
	
	
	private WebDriver driver;
	
	private String userEmailAddress,userPassword, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage ;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInForPageObject userCustomerInforPage ;
	
	private UserAddressPageObject addressPage ;
	private UserMyProductReviewPageObject myProductReviewPage ;
	private UserRewardPointPageObject rewardPointPage ;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		
		
		driver = getBrowserDriver(browserName, appURL);
		
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		
		userPassword = "123456";
		userEmailAddress = "toanzx@gmail.com";	
		adminEmailAddress="admin@yourstore.com";
		adminPassword="admin";
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage =userLoginPage.loginAsUser(userEmailAddress,userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		//Home page -> customer infor
		userCustomerInforPage= userHomePage.clickToMyAccountLink();
		
		//Customer infor click logout -> home page
		userHomePage= userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);
		
		//UserHome Page -> Open admin page -> login page(admin)
		
		
		userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		//Login as admin role
		adminDashboardPage= adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		
		//Dashboard page -> lick logout -> Login page(admin)
		adminLoginPage= adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
		
		
	}

	@Test
	public void Role_02_Admin_To_User() {
		adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		//Home page -> login user
		userLoginPage = userHomePage.clickToLoginLink();
		
		//Login as User role
		userHomePage =userLoginPage.loginAsUser(userEmailAddress,userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
