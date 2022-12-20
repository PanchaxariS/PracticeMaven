package demoMaven.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelData_DataProvider {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","F:\\Selenium browser\\Browser Launch\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@Test(dataProvider = "ExcelData")
	public void login(String Username, String Password) {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@DataProvider(name = "ExcelData")
	public Object[][] excelDP() throws EncryptedDocumentException, IOException{
		Object[] [] varObj= fetchExcelData("C:\\Users\\HP\\Desktop\\Book12.xlsx","Sheet1");
		return varObj;
	}

	public String[][] fetchExcelData(String fileName, String sheetName) throws EncryptedDocumentException, IOException {

		String file = "C:\\Users\\HP\\Desktop\\Book12.xlsx";
		FileInputStream obj = new FileInputStream(file);
		Sheet sheet = WorkbookFactory.create(obj).getSheet("sheetname");
		Row row = sheet.getRow(0);
		Cell cell = sheet.getRow(0).getCell(0);

		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowcount);
		int cellcount = sheet.getRow(0).getLastCellNum();
		System.out.println(cellcount);

		String[][] data = new String[rowcount - 1][cellcount];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				row = sheet.getRow(i);
				// cell=sheet.getRow(i).getCell(j);
				cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();

			}
		}
		return data;

	}

	@AfterMethod
	public void burnDown() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.xpath("//div//a[@id='logout_sidebar_link']")).click();

	}

}
