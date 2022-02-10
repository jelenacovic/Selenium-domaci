package domaci_07_02_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest_Zadatak1 {
	/*Ucitava stranicu Popunite formu proizvoljnim podacima Submitujte formu
	 * Proverite da li su podaci uspesno sacuvani. (imate metodu iz page-a koja vam
	 * vraca da li je uspesno sacuvano, iskorisite je) U AfterClass metodi zatvaramo
	 * stranicu
	 */

	private WebDriver driver;
	private WebDriverWait wait;
	private FormPage_Zadatak1 formPage;
	
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		formPage = new FormPage_Zadatak1(driver, wait);
		
		driver.manage().window().maximize();
		driver.navigate().to("file:///C:/Users/jecah/Downloads/form.html");
	}
	
	@Test
	public void formTest() throws InterruptedException {
		formPage.getFullNameInput().sendKeys("Pera Peric");
		formPage.getGenderRadioButton("female").click();
		formPage.getDateOfBirthInput().sendKeys("23.01.1990");
		formPage.getEmailInput().sendKeys("pera@gmail.com");
		formPage.roleSelect("QA");
		formPage.getCheckboxInput(1).click();
		formPage.getCommentInput().sendKeys("Cao cao");
		formPage.getSubmitButton().click();
		
		Assert.assertTrue(formPage.isDataSaved(), "Data is not saved");
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
