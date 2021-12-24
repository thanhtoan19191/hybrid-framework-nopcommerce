package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;
import pageUIs.nopCommerce.admin.AdminProductDetailPageUI;

public class AdminProductDetailPageObject extends BasePage{
private WebDriver driver;
	
	public AdminProductDetailPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void inputToUsernameTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToUsernameTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

	public void clickToEnpandPanelByName(String panelName) {
		waitForElementVisible(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME,panelName);
		String toogleIconStatus = getElementAttribute(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, "class" , panelName);
		if(toogleIconStatus.contains("fa-plus")) {
			waitForElementClickable(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME,panelName);
			clickToElement(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}
		//1- get tag i attributee
		
		//2- not contains (fa-plus)
		//3- if contains: click i
		
	}

	public void uploadPictureByFileName(String string) {
		
		
	}

	public boolean isPictureUploadedSuccessByFileName(String fileName) {
		fileName= fileName.split("\\.")[0];
		waitForElementVisible(driver, AdminProductDetailPageUI.PICTURE_IMAGE_ADD_NEW_BY_FILE_NAME,fileName);
		return isElementDisplayed(driver, AdminProductDetailPageUI.PICTURE_IMAGE_ADD_NEW_BY_FILE_NAME,fileName);
	}

	public void enterToAltTextbox(String productImageAlt) {
		waitForElementVisible(driver, AdminProductDetailPageUI.ALT_TEXTBOX_ADD_NEW_BY_FILE_NAME);
		sendkeyToElement(driver, AdminProductDetailPageUI.ALT_TEXTBOX_ADD_NEW_BY_FILE_NAME, productImageAlt);
		
	}

	public void enterToTitleTextbox(String productImageTitle) {
		waitForElementVisible(driver, AdminProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW_BY_FILE_NAME);
		sendkeyToElement(driver, AdminProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW_BY_FILE_NAME,productImageTitle);
		
	}

	public void clickToUpDownInDisplayedOrderTextbox(String selectValue) {
		waitForElementClickable(driver, AdminProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_UP_DOWN,selectValue);
		clickToElement(driver, AdminProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_UP_DOWN,selectValue);
		
	}

	public void clickToAddProductPictureButton() {
		waitForElementClickable(driver, AdminProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		
	}

	public boolean isPictureImageDisplayed(String ImageName, String DisplayOrder, String imageAlt, String imageTitle) {
		ImageName=ImageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, AdminProductDetailPageUI.PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE, ImageName,DisplayOrder,imageAlt,imageTitle);
		return isElementDisplayed(driver, AdminProductDetailPageUI.PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE, ImageName,DisplayOrder,imageAlt,imageTitle);
	}

	public AdminProductSearchPageObject clickToSaveButton() {
		waitForElementClickable(driver, AdminProductDetailPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminProductDetailPageUI.SAVE_BUTTON);
		return pageObjects.nopCommerce.admin.PageGeneratorManager.getProductSearchPage(driver);
	}

	public void clickToDeleteButtonAtProductName(String productTitle) {
		waitForElementVisible(driver, AdminProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		clickToElement(driver,  AdminProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		acceptAlert(driver);
		
	}



	
}
