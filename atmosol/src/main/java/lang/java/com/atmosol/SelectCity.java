package lang.java.com.atmosol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectCity {

	@FindBy(xpath = "(//select[@class='form-inline'])[1]")
	private WebElement city1;
	
	@FindBy(xpath = "(//select[@class='form-inline'])[2]")
	private WebElement city2;
	
	@FindBy(xpath = "//input")
	private WebElement click;
	WebDriver driver;

	SelectCity(WebDriver driver) {
		
		PageFactory.initElements(driver,this);

//		driver = this.driver;
//
//		city1 = driver.findElement(By.xpath("(//select[@class='form-inline'])[1]"));
//		city2 = driver.findElement(By.xpath("(//select[@class='form-inline'])[2]"));
//		click = driver.findElement(By.xpath("//input"));

	}

	public void selectCity1() {
		Select rev = new Select(city1);
		rev.selectByValue("Mexico City");

	}

	public void selectCity2() {
		Select rev2 = new Select(city2);
		rev2.selectByVisibleText("London");

	}

	public void clickTab() {
		click.click();
	}

}
