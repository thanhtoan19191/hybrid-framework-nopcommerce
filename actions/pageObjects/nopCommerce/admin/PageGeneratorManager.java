package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;



public class PageGeneratorManager {
	private static AdminLoginPageObject loginPage;
	private static AdminDashboardPageObject dashboardPage;
	private static AdminProductSearchPageObject productSearchPage;
	private static AdminProductDetailPageObject productDetailPage;
	

	private PageGeneratorManager() {

	}

	public static AdminLoginPageObject getLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static AdminProductSearchPageObject getProductSearchPage(WebDriver driver) {
		return new AdminProductSearchPageObject(driver);
	}
	
	public static AdminProductDetailPageObject getproductDetailPage(WebDriver driver) {
		return new AdminProductDetailPageObject(driver);
	}
}
