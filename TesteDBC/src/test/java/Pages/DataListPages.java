package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataListPages {

	static WebDriver driver;

	public DataListPages(WebDriver driver) {
		this.driver = driver;
	}

	public void bootstrapv4() {
		WebElement dropdown = driver.findElement(By.id("switch-version-select"));
		dropdown.findElement(By.xpath("//option[. = 'Bootstrap V4 Theme']")).click();

	}

	public void adduserv4() {
		WebElement adduserv4 = driver.findElement(By.linkText("Add Customer"));
		adduserv4.click();
	}

	public void searchuser() {
		WebElement selectsearchfield = driver.findElement(By.cssSelector(".el-search"));
		selectsearchfield.click();
		WebElement typesearch = driver.findElement(By.name("search"));
		typesearch.sendKeys("Teste Sicredi");
		WebElement sendsearch = driver.findElement(By.name("search"));
		sendsearch.sendKeys(Keys.ENTER);
	}

	public void deleteselected() {
		WebElement selectsearch2 = driver.findElement(By.className("select-all-none"));
		selectsearch2.click();
		WebElement pressdelete = driver.findElement(By.cssSelector(".btn > .text-danger:nth-child(2)"));
		pressdelete.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[text()[contains(.,'Are you sure that you want to delete this 1 item?')]]")));
	}

	public String validarmensagem() {

		return driver
				.findElement(By.xpath("//*[text()[contains(.,'Are you sure that you want to delete this 1 item?')]]"))
				.getText();

	}

	public void confirmdelete() {

		WebElement confirmdelete = driver.findElement(By.cssSelector(".delete-multiple-confirmation-button"));
		confirmdelete.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[text()[contains(.,'Your data has been successfully deleted from the database.')]]")));

	}

	public String validardelete() {

		return driver
				.findElement(By
						.xpath("//*[text()[contains(.,'Your data has been successfully deleted from the database.')]]"))
				.getText();

	}

}