package com.herokuapp.theinternet.keypressestests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;

public class KeyPressesTests extends TestUtilities {
	@Test
	public void pressKeyTest() {
		log.info("Verify that Enter key is pressed");
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();
		keyPressesPage.pressKey(Keys.ENTER);
		takeScreenshot("Presskey");
		String result = keyPressesPage.getResultText();
		Assert.assertTrue(result.equals("You entered: ENTER"),
				"result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
	}

	@Test
	public void pressKeyWithActionsTest() {
		log.info("Verify that Space key is pressed");
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();
		keyPressesPage.pressKeyWithActions(Keys.SPACE);
		String result = keyPressesPage.getResultText();
		Assert.assertTrue(result.equals("You entered: SPACE"),
				"result is not expected. \nShould be 'You entered: SPACE', but it is '" + result + "'");
	}
}