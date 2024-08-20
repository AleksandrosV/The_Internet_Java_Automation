package com.herokuapp.theinternet.alertstests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;

public class AlertsTests extends TestUtilities {

	private JavaScriptAlertsPage alertsPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		alertsPage = welcomePage.clickJavaScriptAlertsLink();
	}

	@Test
	public void jsAlertTestw() {
		SoftAssert softAssert = new SoftAssert();
		alertsPage.openJSAlert();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.acceptAlert();
		String result = alertsPage.getResultText();
		softAssert.assertEquals(alertMessage, JavaScriptAlertsPage.JS_ALERT_MESSAGE,
				"Alert message is not expected. \nShould be '" + JavaScriptAlertsPage.JS_ALERT_MESSAGE
						+ "', but it is '" + alertMessage + "'");
		softAssert.assertEquals(result, JavaScriptAlertsPage.JS_ALERT_SUCCESS_MESSAGE,
				"result is not expected. \nShould be '" + JavaScriptAlertsPage.JS_ALERT_SUCCESS_MESSAGE
						+ "', but it is '" + result + "'");
		softAssert.assertAll();
	}

	@Test
	public void jsDismissTest() {
		SoftAssert softAssert = new SoftAssert();
		alertsPage.openJSConfirm();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.dismissAlert();
		String result = alertsPage.getResultText();
		softAssert.assertTrue(alertMessage.equals(JavaScriptAlertsPage.JS_CONFIRM_MESSAGE),
				"Alert message is not expected. \nShould be '" + JavaScriptAlertsPage.JS_CONFIRM_MESSAGE
						+ "', but it is '" + alertMessage + "'");
		softAssert.assertTrue(result.equals(JavaScriptAlertsPage.JS_CANCEL_MESSAGE),
				"result is not expected. \nShould be '" + JavaScriptAlertsPage.JS_CANCEL_MESSAGE + "', but it is '"
						+ result + "'");
		softAssert.assertAll();
	}

	@Test
	public void jsPromptTest() {
		SoftAssert softAssert = new SoftAssert();
		alertsPage.openJSPrompt();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.typeTextIntoAlert(JavaScriptAlertsPage.WRITE_MESSAGE);
		String result = alertsPage.getResultText();
		softAssert.assertTrue(alertMessage.equals(JavaScriptAlertsPage.JS_PROMPT_MESSAGE),
				"Alert message is not expected. \nShould be '" + JavaScriptAlertsPage.JS_PROMPT_MESSAGE
						+ "', but it is '" + alertMessage + "'");
		softAssert.assertTrue(result.equals("You entered: Hello Alert, it's Alex here"),
				"result is not expected. \nShould be 'You entered: " + JavaScriptAlertsPage.WRITE_MESSAGE
						+ "', but it is '" + result + "'");
		softAssert.assertAll();
	}
}