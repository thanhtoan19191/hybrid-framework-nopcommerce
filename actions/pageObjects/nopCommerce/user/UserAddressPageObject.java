package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.AddressPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;
	
	public UserAddressPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickAddNewButton() {
		waitForElementVisible(driver, AddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
		
	}

	public void inputFirstNameAddress(String firstName) {
		waitForElementVisible(driver, AddressPageUI.FIRST_NAME_ADDRESS);
		sendkeyToElement(driver, AddressPageUI.FIRST_NAME_ADDRESS, firstName);
		
	}

	public void inputLastNameAddress(String lastName) {
		waitForElementVisible(driver, AddressPageUI.LAST_NAME_ADDRESS);
		sendkeyToElement(driver, AddressPageUI.LAST_NAME_ADDRESS, lastName);
		
	}

	public void inputEmailAddress(String email) {
		waitForElementVisible(driver, AddressPageUI.EMAIL_ADDRESS);
		sendkeyToElement(driver, AddressPageUI.EMAIL_ADDRESS, email);
		
	}

	public void selectCountryAddress(String country) {
		waitForElementVisible(driver, AddressPageUI.COUNTRY);
		selectItemInDefaultDropdown(driver, AddressPageUI.COUNTRY, country);
		
	}

	

	

	

	

	
}
