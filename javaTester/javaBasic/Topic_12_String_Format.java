package javaBasic;

public class Topic_12_String_Format {
	
	
	public static String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static String CUSTOMER_INFOR_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	 
	//1 bien cho ca 14 page hoac n page(format giống nhau, chỉ khác tên)
	public static  String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME= "//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
	//1 locator để đại diện cho các page (header/ sidebar/footer)
	public static  String DYNAMIC_LINK_BY_PAGE_NAME= "//div[contains(@class,'%s')]//a[text()='%s']";
	
	//1 locator có tới 3 4 5 6 ... tham số động
	
	public static void main(String[] args) {
		
		  //clickToLink(CUSTOMER_INFOR_LINK); clickToLink(ADDRESS_LINK);
		  //clickToLink(MY_PRODUCT_REVIEW_LINK); clickToLink(REWARD_POINT_LINK);
		  
		  
		  clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Addresses");
		  clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "My product reviews");
		  clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Reward points");
		  clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Customer info");
		 
		
		
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Addresses");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper", "Search");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "header-upper", "My account");
		
	}
	
	
	public static void clickToLink(String locator) {
		System.out.println("Click to: " + locator);
	}
	 
	//1 Tham số động
	/*
	 * public static void clickToLink(String dyanmicLocator,String pageName) {
	 * 
	 * String locator = String.format(dyanmicLocator, pageName);
	 * System.out.println("Click to: " + locator); }
	 */
	
	//2 tham số động
	/*
	 * public static void clickToLink(String dyanmicLocator,String areaName,String
	 * pageName) {
	 * 
	 * String locator = String.format(dyanmicLocator, areaName,pageName);
	 * System.out.println("Click to: " + locator); }
	 */
	
	//n tham số động
	public static void clickToLink(String dyanmicLocator,String... params) {
		
		
		String locator = String.format(dyanmicLocator, (Object[])params);
		System.out.println("Click to: " + locator);
	}
}
