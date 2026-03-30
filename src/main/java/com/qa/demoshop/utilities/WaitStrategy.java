package com.qa.demoshop.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.qa.demoshop.constants.FrameworkConstants;

public class WaitStrategy  {
	FluentWait<WebDriver> fw;
	public WaitStrategy(WebDriver driver) {
		fw = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(FrameworkConstants.defaultWaitTime))
				.pollingEvery(Duration.ofSeconds(FrameworkConstants.pollingWaitTime))
				.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
	}

	public WebElement checkForElementPresence(By locator) {
		return fw.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public WebElement waitForVisibility(By locator) {
		return fw.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public WebElement waitForClickable(By locator) {
		return fw.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public Boolean waitForUrl(String expectedUrl) {
		return fw.until(ExpectedConditions.urlContains(expectedUrl));
	}
	public Boolean waitForTitle(String expectedTitle) {
		return fw.until(ExpectedConditions.titleContains(expectedTitle));
	}
	public Alert waitForAlert() {
		return fw.until(ExpectedConditions.alertIsPresent());
	}
	public WebDriver waitForFrame(int index) {
		return fw.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	public WebDriver waitForFrame(String idOrName) {
		return fw.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}
}


