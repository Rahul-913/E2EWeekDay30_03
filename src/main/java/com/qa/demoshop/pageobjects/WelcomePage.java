package com.qa.demoshop.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.qa.demoshop.exceptions.FrameworkExceptions;

import io.qameta.allure.Step;

public class WelcomePage extends BasePage {
//locators
	public By links(String linkName) {
		return By.xpath("//a[@href='/" + linkName + "']");
	}

	public By menuSelector(String menuName) {
		return By.xpath("//a[@href='/" + menuName + "']");
	}

	final private By logoutLink = By.xpath("//a[@href='/logout']");

	// constructor
	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	// action methods
	@Step("Checking linksVisibilityTest")
	public boolean linksVisibilityTest(String linkName) {
		return elementAction.checkElementDisplayed(links(linkName));
	}

	@Step("Selecting menu by passing:{0}")
	public RegisterPage selectMenu(String menuName) {
		switch (menuName) {
		case "register":
			elementAction.doClick(menuSelector(menuName));
			return new RegisterPage(driver);
		default:
			Reporter.log("Invalid module selected", true);
			throw new FrameworkExceptions("===Ivalild Module Passed===");
		}
	}

	
	@Step("Logging out from application")
	public void doLogout() {
		elementAction.doClick(logoutLink);
	}
}
