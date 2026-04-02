package com.qa.demoshop.utilities;

import org.openqa.selenium.WebDriver;

public class BaseUtility {
protected WebDriver driver;
protected WaitStrategy ws;
public BaseUtility(WebDriver driver) {
	this.driver=driver;
	ws = new WaitStrategy(driver);
}
}
