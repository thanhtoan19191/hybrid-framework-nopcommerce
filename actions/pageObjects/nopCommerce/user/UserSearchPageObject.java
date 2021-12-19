package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.SearchPageUI;


public class UserSearchPageObject extends BasePage{
WebDriver driver;
	
	public UserSearchPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public String getErrorMessageUserPage() {
		waitForElementVisible(driver, SearchPageUI.ERROR_EMPTY_MESSAGE);
		return getElementText(driver, SearchPageUI.ERROR_EMPTY_MESSAGE);
	}

	public void inputDataSearchTextBox(String inputInvalidDataSearch) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, inputInvalidDataSearch);
		
	}

	public String getErrorInvalidDataMessageUserPage() {
		waitForElementVisible(driver, SearchPageUI.INVALID_DATA_ERROR_MESSAGE);
		return getElementText(driver, SearchPageUI.INVALID_DATA_ERROR_MESSAGE);
	}

	

	
	
}

	

