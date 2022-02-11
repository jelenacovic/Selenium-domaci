package domaci_10_02_2022;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak1 {
	private WebDriver driver;
	
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
	}
	
	@Test
	public void googleTest() throws Exception {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshot/google1.png");
		FileUtils.copyFile(srcFile, destFile);
		//FileUtils.copyFile(source, new File("./Screenshot/google.png"));
	}
	
	@AfterMethod
	public void after() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

}
