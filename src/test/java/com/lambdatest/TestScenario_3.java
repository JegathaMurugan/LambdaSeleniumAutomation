package com.lambdatest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URL;
import java.time.Duration;

public class TestScenario_3 {

	WebDriver driver;
	String username = System.getenv("LT_USERNAME");
	String accessKey = System.getenv("LT_ACCESS_KEY");

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

		caps.setCapability("build", "LambdaTest 1");
		caps.setCapability("name", "Drag & Drop Slider Test");

		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),
				caps);
	}

	@Test
	public void inputFormSubmitTest() throws InterruptedException {
		driver.get("https://www.lambdatest.com/selenium-playground");

		// Click "Input Form Submit
		WebElement inputFormLink = driver.findElement(By.xpath("//a[text()='Input Form Submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", inputFormLink);

		// Click Submit without filling
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.selenium_btn")));
		submitBtn.click();

		WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
		String validationMessage = nameInput.getAttribute("validationMessage");
		Assert.assertEquals(validationMessage, "Please fill in this field.");

		// Fill Name and Email using Actions
		WebElement emailInput = driver.findElement(By.name("email"));
		Actions actions = new Actions(driver);
		actions.moveToElement(nameInput).click().sendKeys("John Doe").perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.TAB).perform(); // move to email
		Thread.sleep(500);
		actions.sendKeys("john@example.com").perform();

		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("company")).sendKeys("Example Inc");
		driver.findElement(By.name("website")).sendKeys("www.example.com");

		// Country dropdown
		Select countryDropdown = new Select(driver.findElement(By.name("country")));
		countryDropdown.selectByVisibleText("United States");

		// City
		driver.findElement(By.name("city")).sendKeys("New York");

		// Address
		WebElement addressInput = driver.findElement(By.name("address_line1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addressInput);
		addressInput.sendKeys("123 Example Street");

		WebElement address2Input = driver.findElement(By.name("address_line2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", address2Input);
		address2Input.sendKeys("Apt 101");

		// State
		WebElement stateInput = driver.findElement(By.id("inputState"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", stateInput);
		stateInput.sendKeys("NY");

		// Zip
		WebElement zipInput = driver.findElement(By.id("inputZip"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", zipInput);
		zipInput.sendKeys("10001");

		// Click Submit
		submitBtn.click();

		WebElement successMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.success-msg")));

		// Scroll page to the top
		((JavascriptExecutor) driver).executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");

		// Validate the message
		String msgText = successMsg.getText();
		Assert.assertTrue(msgText.contains("Thanks for contacting us, we will get back to you shortly."));

		// Optional small pause for smooth scroll
		Thread.sleep(500);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
