package com.hrm.employee;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.hrm.AddEmployeePageObject;
import pageObjects.hrm.DashboardPageObject;
import pageObjects.hrm.EmployeeListPageObject;
import pageObjects.hrm.LoginPageObject;
import pageObjects.hrm.PageGenerator;
import pageObjects.hrm.PersonalDetailPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_16_Live_Coding extends BaseTest {
	
	
	private WebDriver driver;
	String employeeID, statusValue;

	
	LoginPageObject loginPage;
	AddEmployeePageObject addEmployeePage;
	DashboardPageObject dashboardPage;
	EmployeeListPageObject employeeListPage;
	PersonalDetailPageObject personalDetailPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		
		log.info("Pre-condition -Step 01: Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);	
		loginPage=PageGenerator.getLoginPage(driver);
		
		statusValue="Enabled";
		
		log.info("Pre-condition -Step 02: Login with Admin role");
		loginPage.enterToTextBoxByID(driver, "txtUsername", "Admin");
		loginPage.enterToTextBoxByID(driver, "txtPassword", "admin123");
		loginPage.clickToButtonByID(driver, "btnLogin");
		dashboardPage=PageGenerator.getDashboardPage(driver);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New -Step 01: Open Employee list page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add_New -Step 02: Click to Add button");
		employeeListPage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage=PageGenerator.getAddEmployeePage(driver);
		
		log.info("Add_New - Step 03: Enter valid firtname textbox");
		addEmployeePage.enterToTextBoxByID(driver, "firstName", "Automation");
		
		log.info("Add_New -Step 04: Enter valid lastname textbox");
		addEmployeePage.enterToTextBoxByID(driver, "lastName", "FC");
		
		log.info("Add_New -Step 05: Get value of employee ID");
		employeeID = addEmployeePage.getTextboxValueByID(driver, "employeeId");
		
		log.info("Add_New -Step 06: Click to Create Login Details checkbox ");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");;
		
		log.info("Add_New -Step 07: Enter UserName textbox ");
		addEmployeePage.enterToTextBoxByID(driver, "user_name", "automationfc3");
		
		log.info("Add_New -Step 08: Enter Password textbox ");
		addEmployeePage.enterToTextBoxByID(driver, "user_password", "Admin@123!#");
		
		log.info("Add_New -Step 09: Enter Confirm Password textbox ");
		addEmployeePage.enterToTextBoxByID(driver, "re_password", "Admin@123!#");
		
		log.info("Add_New -Step 10: Select Enable value in Status Dropdown");
		addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);
		
		log.info("Add_New -Step 11: Click SAve button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		personalDetailPage = PageGenerator.getPersonalDetailPage(driver);
		
		log.info("Add_New -Step 12: Open Employee list page");
		personalDetailPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add_New -Step 13: Enter valid infor to Employee Name textbox");
		employeeListPage.sleepInsecond(5);
		employeeListPage.enterToTextBoxByID(driver, "empsearch_employee_name_empName", "Automation FC");
		employeeListPage.sleepInsecond(5);
		
		log.info("Add_New -Step 14: Click Search button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		employeeListPage.sleepInsecond(5);
		
		log.info("Add_New -Step 15: Verify employee information displayed at result table");
		//verifyTrue(employeeListPage.isValueDisplayedInTableIDAtColumnNameAndRowIndex("resultTable","Last Name","1","Anderson"));
		
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable","Id","1"), employeeID);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable","Last Name","1"), "FC");
		
	}	
		
	@Test
	public void Employee_02_Upload_Avatar() {
		
	}
	
	@Test
	public void Employee_03_Personal_Details() {
		
	}
	
	@Test
	public void Employee_04_Contact_Details() {
		
	}
	
	@Test
	public void Employee_05_Emergency_Details() {
		
	}
	
	@Test
	public void Employee_06_Assigned_Dependents() {
		
	}
	
	@Test
	public void Employee_07_Edit_View_Job() {
		
	}
	
	@Test
	public void Employee_08_Edit_View_Salary() {
		
	}
	
	@Test
	public void Employee_09_Edit_View_Tax() {
		
	}
	
	@Test
	public void Employee_10_Qualifications() {
		
	}
	
	@Test
	public void Employee_11_Search_Employee() {
		
	}

	

	
	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition: close browser" + browserName +"");
		cleanDriverInstance();
	}



}
