package domaci_31_01_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		/* Napisati program koji ucitava stranicu https://geodata.solutions/ Bira
		 * proizvoljan Country, State i City Pritom potrebno je izvrsiti cekanje da se
		 * povaje State-ovi nakon izbora Country-a I takodje je potrebno izvrsiti
		 * cekanje da se ucitaju gradovi nakon izbora State-a 
		 * Izabrerit Country, State i
		 * City tako da imate podatke da selektujete!
		 */

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://geodata.solutions/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	
		Select drpCountry = new Select (driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("Serbia");
		Thread.sleep(5000);
		
		Select drpState = new Select (driver.findElement(By.name("state")));
		drpState.selectByVisibleText("Central Serbia");
		Thread.sleep(5000);
		
		Select drpCity = new Select (driver.findElement(By.name("city")));
		drpCity.selectByVisibleText("Bor");
	}

}
