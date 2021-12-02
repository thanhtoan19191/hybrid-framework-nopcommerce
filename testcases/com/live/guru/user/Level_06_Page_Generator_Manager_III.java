package com.live.guru.user;

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
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.MyDashboardPageObject;
import pageObject.liveGuru.RegisterPageObject;
import pageObject.liveGuru.PageGeneratorManager;


public class Level_06_Page_Generator_Manager_III extends BaseTest {
	
	
	private WebDriver driver;
	private String firstName,lastName,email,password;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyDashboardPageObject myDashboardPage;
	

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "Toan";
		lastName = "FC";
		email = "Toan" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		
	}

	@Test
	public void User_01_Register_To_System() {
		loginPage =  homePage.clickToMyAccountLink();
		
		registerPage =  loginPage.clickToCreateAccountButton();
		
		
		registerPage.inputFirstNameTextbox(firstName);
		
		registerPage.inputLastNameTextbox(lastName);
		registerPage.inputEmailTextbox(email);
		registerPage.inputPasswordTextbox(password);
		registerPage.inputConfirmPasswordTextbox(password);
		
		myDashboardPage= registerPage.clickToRegisterButton();
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(),
				"Thank you for registering with Main Website Store.");
		myDashboardPage.clickToAccountButton();
		homePage =  myDashboardPage.clickToLogoutLink();
		 
		 
		 
		
		
		
	
	}

	@Test
	public void User_02_Login_To_System() {
		loginPage= homePage.clickToMyAccountLink();
		
		loginPage.inputRegisterEmailAddress(email);
		loginPage.inputRegisterPassword(password);
		myDashboardPage =  loginPage.clickToLoginButton();
		 
		
		
	
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
