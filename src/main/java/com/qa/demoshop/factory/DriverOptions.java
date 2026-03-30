package com.qa.demoshop.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class DriverOptions {
	public static ChromeOptions getChromeOptions(Boolean headLess, Boolean incognito) {
		ChromeOptions opt = new ChromeOptions();
		if (headLess) {
			opt.addArguments("--headless");
			Reporter.log("Running Chrome in HEADLESS mode",true);
		}
		if (incognito) {
			opt.addArguments("--incognito");
			Reporter.log("Running Chrome in private mode",true);
		}
		return opt;
	}
	public static FirefoxOptions getFirefoxOptions(Boolean headLess, Boolean incognito) {
		FirefoxOptions opt = new FirefoxOptions();
		if (headLess) {
			opt.addArguments("--headless");
			Reporter.log("Running Firefox in HEADLESS mode",true);
		}
		if (incognito) {
			opt.addArguments("-private");
			Reporter.log("Running Firefox in private mode",true);
		}
		return opt;
	}
	public static EdgeOptions getEdgeOptions(Boolean headLess, Boolean incognito) {
		EdgeOptions opt = new EdgeOptions();
		if (headLess) {
			opt.addArguments("--headless");
			Reporter.log("Running Edge in HEADLESS mode",true);
		}
		if (incognito) {
			opt.addArguments("--incognito");
			Reporter.log("Running Edge in private mode",true);
		}
		return opt;
	}
}





