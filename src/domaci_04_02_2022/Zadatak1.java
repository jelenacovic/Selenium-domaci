package domaci_04_02_2022;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak1 {
	/* Ucitajte stranicu (ako treba gasite onaj dijalog sto iskace) Ukucajte za
	 * pretragu iphone postavice za valutu eure Sortirajte prema ceni da bude
	 * najjefinije prvo Onda izvrsite proveru sortiranja kao sto je bilo za udemy
	 */
	
	private WebDriver driver;
	
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate()
				.to("https://www.kupujemprodajem.com/");
		driver.findElement(By.className("kpBoxCloseButton")).click();
	}
	
	@Test
	public void inputTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("searchKeywordsInput")).sendKeys("iphone");
		driver.findElement(By.className("secondarySearchButton")).click(); 
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='orderSecondSelection']//span[@class='choiceLabelText']")).click();
		driver.findElement(By.xpath("//div[@id='menuGroup0']//div[contains(text(), 'Jeftinije')]")).click();
		driver.findElement(By.className("secondarySearchButton")).click();
		
		List<Double> nizCene = new ArrayList<>();
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='adPrice ']"));
		
		for (int i = 0; i < prices.size(); i++) {
			String[] parts = prices.get(i).getText().split(" ");
			String cena = parts[0];
			String valuta = parts[1];
			if (valuta.equals("€")) {
				String cena2 = cena.split(",")[0];
				double cenaUInt = Double.parseDouble(cena2);
				double cenaZaUbaciti = cenaUInt * 118;
				nizCene.add(cenaZaUbaciti);
			} else {
				double cenaUInt = Integer.parseInt(cena);
				nizCene.add(cenaUInt);
			}
		}
		for (int i = 0; i < nizCene.size(); i++) {
			System.out.println(nizCene.get(i));
		}
		
		boolean sorted = Sorted.sort(nizCene);
		Assert.assertTrue(sorted);	
	}
	
	@AfterMethod 
	public void after(){
		driver.close();
	}
	
}
