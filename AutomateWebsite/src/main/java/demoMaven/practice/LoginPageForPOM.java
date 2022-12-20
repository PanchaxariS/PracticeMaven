package demoMaven.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageForPOM {
	private WebElement Username;		//declaretion
	private WebElement Password;
	private WebElement Login;
	private WebElement getTitleText;
	WebDriver driver;

	LoginPageForPOM(WebDriver driver) {		//parameterised constructor
		this.driver = driver;		//Initialization
		Username = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
		Password = driver.findElement(By.xpath("(//input)[2]"));
		Login = driver.findElement(By.xpath("(//input)[3]"));
		getTitleText = driver.findElement(By.xpath("//div/h2"));

	}

	// setting values to above declared constructor
	public void setUsername(String User) {
		Username.sendKeys(User);
	}

	public void setPassword(String PWD ) {
		Password.sendKeys(PWD);
	}

	public void clickLoginButton() {
		Login.click();
	}

	public void getTitle() {
		System.out.println(getTitleText.getText());
	}

}
