package lang.java.com.atmosol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdPrint {

	@FindBy(xpath = "(//tbody//td)[2]")
	private WebElement printId;
	WebDriver driver;

	IdPrint(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void printText() {
		System.out.println(printId.getText());
	}

}
