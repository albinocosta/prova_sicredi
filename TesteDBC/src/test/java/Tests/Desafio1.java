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

public class Desafio1 {

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
	public void test() {
		datalistPages.bootstrapv4();
		datalistPages.adduserv4();
		cadastroPages.preencherCampos();
		assertEquals(cadastroPages.validarmensagem(),
				"Your data has been successfully stored into the database. Edit Customer or Go back to list");
		driver.close();
	}

}