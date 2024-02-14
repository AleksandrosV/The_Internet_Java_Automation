package theinternet.jobs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JobsPage;

public class JobsTest extends TestUtilities {

	@Test
	public void refreshPageTest() {
		log.info("Verify that the page is refreshed");
		JobsPage jobsPage = new JobsPage(driver, log);
		jobsPage.openPage();
		// Get the initial count text
		String initialCountText = jobsPage.getCountText();
		log.info("Initial Count Text: " + initialCountText);
		refreshPage(1);
		// Get the new count text after refresh
		String newCountText = jobsPage.getCountText();
		log.info("New Count Text: " + newCountText);
		// Convert the count texts to integers for comparison
		int initialCount = Integer.parseInt(initialCountText.replaceAll("\\D", ""));
		int newCount = Integer.parseInt(newCountText.replaceAll("\\D", ""));
		// Verify that the new count is more
		Assert.assertTrue(newCount > initialCount, "Count is not up after refresh");
		// Calculate the difference
		int countDifference = newCount - initialCount;
		// Log the difference
		log.info("The newCount is {} more than the initialCount after refresh.", countDifference);
	}
}
