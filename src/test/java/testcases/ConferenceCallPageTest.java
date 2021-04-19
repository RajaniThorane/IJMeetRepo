package testcases;

import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basesetup.BaseClass;
import keywords.UIKeywords;
import pages.ConferenceCallPage;
import utilities.AlertMsg;
import utilities.Constants;
import utilities.WaitFor;

public class ConferenceCallPageTest extends BaseClass {
	private static final Logger LOG = Logger.getLogger(ConferenceCallPageTest.class);

	@Test
	public void verifyConferenceCall() throws InterruptedException {
		ConferenceCallPage conference = new ConferenceCallPage();
		JoinMeetingPageTest j = new JoinMeetingPageTest();
		j.verifyjoinMeet();
		Thread.sleep(3000);
		UIKeywords key = new UIKeywords();
		LOG.info("Allowing mic");
		// WaitFor.elementToBeVisibile(conference.getInvitePeople(), 40);
		key.switchtoIframe(0);
		LOG.info("switching to iframe");

		// Actions action = new Actions(Constants.driver);
		// action.moveToElement(conference.getChatLink()).build().perform();
		// action.click();
		// WaitFor.elementToBeVisibile(conference.getChatLink(), 40);
		// conference.clickOnInviteMorePeople();
		// LOG.info("clicking on invite more people" +
		// conference.getChatLink().getText());
		// WaitFor.elementToBeVisibile(conference.getChatLink(), 40);
		conference.clickOnChatLink();

		
		
	}

}
