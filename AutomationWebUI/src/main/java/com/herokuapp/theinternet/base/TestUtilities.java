package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Refresh the page a specified number of times */
	public void refreshPage(int numberOfTimes) {
		for (int i = 0; i < numberOfTimes; i++) {
			log.info("Refreshing page - Attempt #" + (i + 1));
			driver.navigate().refresh();
		}
		log.info("Page refreshed " + numberOfTimes + " times.");
	}

	@DataProvider(name = "files")
	protected static Object[][] files() {
		return new Object[][] { { 1, "text1.txt" }, { 2, "text2.txt" }, { 3, "text3.txt" }, { 4, "text4.txt" } };
	}

	/** Take screenshot */
	protected void takeScreenshot(String fileName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "screenshots"
				+ File.separator + getTodaysDate() + File.separator + testSuiteName + File.separator + testName
				+ File.separator + testMethodName + File.separator + getSystemTime() + " " + fileName + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Todays date in yyyyMMdd format */
	private static String getTodaysDate() {
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}

	/** Current time in HHmmssSSS */
	private String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}

	/** Get logs from browser console */
	protected List<LogEntry> getBrowserLogs() {
		LogEntries log = driver.manage().logs().get("browser");
		List<LogEntry> logList = log.getAll();
		return logList;
	}
}
