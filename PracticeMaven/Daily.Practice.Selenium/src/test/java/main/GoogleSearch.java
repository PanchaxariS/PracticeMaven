package main;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch { // Declaration
	WebDriver driver;

	@FindBy(name = "q")
	WebElement search;

	@FindBy(xpath = "(//div//a/h3)[1]")
	WebElement sauceDemoLink;

	public GoogleSearch(WebDriver driver) { // Initialization
		PageFactory.initElements(driver, this);

	}

	public void searchBox() {
		search.sendKeys("Sauce Demo");
		search.sendKeys(Keys.ENTER);
	}

	public void clickLink() {
		sauceDemoLink.click();
	}

}
