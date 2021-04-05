package testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import basesetup.BaseClass;
import pages.SceduleMeetingPage;
import sun.rmi.runtime.Log;

public class SceduleMeetingTest extends BaseClass {
	private static final Logger LOG = Logger.getLogger(SceduleMeetingTest.class);

	@Test
	public void verifySceduleMeeting() {
      SignInPageTest signtest = new SignInPageTest();
      SceduleMeetingPage schedulepage = new SceduleMeetingPage(); 
      signtest.verifyLogin();
     schedulepage.clickOnScheduleMeeting();
    LOG.info("Click On Schedule Meeting : ");
    LOG.info("Tab Name is : "+schedulepage.getTextOfTabName());
      

	}

}
