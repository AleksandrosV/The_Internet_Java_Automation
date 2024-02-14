package com.herokuapp.theinternet.draganddroptests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DragAndDropTests extends TestUtilities {
	@Test
	public void dragAToBTest() {
		log.info("Verify that A is dragged to B");
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropLink();
		dragAndDropPage.dragAtoB();
		String columnAText = dragAndDropPage.getColumnAText();
		String columnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);
		Assert.assertTrue(columnBText.equals("A"), "Column B header should be A, but it is: " + columnBText);
	}

	@Test
	public void dragBToATest() {
		log.info("Verify that B is dragged to A");
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropLink();
		dragAndDropPage.dragBtoA();
		String columnBText = dragAndDropPage.getColumnBText();
		String columnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(columnBText.equals("A"), "Column B header should be A, but it is: " + columnBText);
		Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);
	}
}