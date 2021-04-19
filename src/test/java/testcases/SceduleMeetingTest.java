package testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basesetup.BaseClass;
import keywords.UIKeywords;
import pages.SceduleMeetingPage;
import sun.rmi.runtime.Log;
import utilities.Constants;
import utilities.WaitFor;

public class SceduleMeetingTest extends BaseClass {
	private static final Logger LOG = Logger.getLogger(SceduleMeetingTest.class);

	@Test
	public void verifySceduleMeeting() throws InterruptedException {
      SignInPageTest signtest = new SignInPageTest();
      SceduleMeetingPage schedulepage = new SceduleMeetingPage(); 
      signtest.verifyLogin();
     schedulepage.clickOnScheduleMeeting();
      LOG.info("Click On Schedule Meeting : ");
    LOG.info("Tab Name is : "+schedulepage.getTextOfTabName());
    
    schedulepage.enterMeetingTopic("My Meeting");
    LOG.info("Entering meeting topic ");
    schedulepage.enterMeetingdescription("This is  project descussion ");
    LOG.info("Entering Project description");
    WaitFor.elementToBeVisibile(schedulepage.getInviteUserTxt(), 30);
    
    schedulepage.enterMeetingInvites("rajani.thorane@gmail.com");
    LOG.info("Inviting People");
    schedulepage.clickOnWhendateTextBox();
    LOG.info("Click on date TextBox");
    schedulepage.selectMonth("May");
    LOG.info("Select Month ");
    schedulepage.selectYear("2022");
    LOG.info("Select Year ");
    schedulepage.selectDay("27");
    LOG.info("Select date ");
    schedulepage.enterTime("8:26 PM");
    LOG.info("Meeting Time Entered");
    Thread.sleep(2000);
    schedulepage.selectMeetingHours("02");
    LOG.info("Meeting Hours selected");
    schedulepage.selectMeetingMinute("30");
    LOG.info("Meeting Minute Selected");
    schedulepage.selectTimeZone("(GMT+05:30) Asia/Kolkata");
    LOG.info("Selecting time zone ");
    schedulepage.selectLanguage("English");
    LOG.info("Selcting  language");
    Thread.sleep(5000);
    
    
    
		SignInPageTest signtest = new SignInPageTest();
		SceduleMeetingPage schedulepage = new SceduleMeetingPage();
		signtest.verifyLogin();
		schedulepage.clickOnScheduleMeeting();
		LOG.info("Click On Schedule Meeting : ");
		LOG.info("Tab Name is : " + schedulepage.getTextOfTabName());

		schedulepage.enterMeetingTopic("My Meeting");
		LOG.info("Entering meeting topic ");
		schedulepage.enterMeetingdescription("This is  project descussion ");
		LOG.info("Entering Project description");
		// Thread.sleep(2000);
		//WaitFor.elementLocate(schedulepage.getInviteUserTxt(),30);
		//schedulepage.enterMeetingInvites("rajani.thorane@gmail.com");
		//LOG.info("Inviting People");
		schedulepage.clickOnWhendateTextBox();
		LOG.info("Click on date TextBox");
		//LOG.info(schedulepage.readElements());

	}

}
