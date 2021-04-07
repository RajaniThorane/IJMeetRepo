package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basesetup.BaseClass;
import keywords.UIKeywords;
import listeners.MyListeners;
import pages.SignInPage;
import utilities.Constants;
import utilities.Dataproviders;
import utilities.WaitFor;

//@Listeners(MyListeners.class)
public class SignInPageTest extends BaseClass {
	private static final Logger LOG = Logger.getLogger(SignInPageTest.class);

	// @Test
	public void verifyLogin() {
		SignInPage signin = new SignInPage();
		WaitFor.elementToBeVisibile(signin.getsignuplink(), 30);
		signin.clickOnsignUpLink();
		LOG.info("Entering EmailId ");
		signin.enterEmail("jangamashwini04@gmail.com");
		LOG.info("Entering Password");
		signin.enterPassword("Ashwini@123");
		LOG.info("Click on Signinbutton");
		signin.clickOnSignUpBtn();
		WaitFor.elementToBeVisibile(signin.getConfirmationMessage(), 30);

		String actual = signin.getConfirmationMessageText();
		Assert.assertTrue(actual.contains("Hello"));
		LOG.info("Redirect on dashboard  and dispaly : " + actual);
	}

	@Test(dataProvider = "LoginData", dataProviderClass = Dataproviders.class)
	public void verifyLogin(Object emailId, Object password) {
		SignInPage signin = new SignInPage();
		UIKeywords k = new UIKeywords();
		WaitFor.elementToBeVisibile(signin.getsignuplink(), 30);
		signin.clickOnsignUpLink();
		LOG.info("Entering EmailId " + emailId);
		signin.enterEmail((String) emailId);
		LOG.info("Entering Password" + password);
		signin.enterPassword((String) password);
		LOG.info("Click on Signinbutton");
		signin.clickOnSignUpBtn();
		String actual = null;
		if (k.gettingCurrentUrl().equals(k.verifyExpectedCurrentUrl())) {
			actual = signin.getConfirmationMessageText();
			Assert.assertTrue(actual.contains("Hello"));
			LOG.info("Redirect on dashboard  and dispaly : " + actual);
		} else {
			WaitFor.elementToBeVisibile(signin.geterr_msg(), 30);
			actual = signin.get_err_text();

			if (!actual.isEmpty()) {
				Assert.assertEquals(actual, "These credentials do not match our records.");
				LOG.info("Displaying an error msg:" + actual);
			}

		}

	}

}
