package demoMaven.practice;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNG_Parameters {

	@Test(priority = 100)
	public void test1() {
		System.out.println("Test 1 is Running..");
	}

	@Test(priority = -200, invocationCount = 2)
	public void test2() {
		System.out.println("Test 2 is Running..");
	}

	@Test(invocationCount = 3)
	public void test3() {
		System.out.println("Test 3 is Running..");
	}

	@Test(enabled = false) // not executed bcz of enabled the value TRUE to FALSE
	public void test4() {
		System.out.println("Test 4 is Running..");
	}

	@Test
	public void test5() {
		System.out.println("Test 5 is Running..");
		Assert.fail(); // ForceFully Failed by Using ASSERT CLASS..
	}

	@Test(dependsOnMethods = { "test5" }) // Skipped bcz it depends on TEST 5 which is failed..
	public void test6() {
		System.out.println("Test 6 is Running..");
	}

	@Test(timeOut = 2000, description = "TestNG is parametes are act like an Attribute..")
	public void test7() throws InterruptedException {
		System.out.println("Test 7 is Running..");
		Thread.sleep(3000);
	}

	@Test(expectedExceptions = { ArithmeticException.class })
	public void test8() {
		System.out.println("Test 8 is Running..");
		int i = 5 / 0;
		System.out.println(i);
		Assert.fail(); // forcefully Pass bcz of EXPECTED-EXCEPTIONS parameter..
	}

	@Test(groups = { "arjun" })
	public void test9() {
		System.out.println("Test 9 is Running..");
	}

	@Test(groups = { "arjun" })
	public void test10() {
		System.out.println("Test 10 is Running..");
	}

}
