package com.herokuapp.theinternet.alertstests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;

public class AlertsTests extends TestUtilities {
	@Test
	public void jsAlertTest() {
		SoftAssert softAssert = new SoftAssert();
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		alertsPage.openJSAlert();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.acceptAlert();
		String result = alertsPage.getResultText();
		softAssert.assertTrue(alertMessage.equals("I am a JS Alert"),
				"Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");
		softAssert.assertTrue(result.equals("You successfully clicked an alert"),
				"result is not expected. \nShould be 'You successfully clicked an alert', but it is '" + result + "'");
		softAssert.assertAll();
	}

	@Test
	public void jsDismissTest() {
		SoftAssert softAssert = new SoftAssert();
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		alertsPage.openJSConfirm();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.dismissAlert();
		String result = alertsPage.getResultText();
		softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
				"Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");
		softAssert.assertTrue(result.equals("You clicked: Cancel"),
				"result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
		softAssert.assertAll();
	}

	@Test
	public void jsPromptTest() {
		SoftAssert softAssert = new SoftAssert();
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		alertsPage.openJSPrompt();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.typeTextIntoAlert("Hello Alert, it's Alex here");
		String result = alertsPage.getResultText();
		softAssert.assertTrue(alertMessage.equals("I am a JS prompt"),
				"Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");
		softAssert.assertTrue(result.equals("You entered: Hello Alert, it's Alex here"),
				"result is not expected. \nShould be 'You entered: Hello Alert, its Dmitry here', but it is '" + result
						+ "'");
		softAssert.assertAll();
	}
}