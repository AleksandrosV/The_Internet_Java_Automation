package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

	private By columnA = By.id("column-a");
	private By columnB = By.id("column-b");

	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Drag A box and drop it on B box */
	public void dragAtoB() {
		log.info("Drag and drop A box on B box");
		performDragAndDrop(columnA, columnB);
	}

	/** Drag B box and drop it on A box */
	public void dragBtoA() {
		log.info("Drag and drop B box on A box");
		performDragAndDrop(columnB, columnA);
	}

	/** Getting Column A Text */
	public String getColumnAText() {
		String text = find(columnA).getText();
		log.info("Column A Text: " + text);
		return text;
	}

	/** Getting Column B Text */
	public String getColumnBText() {
		String text = find(columnB).getText();
		log.info("Column B Text: " + text);
		return text;
	}
}