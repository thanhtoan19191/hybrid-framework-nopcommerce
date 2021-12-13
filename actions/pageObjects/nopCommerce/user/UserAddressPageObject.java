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

	public void inputCityAddress(String City) {
		waitForElementVisible(driver, AddressPageUI.CITY);
		sendkeyToElement(driver, AddressPageUI.CITY, City);
		
	}

	public void inputAddress1(String Address1) {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_1);
		sendkeyToElement(driver, AddressPageUI.ADDRESS_1, Address1);
		
	}

	public void inputZipCodeAddress(String ZipCode) {
		waitForElementVisible(driver, AddressPageUI.ZIP_CODE);
		sendkeyToElement(driver, AddressPageUI.ZIP_CODE, ZipCode);
		
	}

	public void inputPhoneAddress(String PhoneNo) {
		waitForElementVisible(driver, AddressPageUI.PHONE_NUMBER);
		sendkeyToElement(driver, AddressPageUI.PHONE_NUMBER, PhoneNo);
		
	}

	public void clickSaveButton() {
		waitForElementVisible(driver, AddressPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_BUTTON);
		
	}

	public String getFirstNameLastName() {
		waitForElementVisible(driver, AddressPageUI.FIRST_NAME_AND_LAST_NAME);
		return getElementText(driver, AddressPageUI.FIRST_NAME_AND_LAST_NAME);
	}

	public String getEmail() {
		waitForElementVisible(driver, AddressPageUI.GET_EMAIL_ADDRESS);
		return getElementText(driver, AddressPageUI.GET_EMAIL_ADDRESS);
	}

	public String getPhoneNumber() {
		waitForElementVisible(driver, AddressPageUI.GET_PHONE_NUMBER);
		return getElementText(driver, AddressPageUI.GET_PHONE_NUMBER);
	}

	public String getAddress_1() {
		waitForElementVisible(driver, AddressPageUI.GET_ADDRESS_1);
		return getElementText(driver, AddressPageUI.GET_ADDRESS_1);
	}

	public String getCityAndZip() {
		waitForElementVisible(driver, AddressPageUI.GET_CITY_AND_ZIP);
		return getElementText(driver, AddressPageUI.GET_CITY_AND_ZIP);
	}

	public String getCountry() {
		waitForElementVisible(driver, AddressPageUI.GET_COUNTRY);
		return getElementText(driver, AddressPageUI.GET_COUNTRY);
	}

	

	

	

	

	
}
