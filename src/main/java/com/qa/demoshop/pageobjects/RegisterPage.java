package com.qa.demoshop.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.qa.demoshop.validation.ValidationHelper;

import io.qameta.allure.Step;

public class RegisterPage extends BasePage {
//locator

	public By genderSelection(String genderName) {
		return By.xpath("//input[@id='gender-" + genderName + "']");
	}

	private final By fnTf = By.id("FirstName");
	private final By lnTf = By.id("LastName");
	private final By emailTf = By.id("Email");
	private final By pswTf = By.id("Password");
	private final By confirmPswTf = By.id("ConfirmPassword");
	private final By registerBtn = By.id("register-button");
	private final By confirmationMsg = By.xpath("//div[@class='result']");

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// methods
	@Step("Here we are selecting gender :{0}")
	public void selectGeneder(String genderName) {
		elementAction.doClick(genderSelection(genderName));
	}

	@Step("We are creating user by entering fn:{0},ln:{1},email:{2},psw:{3}")
	public String createUser(String fn, String ln, String email, String psw) {
		elementAction.doEnterValue(fn, fnTf);
		Reporter.log(fn, true);
		elementAction.doEnterValue(ln, lnTf);
		Reporter.log(ln, true);
		elementAction.doEnterValue(email, emailTf);
		Reporter.log(email, true);
		elementAction.doEnterValue(psw, pswTf);
		Reporter.log(psw, true);
		elementAction.doEnterValue(psw, confirmPswTf);
		Reporter.log(psw, true);
		elementAction.doClick(registerBtn);
		return elementAction.fetchElementText(confirmationMsg);
	}
}
