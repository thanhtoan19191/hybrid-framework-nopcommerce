package pageUIs.nopCommerce.admin;

public class AdminBasePageUI {
	public static final String MENU_LINK_BY_NAME="xpath=//ul[@role='menu']/li/a/p[contains(text(),'%s')]";
	public static final String SUB_MENU_LINK_BY_NAME="xpath=//ul[@class='nav nav-treeview' and @style]//p[contains(text(),'%s')]";
	public static final String UPLOAD_FILE_BY_CARD_NAME="xpath=//div[@id='product-%s']//input[@type='file']";
	public static final String NO_DATA_MESSAGE_BY_TABLE_NAME="xpath=//table[@id='%s-grid']//td[@class='dataTables_empty' and text()='No data available in table']";
	public static final String DYNAMIC_TEXTBOX_BY_ID="xpath=//input[@id='%s']";
	public static final String DYNAMIC_PAGE_HEADER="xpath=//div[@class='header']//a[text()='%s']";
	public static final String DYNAMIC_RADIO_BY_ID="xpath=//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME="xpath=//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT="xpath=//button[text()='%s']";
	
}
