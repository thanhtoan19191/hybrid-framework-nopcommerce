package javaBasic;

import org.testng.annotations.Test;

public class Topic_09_Array {
	int arr[] = {5,8,15,7,60,1};
	static String name;
	static int age;
	
	public Topic_09_Array(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public static void display() {
		System.out.println("name" + name);
		System.out.println("age" + age);
	}
	
	//@Test
  public void TC_01_Max_Number() {
		
		int maxNum=0;
		for (int i=0;i<arr.length;i++) {
			if(maxNum < arr[i]) {
				maxNum = arr[i];
			}
		}
		System.out.println(maxNum);
		
  }
	
	//@Test
	  public void TC_02_Sum() {
		int sum=0;
		for (int i=0;i<arr.length;i++) {
			sum=arr[0] + arr[arr.length-1];
		}
		System.out.println(sum);
	}
	
	//@Test
	  public void TC_03_Even() {
		for (int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				System.out.println(arr[i]);
			}
		}
	}
	
	//@Test
	  public void TC_04_Sum_Over_Zero() {
		int arrNum[] = {3, -7, 2, 5, 9, -6, 10, 12};
		int sum=0;
		for (int i=0;i<arrNum.length;i++) {
			if(arrNum[i] >0 && arrNum[i]%2!=0) {
				sum+=arrNum[i];
			}
		}
		System.out.println(sum);
	}
	
	//@Test
	  public void TC_05_List() {
		int arrNum[] = {3, -7, 2, 5, 9, -6, 10, 12};
		for (int i=0; i<arrNum.length; i++) {
			if(arrNum[i] >=0 && arrNum[i]<=10) {
				System.out.println(arrNum[i]);
			}
		}
	}
	
	//@Test
	  public void TC_05_Sum_And_Everage() {
		int arrNum[] = {3,5,7,30,10,5,8,23,0,-5};
		int sum=0;
		float average=0f;
		for (int i=0; i<arrNum.length; i++) {
			sum+=arrNum[i];
		}
		System.out.println(sum);
		System.out.println(sum/arrNum.length);
		
	}
	

		
	  @Test
		public void TC_06(String[] args) {
			Topic_09_Array[] Topic_09_Arrays = new Topic_09_Array[2];
			Topic_09_Arrays[0]= new Topic_09_Array("Tien",25);
			Topic_09_Arrays[0]= new Topic_09_Array("Tuan",24);
			for(int i=0;i<2;i++) {
				Topic_09_Array.display();
			}
		}
	}

