package lang.java.com.atmosol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickPurchase {

	@FindBy(xpath = "(//input)[12]")
	private WebElement purchase;
	WebDriver driver;

	ClickPurchase(WebDriver driver) {
		PageFactory.initElements(driver, this);
//		driver = this.driver;
//		purchase = driver.findElement(By.xpath("(//input)[12]"));

	}

	public void clickPurc() {
		purchase.click();
	}

}
