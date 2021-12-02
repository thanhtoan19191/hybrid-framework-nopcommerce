package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.MyDashboardPageObject;
import pageObject.liveGuru.RegisterPageObject;


public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}
}
