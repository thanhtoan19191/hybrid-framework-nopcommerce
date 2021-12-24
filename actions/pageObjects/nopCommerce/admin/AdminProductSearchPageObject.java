package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;
import pageUIs.nopCommerce.admin.AdminProductSearchPageUI;

public class AdminProductSearchPageObject extends BasePage{
private WebDriver driver;
	
	public AdminProductSearchPageObject(WebDriver driver) {
		this.driver=driver;
	}


	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, AdminProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminProductSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductSearchPageUI.SEARCH_BUTTON);
		
	}

	public AdminProductDetailPageObject clickToEditButtonByProductName(String productName) {
		waitForElementClickable(driver, AdminProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME,productName);
		clickToElement(driver, AdminProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME,productName);
		return pageObjects.nopCommerce.admin.PageGeneratorManager.getproductDetailPage(driver);
	}

	public boolean isSuccessMessageDisplayed(String messageName) {
		waitForElementVisible(driver, AdminProductSearchPageUI.SUCCESS_MESSAGE_NAME,messageName);
		return isElementDisplayed(driver, AdminProductSearchPageUI.SUCCESS_MESSAGE_NAME,messageName);
	}

	public boolean isPictureImageDisplayed(String productImageName, String productName) {
		productImageName=productImageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, AdminProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productImageName,productName);
		return isElementDisplayed(driver, AdminProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productImageName,productName);
	}

	
}
