package com.qa.demoshop.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.demoshop.factory.DriverManager;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {

	public String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}

	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] getScreenshotBytes(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}", type = "text/plain")
	public String getTextLog(String msg) {
		return msg;
	}

	@Attachment(value = "{0}", type = "text/html")
	public String getHtmlLog(String html) {
		return html;
	}

	// Once before each suite
	@Override
	public void onStart(ITestContext context) {
		System.out.println("I have started with suite execution :" + context.getName());
	}

	// Once after each suite
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("I have finished with suite execution :" + context.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("I have started with testcase execution :" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("I have successfully finished testcase execution :" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase execution have been failed :" + result.getName());
		if (DriverManager.getDriver() instanceof WebDriver) {
			getScreenshotBytes(DriverManager.getDriver());
			System.out.println("Test method failed and screenshot captured for :" + result.getName());
		}
		getTextLog(getTestMethodName(result) + " method failed and screenshot captured for :" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase execution has been skipped :" + result.getName());
	}

}
