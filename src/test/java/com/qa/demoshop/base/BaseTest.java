package com.qa.demoshop.base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.demoshop.factory.DriverManager;
import com.qa.demoshop.pageobjects.RegisterPage;
import com.qa.demoshop.pageobjects.WelcomePage;
import com.qa.demoshop.utilities.CaptureScreenshot;
import com.qa.demoshop.utilities.FakeDataGenerator;
import com.qa.demoshop.utilities.ReadConfigData;
import com.qa.demoshop.utilities.WebDriverActions;

public class BaseTest {
	protected WebDriver driver;
	private DriverManager manager;
	private WebDriverActions driverActions;
	private ReadConfigData rcd;
	protected RegisterPage rp;
	protected WelcomePage wp;
	protected FakeDataGenerator dataGen;

	private static final Logger logger = LogManager.getLogger(BaseTest.class);

	@Parameters({ "browserNameXml", "headlessModeXml", "privateModeXml" }) // xml-chrome
	@BeforeClass
	public void launchBrowser(String browserNameXml, String headlessModeXml, String privateModeXml) throws IOException {
		logger.info("Launching the browser " + browserNameXml + " with headless mode " + headlessModeXml
				+ " and private mode as " + privateModeXml + "");

		rcd = new ReadConfigData();
		manager = new DriverManager();

		String browser = System.getProperty("browser", browserNameXml);
		String headless = System.getProperty("headless", headlessModeXml);
		String incognito = System.getProperty("incognito", privateModeXml);
		String url = System.getProperty("testUrl", rcd.getProperty("testUrl"));

		if (browserNameXml != null) {
			rcd.prop.setProperty("browsername", browser);
		}
		if (headlessModeXml != null) {
			rcd.prop.setProperty("headless", headless);
		}
		if (privateModeXml != null) {
			rcd.prop.setProperty("incognito", incognito);
		}
		boolean headLessValue = Boolean.parseBoolean(rcd.getProperty("headless"));
		boolean incognitoValue = Boolean.parseBoolean(rcd.getProperty("incognito"));
		driver = manager.initDriver(rcd.getProperty("browsername"), headLessValue, incognitoValue);// browsername,headless,incognito
		driverActions = new WebDriverActions(driver);
//		driverActions.enterUrl(rcd.getProperty("testUrl"));
		driverActions.enterUrl(url);
		driverActions.maximizeBrowser();
		wp = new WelcomePage(driver);
		rp = new RegisterPage(driver);

	}

	@AfterMethod
	public void attachScreenShot(ITestResult result) {
		if (!result.isSuccess()) {
			logger.info("The screenshot is being captured for method " + result.getName());
			ChainTestListener.embed(CaptureScreenshot.getScreenshotFile(driver), "image/png");
		}
	}

	public void closeApplication() {
		logger.info("The Application is being logged out");
		wp.doLogout();
	}

	@AfterClass(enabled = true)
	public void tearDown() throws InterruptedException {
		Reporter.log("Closed browser after logout validated", true);
		logger.info("Closed browser after logout validated");

		driverActions.closeBrowser();

	}

}
