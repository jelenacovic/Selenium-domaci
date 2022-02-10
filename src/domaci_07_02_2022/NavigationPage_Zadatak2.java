package domaci_07_02_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage_Zadatak2 {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public NavigationPage_Zadatak2(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getShopButton() {
		return driver.findElement(By.xpath("//*[@class=' nav-menu']//li[5]"));
	}
	
	public WebElement getFirstProductButton() {
		return driver.findElement(
				By.xpath("//*[contains(@class, 'woocommerce-LoopProduct-link woocommerce-loop-product__link')]"));
	}
}


