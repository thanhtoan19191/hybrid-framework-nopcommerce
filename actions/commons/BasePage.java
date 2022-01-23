package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.hrm.DashboardPageObject;
import pageObjects.hrm.LoginPageObject;
import pageObjects.hrm.PageGenerator;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductSearchPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUIs.hrm.MyInforPageUI;
import pageUIs.nopCommerce.admin.AdminBasePageUI;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.CustomerInforPageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	public void openPageURL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByPageTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			String actualPageTitle = driver.getTitle();
			if (actualPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentPageID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentPageID)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(parentPageID);
	}
	

	
	
	//locatorType: id=/  css=/ xpath=/ name=/ class=/
	//locatorType: Id=/  Css=/ Xpath=/ Name=/ Class=/
	//locatorType: ID=/  CSS=/ XPATH=/ NAME=/ CLASS=/
	private By getByLocator(String locatorType) {
		By by=null;
		System.out.println("Locator type =" + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by=By.id(locatorType.substring(3));
		}else if(locatorType.startsWith("class=")|| locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")){
			by=By.className(locatorType.substring(6));
		}else if(locatorType.startsWith("name=")|| locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")){
			by=By.name(locatorType.substring(5));
		}else if(locatorType.startsWith("css=")|| locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by=By.cssSelector(locatorType.substring(4));
		}else if(locatorType.startsWith("xpath=")|| locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")|| locatorType.startsWith("XPath=")) {
			by=By.xpath(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator type is not support!");
		}
		return by;
	}
	
	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		System.out.println("Locator type before:" + locatorType);
		if(locatorType.startsWith("xpath=")|| locatorType.startsWith("XPATH=") || 
				locatorType.startsWith("Xpath=")|| locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		for (String value : dynamicValues) {
			System.out.println("Value map to locator:" + value);
		}
		
		System.out.println("Locator type after:" + locatorType);
		return locatorType;
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
	
	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	
	public WebElement getWebElement(WebDriver driver, String locatorType, String...params) {
		return driver.findElement(getByLocator(getDynamicXpath(locatorType, params)));
	}
	
	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	
	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}
	
	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText().trim();
	}
	
	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText().trim();
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	

	
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}
	

	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String ...params) {
		locatorType=getDynamicXpath(locatorType, params);
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}
	
	public void selectItemDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(driver, parentXpath).click();
		sleepInsecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInsecond(1);
				item.click();
				break;
			}
		}
	}
	
	
	public void sleepInsecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String...params) {
		return getWebElement(driver, getDynamicXpath(locatorType, params)).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}
	
	public int getElementSize(WebDriver driver, String locatorType,String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}
	
	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType, String...params) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, params));
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		System.out.println("Start time=" +new Date().toString());
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements=getListWebElement(driver, locatorType);
		overrideGlobalTimeout(driver, longTimeout);
		
		if(elements.size()==0) {
			System.out.println("Element not in DOM");
			System.out.println("End time=" + new Date().toString());
			return true;
		}else if(elements.size()>0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible on UI");
			System.out.println("End time=" + new Date().toString());
			return true;
		}else {
			System.out.println("Element in DOM and visible on UI");
			return false;
		}
	}
	
	public void overrideGlobalTimeout(WebDriver driver,long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locatorType,String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locatorType,String... params) {
		return getWebElement(driver, getDynamicXpath(locatorType, params)).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locatorType, String...params) {
		return getWebElement(driver, getDynamicXpath(locatorType, params)).isEnabled();
	}
	
	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locatorType, String... dynamicValues ) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
	}


	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	
	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}


	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}
	
	public boolean isJQueryAjaxLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait= new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return(Boolean)jsExecutor.executeScript("return (window.jQuery !=null) && (jQuery.active===0);");
			}
		};
		return explicitWait.until(jQueryLoad);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locatorType,String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForAllElementsVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	public void waitForAllElementsVisible(WebDriver driver, String locatorType,String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForAllElementsInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver,locatorType)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locatorType,String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	//Tối ưu bài học switch page User Nopcommerce
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}
	
	public UserRewardPointPageObject openRewardPoint(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}
	
	public UserCustomerInForPageObject openCustomerInforPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
	
	public UserChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getUserChangePasswordPage(driver);
	}
	
	
	//Tối ưu bài học Dynamic locator
	public BasePage openPagesAtMyAccountByName(WebDriver driver,String pageName ) {
		
		waitForAllElementsVisible(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInforPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		case "Change password":
			return PageGeneratorManager.getUserChangePasswordPage(driver);
			
		default:
			throw new RuntimeException("Invalid Page Name at My Account");
		}
	}
	
	public void openPagesAtMyAccountByPageName(WebDriver driver,String pageName ) {
		
		waitForAllElementsVisible(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		
	}
	
	//switch role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String...params) {
		Actions action = new Actions(driver);
		locator=getDynamicXpath(locator, params);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}
	
	//Admin-nopcommerce
		public void openSubMenuPageByName(WebDriver driver,String menuPageName, String submenuPageName) {
			waitForElementClickable(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuPageName);
			clickToElement(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuPageName);
			waitForElementClickable(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, submenuPageName);
			clickToElement(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, submenuPageName);
			
		}
		
		public void uploadMultipleFiles(WebDriver driver,String cardName, String...fileNames) {
			String filePath=System.getProperty("user.dir")+"\\uploadFiles\\";
			String fullFileName="";
			for (String file : fileNames) {
				fullFileName=fullFileName+filePath+file+"\n";
			}
			fullFileName=fullFileName.trim();
			getWebElement(driver, AdminBasePageUI.UPLOAD_FILE_BY_CARD_NAME, cardName).sendKeys(fullFileName);
		
		}
		
		public boolean isMessageDisplayedInEmptyTable(WebDriver driver, String tableName) {
			waitForElementVisible(driver, AdminBasePageUI.NO_DATA_MESSAGE_BY_TABLE_NAME,tableName);
			return isElementDisplayed(driver, AdminBasePageUI.NO_DATA_MESSAGE_BY_TABLE_NAME,tableName);
		}
		
		public void enterToTextboxByID(WebDriver driver,String textboxID, String value) {
			waitForElementVisible(driver, AdminBasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
			sendkeyToElement(driver, AdminBasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
			
		}
		
		public void openHeaderPageByName(WebDriver driver,String pageName) {
			waitForElementClickable(driver, AdminBasePageUI.DYNAMIC_PAGE_HEADER, pageName);
			clickToElement(driver, AdminBasePageUI.DYNAMIC_PAGE_HEADER, pageName);
		}
		
		public void clickToRadioButtonByID(WebDriver driver, String radioButtonID) {
			waitForElementClickable(driver, AdminBasePageUI.DYNAMIC_RADIO_BY_ID, radioButtonID);
			clickToElement(driver, AdminBasePageUI.DYNAMIC_RADIO_BY_ID, radioButtonID);
		}
		
		public void selectDropdownByName(WebDriver driver, String dropdownName, String itemtext) {
			selectItemInDefaultDropdown(driver, AdminBasePageUI.DYNAMIC_DROPDOWN_BY_NAME, itemtext, dropdownName);
		}
		
		public void clickToButtonByText(WebDriver driver,String buttonText) {
			waitForElementClickable(driver, AdminBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
			clickToElement(driver, AdminBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		}
		
		//HRM: Menu
		public void openMenuPage(WebDriver driver, String menuPageName) {
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, menuPageName);
			clickToElement(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, menuPageName);
		}
		
		// submenu
		public void openSubMenuPage(WebDriver driver, String menuPageName, String subMenuPageName) {
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, menuPageName);
			clickToElement(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, menuPageName);
			
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, subMenuPageName);
			clickToElement(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, subMenuPageName);
		}
		
		// childsubmenu
		public void openChildSubMenuPage(WebDriver driver, String menuPageName, String subMenuPageName, String childSubMenuPageName) {
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, menuPageName);
			clickToElement(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, menuPageName);
			
			waitForElementVisible(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, subMenuPageName);
			hoverMouseToElement(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, subMenuPageName);
			
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, childSubMenuPageName);
			clickToElement(driver, pageUIs.hrm.BasePageUI.DYNAMIC_MENU_PAGE, childSubMenuPageName);
		}
		
		public void clickToButtonByID(WebDriver driver, String ButtonIDName) {
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.BUTTON_BY_ID, ButtonIDName);
			clickToElement(driver, pageUIs.hrm.BasePageUI.BUTTON_BY_ID, ButtonIDName);
		}
		
		//enter textbox component
		public void enterToTextBoxByID(WebDriver driver, String textBoxIDName, String value) {
			waitForElementVisible(driver, pageUIs.hrm.BasePageUI.TEXTBOX_BY_ID, textBoxIDName);
			sendkeyToElement(driver, pageUIs.hrm.BasePageUI.TEXTBOX_BY_ID, value, textBoxIDName);
		}
		
		//Get textbox value component
		public String getTextboxValueByID(WebDriver driver, String textBoxIDName) {
			waitForElementVisible(driver, pageUIs.hrm.BasePageUI.TEXTBOX_BY_ID, textBoxIDName);
			return getElementAttribute(driver, pageUIs.hrm.BasePageUI.TEXTBOX_BY_ID, "value", textBoxIDName);
		}
		
		//Dropdown
		public void selectItemInDropdownByID(WebDriver driver,String dropdownID, String valueItem ) {
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.DROPDOWN_BY_ID, dropdownID);
			selectItemInDefaultDropdown(driver, pageUIs.hrm.BasePageUI.DROPDOWN_BY_ID, valueItem, dropdownID);
		}
		
		//Get Dropdown selected value
		public String getSelectedValueInDropdownByID(WebDriver driver,String dropdownID ) {
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.DROPDOWN_BY_ID, dropdownID);
			return getSelectedItemDefaultDropdown(driver, pageUIs.hrm.BasePageUI.DROPDOWN_BY_ID, dropdownID);
		}
	
		
		public void clickToCheckboxByLabel(WebDriver driver,String checkboxLabelName) {
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.CHECKBOX_BY_LABEL, checkboxLabelName);
			checkToDefaultCheckboxRadio(driver, pageUIs.hrm.BasePageUI.CHECKBOX_BY_LABEL, checkboxLabelName);
		}
		
		public String getValueInTableIDAtColumnNameAndRowIndex(WebDriver driver,String tableID, String headerName, String rowIndex) {
			int columnIndex = getElementSize(driver, pageUIs.hrm.BasePageUI.TABLE_HEADER_BY_ID_AND_NAME, tableID,headerName)+1;
			waitForElementVisible(driver, pageUIs.hrm.BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID,rowIndex, String.valueOf(columnIndex));
			return getElementText(driver, pageUIs.hrm.BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID,rowIndex,String.valueOf(columnIndex));
		}
		
		public LoginPageObject logoutToSystem(WebDriver driver) {
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.WELCOME_USER_LINK);
			clickToElement(driver, pageUIs.hrm.BasePageUI.WELCOME_USER_LINK);
			waitForElementClickable(driver, pageUIs.hrm.BasePageUI.LOGOUT_LINK);
			clickToElement(driver, pageUIs.hrm.BasePageUI.LOGOUT_LINK);
			return PageGenerator.getLoginPage(driver);
		}
		
		public DashboardPageObject loginToSystem(WebDriver driver, String userName, String password) {
			waitForElementVisible(driver, pageUIs.hrm.BasePageUI.USER_LOGIN_TEXTBOX);
			sendkeyToElement(driver, pageUIs.hrm.BasePageUI.USER_LOGIN_TEXTBOX, userName);
			sendkeyToElement(driver, pageUIs.hrm.BasePageUI.PASSWORD_LOGIN_TEXTBOX, password);
			clickToElement(driver, pageUIs.hrm.BasePageUI.LOGIN_BUTTON);
			return PageGenerator.getDashboardPage(driver);
		}
		
		public void uploadImage(WebDriver driver, String filePath) {
			
			getWebElement(driver, pageUIs.hrm.BasePageUI.UPLOAD_FILE).sendKeys(filePath);
		
		}
		
		public boolean isSuccessMessageDisplayed(WebDriver driver, String messageValue) {
			waitForElementVisible(driver, pageUIs.hrm.BasePageUI.SUCCESS_MESSAGE_VALUE,messageValue);
			return isElementDisplayed(driver, pageUIs.hrm.BasePageUI.SUCCESS_MESSAGE_VALUE,messageValue);
			
		}
		
		public boolean isFieldEnableByName(WebDriver driver, String fieldID) {
			waitForElementVisible(driver, pageUIs.hrm.BasePageUI.ANY_FIELD_BY_ID, fieldID);
			return isElementEnabled(driver, pageUIs.hrm.BasePageUI.ANY_FIELD_BY_ID, fieldID);
		}
		
		public void clickToRadioByLabel(WebDriver driver,String radioLabelName) {
			waitForElementClickable(driver,pageUIs.hrm.BasePageUI.RADIO_BY_LABEL , radioLabelName);
			checkToDefaultCheckboxRadio(driver,pageUIs.hrm.BasePageUI.RADIO_BY_LABEL , radioLabelName);
		}
		
		public boolean isRadioButtonSelectedByLabel(WebDriver driver, String labelName) {
			waitForElementVisible(driver,pageUIs.hrm.BasePageUI.RADIO_BY_LABEL,labelName);
			return isElementSelected(driver,pageUIs.hrm.BasePageUI.RADIO_BY_LABEL,labelName);
		}
		
		public List<WebElement> getElements(WebDriver driver, String locator) {
			return driver.findElements(getByXpath(locator));
		}
		
		public By getByXpath(String locator) {
			return By.xpath(locator);
		}
		
	private long longTimeout = 30;
	private long shortTimeout = 5;
}
