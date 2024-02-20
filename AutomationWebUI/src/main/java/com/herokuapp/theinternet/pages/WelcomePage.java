package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com";
	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
	private By checkboxesLinkLocator = By.linkText("Checkboxes");
	private By dragAndDropLinkLocator = By.linkText("Drag and Drop");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By editorLinkLocator = By.linkText("WYSIWYG Editor");
	private By horizontalSliderLinkLocator = By.linkText("Horizontal Slider");
	private By hoversLinkLocator = By.linkText("Hovers");
	private By jsErrorLocator = By.linkText("JavaScript onload event error");
	private By keyPressesLocator = By.linkText("Key Presses");
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By uploadFileLinkLocator = By.linkText("File Upload");
	private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");

	public WelcomePage(WebDriver driver, Logger log) { // Constructor
		super(driver, log);
	}

	/** Open WelcomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Open WelcomePage with given URL */
	protected void openUrl(String url) {
		driver.get(url);
	}

	public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
		click(javaScriptAlertsLinkLocator);
		return new JavaScriptAlertsPage(driver, log);
	}

	public CheckboxesPage clickCheckboxesLink() {
		click(checkboxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}

	public DragAndDropPage clickDragAndDropLink() {
		click(dragAndDropLinkLocator);
		return new DragAndDropPage(driver, log);
	}

	public DropdownPage clickDropdownLink() {
		click(dropdownLinkLocator);
		return new DropdownPage(driver, log);
	}

	public EditorPage clickWYSIWYGEditorLink() {
		click(editorLinkLocator);
		return new EditorPage(driver, log);
	}

	public HorizontalSliderPage clickHorizontalLink() {
		click(horizontalSliderLinkLocator);
		return new HorizontalSliderPage(driver, log);
	}

	public HoversPage clickHoversLink() {
		click(hoversLinkLocator);
		return new HoversPage(driver, log);
	}

	public JSErrorPage clickJsErrorLink() {
		click(jsErrorLocator);
		return new JSErrorPage(driver, log);
	}

	public KeyPressesPage clickKeyPressesLink() {
		click(keyPressesLocator);
		return new KeyPressesPage(driver, log);
	}

	public LoginPage clickFormAuthenticationLink() {
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}

	public FileUploaderPage clickFileUploadonLink() {
		click(uploadFileLinkLocator);
		return new FileUploaderPage(driver, log);
	}

	public WindowsPage clickMultipleWindowsLink() {
		click(multipleWindowsLinkLocator);
		return new WindowsPage(driver, log);
	}
}
