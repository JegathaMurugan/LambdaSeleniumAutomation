package com.lambdatest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URL;

public class TestScenario_2 {

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

        caps.setCapability("build", "LambdaTest 1");
        caps.setCapability("name", "Drag & Drop Slider Test");

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),caps);
    }

    @Test
    public void dragSliderTo95Test() throws InterruptedException {
        // Launch Url
        driver.get("https://www.lambdatest.com/selenium-playground");

        // Click “Drag & Drop Sliders”
        driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("drag-drop-range-sliders"));

        WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
        WebElement sliderValue = driver.findElement(By.id("rangeSuccess"));
        
        //Perform Value change in slider
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "arguments[0].value = 95;" +               
            "arguments[1].innerText = 95;" +           
            "arguments[0].dispatchEvent(new Event('input'));" + 
            "arguments[0].dispatchEvent(new Event('change'));",
            slider, sliderValue
        );

        //Validate the displayed value
        String value = sliderValue.getText();
        System.out.println("Slider value: " + value);
        Assert.assertEquals(value, "95", "Slider value should be 95");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
