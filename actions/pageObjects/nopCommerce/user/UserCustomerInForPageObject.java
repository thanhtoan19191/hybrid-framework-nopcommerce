package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInforPageUI;

public class UserCustomerInForPageObject extends BasePage {
	
	WebDriver driver;
	
	
	public UserCustomerInForPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	public void selectGenderCheckbox() {
		waitForElementVisible(driver, CustomerInforPageUI.FEMALE_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, CustomerInforPageUI.FEMALE_CHECKBOX);
	}

	public void editFirstNameTextbox(String editFirstName) {
		waitForElementVisible(driver, CustomerInforPageUI.EDIT_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.EDIT_FIRST_NAME_TEXTBOX, editFirstName);
		
	}

	public void editLastNameTextbox(String editLastName) {
		waitForElementVisible(driver, CustomerInforPageUI.EDIT_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.EDIT_LAST_NAME_TEXTBOX, editLastName);
	}

	public void selectDayDropdown(String day) {
		waitForElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInforPageUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropdown(String month) {
		waitForElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInforPageUI.MONTH_DROPDOWN, month);
		
	}

	public void selectYearDropdown(String year) {
		waitForElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInforPageUI.YEAR_DROPDOWN, year);
		
	}

	public void editEmailTextbox(String email) {
		waitForElementVisible(driver, CustomerInforPageUI.EDIT_EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.EDIT_EMAIL_TEXTBOX, email);
		
	}

	public void inputCompanyTextbox(String company) {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.COMPANY_TEXTBOX, company);
		
	}

	public void clickSaveButton() {
		waitForElementVisible(driver, CustomerInforPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInforPageUI.SAVE_BUTTON);
		
	}

	
}
