package com.herokuapp.theinternet.draganddroptests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;

public class DragAndDropTests extends TestUtilities {

	private DragAndDropPage dragAndDropPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		dragAndDropPage = welcomePage.clickDragAndDropLink();
	}

	@Test(priority = 1)
	public void pageTitle() {
		log.info("Verify that page title is Drag and Drop");
		String pageTitle = dragAndDropPage.getPageTitle();
		Assert.assertTrue(pageTitle.equals(DragAndDropPage.DRAG_AND_DROP_TITLE),
				"Page title should be Drag and Drop, but it is: " + pageTitle);
	}

	@Test(priority = 2)
	public void dragAToBTest() {
		log.info("Verify that A is dragged to B");
		dragAndDropPage.dragAtoB();
		String columnAText = dragAndDropPage.getColumnAText();
		String columnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);
		Assert.assertTrue(columnBText.equals("A"), "Column B header should be A, but it is: " + columnBText);
	}

	@Test(priority = 3)
	public void dragBToATest() {
		log.info("Verify that B is dragged to A");
		dragAndDropPage.dragBtoA();
		String columnBText = dragAndDropPage.getColumnBText();
		String columnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(columnBText.equals("A"), "Column B header should be A, but it is: " + columnBText);
		Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);
	}
}