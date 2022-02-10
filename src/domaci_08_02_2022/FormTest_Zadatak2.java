package domaci_08_02_2022;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import domaci_08_02_2022.FormPage_Zadatak2;

public class FormTest_Zadatak2 {
	/* Zatim kreirati FormTest koji Ucitava form.html stranicu (form.html je u
	 * folderu za domaci skinite je i otvorite u chrome i iskopirajte url) I
	 * popunjava formu koristeci FormData.xlsx fajl (u folderu je za domaci)
	 * Postavite odgovarajuce waitere tako da se saceka sledeci unos podataka u
	 * formu nakon submitovanja
	 */
	

	private WebDriver driver;
	private WebDriverWait wait;
	private FormPage_Zadatak2 formPage;
	
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		formPage = new FormPage_Zadatak2(driver, wait);
		
		driver.manage().window().maximize();
		driver.navigate().to("file:///C:/Users/jecah/Downloads/form.html");
	}
	
	@Test
	public void formTest() throws IOException {
		File file = new File("data/FormData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("form");
		
		DataFormatter df = new DataFormatter();
		
		for(int i = 1; i < 7; i++) {
			String fullName = sheet.getRow(i).getCell(0).getStringCellValue();
			String gender = sheet.getRow(i).getCell(1).getStringCellValue();
			String dateOfBirth = df.formatCellValue(sheet.getRow(i).getCell(2));
			String email = sheet.getRow(i).getCell(3).getStringCellValue();
			String role = sheet.getRow(i).getCell(4).getStringCellValue();
			String waysOfDev = sheet.getRow(i).getCell(5).getStringCellValue();
			String comment = sheet.getRow(i).getCell(6).getStringCellValue();
			
			formPage.dataInput(fullName, gender, dateOfBirth, email, role, comment);
			
			Assert.assertTrue(formPage.isDataSaved(), "Data is not saved");
		}
	}
	
	@AfterMethod
	public void after() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
