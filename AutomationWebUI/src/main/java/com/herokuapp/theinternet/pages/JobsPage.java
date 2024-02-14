package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobsPage extends BasePageObject {
	
	private String pageUrl = "https://www.jobs.bg/job/7265166";
	private By countText = By.cssSelector(".count-text");

	public JobsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open JobsPage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}
	
	public String getCountText() {
		return find(countText).getText();
	}
}
