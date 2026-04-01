package com.qa.demoshop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.demoshop.exceptions.ElementExceptions;
import com.qa.demoshop.validation.ValidationHelper;

public class ElementActions extends BaseUtility {
	public ElementActions(WebDriver driver) {
		super(driver);
	}

	public WebElement getElement(By locator) {
		return ws.waitForVisibility(locator);
	}

//click,clear,sendkeys,submit
	public void doClick(By locator) {
		ValidationHelper.ValidateLocator(locator, "doClick");// null or not
		try {
			ws.waitForClickable(locator).click();
		} catch (Exception e) {
			throw new ElementExceptions("===[doClick] The specified locator " + locator
					+ " +is not matching with any element in webpage===");
		}
	}

	public void doClear(By locator) {
		ValidationHelper.ValidateLocator(locator, "doClick");// null or not
		try {
			getElement(locator).clear();
		} catch (Exception e) {
			throw new ElementExceptions("===[doClear] The specified locator " + locator
					+ " +is not matching with any element in webpage===");
		}
	}

	public void doEnterValue(String value, By locator) {
		ValidationHelper.ValidateLocator(locator, "doEnterValue");// null or not
		ValidationHelper.ValidateString(value, "doEnterValue");
		try {
			doClear(locator);
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			throw new ElementExceptions("===[doEnterValue] The specified locator " + locator
					+ " is not matching with any element in webpage===");
		}
	}

//isDisplayed,enabled,selected,gettext,getattribute
	public boolean checkElementDisplayed(By locator) {
		ValidationHelper.ValidateLocator(locator, "checkElementDisplayed");
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			throw new ElementExceptions("===[checkElementDisplayed] The specified locator " + locator
					+ " +is not matching with any element in webpage===");
		}
	}

	public boolean checkElementEnabled(By locator) {
		ValidationHelper.ValidateLocator(locator, "checkElementEnabled");
		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			throw new ElementExceptions("===[checkElementEnabled] The specified locator " + locator
					+ " +is not matching with any element in webpage===");
		}
	}

	public boolean checkElementSelected(By locator) {
		ValidationHelper.ValidateLocator(locator, "checkElementSelected");
		try {
			return getElement(locator).isSelected();
		} catch (Exception e) {
			throw new ElementExceptions("===[checkElementEnabled] The specified locator " + locator
					+ " +is not matching with any element in webpage===");
		}
	}

	public String fetchElementText(By locator) {
		ValidationHelper.ValidateLocator(locator, "fetchElementText");
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			throw new ElementExceptions("===[fetchElementText] The specified locator " + locator
					+ " +is not matching with any element in webpage===");
		}
	}

	public String fetchElementAttribute(By locator, String an) {
		ValidationHelper.ValidateLocator(locator, "fetchElementAttribute");
		try {
			return getElement(locator).getAttribute(an);
		} catch (Exception e) {
			throw new ElementExceptions("===[fetchElementAttribute] The specified locator " + locator
					+ " +is not matching with any element in webpage===");
		}
	}
}