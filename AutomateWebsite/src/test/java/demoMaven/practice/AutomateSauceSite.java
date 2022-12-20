package demoMaven.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomateSauceSite {

	WebDriver driver;

	@BeforeTest
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium browser\\Browser Launch\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@BeforeClass
	public void searchGoogle() {
		WebElement ak = driver.findElement(By.name("q"));
		ak.sendKeys("sauce demo");
		ak.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div//a/h3)[1]")).click();

	}
	
//	@BeforeMethod	//parameterization
//	public void login1() throws EncryptedDocumentException, IOException {
//		String path = "C:\\Users\\HP\\Desktop\\Book12.xlsx";
//		FileInputStream file = new FileInputStream(path);
//		
//		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
//		
//		int rowcount = sheet.getLastRowNum();
//		System.out.println(rowcount);
//		int cellcount= sheet.getRow(0).getLastCellNum();
//		System.out.println(cellcount);
//		
//		for(int i=1 ; i<=rowcount ; i++) {
//			for(int j=0 ; j<=cellcount ; j++) {
//				String Username = sheet.getRow(i).getCell(0).getStringCellValue();
//				String Password = sheet.getRow(i).getCell(j).getStringCellValue();
//				driver.findElement(By.xpath("(//input)[1]")).sendKeys(Username);
//				driver.findElement(By.xpath("(//input)[2]")).sendKeys(Password);
//				driver.findElement(By.xpath("(//input)[3]")).click();
//				
//			}
//		}
//		
//	}

	@Test(priority=0)
	public void enterData() {
		driver.findElement(By.xpath("(//input)[1]")).sendKeys("standard_user");
		driver.findElement(By.xpath("(//input)[2]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("(//input)[3]")).click();

	}
	
	@Test(priority=1)
	public void handleDropDown() {
		Select select = new Select(driver.findElement(By.xpath("//select")));
		select.selectByValue("za");
		driver.findElement(By.xpath("(//div/button)[4]")).click();
	}
	
	@Test(priority=2)
	public void clickCart() {
		driver.findElement(By.xpath("(//div/a)[1]")).click();
	
	}
	
	@Test(priority=3)
	public void clickCheckout() {
		driver.findElement(By.xpath("(//div/button)[5]")).click();
	}
	
	@Test(priority=4)
	public void enterDetails() {
		driver.findElement(By.name("firstName")).sendKeys("Arjun");
		driver.findElement(By.name("lastName")).sendKeys("Gaikwad");
		driver.findElement(By.name("postalCode")).sendKeys("423701");
		driver.findElement(By.name("continue")).click();
	}
	
	@Test(priority=5)
	public void clickFinish() {
		driver.findElement(By.xpath("(//div/button)[4]")).click();
	}
	
	@AfterClass
	public void returnHome() {
		driver.findElement(By.xpath("(//div/button)[3]")).click();
	}
	
	@AfterTest
	public void clickLogout() {
		driver.findElement(By.xpath("(//div/button)[1]")).click();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("(//div/nav/a)[3]"))).click();
		driver.close();
	}
	
//	@AfterMethod
//	public void logout() {
//		driver.findElement(By.xpath("(//div/button)[1]")).click();
//		Actions a = new Actions(driver);
//		a.moveToElement(driver.findElement(By.xpath("(//div/nav/a)[3]"))).click();
//	}
//	
//	@AfterClass
//	public void quit() {
//		driver.quit();
//	}
//	
	

}
