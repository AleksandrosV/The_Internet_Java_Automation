package com.herokuapp.theinternet.hoverstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;

public class HoversTests extends TestUtilities {
	@Test
	public void user1ProfileTest() {
		log.info("Verify that user 1 profile can be opened");
		HoversPage hoversPage = welcomePage.clickHoversLink();
		hoversPage.openUserProfile(1);
		Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/1"),
				"Url of opened page is not expected User 1 page url");
	}

	@Test
	public void user2ProfileTest() {
		log.info("Verify that user 2 profile can be opened");
		HoversPage hoversPage = welcomePage.clickHoversLink();
		hoversPage.openUserProfile(2);
		Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"),
				"Url of opened page is not expected User 2 page url");
	}

	@Test
	public void user3ProfileTest() {
		log.info("Verify that user 3 profile can be opened");
		HoversPage hoversPage = welcomePage.clickHoversLink();
		hoversPage.openUserProfile(3);
		Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/3"),
				"Url of opened page is not expected User 3 page url");
	}
}