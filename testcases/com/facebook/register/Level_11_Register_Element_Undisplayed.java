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
	public void Register_01_Element_Displayed() {
		
		  Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		  
		  registerPage.enterToEmailTextbox("toan@gmail.com");
		  registerPage.sleepInsecond(3);
		  Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		 
		
	}

	@Test
	public void Register_02_Element_Undisplayed_In_DOM() {
		
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInsecond(3);
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		 
		
	}
	
	@Test
	public void Register_03_Element_Undisplayed_Not_In_DOM() {
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
		
		
	}
	
	@Test
	public void Register_04_Element_Undisplayed_Not_In_DOM() {
		Assert.assertTrue(registerPage.isLoginButtonUndisplayed());
	}

	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}



}
