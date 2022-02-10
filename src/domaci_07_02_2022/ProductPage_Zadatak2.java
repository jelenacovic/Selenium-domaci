package domaci_07_02_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage_Zadatak2 {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public ProductPage_Zadatak2(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getQuantityUpButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'quantity-button quantity-up')]"));
	}
	
	public WebElement getAddToCartButton() {
		return driver.findElement(By.className("single_add_to_cart_button"));
	}
	
	public boolean isTextFound() {
		boolean isTextFound = false;
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'woocommerce-message')]")));
		try {
			driver.findElement(By.xpath("//*[contains(@class,'woocommerce-message')]"));
			isTextFound = true;
		} catch (Exception e) {
			isTextFound = false;
		}
		return isTextFound;
	}
	
	public WebElement getViewCartButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'button wc-forward')]"));
	}

}
