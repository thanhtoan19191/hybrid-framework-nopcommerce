package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

import pageUIs.liveGuru.LoginPageUI;
import pageUIs.liveGuru.RegisterPageUI;

public class LoginPageObject extends BasePage{
private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public RegisterPageObject clickToCreateAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		return PageGeneratorManager.getRegisterPage(driver);
		
	}

	public void inputRegisterEmailAddress(String email) {
		waitForElementVisible(driver, LoginPageUI.REGISTER_EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.REGISTER_EMAIL_TEXTBOX, email);
		
	}

	public void inputRegisterPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.REGISTER_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.REGISTER_PASSWORD_TEXTBOX, password);
		
	}

	public MyDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
		
	}
}
