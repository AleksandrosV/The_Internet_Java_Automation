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
		softAssert.assertTrue(alertMessage.equals(alertsPage.jsAlertMessage),
				"Alert message is not expected. \nShould be '" + alertsPage.jsAlertMessage + "', but it is '"
						+ alertMessage + "'");
		softAssert.assertTrue(result.equals(alertsPage.jsAlertSuccessMessage), "result is not expected. \nShould be '"
				+ alertsPage.jsAlertSuccessMessage + "', but it is '" + result + "'");
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
		softAssert.assertTrue(alertMessage.equals(alertsPage.jsConfirmMessage),
				"Alert message is not expected. \nShould be '" + alertsPage.jsConfirmMessage + "', but it is '"
						+ alertMessage + "'");
		softAssert.assertTrue(result.equals(alertsPage.jsCancelMessage),
				"result is not expected. \nShould be '" + alertsPage.jsCancelMessage + "', but it is '" + result + "'");
		softAssert.assertAll();
	}

	@Test
	public void jsPromptTest() {
		SoftAssert softAssert = new SoftAssert();
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		alertsPage.openJSPrompt();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.typeTextIntoAlert(alertsPage.writeMessage);
		String result = alertsPage.getResultText();
		softAssert.assertTrue(alertMessage.equals(alertsPage.jsPromptMessage),
				"Alert message is not expected. \nShould be '" + alertsPage.jsPromptMessage + "', but it is '"
						+ alertMessage + "'");
		softAssert.assertTrue(result.equals("You entered: Hello Alert, it's Alex here"),
				"result is not expected. \nShould be 'You entered: " + alertsPage.writeMessage + "', but it is '"
						+ result + "'");
		softAssert.assertAll();
	}
}