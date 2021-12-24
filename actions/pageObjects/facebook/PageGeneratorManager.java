package pageObjects.facebook;

import org.openqa.selenium.WebDriver;



public class PageGeneratorManager {
	private static RegisterPageObject registerPage;
	
	

	private PageGeneratorManager() {

	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	
}
