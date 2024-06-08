package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverFactory {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		}
		return driver.get();
	}
}
