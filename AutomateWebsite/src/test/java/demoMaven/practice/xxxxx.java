package demoMaven.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class xxxxx {	
	WebDriver driver;
	
	@BeforeTest
	public void InitialiseChrome() {
		System.setProperty("webdriver.chrome.driver","F:\\Selenium browser\\Browser Launch\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@BeforeClass
	public void SearchGoogle() {
		WebElement search= driver.findElement(By.name("q"));
		search.sendKeys("sauce demo");
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='Swag Labs']")).click();
	}
	
	@Test(priority = 0)
	public void login () throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id='user-name']")).clear();
		WebElement input= driver.findElement(By.xpath("//*[@id='user-name']"));
		input.sendKeys("standard_user");
		WebElement i= driver.findElement(By.id("password"));
		i.clear();
		i.sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
	}
	
	@Test(priority=1)
	public void SelectProduct() throws Exception {
		
		Select S= new Select(driver.findElement(By.xpath("//*[@id='header_container']/div[2]/div[2]/span/select")));
		S.selectByValue("lohi");
		driver.findElement(By.xpath("//*[@id='item_5_title_link']/div")).click();
		driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
		
	}
	
	@Test(priority=2)
	public void AddtoCart() {
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();
		driver.findElement(By.id("checkout")).click();
	}
	
	@DataProvider(name="Data")
	public Object[][] dpMethod(){
		return new Object[][] {{"RanchodDas","Chanchad","410507"}};	
	}
	
	@Test(priority=3, dataProvider="Data")
	public void AddDetails(String Name, String LastName, String Pincode) throws InterruptedException {
		driver.findElement(By.id("first-name")).sendKeys(Name);
		driver.findElement(By.id("last-name")).sendKeys(LastName);
		driver.findElement(By.id("postal-code")).sendKeys(Pincode);
		driver.findElement(By.id("continue")).click();
		
		String ExpURL= "https://www.saucedemo.com/checkout-step-two.html";
		String ActUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(ActUrl, ExpURL, "URL's Dont Match");
		
		
		driver.findElement(By.id("finish")).click();
	}
	
	@AfterClass
	public void Logout() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Actions S=new Actions(driver);
		S.moveToElement(driver.findElement(By.id("logout_sidebar_link"))).click();
	}
	
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}



