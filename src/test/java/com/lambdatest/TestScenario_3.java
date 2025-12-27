package com.lambdatest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class TestScenario_3 extends BaseTest {

	protected RemoteWebDriver driver;

	@BeforeMethod
	@Parameters({ "browser", "platform", "browserVersion" })
	public void setup(String browser, String platform, String browserVersion, Method m) throws Exception {
		createDriver(browser, platform, browserVersion, m.getName());
		driver = getDriver(); 
	}

	@Test
	public void inputFormSubmitTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions actions = new Actions(driver);

		driver.get("https://www.lambdatest.com/selenium-playground");

		// Click Input Form Submit
		WebElement inputFormLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Input Form Submit']")));
		inputFormLink.click();

		// Locate the submit button
		WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']")));
		submitBtn.click();
		Thread.sleep(500); 


		
		// Locate the required field
		WebElement nameField = driver.findElement(By.id("name"));

		// Get browser-native validation message
		String validationMsg = nameField.getAttribute("validationMessage");

		// Assert that validation message is not empty
		Assert.assertTrue(validationMsg != null && validationMsg.length() > 0,
		        "Validation message not shown");
		// Fill Name and Email using Actions
		WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
		WebElement emailInput = driver.findElement(By.name("email"));
		actions.moveToElement(nameInput).click().sendKeys("John Doe").perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		actions.sendKeys("john@example.com").perform();

		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("company")).sendKeys("Example Inc");
		driver.findElement(By.name("website")).sendKeys("www.example.com");

		// Country
		Select countryDropdown = new Select(driver.findElement(By.name("country")));
		countryDropdown.selectByVisibleText("United States");

		driver.findElement(By.name("city")).sendKeys("New York");
		driver.findElement(By.name("address_line1")).sendKeys("Aj Street");
		driver.findElement(By.name("address_line2")).sendKeys("chinnu");
		driver.findElement(By.id("inputState")).sendKeys("TN");
		driver.findElement(By.id("inputZip")).sendKeys("010622");
		actions.sendKeys(Keys.TAB).perform();

		// Refind to avoid stale exception and click submit
		WebElement finalSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", finalSubmit);

		// verify success message
		WebElement successMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.success-msg")));
		String msgText = successMsg.getText();
		Assert.assertTrue(msgText.contains("Thanks for contacting us, we will get back to you shortly."));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
