package main;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SauceDemo {

	WebDriver driver;

	@FindBy(xpath = "(//input)[1]")
	WebElement Username;

	@FindBy(xpath = "(//input)[2]")
	WebElement Password;

	@FindBy(xpath = "(//input)[3]")
	WebElement clickLogin;

	@FindBy(xpath = "(//select/option)[2]")
	WebElement dropdown;

	@FindBy(xpath = "(//div/button)[4]")
	WebElement selectCloth;

	@FindBy(xpath = "(//div/a)[1]")
	WebElement addToCart;

	@FindBy(xpath = "(//div/button)[5]")
	WebElement clickCheckOut;

	@FindBy(name = "firstName")
	WebElement enterName;

	@FindBy(name = "lastName")
	WebElement enterLastName;

	@FindBy(name = "postalCode")
	WebElement enterPinCode;

	@FindBy(name = "continue")
	WebElement clickContinue;

	public SauceDemo(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void un() {
		Username.sendKeys("standard_user");
	}

	public void pwd() {
		Password.sendKeys("secret_sauce");
	}

	public void click() {
		clickLogin.click();
	}

	public void listBox() {
		dropdown.click();
//		driver.findElement(By.xpath("(//select/option)[2]")).click();
//		WebElement drp = driver.findElement(By.xpath("//select"));
//		Select select = new Select(drp);
//		select.selectByValue("za");

	}

	public void selectCloth() {
		selectCloth.click();
	}

	public void clickCart() {
		addToCart.click();
	}

	public void checkOrder() {
		clickCheckOut.click();
	}

	public void enterName() {
		enterName.sendKeys("Shruti");
	}

	public void enterLN() {
		enterLastName.sendKeys("Patil");
	}

	public void enterPC() {
		enterPinCode.sendKeys("457896");
	}

	public void continueButton() {
		clickContinue.click();
	}

}
