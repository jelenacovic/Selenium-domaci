package domaci_28_01_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		/* Napisati program koji vrsi dodavanje 5 reda u tabelu. Maksimizirati prozor
		 * Ucitati stranicu
		 * https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete
		 * -row-feature.php Dodati red podataka - jedan red u jednoj iteraciji Kliknite
		 * na dugme Add New Unesite name,departmant i phone (mogu da budu uvek iste
		 * vrednost) Kliknite na zeleno Add dugme Na kraju programa ugasite pretrazivac.
		 */
		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		
		
		
		for(int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//button[@type ='button']")).click();
						
			driver.findElement(By.id("name")).sendKeys("Pera Peric");
			driver.findElement(By.id("department")).sendKeys("IT");
			driver.findElement(By.id("phone")).sendKeys("12233");
			
			driver.findElement(By.xpath("//*[contains(@class, 'table table-bordered')]/tbody/tr[last()]/td[4]/a[1]")).click();
			
		}
		

		Thread.sleep(2000);
		
		driver.close();

	}

}
