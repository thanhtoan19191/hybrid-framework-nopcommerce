package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.saucelab.LoginPageUI;



public class LoginPageObject extends BasePage{
private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void enterToUserNameTextbox(String userName) {
		waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, userName);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public InventoryPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getInventoryPage(driver);
	}
	
	
}
