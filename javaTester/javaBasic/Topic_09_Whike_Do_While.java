package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_Whike_Do_While {
	static Scanner scanner = new Scanner (System.in);
	/*
	 * public static void main (String[] args) { TC_01(); }
	 */
	
	//@Test
	public static void TC_01_While() {
		int number = scanner.nextInt();
		while(number<=100) {
			if(number%2==0) {
				System.out.println(number);
			}
			number++;
		}
	}
	
	//@Test
	public static void TC_02_Do_While() {
		int number = scanner.nextInt();
		do{
			if(number%2==0) {
				System.out.println(number);
			}
			number++;
		}
		while(number<=100);
	}
	
	//@Test
	public static void TC_03_While() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		while(numberA <= numberB) {
			if(numberA %3==0 && numberA%5==0) {
				System.out.println(numberA);
			}
			numberA++;
		}
	}
	
	//@Test
	public static void TC_04_While() {
		int number = scanner.nextInt();
		int i=0;
		int Tong=0;
		while(i<=number) {
			if(i%2!=0) {
				Tong+=i;
			}
			i++;
		}
		System.out.println(Tong);
	}
	
	//@Test
	public static void TC_05_While() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		while(numberA <= numberB) {
			if(numberA %3==0) {
				System.out.println(numberA);
			}
			numberA++;
		}
	}
	
	//@Test
	public void TC_06_While() {
		int number = scanner.nextInt();
		int tich=1;
		int i=2;
		while(i<=number) {
			tich*=i;
			i++;
		}
		System.out.println(tich);
	}
	
	@Test
	public void TC_07_While() {
		int i=1;
		int Tong=0;
		while(i<=10) {
			if(i%2==0) {
				Tong+=i;
			}
			i++;
		}
		System.out.println(Tong);
	}
}
