package com.lambdatest;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class BaseTest {
	protected RemoteWebDriver getDriver() {
		return driver.get();
	}

	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	protected void createDriver(String browser, String platform, String browserVersion, String testName)
			throws Exception {
		String username = System.getenv("LT_USERNAME");
		String accessKey = System.getenv("LT_ACCESS_KEY");

		if (username == null || accessKey == null) {
			throw new Exception("LambdaTest credentials not found in environment variables.");
		}

		// LambdaTest options
		HashMap<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("username", username);
		ltOptions.put("accessKey", accessKey);

		ltOptions.put("build", "Selenium 101 Assignment");
		ltOptions.put("name", testName);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("console", true);
		ltOptions.put("visual", true);

		ltOptions.put("plugin", "java-testNG");
		ltOptions.put("selenium_version", "4.21.0");
		ltOptions.put("w3c", true);

		// Browser-specific options
		if (browser.equalsIgnoreCase("Chrome")) {
		    ChromeOptions options = new ChromeOptions();
		    options.setPlatformName(platform);
		    options.setBrowserVersion(browserVersion != null ? browserVersion : "latest");
		    options.setCapability("browserName", "Chrome");
		    options.setCapability("LT:Options", ltOptions);
		    driver.set(new RemoteWebDriver(
		        new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), options));

		} else if (browser.equalsIgnoreCase("Firefox")) {
		    FirefoxOptions options = new FirefoxOptions();
		    options.setPlatformName(platform);
		    options.setBrowserVersion(browserVersion != null ? browserVersion : "latest");
		    options.setCapability("browserName", "Firefox");
		    options.setCapability("LT:Options", ltOptions);
		    driver.set(new RemoteWebDriver(
		        new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), options));

		} else {
		    throw new Exception("Unsupported browser: " + browser);
		}
	}

	protected void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}
	}
}
