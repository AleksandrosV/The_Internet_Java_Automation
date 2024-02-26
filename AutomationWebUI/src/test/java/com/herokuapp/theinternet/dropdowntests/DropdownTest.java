package com.herokuapp.theinternet.dropdowntests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;

public class DropdownTest extends TestUtilities {

	private DropdownPage dropdownPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		dropdownPage = welcomePage.clickDropdownLink();
	}

	@Test
	public void optionOneTest() {
		log.info("Verify that option one is selected");
		dropdownPage.selectOption(1);
		String selectedOption = dropdownPage.getSelectedOption();
		Assert.assertTrue(selectedOption.equals(DropdownPage.OPTION_ONE),
				"Option 2 is not selected. Instead selected - " + selectedOption);
	}

	@Test
	public void optionTwoTest() {
		log.info("Verify that option two is selected");
		dropdownPage.selectOption(2);
		String selectedOption = dropdownPage.getSelectedOption();
		Assert.assertTrue(selectedOption.equals(DropdownPage.OPTION_TWO),
				"Option 2 is not selected. Instead selected - " + selectedOption);
	}
}