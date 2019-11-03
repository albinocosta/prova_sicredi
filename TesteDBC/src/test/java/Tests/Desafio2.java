package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CadastroPages;
import Pages.DataListPages;

public class Desafio2 {

	static WebDriver driver;
	static CadastroPages cadastroPages;
	static DataListPages datalistPages;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
		datalistPages = new DataListPages(driver);
		cadastroPages = new CadastroPages(driver);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() throws Exception {
		datalistPages.bootstrapv4();
		datalistPages.adduserv4();
		cadastroPages.preencherCampos();
		assertEquals(cadastroPages.validarmensagem(),
				"Your data has been successfully stored into the database. Edit Customer or Go back to list");

		cadastroPages.backaftersave();
		datalistPages.searchuser();
		Thread.sleep(3000);
		datalistPages.deleteselected();
		assertEquals(datalistPages.validarmensagem(), "Are you sure that you want to delete this 1 item?");
		datalistPages.confirmdelete();
		assertEquals(datalistPages.validardelete(), "Your data has been successfully deleted from the database.");
		driver.close();

	}

}