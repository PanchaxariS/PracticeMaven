package demoMaven.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Parameter {

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "mgr123", "mgr!23" }, { "mngr445160", "zysyqUh" } };

	}

	@Test(dataProvider = "data-provider")
	public void myData(String Username, String password) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium browser\\Browser Launch\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/index.php");
		driver.manage().window().maximize();

//	public void myData(String Username, String password) {
//		System.setProperty("webdriver.gecko.driver",
//				"D:\\Selenium browser\\Browser Launch\\geckodriver-v0.31.0-win64" + "\\geckodriver.exe\\");
//		WebDriver driver = new FirefoxDriver();
//		// driver.get("https://web.whatsapp.com/");
//		driver.get("https://demo.guru99.com/v4/index.php");
//		driver.manage().window().maximize();

		LoginPageForPOM ak = new LoginPageForPOM(driver);
		ak.getTitle();
		ak.setUsername(Username);
		ak.setPassword(password);
		ak.clickLoginButton();

		HomePageForPOM AK = new HomePageForPOM(driver);
		AK.getTextofManagerID();
		AK.getTextofHomepage();
		AK.clickLogout();

		Alert a = driver.switchTo().alert();
		a.accept();
		driver.quit();

	}

}
