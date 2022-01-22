package pageObjects.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.InventoryPageUI;



public class InventoryPageObject extends BasePage{
private WebDriver driver;
	
	public InventoryPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void selectItemInSortDropdown(String itemText) {
		waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, InventoryPageUI.SORT_DROPDOWN, itemText);
		
	}

	public boolean isProductNameSortAcseDing() {
		List<WebElement> productNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		
		List<String> productNameText = new ArrayList<String>();
		
		for(WebElement productName:productNameElements) {
			productNameText.add(productName.getText());
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		
		Collections.sort(productNameTextClone);
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductNameSortDescenDing() {
		List<WebElement> productNameElements = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		
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
		List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> productPriceValue = new ArrayList<Float>();
		
		for(WebElement productPrice:productPriceElements) {
			Float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$", "")) ;
			productPriceValue.add(productPriceNumber);
		}
		
		List<Float> productPriceTextClone = new ArrayList<Float>(productPriceValue);
		
		Collections.sort(productPriceTextClone);
		return productPriceValue.equals(productPriceTextClone);
	}

	public boolean isProductPriceSortDescenDing() {
		List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> productPriceValue = new ArrayList<Float>();
		
		for(WebElement productPrice:productPriceElements) {
			Float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$", "")) ;
			productPriceValue.add(productPriceNumber);
		}
		
		List<Float> productPriceTextClone = new ArrayList<Float>(productPriceValue);
		
		Collections.sort(productPriceTextClone);
		Collections.reverse(productPriceTextClone);
		return productPriceValue.equals(productPriceTextClone);
	}
	
	
}
