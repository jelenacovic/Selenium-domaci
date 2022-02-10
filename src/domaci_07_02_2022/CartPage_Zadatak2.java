package domaci_07_02_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class CartPage_Zadatak2 {

	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	public CartPage_Zadatak2(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public boolean isProductInTheCart() {
		boolean isProductInTheCart;
		String value = driver.findElement(By.xpath("//*[contains(@class, 'input-text qty text')]")).getAttribute("value");
		if (value.equals("2")) {
			return isProductInTheCart = true;
		}
		return isProductInTheCart = false;
	}

	public WebElement getRemoveButton() {
		return driver.findElement(By.className("remove"));
	}

	
	public boolean isCartEmpty() throws InterruptedException {	
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//p[@class='cart-empty woocommerce-info']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@AfterMethod
	public void after() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

}
