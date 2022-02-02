package domaci_01_02_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak2 {

	public static void main(String[] args) {
		/* Napisti program koji: Ucitava stranicu https://videojs.com/city Pusta video
		 * klikom na play dugme Cekamo da se video ucita Tako sto proveravamo da li vise
		 * to play dugme nije vidljivo. Za vezbanje Probajte da napisete dopunite koji
		 * ceka da se zavrsi video i ispisuje u konzoli. Video je gotov.
		 */

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://videojs.com/city");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		driver.findElement(By.className("vjs-big-play-button")).click();

		
		boolean dugmeVidljivo;

		try {
			WebElement e = driver.findElement(By.className("vjs-big-play-button"));
			dugmeVidljivo = true;
		} catch (Exception e2) {
			dugmeVidljivo = false;
		}

		if (dugmeVidljivo) {
			System.out.println("Dugme je vidljivo");
		} else {
			System.out.println("Dugme nije vidljivo");
		}
		
		
		wait.until(ExpectedConditions.attributeContains(By.xpath("//button[contains(@class, 'vjs-ended')]"), "title", "Replay"));
		System.out.println("Video je gotov");

	}

}
