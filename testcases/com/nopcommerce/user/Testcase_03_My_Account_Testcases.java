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
import pageUIs.liveGuru.HomePageUI;
import pageUIs.nopCommerce.user.MyProductReviewPageUI;

public class Testcase_03_My_Account_Testcases extends BaseTest {
	
	
	private WebDriver driver;
	
	private String firstName, lastName,
	existingEmail,validPassword,editFirstName,editLastName,dayOfBirth,
	monthOfBirth,yearOfBirth,editEmail,company,emailAddress,country,city, address_1,zipcode,phoneNumber,newPassword,reviewTitle,reviewText;
	private UserHomePageObject homePage ;
	private UserRegisterPageObject registerPage ;
	private UserLoginPageObject loginPage;
	private UserCustomerInForPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	
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
		monthOfBirth="January";
		yearOfBirth="1999";
		editEmail="Automationfc.vn@gmail.com";
		company="AutomationFC";
		emailAddress="automationfc.vn@gmail.com";
		country="Viet Nam";
		city="Da Nang";
		address_1="123/04 le Lai";
		zipcode="550000";
		phoneNumber="0123456789";
		newPassword="654321";
		reviewTitle="lenovo";
		reviewText="Good product";
		
	
		
		
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
		
		addressPage.inputCityAddress(city);
		addressPage.inputAddress1(address_1);
		addressPage.inputZipCodeAddress(zipcode);
		addressPage.inputPhoneAddress(phoneNumber);
		addressPage.clickSaveButton();
		Assert.assertEquals(addressPage.getFirstNameLastName(), firstName +" "+ lastName);
		Assert.assertEquals(addressPage.getEmail(), "Email:"+" "+emailAddress);
		Assert.assertEquals(addressPage.getPhoneNumber(), "Phone number:"+" "+phoneNumber);
		Assert.assertEquals(addressPage.getAddress_1(), address_1);
		Assert.assertEquals(addressPage.getCityAndZip(), city+", "+zipcode);
		Assert.assertEquals(addressPage.getCountry(), country);
		
	}

	@Test
	public void Testcase_03_Change_Password() {
		//add -> changepass
		changePasswordPage=addressPage.openChangePasswordPage(driver);
		changePasswordPage.inputOldPassword(validPassword);
		changePasswordPage.inputNewPassword(newPassword);
		changePasswordPage.inputConfirmNewPassword(newPassword);
		changePasswordPage.clickNewPassword();
		Assert.assertTrue(changePasswordPage.isPasswordChangedDisplayed());
		changePasswordPage.clickClosePasswordChangedMessage();
		homePage = changePasswordPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(newPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}

	@Test
	public void Testcase_04_My_Product_Review() {
		homePage.isMyAccountLinkDisplayed();
		homePage.clickToElement(driver, HomePageUI.COMPUTERS_ICON_MENU);
		homePage.clickToElement(driver, HomePageUI.DESKTOPS_ICON);
		homePage.clickToElement(driver, HomePageUI.SELECT_ITEM_ICON);
		homePage.clickToElement(driver, HomePageUI.ADD_TO_REVIEW);
		homePage.sendkeyToElement(driver, HomePageUI.REVIEW_TITLE, reviewTitle);
		homePage.sendkeyToElement(driver, HomePageUI.REVIEW_TEXT, reviewText);
		homePage.checkToDefaultCheckboxRadio(driver, HomePageUI.GOOD_CHECKBOX_RADIO);
		homePage.clickToElement(driver, HomePageUI.SUBMIT_REVIEW_BUTTON);
		homePage.clickToMyAccountLink();
		myProductReviewPage = homePage.openMyProductReviewPage(driver);
		Assert.assertEquals(myProductReviewPage.getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE), reviewTitle);
		Assert.assertEquals(myProductReviewPage.getElementText(driver, MyProductReviewPageUI.REVIEW_TEXT), reviewText);
		
		
		
		

	}

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
