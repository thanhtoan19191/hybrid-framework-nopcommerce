package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGING_BY_NUMBER="xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGING_BY_NUMBER_ACTIVED="xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_NAME="xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String ICON_BY_COUNTRY_NAME="xpath=//td [@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL="xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String HEADER_NAME_INDEX="xpath=//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_ROW_INDEX="xpath=//tr[%s]/td[%s]/input";
	
}
