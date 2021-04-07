package testcases;

import java.util.concurrent.ScheduledExecutorService;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import basesetup.BaseClass;
import keywords.UIKeywords;
import pages.SceduleMeetingPage;
import sun.rmi.runtime.Log;
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
   // Thread.sleep(2000);
    WaitFor.elementLocate(schedulepage.getInviteUserTxt(), 5000);
    schedulepage.enterMeetingInvites("rajani.thorane@gmail.com");
    LOG.info("Inviting People");
    schedulepage.clickOnWhendateTextBox();
    LOG.info("Click on date TextBox");
    
    
    
    
      

	}

}
