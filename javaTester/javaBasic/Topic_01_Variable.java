package javaBasic;

public class Topic_01_Variable {
	static int studentNumber;
	static boolean statusValue;
	static final String browserName="Chrome";
	
	String studentName="AutomationFC";
	
	public static void main(String[] args) {
		System.out.println(studentNumber);
		System.out.println(statusValue);
	}

	
	//getter
	public String getStudentName() {
		return this.studentName;
	}
	
	//Setter
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}
