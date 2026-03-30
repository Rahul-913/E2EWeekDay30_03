package com.qa.demoshop.pageobjects;

import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.ElementActions;
import com.qa.demoshop.utilities.WebDriverActions;

public class BasePage {

	protected WebDriver driver;
	protected ElementActions elementAction;
	protected WebDriverActions driverActions;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		elementAction = new ElementActions(driver);
		driverActions = new WebDriverActions(driver);
	}

}
