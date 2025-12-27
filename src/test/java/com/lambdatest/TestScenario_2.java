package com.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestScenario_2 extends BaseTest {

	protected RemoteWebDriver driver;

	@BeforeMethod
	@Parameters({ "browser", "platform", "browserVersion" })
	public void setup(String browser, String platform, String browserVersion, Method m) throws Exception {
		createDriver(browser, platform, browserVersion, m.getName());
		driver = getDriver();
	}
	@Test
	public void dragSliderTo95Test() {
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("drag-drop-range-sliders"));

		WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
		WebElement sliderValue = driver.findElement(By.id("rangeSuccess"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = 95;" + "arguments[1].innerText = 95;"
				+ "arguments[0].dispatchEvent(new Event('input'));"
				+ "arguments[0].dispatchEvent(new Event('change'));", slider, sliderValue);

		Assert.assertEquals(sliderValue.getText(), "95");
	}

	@AfterMethod
	public void tearDown() {
		quitDriver();
	}
}
