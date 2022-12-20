package demoMaven.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class Assertions {
	WebDriver driver;
	SoftAssert b = new SoftAssert();

	@Test
	public void login() { // Assert
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium browser\\Browser Launch\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		String expTitle = "Swa Labs";
		String actTitle = driver.getTitle();

//		Assert.assertEquals(expTitle, actTitle);
//		Assert.assertEquals("Two Title Not Matched", expTitle, actTitle);
		b.assertEquals(expTitle, actTitle);
//		b.assertAll();
	}

	@Test
	public void login1() { // Assert
		WebElement ak = driver.findElement(By.className("login_logo"));
//		Assert.assertTrue(ak.isDisplayed());
		Assert.assertFalse("Condition is True", ak.isDisplayed());
	}

	@Test
	public void login2() {
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		WebElement as = driver.findElement(By.className("inventory_item_name"));
		as.click();
		WebElement image = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/img"));
		b.assertTrue(image.isDisplayed());

		b.assertAll();

	}

}
