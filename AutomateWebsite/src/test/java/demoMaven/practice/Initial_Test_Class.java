package demoMaven.practice;

import org.testng.annotations.Test;

public class Initial_Test_Class {
	public static void main(String[] args) {
		Initial_Test_Class a = new Initial_Test_Class();
		a.test3();
	}

	@Test
	public void test1() {
		System.out.println("Test1 is Running..");
	}

	@Test
	public void test2() {
		System.out.println("Test2 is Running");
	}
	
	public void test3() {	//This is not executed because of unAvailability of @Test Annotation
		System.out.println("Test3 is Running");
	}

}
