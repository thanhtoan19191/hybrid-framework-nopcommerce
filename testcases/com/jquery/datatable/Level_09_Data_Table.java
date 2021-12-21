package com.jquery.datatable;

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
import pageObject.jQuery.HomePageObject;




public class Level_09_Data_Table extends BaseTest {
	
	
	WebDriver driver;
	HomePageObject homePage;

	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		
		
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	//@Test
	public void Table_01_Paging() {
		//homePage.openPageURL(driver, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageActiveByNumber("5"));
		
		homePage.openPageByNumber("20");
		Assert.assertTrue(homePage.isPageActiveByNumber("20"));
		
		
	}

	@Test
	public void Table_02_Actions() {
		//Input to textbox
		homePage.inputToHeaderTextboxByName("Famales","434000");
		homePage.sleepInsecond(3);
		
		homePage.inputToHeaderTextboxByName("Males","215000");
		homePage.sleepInsecond(3);
		
		homePage.inputToHeaderTextboxByName("Country","Southern Asia");
		homePage.sleepInsecond(3);
		
		//click to icon
		
		//Verify row values
	}

	

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
