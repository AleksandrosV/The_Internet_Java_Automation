package com.herokuapp.theinternet.uploadtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;

public class UploadTests extends TestUtilities {
	@Test(dataProvider = "files")
	public void fileUploadTest(int no, String fileName) {
		log.info("Starting fileUploadTest #" + no + " for " + fileName);
		FileUploaderPage fileUploaderPage = welcomePage.clickFileUploadonLink();
		fileUploaderPage.selectFile(fileName);
		fileUploaderPage.pushUploadButton();
		takeScreenshot("upload");
		String fileNames = fileUploaderPage.getUploadedFilesNames();
		Assert.assertTrue(fileNames.contains(fileName),
				"Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
	}
}