package lang.java.com.atmosol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Initialiazation {

	private WebElement printTitle;
	private WebElement clickDesti;
	WebDriver driver;

	Initialiazation(WebDriver driver) {

		this.driver = driver;

		printTitle = driver.findElement(By.xpath("//div[@class='jumbotron']/div/h1"));
		clickDesti = driver.findElement(By.xpath("//a[text()='destination of the week! The Beach!']"));

	}

	public void getTitle() {
		System.out.println(printTitle.getText());
	}

	public void destination() {
		clickDesti.click();
	}

}
