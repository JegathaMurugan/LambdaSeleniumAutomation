package com.lambdatest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URL;

public class TestScenario_1 {

	WebDriver driver;
	String username = System.getenv("LT_USERNAME");
	String accessKey = System.getenv("LT_ACCESS_KEY");


    @Parameters({"browser"})
    @BeforeMethod
	public void setup(String browser) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		caps.setCapability("browserVersion", "latest");
		caps.setCapability("platformName", "Windows 11");

		caps.setCapability("video", true);
		caps.setCapability("network", true);
		caps.setCapability("console", true);
		caps.setCapability("visual", true);

		caps.setCapability("build", "Selenium 101 Assignment");
		caps.setCapability("name", "Test Scenario 1");

		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),caps);
	}

	@Test
	public void simpleFormDemoTest() {

		driver.get("https://www.lambdatest.com/selenium-playground");

		driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();

		// Validate URL
		Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"));

		String message = "Welcome to LambdaTest";

		// ID
		WebElement inputBox = driver.findElement(By.id("user-message"));
		inputBox.sendKeys(message);

		// CSS Selector
		driver.findElement(By.cssSelector("#showInput")).click();

		// XPath
		String displayedMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();

		Assert.assertEquals(displayedMessage, message);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
