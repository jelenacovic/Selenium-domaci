package domaci_28_01_2022;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		/* Maksimizirati prozor Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr Od
		 * korisnika ucitati broj na koju zvezdicu je potrebno kliknuti (u rasponu od 1
		 * do 5) I izvrsite akciju klik na odgovarajuci element Na kraju programa
		 * ugasite pretrazivac.
		 */
		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://s.bootsnipp.com/iframe/WaXlr");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Unesite broj zvezdica: ");
		int n = s.nextInt();
		
		switch (n) {
		case 1:
			driver.findElement(By.xpath("//button[@id = 'rating-star-1']")).click();
			break;
		case 2:
			driver.findElement(By.xpath("//button[@id = 'rating-star-2']")).click();
			break;
		case 3:
			driver.findElement(By.xpath("//button[@id = 'rating-star-3']")).click();
			break;
		case 4:
			driver.findElement(By.xpath("//button[@id = 'rating-star-4']")).click();
			break;
		case 5:
			driver.findElement(By.xpath("//button[@id = 'rating-star-5']")).click();
			break;
		default:
		}
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
