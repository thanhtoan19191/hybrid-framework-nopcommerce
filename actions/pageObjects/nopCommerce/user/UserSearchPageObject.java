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

	public String getDataAfterSearch() {
		waitForElementVisible(driver, SearchPageUI.THINKPAD_X1_DATA);
		return getElementText(driver, SearchPageUI.THINKPAD_X1_DATA);
	}

	public void checkAdvanceSearch() {
		waitForElementClickable(driver, SearchPageUI.ADVANCE_SEARCH);
		clickToElement(driver, SearchPageUI.ADVANCE_SEARCH);
		
	}

	public void selectCategoryDropDownList(String inputCategory) {
		waitForElementVisible(driver, SearchPageUI.CATEGORY);
		selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY, inputCategory);
		
	}

	public void checkSubCategory() {
		waitForElementClickable(driver, SearchPageUI.SUB_CATEGORY);
		clickToElement(driver, SearchPageUI.SUB_CATEGORY);
		
	}

	public void selectManufactorDropDownList(String inputManufacture) {
		waitForElementVisible(driver, SearchPageUI.MANUFACTURE);
		selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURE, inputManufacture);
		
	}

	public String getProductText() {
		waitForElementVisible(driver, SearchPageUI.RELATIVE_DATA);
		return getElementText(driver, SearchPageUI.RELATIVE_DATA);
		
	}

	public String getProductSubCategory() {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_SUB_CATEGORY_DATA);
		return getElementText(driver, SearchPageUI.PRODUCT_SUB_CATEGORY_DATA);
		
	}

	public String getProductCorrectManufacture() {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_MANUFACTURE_DATA);
		return getElementText(driver, SearchPageUI.PRODUCT_MANUFACTURE_DATA);
	}

	

	
	
}

	

