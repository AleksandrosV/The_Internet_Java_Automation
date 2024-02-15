package com.herokuapp.theinternet.jserrortests;

import java.util.List;

import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;

public class JSErrorTests extends TestUtilities {
	@Test
	public void jsErrorTest() {
		log.info("Verify that the JS page has not JS errors");
		SoftAssert softAssert = new SoftAssert();
		welcomePage.clickJsErrorLink();
		List<LogEntry> logs = getBrowserLogs();

		for (LogEntry logEntry : logs) {
			if (logEntry.getLevel().toString().equals("SEVERE")) {
				softAssert.fail("Severe error: " + logEntry.getMessage());
				// Print log to console
				System.out.println("Console Log - SEVERE: " + logEntry.getMessage());
			} else {
				// Print other logs to console
				System.out.println("Console Log - " + logEntry.getLevel() + ": " + logEntry.getMessage());
			}
		}
		softAssert.assertAll();
	}
}
