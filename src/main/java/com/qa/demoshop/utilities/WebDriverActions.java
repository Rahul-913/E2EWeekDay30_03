package com.qa.demoshop.utilities;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverActions extends BaseUtility {

	public WebDriverActions(WebDriver driver) {
		super(driver);
	}

	public void enterUrl(String url) {
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void closeTab() {
		driver.close();
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void minimizeBrowser() {
		driver.manage().window().minimize();
	}
	public void fullscreenBrowser() {
		driver.manage().window().fullscreen();
	}
	public void navigateToPage(String url) {
		driver.navigate().to(url);
	}
	public void navigateToPreviousPage(String url) {
		driver.navigate().back();
	}
	public void navigateToForwardPage(String url) {
		driver.navigate().forward();
	}
	public void refreshPage(String url) {
		driver.navigate().refresh();
	}
	public String getCurrentTabAddress() {
		return driver.getWindowHandle();
	}
	public Set<String> getAllTabAddress() {
		return driver.getWindowHandles();
	}
	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}
	public void changeToWindow(String address) {
		driver.switchTo().window(address);
	}
	public void changeToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void changeToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void changeToFrame(WebElement address) {
		driver.switchTo().frame(address);
	}
	
	//FetchPosition
	//FetchDimension
	//ChangePosition
	//ChangeDimension
	
	
	
	
	
}
