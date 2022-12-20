package demoMaven.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageForPOM {
	private WebElement managerIdText;
	private WebElement HomepageText;
	private WebElement clickNewTours;
	private WebElement Logout;
	WebDriver driver;

	HomePageForPOM(WebDriver driver) {

		this.driver = driver;
		managerIdText = driver.findElement(By.xpath("(//td)[7]"));
		HomepageText = driver.findElement(By.xpath("//div/h2"));
		clickNewTours = driver.findElement(By.xpath("(//div/following::a)[36]"));
		Logout = driver.findElement(By.xpath("//a[text()='Log out']"));

	}

	public void getTextofManagerID() {
		System.out.println(managerIdText.getText());
	}

	public void getTextofHomepage() {
		System.out.println(HomepageText.getText());
		clickNewTours.click();

	}
	
	public void clickTabNewTours() {
		
	}

	public void clickLogout() {
		Logout.click();
	}

}
