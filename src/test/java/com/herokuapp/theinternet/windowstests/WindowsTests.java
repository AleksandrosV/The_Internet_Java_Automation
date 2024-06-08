package com.herokuapp.theinternet.windowstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WindowsPage;

public class WindowsTests extends TestUtilities {
	@Test
	public void newWindowTest() {
		log.info("Verify that new window page is opened");
		WindowsPage windowsPage = welcomePage.clickMultipleWindowsLink();
		windowsPage.openNewWindow();
		NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();
		String pageSource = newWindowPage.getCurrentPageSource();
		Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");
	}
}