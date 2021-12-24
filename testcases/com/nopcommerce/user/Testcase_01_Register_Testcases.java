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

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Testcase_01_Register_Testcases extends BaseTest {
	
	private UserHomePageObject homePage ;
	private UserRegisterPageObject registerPage ;
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAddress,password;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		
		
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		//homePage = new UserHomePageObject(driver);
		//registerPage = new UserRegisterPageObject(driver);
		
		firstName="Automation";
		lastName="FC";
		
		password = "123456";
		emailAddress = "auto" + generateFakeNumber() + "@mail.com";
		
		
	}

	@Test
	public void Register_01_Register_Empty_Data() {
		
		
		
		registerPage = homePage.clickToRegisterLink();
		
		
		registerPage.clickToRegisterButton();

		

		
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(),"First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(),"Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
		
		
		

	}

	@Test
	public void Register_02_Register_Invalid_Email() {
		
		
		
		registerPage =homePage.clickToRegisterLink();
		
		
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@456%*");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		

		

		
		registerPage.clickToRegisterButton();
		
		
		
		
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");

	}

	@Test
	public void Register_03_Register_Success() {
		
		registerPage = homePage.clickToRegisterLink();
		
		
		
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		
		registerPage.clickToRegisterButton();
		
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Register_04_Register_Existing_Email() {
		
		
		registerPage = homePage.clickToRegisterLink();

		
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		
		registerPage.clickToRegisterButton();
		
		
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");

	}

	@Test
	public void Register_05_Register_Password_Less_Than_6_Characters() {
		
		registerPage = homePage.clickToRegisterLink();

		
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		
		registerPage.clickToRegisterButton();
		
		
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Register_Invalid_Confirm_Password() {
		
		registerPage =homePage.clickToRegisterLink();

		
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123654");

		
		registerPage.clickToRegisterButton();
		
		
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");


	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}


}
