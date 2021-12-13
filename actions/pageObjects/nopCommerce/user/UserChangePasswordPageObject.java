package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.ChangePasswordPageUI;


	public class UserChangePasswordPageObject extends BasePage {
		WebDriver driver;
		
		public UserChangePasswordPageObject(WebDriver driver) {
			this.driver=driver;
		}
		
		public void inputOldPassword(String oldPassword) {
			waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASS_WORD);
			sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASS_WORD, oldPassword);
				
	}

		public void inputNewPassword(String newPassword) {
			waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASS_WORD);
			sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASS_WORD, newPassword);
			
		}

		public void inputConfirmNewPassword(String confirmNewPassword) {
			waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_NEW_PASS_WORD);
			sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASS_WORD, confirmNewPassword);
			
		}

		public void clickNewPassword() {
			waitForElementVisible(driver, ChangePasswordPageUI.SAVE_PASSWORD_BUTTON);
			clickToElement(driver, ChangePasswordPageUI.SAVE_PASSWORD_BUTTON);
			
		}

		public boolean isPasswordChangedDisplayed() {
			waitForElementVisible(driver, ChangePasswordPageUI.PASSWORD_WAS_CHANGED);
			return isElementDisplayed(driver, ChangePasswordPageUI.PASSWORD_WAS_CHANGED);
		}

		public void clickClosePasswordChangedMessage() {
			waitForElementVisible(driver, ChangePasswordPageUI.CLOSE_CHANGED_PASSWORD_MESSAGE);
			clickToElement(driver, ChangePasswordPageUI.CLOSE_CHANGED_PASSWORD_MESSAGE);
			
		}

		public UserHomePageObject clickToLogoutLink() {
			waitForElementVisible(driver, ChangePasswordPageUI.LOG_OUT_LINK);
			clickToElement(driver, ChangePasswordPageUI.LOG_OUT_LINK);
			return PageGeneratorManager.getUserHomePage(driver);
			
		}

}

	
