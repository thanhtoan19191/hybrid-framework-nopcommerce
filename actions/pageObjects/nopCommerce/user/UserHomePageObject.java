package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.saucelab.InventoryPageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver=driver;
	}

	@Step("click to Register link")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}


	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}

	public UserCustomerInForPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	public UserCustomerInForPageObject openMyAccountPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserSearchPageObject openSearchPage() {
		waitForElementVisible(driver, HomePageUI.SEARCH_FOOTER_LINK);
		clickToElement(driver, HomePageUI.SEARCH_FOOTER_LINK);
		return PageGeneratorManager.getUserSearchPage(driver);
	}

	public void clickToSubMenu() {
		waitForElementClickable(driver, HomePageUI.COMPUTERS_LINK);
		clickToElement(driver, HomePageUI.COMPUTERS_LINK);
		waitForElementClickable(driver, HomePageUI.NOTEBOOKS_LINK);
		clickToElement(driver, HomePageUI.NOTEBOOKS_LINK);
		
	}

	public void selectItemInSortDropdown(String itemText) {
		waitForElementClickable(driver, HomePageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, HomePageUI.SORT_DROPDOWN, itemText);
		
	}

	public boolean isProductNameSortAcseDing() {
		List<WebElement> productNameElements = getListWebElement(driver, HomePageUI.PRODUCT_NAME_TEXT);
		
		List<String> productNameText = new ArrayList<String>();
		
		for(WebElement productName:productNameElements) {
			productNameText.add(productName.getText());
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		
		Collections.sort(productNameTextClone);
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductNameSortDescenDing() {
		List<WebElement> productNameElements = getListWebElement(driver, HomePageUI.PRODUCT_NAME_TEXT);
		
		List<String> productNameText = new ArrayList<String>();
		
		for(WebElement productName:productNameElements) {
			productNameText.add(productName.getText());
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		
		Collections.sort(productNameTextClone);
		Collections.reverse(productNameTextClone);
		
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductPriceSortAcseDing() {
		List<WebElement> productPriceElements = getListWebElement(driver, HomePageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> productPriceValue = new ArrayList<Float>();
		
		for(WebElement productPrice:productPriceElements) {
			Float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$", "")) ;
			productPriceValue.add(productPriceNumber);
		}
		
		List<Float> productPriceTextClone = new ArrayList<Float>(productPriceValue);
		
		Collections.sort(productPriceTextClone);
		return productPriceValue.equals(productPriceTextClone);
	}

	

	

	
	
}
