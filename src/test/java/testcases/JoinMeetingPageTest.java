package testcases;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import basesetup.BaseClass;
import keywords.UIKeywords;
import pages.JoinMettingPage;
import pages.SignInPage;
import utilities.Dataproviders;
import utilities.WaitFor;

public class JoinMeetingPageTest extends BaseClass {
	private static final Logger LOG = Logger.getLogger(JoinMeetingPageTest.class);

	// @Test
	public void verifyjoinMeet() throws InterruptedException {
		JoinMettingPage joinmeet = new JoinMettingPage();
		SignInPageTest signtest = new SignInPageTest();
		signtest.verifyLogin();
		joinmeet.clickOnJoinMeetlink();
		LOG.info("clicking on join meet link and getting text as:" + joinmeet.getJoinMeetTxt());
		joinmeet.enterUsername("Rajani");
		LOG.info("Entering username");
		joinmeet.enetrMeetingId("8bf1067");
		LOG.info("Entering meeting id");
		joinmeet.clickOnJoinMeetingBtn();
		//Thread.sleep(4000);
		LOG.info("click on join meeting button");
	}

	@Test(dataProvider = "jmeetData", dataProviderClass = Dataproviders.class)
	public void verifyjoinMeeting(String user_name, String meeting_Id) throws InterruptedException {
		UIKeywords k = new UIKeywords();
		SignInPage s = new SignInPage();
		SignInPageTest signtest = new SignInPageTest();
		JoinMettingPage jmeet = new JoinMettingPage();
		signtest.verifyLogin();
		// WaitFor.elementToBeVisibile(s.getConfirmationMessage(), 30);
		jmeet.clickOnJoinMeetlink();
		LOG.info("clicking on join meet link and getting text as:" + jmeet.getJoinMeetTxt());
		/*
		 * jmeet.clickOnBackArrowLink(); LOG.info("clicking on back button link");
		 * Thread.sleep(2000); jmeet.clickOnJoinMeetlink();
		 * LOG.info("clicking on join meet link and getting text as:" +
		 * jmeet.getJoinMeetTxt());
		 */
		jmeet.enterUsername(user_name);
		LOG.info("enetring username");
		jmeet.enetrMeetingId(meeting_Id);
		LOG.info("Entering meeting id");
		jmeet.clickOnJoinMeetingBtn();
		Thread.sleep(3000);
		LOG.info("clicking on join meeting button");
		String actual = null;
		if (k.getActualJmeetingCurrentUrl().equals(k.getExpectedJmeetingCurrentUrl())) {
			// actual = jmeet.confirmationMsgForJmeet();
			Assert.assertEquals(k.getActualJmeetingCurrentUrl(), k.getExpectedJmeetingCurrentUrl());
			LOG.info("Running on Expected Join meeting window and url is : " + k.getActualJmeetingCurrentUrl());
		} else {
			WaitFor.elementToBeVisibile(jmeet.getWrongMeetId(), 30);
			actual = jmeet.error_msgforWrongMeetId();
			if (actual.contains("Meeting")) {
				Assert.assertEquals(actual, "Meeting id not found");
				LOG.info("Enetered wrong meeting id : " + jmeet.error_msgforWrongMeetId());
			} else {
				WaitFor.elementToBeVisibile(jmeet.getEmptyMeeting_Id(), 30);
				actual = jmeet.errorMsgForEmptyMeetingId();
				if (actual.contains("Please")) {
					Assert.assertEquals(actual, "Please enter meeting id.");
					LOG.info("Leaving Meeting Id empty:" + actual);
				}
			}
		}

	}
}
