package domaci_07_02_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ShopTest_Zadatak2 {
	/* Napisati test koji: Ucitava stranicu http://cms.demo.katalon.com/ Vrsi klik
	 * na Shop link iz navigacije Otvara stranicu prvog proizvoda klikom na karticu
	 * prvog proizvoda Dodaje proizvod u korpu sa kolicinom 2 Verifikuje poruku
	 * nakon dodavanja “has been added to your cart.” Odlazi u korpu klikom na dugme
	 * VIew Cart Verifikuje stanje u korpi, tj. da postoji proizvod sa kolicinom 2.
	 * Brise stavku iz korpe klikom na dugme x. Verifikuje poruku za praznu korpu.
	 * Osmislite pageve za ovaj zadatak!
	 */
	
	private WebDriver driver;
	private WebDriverWait wait;
	private ProductPage_Zadatak2 productPage;
	private NavigationPage_Zadatak2 navigationPage;
	private CartPage_Zadatak2 cartPage;
	
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		productPage = new ProductPage_Zadatak2(driver, wait);
		navigationPage = new NavigationPage_Zadatak2(driver, wait);
		cartPage = new CartPage_Zadatak2(driver, wait);
		
		driver.manage().window().maximize();
		driver.navigate().to("http://cms.demo.katalon.com/");
	}
	
	@Test
	public void shopTest() throws InterruptedException {
		navigationPage.getShopButton().click();
		navigationPage.getFirstProductButton().click();
		productPage.getQuantityUpButton().click();
		productPage.getAddToCartButton().click();
		Assert.assertTrue(productPage.isTextFound(), "No message shown.");
		productPage.getViewCartButton().click();
		Assert.assertTrue(cartPage.isProductInTheCart(), "Cart empty.");
		cartPage.getRemoveButton().click();
		Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty.");
	}

}
