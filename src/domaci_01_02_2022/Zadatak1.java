package domaci_01_02_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		/* Napisati program koji : Ucitava stranicu
		 * https://www.udemy.com/courses/search/?src=ukw&q=slksd Klikce na dugme za
		 * jezik i proverava da li se prikazuje dijalog za promenu jezika Stampa u
		 * konzoli tekst “Dijalog se prikazao”
		 */
		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.udemy.com/courses/search/?src=ukw&q=slksd");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(@class, 'language-selector-button--button--1wgoL')]")).click();
		
		boolean dijalogPostoji;
		try {
			WebElement e = driver.findElement(By.xpath("//*[contains(@class, 'language-selector-modal-trigger--modal--3jcoz')]"));
			dijalogPostoji = true;
		} catch (Exception e2) {
			dijalogPostoji = false;
		}
		
		if(dijalogPostoji) {
			System.out.println("Dijalog se prikazao");
		} else {
			System.out.println("Dijalog se nije prikazao");
		}

		}

	}


