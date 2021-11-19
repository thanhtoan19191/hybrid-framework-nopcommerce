package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner (System.in);

	@Parameters("browser")
	//@Test
	public void TC_01(String browserName) {
		driver = getBrowserDrivers(browserName);
		
		System.out.println(browserName);
		
		driver.quit();
	}
	
	//@Test
	public void TC_02() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(month + " là tháng 31 ngày");
			break;
		case 2:
			System.out.println(month + " là tháng 28 hoặc 29 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(month + " là tháng 30 ngày");
			break;
		default:
			System.out.println("Tháng ko hợp lệ");
			break;
		}
		
	}
	
	//@Test
	public void TC_03() {
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
		}
	}
	
	@Test
	public void TC_04() {
		
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		String match = scanner.next();
		switch (match) {
		case ("Tong"):
			System.out.println(numberA + numberB);
			break;
		case ("Hieu"):
			System.out.println(numberA - numberB);
			break;
		case ("Tich"):
			System.out.println(numberA * numberB);
			break;
		case ("Thuong"):
			System.out.println(numberA / numberB);
			break;

		default:
			System.out.println("Ko hợp lệ");
			break;
		}
		
	}
	
	
	
	public WebDriver getBrowserDrivers(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			return new ChromeDriver();
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			return new FirefoxDriver();
		}
		return driver;
		
	}
	

}
