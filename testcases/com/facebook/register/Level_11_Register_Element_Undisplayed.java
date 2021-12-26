package com.facebook.register;

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
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;


public class Level_11_Register_Element_Undisplayed extends BaseTest {
	
	
	private WebDriver driver;
	RegisterPageObject registerPage;
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		
		
		driver = getBrowserDriver(browserName, appURL);
		registerPage= PageGeneratorManager.getRegisterPage(driver);
		
		
	}

	@Test
	public void Register_01_Verify() {
		
		verifyFalse(registerPage.isEmailTextboxDisplayed());

		registerPage.enterToEmailTextbox("toan@gmail.com");
		registerPage.sleepInsecond(3);
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());

		registerPage.enterToEmailTextbox("");
		registerPage.sleepInsecond(3);
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
		
		verifyTrue(registerPage.isLoginButtonUndisplayed());
	}

	

	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}



}
