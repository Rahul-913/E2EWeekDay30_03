package com.qa.demoshop.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	public static File getScreenshotFile(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		return temp;
	}

	public static String getScreenshotBASE64(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		return temp;
	}

	public static byte[] getScreenshotBYTES(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] temp = ts.getScreenshotAs(OutputType.BYTES);
		return temp;
	}
}
