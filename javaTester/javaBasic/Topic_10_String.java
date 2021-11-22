package javaBasic;

import java.util.Iterator;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_10_String {
	Scanner scanner = new Scanner (System.in);
	
	//@Test
	public void TC_01() {
		String courseName = "Automation Testing Advanced";
		char courseNameArr[] = courseName.toCharArray();
		int count = 0;
		for (char character : courseNameArr) {
			//Upper case
			if (character>= 'A' && character<='Z')  {
				count +=1;
			}
			
		}
		System.out.println(count);
	}
	
	//@Test
	public void TC_02() {
		String courseName = "Automation Testing 345 Tutorials online 798";
		
		char courseNameArr[] = courseName.toCharArray();
		int countCharacterA = 0;
		for (char character : courseNameArr) {
			if (character == 'A' || character == 'a') {
				countCharacterA += 1;
			}
		}
		System.out.println("Số ký tự a:" + countCharacterA);
		 
		
		System.out.println("Có chữ Testing:"+courseName.contains("Testing"));
		System.out.println("Có chữ bắt đầu bằng Automation:"+courseName.startsWith("Automation"));
		System.out.println("Có chữ kết thúc bằng Online:"+courseName.endsWith("Online"));
		
		int index = courseName.indexOf("Tutorials");
		System.out.println("vị trí Tutorials:"+index);
		
		System.out.println("Thay thế online bằng offline:"+courseName.replace("online", "offline"));
		
		int countCharacterNumber = 0;
		for (char character : courseNameArr) {
			if (character >= '0' && character <= '9') {
				countCharacterNumber += 1;
			}
		}
		System.out.println("Số ký tự số:" + countCharacterNumber);
		
	}
	
	@Test
	public void TC_03() {
		String name = scanner.nextLine();
		char courseNameArr[] = name.toCharArray();
		for (int i=courseNameArr.length-1; i>=0; i--) {
			System.out.println(courseNameArr[i]);
			
			
		}
	}
}
