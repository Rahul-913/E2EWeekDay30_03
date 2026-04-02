package com.qa.demoshop.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.demoshop.base.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
@Listeners(ChainTestListener.class)
public class WelcomePageTest extends BaseTest {
	@Epic("SRS_001")
    @Feature("RegisterModule")
    @Story("RegisterVisibility")
	@Test
	public void registerVisible() {
		boolean flag = wp.linksVisibilityTest("register");
		assertTrue(flag);
		Reporter.log("registerLinkVisible", true);
		ChainTestListener.log("registerLinkVisible");
	}
	@Epic("SRS_001")
    @Feature("HomepageModule")
    @Story("loginVisible")
	@Test
	public void loginVisible() {
		boolean flag = wp.linksVisibilityTest("login");
		assertTrue(flag);
		Reporter.log("loginLinkVisible", true);
		ChainTestListener.log("loginLinkVisible");

	}
	@Epic("SRS_001")
    @Feature("WelcomeModule")
    @Story("cartVisible")
	@Test
	public void cartVisible() {
		boolean flag = wp.linksVisibilityTest("cart");
		assertTrue(flag);
		Reporter.log("cartLinkVisible", true);
		ChainTestListener.log("cartLinkVisible");

	}
	@Epic("SRS_001")
    @Feature("WelcomeModule")
    @Story("wishlistVisible")
	@Test
	public void wishlistVisible() {
		boolean flag = wp.linksVisibilityTest("wishlist");
		assertTrue(flag);
		Reporter.log("wishlistLinkVisible", true);
		ChainTestListener.log("wishlistLinkVisible");

	}

//	@Test
//	public void select() {
//		wp.selectMenu("cart");
//	}
}
