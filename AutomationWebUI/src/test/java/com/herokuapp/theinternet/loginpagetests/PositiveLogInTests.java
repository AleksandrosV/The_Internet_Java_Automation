package com.herokuapp.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;

public class PositiveLogInTests extends TestUtilities {
	@Test
	public void logInTest() {
		log.info("Verify that user can login with valid credentials");
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
		takeScreenshot("SecureAreaPage opened");
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible.");
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"Success Message does not contain Expected Message\nExpected Success Message: " + expectedSuccessMessage
						+ "\nActual Success Message: " + actualSuccessMessage);
	}
}