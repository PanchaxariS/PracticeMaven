package demoMaven.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClassForPOM {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium browser\\Browser Launch\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/v4");
		driver.manage().window().maximize();

		LoginPageForPOM ak = new LoginPageForPOM(driver);
		ak.getTitle();
		ak.setUsername("mgr123");
		ak.setPassword("mgr!23");
		ak.clickLoginButton();
		System.out.println("*+*+*+**+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
		

		Thread.sleep(3000);
		HomePageForPOM ak2 = new HomePageForPOM(driver);
		ak2.getTextofHomepage();
		ak2.getTextofManagerID();
		ak2.clickLogout();
		
		Alert ak3= driver.switchTo().alert();
		ak3.accept();

	}

}
