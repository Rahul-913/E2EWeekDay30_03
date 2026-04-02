package com.qa.demoshop.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

import com.qa.demoshop.exceptions.FrameworkExceptions;
import com.qa.demoshoperrormsgs.FrameworkErrors;

public class DriverManager {
	static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(String browserName, boolean headLess, boolean incognito) {
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			ChromeOptions copt = DriverOptions.getChromeOptions(headLess, incognito);
			threadDriver.set(new ChromeDriver(copt));
			break;
		case "firefox":
			FirefoxOptions fopt = DriverOptions.getFirefoxOptions(headLess, incognito);
			threadDriver.set(new FirefoxDriver(fopt));
			break;
		case "edge":
			EdgeOptions eopt = DriverOptions.getEdgeOptions(headLess, incognito);
			threadDriver.set(new EdgeDriver(eopt));
			break;
		default:
			Reporter.log(browserName + " " + FrameworkErrors.browserErrorMsg, true);
			throw new FrameworkExceptions(FrameworkErrors.browserErrorMsg);
		}
		return getDriver();
	}

	public static WebDriver getDriver() {
		return threadDriver.get();
	}
}
