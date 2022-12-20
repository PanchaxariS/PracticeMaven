package lang.java.com.atmosol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClassFlight {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/index.php");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

		Initialiazation rev1 = new Initialiazation(driver);
		rev1.getTitle();
		rev1.destination();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();

		SelectCity rev2 = new SelectCity(driver);
		rev2.selectCity1();
		rev2.selectCity2();
		rev2.clickTab();

		ChooseFlight rev3 = new ChooseFlight(driver);
		rev3.chooseFlight();

		ClickPurchase rev4 = new ClickPurchase(driver);
		rev4.clickPurc();

		IdPrint rev5 = new IdPrint(driver);
		rev5.printText();

	}

}
