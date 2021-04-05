package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uitilities.WaitFor;

import basesetup.BaseClass;
import keywords.UIKeywords;
import pages.SignInPage;

public class SignInPageTest extends BaseClass {
	private static final Logger LOG = Logger.getLogger(SignInPageTest.class);

	@Test
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

}
