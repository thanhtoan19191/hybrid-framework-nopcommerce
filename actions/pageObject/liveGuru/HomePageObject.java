package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;


public class HomePageObject extends BasePage{
private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getLoginPage(driver);
		
	}

}
