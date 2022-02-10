package domaci_07_02_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage_Zadatak1 {
	/* Od klasa je potrebno: FormPage koja ima: getere za sve inpute geter za radio
	 * - //*[@name='gender'][@value='"+ radioValue +"'] - kao parametar prima value
	 * (male/female/middle) tog radio dugmeta geter za checkbox inpute -
	 * //*[@type='checkbox'][@value='"+ checkboxValue +"'] - kao parametar prima
	 * value (read_books, online_courses, opensource, tech_cons, tech_blogs,
	 * via_delivery - jednu od ovde navedenih) tog checkbox inputa getter koji hvata
	 * dugme treba da ceka da element postane klikabilan pre nego sto vrati element.
	 * Koristite waiter za ovaj slucaj. metodu koja vraca da li su podaci uspesno
	 * sacuvani, tako sto proverava da li element koji nosi poruku za atribut style
	 * ima vrednost "visibility: visible"
	 */
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public FormPage_Zadatak1(WebDriver driver, WebDriverWait wait) {
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
	
	public boolean isDataSaved() {
		try {
			wait.until(ExpectedConditions.attributeToBe(By.id("submit"), "disabled", ""));
			return true;
		} catch (Exception e) {
			return false;
		}
	}


}
