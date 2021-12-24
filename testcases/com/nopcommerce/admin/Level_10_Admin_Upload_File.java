package com.nopcommerce.admin;

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
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductDetailPageObject;
import pageObjects.nopCommerce.admin.AdminProductSearchPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_10_Admin_Upload_File extends BaseTest {
	
	
	private WebDriver driver;
	String productName="Windows 8 Pro";
	String productAvatarImg="Avatar.JPG";
	String productAvatarAlt="Avatar Alt";
	String productAvatarTitle="Avatar Title";
	String productAvatarOrder="1";
	AdminLoginPageObject loginPage;
	AdminDashboardPageObject dashboardPage;
	AdminProductSearchPageObject productSearchPage;
	AdminProductDetailPageObject productDetailPage;
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		
		
		driver = getBrowserDriver(browserName, appURL);

		loginPage = pageObjects.nopCommerce.admin.PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToUsernameTextbox("admin@yourstore.com");
		loginPage.inputToPasswordTextbox("admin");
		dashboardPage = loginPage.clickToLoginButton();
		
		dashboardPage.openSubMenuPageByName(driver,"Catalog","Products");
		productSearchPage=pageObjects.nopCommerce.admin.PageGeneratorManager.getProductSearchPage(driver);

		productSearchPage.enterToProductNameTextbox(productName);

		productSearchPage.clickToSearchButton();

		productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);

	}



	@Test
	public void Admin_01_Upload_File() {
		
		productDetailPage.clickToEnpandPanelByName("Pictures");

		productDetailPage.uploadMultipleFiles(driver, "pictures", productAvatarImg);

		Assert.assertTrue(productDetailPage.isPictureUploadedSuccessByFileName(""));

		productDetailPage.enterToAltTextbox(productAvatarAlt);
		productDetailPage.enterToTitleTextbox(productAvatarTitle);
		productDetailPage.clickToUpDownInDisplayedOrderTextbox("Increase");

		productDetailPage.clickToAddProductPictureButton();

		Assert.assertTrue(productDetailPage.isPictureImageDisplayed(productName, productAvatarOrder, productAvatarAlt, productAvatarTitle));

		productSearchPage = productDetailPage.clickToSaveButton();

		Assert.assertTrue(productSearchPage.isSuccessMessageDisplayed("The product has been updated successfully."));

		productSearchPage.enterToProductNameTextbox(productName);

		productSearchPage.clickToSearchButton();

		Assert.assertTrue(productSearchPage.isPictureImageDisplayed(productName, productName));

		productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);

		productDetailPage.clickToEnpandPanelByName("Pictures");

		productDetailPage.clickToDeleteButtonAtProductName(productAvatarTitle); // Accept alert

		Assert.assertTrue(productDetailPage.isMessageDisplayedInEmptyTable(driver,"productpictures"));

		productSearchPage = productDetailPage.clickToSaveButton();

		productSearchPage.enterToProductNameTextbox(productName);

		productSearchPage.clickToSearchButton();

		Assert.assertTrue(productSearchPage.isPictureImageDisplayed("default-image", productName));
		 
	}


	
	

	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}



}
