package demoMaven.practice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Guru99TestClass {
	WebDriver driver;

	@BeforeTest
	public void initializeChrome() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium browser\\Browser Launch\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@BeforeMethod
	public void login() {
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		LoginPageForPOM ak = new LoginPageForPOM(driver);
		ak.getTitle();
		ak.setUsername("mgr123");
		ak.setPassword("mgr!23");
		ak.clickLoginButton();

	}

	@Test(priority=1)
	public void manager_ID_Text() {
		HomePageForPOM a = new HomePageForPOM(driver);
		a.getTextofManagerID();

	}

	@Test (priority=2)
	public void homePageText() {
		HomePageForPOM ak = new HomePageForPOM(driver);
		ak.getTextofHomepage();
	}

	@AfterMethod
	public void logout() {
		HomePageForPOM ak = new HomePageForPOM(driver);
		ak.clickLogout();
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	@AfterTest
	public void closeChrome() {
		driver.quit();

	}

}
