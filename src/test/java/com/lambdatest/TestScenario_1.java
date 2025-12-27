package com.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestScenario_1 extends BaseTest {

	protected RemoteWebDriver driver;

	@BeforeMethod
	@Parameters({ "browser", "platform", "browserVersion" })
	public void setup(String browser, String platform, String browserVersion, Method m) throws Exception {
		createDriver(browser, platform, browserVersion, m.getName());
		driver = getDriver(); 
	}

	@Test
	public void simpleFormDemoTest() {
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"));

		String message = "Welcome to LambdaTest";
		WebElement inputBox = driver.findElement(By.id("user-message"));
		inputBox.sendKeys(message);

		driver.findElement(By.cssSelector("#showInput")).click();
		String displayedMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();

		Assert.assertEquals(displayedMessage, message);
	}

	@AfterMethod
	public void tearDown() {
		quitDriver();
	}
}
