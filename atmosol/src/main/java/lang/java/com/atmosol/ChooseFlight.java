package lang.java.com.atmosol;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseFlight {

	@FindBy(xpath = "(//input)[13]")
	private WebElement selectFlight;
	WebDriver driver;

	ChooseFlight(WebDriver driver) {

		PageFactory.initElements(driver, this);

		// selectFlight = driver.findElement(By.xpath("(//input)[13]"));
		// List<WebElement> selectFlight = driver.findElements(By.name("price"));

	}

	public void chooseFlight() {
		selectFlight.click();

	}

}
