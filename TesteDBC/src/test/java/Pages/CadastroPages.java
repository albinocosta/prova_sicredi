package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPages {

	static WebDriver driver;

	public CadastroPages(WebDriver driver) {
		this.driver = driver;

	}

	public void preencherCampos() {

		WebElement Name = driver.findElement(By.id("field-customerName"));
		Name.sendKeys("Teste Sicredi");

		WebElement LastName = driver.findElement(By.id("field-contactLastName"));
		LastName.sendKeys("Teste");

		WebElement ContactFirstName = driver.findElement(By.id("field-contactFirstName"));
		ContactFirstName.sendKeys("Albino");

		WebElement Phone = driver.findElement(By.id("field-phone"));
		Phone.sendKeys("51 9999-9999");

		WebElement AdressLine1 = driver.findElement(By.id("field-addressLine1"));
		AdressLine1.sendKeys("Av Assis Brasil, 3970");

		WebElement AdressLine2 = driver.findElement(By.id("field-addressLine2"));
		AdressLine2.sendKeys("Torre D");

		WebElement City = driver.findElement(By.id("field-city"));
		City.sendKeys("Porto Alegre");

		WebElement State = driver.findElement(By.id("field-state"));
		State.sendKeys("RS");

		WebElement PostalCode = driver.findElement(By.id("field-postalCode"));
		PostalCode.sendKeys("91000-000");

		WebElement Country = driver.findElement(By.id("field-country"));
		Country.sendKeys("Brasil");

		WebElement fEmployeer = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]"));
		fEmployeer.click();

		WebElement Fixter = driver
				.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/ul/li[8]"));
		Fixter.click();

		WebElement limit = driver.findElement(By.id("field-creditLimit"));
		limit.sendKeys("200");

		WebElement Save = driver.findElement(By.id("form-button-save"));
		Save.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[text()[contains(.,'Your data has been successfully stored into the database. ')]]")));

	}

	public String validarmensagem() {

		return driver
				.findElement(By
						.xpath("//*[text()[contains(.,'Your data has been successfully stored into the database. ')]]"))
				.getText();

	}

	public void backaftersave() {

		WebElement goback = driver.findElement(By.linkText("Go back to list"));
		goback.click();
	}

}