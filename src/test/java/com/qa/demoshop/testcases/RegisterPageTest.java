package com.qa.demoshop.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.demoshop.base.BaseTest;
import com.qa.demoshop.testdata.UserCreationData;

@Listeners(ChainTestListener.class)
public class RegisterPageTest extends BaseTest {

	@BeforeMethod
	public void precondition() {
		rp = wp.selectMenu("register");
	}

	@Test(dataProvider = "userData", dataProviderClass = UserCreationData.class, invocationCount = 1)
	public void doRegister(String fn, String ln, String email, String psw) {
		rp.selectGeneder("male");
		String msg = rp.createUser(fn, ln, email, psw);
		assertEquals(msg, "Your registration completed");
		Reporter.log("Assert successful user created", true);// testng report
		ChainTestListener.log("Assert successful user created");// chaintest report
		closeApplication();
	}
}
