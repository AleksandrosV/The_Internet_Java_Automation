package com.herokuapp.theinternet.editortests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;

public class EditorTests extends TestUtilities {
	@Test
	public void defaultEditorValueTest() {
		log.info("Starting defaultEditorValueTest");
		welcomePage.scrollToBottom();
		EditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();
		String editorText = editorPage.getEditorText();
		Assert.assertTrue(editorText.equals(EditorPage.EDITOR_TEXT),
				"Editor default text is not expected. It is: " + editorText);
	}
}