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
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.hrm.AddEmployeePageObject;
import pageObjects.hrm.DashboardPageObject;
import pageObjects.hrm.EmployeeListPageObject;
import pageObjects.hrm.LoginPageObject;
import pageObjects.hrm.PageGenerator;
import pageObjects.hrm.MyInforPO;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInForPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_16_Live_Coding extends BaseTest {
	
	
	private WebDriver driver;
	
	String adminUserName, adminPassword, empFirstName, empLastName, empUserName, empPassword, empFullName, employeeID, statusValue;
	String editEmpFirstName, editEmpLastName, editEmpGender, editEmpMaritalStatus, editEmpNationality;
	String avatarFilePath=GlobalConstants.UPLOAD_FOLDER_PATH +"Avatar.JPG";

	
	LoginPageObject loginPage;
	AddEmployeePageObject addEmployeePage;
	DashboardPageObject dashboardPage;
	EmployeeListPageObject employeeListPage;
	MyInforPO myInforPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		
		log.info("Pre-condition -Step 01: Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);	
		loginPage=PageGenerator.getLoginPage(driver);
		
		statusValue="Enabled";
		adminUserName="Admin";
		adminPassword="admin123";
		empFirstName="Automation";
		empLastName="FC";
		empFullName= empFirstName + " "+empLastName;
		empUserName="afcvn";
		empPassword="automation123";
		
		editEmpFirstName="John"; 
		editEmpLastName="Wick"; 
		editEmpGender="Male"; 
		editEmpMaritalStatus="Single"; 
		editEmpNationality="Vietnamese";
		
		log.info("Pre-condition -Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSystem(driver, adminUserName, adminPassword);
	
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
		addEmployeePage.enterToTextBoxByID(driver, "firstName", empFirstName);
		
		log.info("Add_New -Step 04: Enter valid lastname textbox");
		addEmployeePage.enterToTextBoxByID(driver, "lastName", empLastName);
		
		log.info("Add_New -Step 05: Get value of employee ID");
		employeeID = addEmployeePage.getTextboxValueByID(driver, "employeeId");
		
		log.info("Add_New -Step 06: Click to Create Login Details checkbox ");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");;
		
		log.info("Add_New -Step 07: Enter UserName textbox ");
		addEmployeePage.enterToTextBoxByID(driver, "user_name", empUserName);
		
		log.info("Add_New -Step 08: Enter Password textbox ");
		addEmployeePage.enterToTextBoxByID(driver, "user_password", empPassword);
		
		log.info("Add_New -Step 09: Enter Confirm Password textbox ");
		addEmployeePage.enterToTextBoxByID(driver, "re_password", empPassword);
		
		log.info("Add_New -Step 10: Select Enable value in Status Dropdown");
		addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);
		
		log.info("Add_New -Step 11: Click SAve button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		myInforPage = PageGenerator.getMyInforPage(driver);
		
		log.info("Add_New -Step 12: Open Employee list page");
		myInforPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add_New -Step 13: Enter valid infor to Employee Name textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.enterToTextBoxByID(driver, "empsearch_employee_name_empName", empFullName);
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Add_New -Step 14: Click Search button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Add_New -Step 15: Verify employee information displayed at result table");
		//verifyTrue(employeeListPage.isValueDisplayedInTableIDAtColumnNameAndRowIndex("resultTable","Last Name","1","Anderson"));
		
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable","Id","1"), employeeID);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable","Last Name","1"), "FC");
		
	}	
		
	@Test
	public void Employee_02_Upload_Avatar() {
		log.info("Upload_Avatar -Step 1:Login with employee role");
		loginPage=employeeListPage.logoutToSystem(driver);
		dashboardPage = loginPage.loginToSystem(driver, empUserName, empPassword);
		
		log.info("Upload_Avatar -Step 2:Open Personal Detail Page");
		dashboardPage.openMenuPage(driver, "My Info");
		myInforPage = PageGenerator.getMyInforPage(driver);
		
		log.info("Upload_Avatar -Step 3:Click to change photo image");
		myInforPage.clickToChangePhotoImage();
		
		log.info("Upload_Avatar -Step 4:upload new avatar image");
		myInforPage.uploadImage(driver, avatarFilePath);
		
		log.info("Upload_Avatar -Step 5:Click to upload button");
		myInforPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Upload_Avatar -Step 6:Verify success message is displayed");
		verifyTrue(myInforPage.isSuccessMessageDisplayed(driver,"Successfully Uploaded"));
		
		log.info("Upload_Avatar -Step 7:Verify new avatar image is displayed");
		verifyTrue(myInforPage.isNewAvatarImageDisplayed());
	}
	
	@Test
	public void Employee_03_Personal_Details() {
		log.info("Personal_Details -Step 1:Open personal detail tab at sidebar");
		myInforPage.openTabAtSideBarByName("Personal Details");
		
		log.info("Personal_Details -Step 2:VErify all fields at personal detail tab are disabled");
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtEmpFirstName"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtEmpLastName"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtEmployeeId"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtLicenNo"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtNICNo"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtSINNo"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_optGender_1"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_optGender_2"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_cmbMarital"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_cmbNation"));
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_DOB"));
		
		log.info("Personal_Details -Step 3:Click to Edit button at personal detail form");
		myInforPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Personal_Details -Step 4:Verify employeeID textbox is disabled");
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtEmployeeId"));
		
		log.info("Personal_Details -Step 5:Verify driver liscense number textbox is disabled");
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtLicenNo"));
		
		log.info("Personal_Details -Step 6:Verify SSN number textbox is disabled");
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtNICNo"));
		
		log.info("Personal_Details -Step 7:Verify SIN number textbox is disabled");
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_txtSINNo"));
		
		log.info("Personal_Details -Step 8:Verify date of birth textbox is disabled");
		verifyFalse(myInforPage.isFieldEnableByName(driver, "personal_DOB"));
		
		log.info("Personal_Details -Step 9:Enter new value to firstname textbox");
		myInforPage.enterToTextboxByID(driver, "personal_txtEmpFirstName", editEmpFirstName);
		
		log.info("Personal_Details -Step 10:Enter new value to lastname textbox");
		myInforPage.enterToTextboxByID(driver, "personal_txtEmpLastName", editEmpLastName);
		
		log.info("Personal_Details -Step 11:Enter new value to gender radio button");
		myInforPage.clickToRadioByLabel(driver, editEmpGender);
		
		log.info("Personal_Details -Step 12:Enter new value to marital status dropdown");
		myInforPage.selectItemInDropdownByID(driver, "personal_cmbMarital", editEmpMaritalStatus);
		
		log.info("Personal_Details -Step 13:Enter new value to nationality dropdown");
		myInforPage.selectItemInDropdownByID(driver, "personal_cmbNation", editEmpNationality);
		
		log.info("Personal_Details -Step 14:Click Save button at personal detail");
		myInforPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Personal_Details -Step 15:Verify success message is displayed");
		verifyTrue(myInforPage.isSuccessMessageDisplayed(driver,"Successfully Saved"));
		
		log.info("Personal_Details -Step 16:verify firstname textbox is updated successfully");
		verifyEquals(myInforPage.getTextboxValueByID(driver, "personal_txtEmpFirstName"), editEmpFirstName) ;
		
		log.info("Personal_Details -Step 17:verify lastname textbox is updated successfully");
		verifyEquals(myInforPage.getTextboxValueByID(driver, "personal_txtEmpLastName"), editEmpLastName) ;
		
		log.info("Personal_Details -Step 18:verify gender radio button is updated successfully");
		verifyTrue(myInforPage.isRadioButtonSelectedByLabel(driver, editEmpGender));
		
		log.info("Personal_Details -Step 19:verify marital status dropdown is updated successfully");
		verifyEquals(myInforPage.getSelectedValueInDropdownByID(driver, "personal_cmbMarital"), editEmpMaritalStatus);
		
		log.info("Personal_Details -Step 20:verify nationality dropdown is updated successfully");
		verifyEquals(myInforPage.getSelectedValueInDropdownByID(driver, "personal_cmbNation"), editEmpNationality);
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
