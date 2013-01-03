package com.shaunabram.handsontable.client;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SimpleSeleniumIT {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
    private final int TIMEOUT_SECS = 10;
//    private final Log log = LogFactory.getLog(SimpleSeleniumIT.class);

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();//or ChromeDriver();
		baseUrl = "http://localhost:9090/";
		driver.manage().timeouts().implicitlyWait(TIMEOUT_SECS, TimeUnit.SECONDS);
	}

    @Test
    public void containsInitialGreeting() {
        driver.get(baseUrl + "Handsontable-SpringMVC");
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Handsontable/SpringMVC Example"));
    }

    @Test
    public void submitDisplaysDataFromServer() {
        driver.get(baseUrl + "Handsontable-SpringMVC");
        String description = "testDescription";
        driver.findElement(By.id("description")).sendKeys(description);
        submitAndWait();

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Description: " + description));
        assertTrue(pageSource.contains(",Kia,Nissan,Toyota,Honda"));
    }

    private void submitAndWait() {
        driver.findElement(By.id("Submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_SECS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("serverResults")));
    }

    @After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
