package domaci_31_01_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		/* Napisati program koji: Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
		 * Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika
		 * element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO
		 * RESITI KORISCENJEM PETLJE) POMOC: Brisite elemente odozdo. (ZA
		 * VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
		 */
		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://s.bootsnipp.com/iframe/Dq2X");
		
		for(int i = 1; i <= 5; i++) {
			driver.findElement(By.xpath("//button[@class='close'][last()]")).click();
			Thread.sleep(5000);
			
			boolean postojiElement;
			
			try {
			WebElement e = driver.findElement(By.xpath("//*[contains(@class, 'col-md-12')]/div[last()]/button" + i));
			postojiElement = true;
			} catch (Exception e2) {
				postojiElement = false;
			}
			
			if(postojiElement) {
				System.out.println("Element nije obrisan");
			} else {
				System.out.println("Element je obrisan");
			}		
		}  
		
		
		/* brisanje elementa odozgo
		for(int i = 1; i <=5; i++) {
			driver.findElement(By.xpath("//button[@class='close']")).click();
			Thread.sleep(5000);
			
			boolean postojiElement;
			
			try {
				WebElement e = driver.findElement(By.xpath("//*[contains(@class, 'col-md-12')]/div[1]/button"+i));
				postojiElement = true;
				} catch (Exception e2) {
					postojiElement = false;
				}
				
				if(postojiElement) {
					System.out.println("Element nije obrisan");
				} else {
					System.out.println("Element je obrisan");
				}		
			} */
			
		}

	}


