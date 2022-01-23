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
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageUIs.liveGuru.HomePageUI;
import pageUIs.nopCommerce.user.MyProductReviewPageUI;

public class Testcase_05_Sort_Display_Paging extends BaseTest {
	
	
	private WebDriver driver;
	
	
	private UserHomePageObject homePage ;
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		
		log.info("Pre-condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		homePage.clickToSubMenu();
		
	}

	//@Test
	public void Testcase_01_Sort_Name_A_To_Z() {
		homePage.selectItemInSortDropdown("Name: A to Z");
		verifyTrue(homePage.isProductNameSortAcseDing());
	
	}

	//@Test
	public void Testcase_02_Sort_Name_Z_To_A() {
		homePage.selectItemInSortDropdown("Name: Z to A");
		verifyTrue(homePage.isProductNameSortDescenDing());
	}

	@Test
	public void Testcase_03_Sort_Price_Low_To_High() {
		homePage.selectItemInSortDropdown("Price: Low to High");
		verifyTrue(homePage.isProductPriceSortAcseDing());
		
	}

	@Test
	public void Testcase_04_Search_With_Valid_Data() {
		
		
	}
	
	@Test
	public void Testcase_05_Advance_Search_Parent_Category() {
		
		
	}

	@Test
	public void Testcase_06_Advance_Search_Sub_Category() {
		
		
	}
	
	@Test
	public void Testcase_07_Advance_Search_Incorrect_Manufacture() {
		
	}
	
	@Test
	public void Testcase_08_Advance_Search_Correct_Manufacture() {
		
	}
	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}



}
