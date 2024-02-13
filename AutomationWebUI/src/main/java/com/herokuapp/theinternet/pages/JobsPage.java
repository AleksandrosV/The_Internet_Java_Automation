package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobsPage extends BasePageObject {

	public JobsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private By countText = By.cssSelector(".count-text");

	public String getCountText() {
		return find(countText).getText();
	}
}
