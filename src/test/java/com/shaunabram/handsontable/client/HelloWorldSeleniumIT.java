package com.shaunabram.handsontable.client;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HelloWorldSeleniumIT {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
//    private final Log log = LogFactory.getLog(HelloWorldSeleniumIT.class);

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();//or ChromeDriver();
		baseUrl = "http://localhost:9090/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

    @Test
    public void containsInitialGreeting() throws Exception {
        driver.get(baseUrl + "Handsontable-SpringMVC/HelloWorld");
        assertTrue(driver.getPageSource().contains("Hello World!"));
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
