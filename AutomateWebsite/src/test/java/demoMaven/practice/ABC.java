package demoMaven.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ABC {

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "locked_out_user", "secret_sauce" } };
	}

	@Test(dataProvider = "data-provider")
	public void myData(String Username, String password) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium browser\\Browser Launch\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		LoginPageForPOM login = new LoginPageForPOM(driver);
		login.getTitle();
		login.setUsername(Username);
		login.setPassword(password);
		login.clickLoginButton();

		HomePageForPOM HP = new HomePageForPOM(driver);
		HP.getTextofHomepage();
		HP.clickLogout();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.close();
	}

}
