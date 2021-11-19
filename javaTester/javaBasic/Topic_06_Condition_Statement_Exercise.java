package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;



public class Topic_06_Condition_Statement_Exercise {
	Scanner scanner = new Scanner (System.in);
	
	//@Test
	public void TC_01() {
		
		int number = scanner.nextInt();
		if (number%2==0 ) {
			System.out.println(number + "là số chẵn");
		}else {
			System.out.println(number + "là số lẻ");
		}
		
	}
	
	//@Test
	public void TC_02() {
		int firstNumber = scanner.nextInt();
		int secondNumber = scanner.nextInt();
		if (firstNumber >= secondNumber ) {
			System.out.println(firstNumber + " lớn hơn hoặc bằng " + secondNumber);
		}else {
			System.out.println(firstNumber + " nhỏ hơn " + secondNumber);
		}
	}
	
	//@Test
	public void TC_03() {
		String firstPeopleName = scanner.nextLine();
		String secondPeopleName = scanner.nextLine();
		if (firstPeopleName.equals(secondPeopleName)) {
			System.out.println(firstPeopleName + " giống tên " + secondPeopleName);
		}else {
			System.out.println(firstPeopleName + " khác tên " + secondPeopleName);
		}
	}
	
	//@Test
	public void TC_04() {
		int firstNumber = scanner.nextInt();
		int secondNumber = scanner.nextInt();
		int thirstNumber = scanner.nextInt();
		
		if (firstNumber > secondNumber && firstNumber > thirstNumber) {
			System.out.println(firstNumber + " là số lớn nhất " );
		}else if (secondNumber > firstNumber && secondNumber > thirstNumber) {
			System.out.println(secondNumber + " là số lớn nhất " );
		}else {
			System.out.println(thirstNumber + " là số lớn nhất " );
		}
	}
	
	//@Test
	public void TC_05() {
		int number = scanner.nextInt();
		if (number>=10 && number<=100) {
			System.out.println(number + " nằm trong [10, 100] " );
		}else {
			System.out.println(number + " không nằm trong [10, 100] " );
		}
	}
	
	//@Test
	public void TC_06() {
		float point = scanner.nextFloat();
		if (point>0 && point<=5) {
			System.out.println(point + " là điểm D " );
		}else if (point>5 && point<=7.5) {
			System.out.println(point + " là điểm C " );
		}else if (point>7.5 && point<=8.5) {
			System.out.println(point + " là điểm B " );
		}else if (point>8.5 && point<=10) {
			System.out.println(point + " là điểm A " );
		}else {
			System.out.println("Vui lòng nhập lại" );
		}
	}
	
	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		
		if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
			System.out.println(month + " là tháng 31 ngày");
		}else if (month==2) {
			System.out.println(month + " là tháng 28 hoặc 29 ngày");
		}else if (month==4 || month==6 || month==9 || month==11) {
			System.out.println(month + " là tháng 30 ngày");
		}else {
			System.out.println("Tháng ko hợp lệ");
		}
	}
	
}


