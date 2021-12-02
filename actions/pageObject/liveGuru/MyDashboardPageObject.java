package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

import pageUIs.liveGuru.MyDashboardPageUI;
import pageUIs.liveGuru.RegisterPageUI;




public class MyDashboardPageObject extends BasePage{
private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.SUCCESSFUL_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.SUCCESSFUL_MESSAGE);
	}

	public void clickToAccountButton() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_BUTTON);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_BUTTON);
		
		
	}
	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_BUTTON);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
}
