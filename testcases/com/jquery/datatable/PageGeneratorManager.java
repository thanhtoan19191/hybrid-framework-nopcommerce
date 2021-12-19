package com.jquery.datatable;

import org.openqa.selenium.WebDriver;

import pageObject.jQuery.HomePageObject;



public class PageGeneratorManager {
	private static HomePageObject homePage;
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if (homePage ==null) {
			homePage=new HomePageObject(driver);
		}
		return homePage;
	}
	
	
}
