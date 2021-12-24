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
	public void beforeClass(String browserName, String appURL) {
		
		
		driver = getBrowserDriver(browserName, appURL);
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

	//@Test
	public void Table_02_Input_Header_Textbox() {
		//Input to textbox
		homePage.inputToHeaderTextboxByName("Females","434000");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Males","215000");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Country","Southern Asia");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);
	}
	
	//@Test
	public void Table_03_Click_Icon() {

		// click to icon
		homePage.clickToIconByCountryName("Argentina", "remove");
		homePage.sleepInsecond(3);

		homePage.clickToIconByCountryName("Algeria", "remove");
		homePage.sleepInsecond(3);

		homePage.clickToIconByCountryName("Arab Rep of Egypt", "edit");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.clickToIconByCountryName("Aruba", "edit");
		homePage.sleepInsecond(3);
	}

	//@Test
	public void Table_04_Verify_Row_Values() {
		// Verify row values
		homePage.inputToHeaderTextboxByName("Country", "Argentina");
		Assert.assertTrue(homePage.isRowValueDisplayed("338282","Argentina","349238","687522"));
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Country", "Angola");
		Assert.assertTrue(homePage.isRowValueDisplayed("276880","Angola","276472","553353"));
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);
		

	}

	@Test
	public void Table_05_Input_To_Row_Textbox() {
		homePage.inputToTextboxByRowNumber("Contact Person","3","John Kenedy");
		homePage.sleepInsecond(3);
		
		homePage.inputToTextboxByRowNumber("Order Placed","1","5");
		homePage.sleepInsecond(3);
		
		homePage.inputToTextboxByRowNumber("Company","2","Apple");
		homePage.sleepInsecond(3);
		
		homePage.inputToTextboxByRowNumber("Member Since","3","1950");
		homePage.sleepInsecond(3);
		
		
		
	}

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
