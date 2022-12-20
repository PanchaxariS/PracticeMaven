package demoMaven.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing_Annotations_Uses {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite runs ONLY ONES before all tests in Suite Executed");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test runs before First @test in Annotation Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class runs before First @test Method excecuted");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method runs before all @Test Annotation Method");
	}

	@Test
	public void test1() {
		System.out.println("Use to Defined Test1 Case to be Executed");
	}

	@Test
	public void test2() {
		System.out.println("Use to Defined Test2 Case to be Executed");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method executed after Every @Test Annotated Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This will Executed after all test methods in current class..");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Execute when all @Test annotated methods complete the execution..");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Run once after the Execution of all tests in the suite");
	}

}
