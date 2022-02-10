package domaci_08_02_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage_Zadatak2 {

	private WebDriver driver;
	private WebDriverWait wait;

	public FormPage_Zadatak2(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getFullNameInput() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getGenderRadioButton(String radioValue) {
		return driver.findElement(By.xpath("//input[@name ='gender'][@value ='" + radioValue + "']"));
	}

	public WebElement getDateOfBirthInput() {
		return driver.findElement(By.id("dob"));
	}

	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}

	public void roleSelect(String roleValue) {
		Select dropdownRole = new Select(driver.findElement(By.id("role")));
		dropdownRole.selectByVisibleText(roleValue);
	}

	public WebElement getCheckboxInput(int checkboxValue) {
		return driver.findElement(
				By.xpath("//div[contains(@class, 'col-sm-10 development-ways')]/div[" + checkboxValue + "]//input"));
	}

	public WebElement getCommentInput() {
		return driver.findElement(By.id("comment"));
	}

	public WebElement getSubmitButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		return driver.findElement(By.id("submit"));
	}
	
	public void dataInput(String fullName, String gender, String dateOfBirth, String email, String role, String comment) {
		this.getFullNameInput().sendKeys(fullName);
		this.getGenderRadioButton(gender).click();
		this.getDateOfBirthInput().sendKeys(dateOfBirth);
		this.getEmailInput().sendKeys(email);
		this.roleSelect(role);
		this.getCommentInput().sendKeys(comment);
	}

	public boolean isDataSaved() {
		try {
			wait.until(ExpectedConditions.attributeToBe(By.id("submit"), "disabled", ""));
			return true;
		} catch (Exception e) {
			return false;
		}
	}	
}
