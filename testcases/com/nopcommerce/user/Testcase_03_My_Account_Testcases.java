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
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Testcase_03_My_Account_Testcases extends BaseTest {
	
	
	private WebDriver driver;
	
	private String firstName, lastName, invalidEmail, notFoundEmail,
	existingEmail,validPassword, incorrectPassword,editFirstName,editLastName,dayOfBirth,
	monthOfBirth,yearOfBirth,editEmail,company,emailAddress,country;
	private UserHomePageObject homePage ;
	private UserRegisterPageObject registerPage ;
	private UserLoginPageObject loginPage;
	private UserCustomerInForPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName="Automation";
		lastName="FC";
		validPassword = "123456";
		existingEmail = "auto" + generateFakeNumber() + "@mail.com";
		editFirstName="Automation";
		editLastName="FCC";
		dayOfBirth="1";
		monthOfBirth="1";
		yearOfBirth="1999";
		editEmail="Automationfc.vn@gmail.com";
		company="AutomationFC";
		emailAddress="automationfc.vn@gmail.com";
		country="Viet Nam";
		
		
	
		
		
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
	public void Testcase_01_Update_Customer_Infor() {
		customerInforPage = homePage.clickToMyAccountLink();
		customerInforPage.selectGenderCheckbox();

		customerInforPage.editFirstNameTextbox(editFirstName);
		customerInforPage.editLastNameTextbox(editLastName);

		customerInforPage.selectDayDropdown(dayOfBirth);
		customerInforPage.selectMonthDropdown(monthOfBirth);
		customerInforPage.selectYearDropdown(yearOfBirth);
		customerInforPage.editEmailTextbox(editEmail);
		customerInforPage.inputCompanyTextbox(company);
		customerInforPage.clickSaveButton();

	}

	@Test
	public void Testcase_02_Address_Infor() {
		//customer -> addd
		addressPage=customerInforPage.openAddressPage(driver);
		addressPage.clickAddNewButton();
		addressPage.inputFirstNameAddress(firstName);
		addressPage.inputLastNameAddress(lastName);
		addressPage.inputEmailAddress(emailAddress);
		
		
		addressPage.selectCountryAddress(country);
		/*
		 * addressPage.inputCityAddress(); addressPage.inputAddress1();
		 * addressPage.inputZipCodeAddress(); addressPage.inputPhoneAddress();
		 * addressPage.clickSaveButton();
		 */
		 
		


	}

	@Test
	public void Login_03_Email_Not_Found() {
		
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}



}
