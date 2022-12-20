package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.GoogleSearch;
import main.SauceDemo;

public class TestClass {
	WebDriver driver;

	@BeforeTest
	public void initializeChrome() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium browser\\Browser Launch\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

	}

	@Test
	public void searchGoogle() {
		GoogleSearch ak = new GoogleSearch(driver);
		ak.searchBox();
		ak.clickLink();

	}

	@Test(dependsOnMethods = { "searchGoogle" })
	public void website() {
		SauceDemo a = new SauceDemo(driver);
		a.un();
		a.pwd();
		a.click();
		a.listBox();
		a.selectCloth();
		a.clickCart();
		a.checkOrder();
		a.enterName();
		a.enterLN();
		a.enterPC();
		a.continueButton();

	}

}
