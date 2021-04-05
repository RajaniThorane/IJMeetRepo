package testcases1;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basesetup.BaseClass;
import keywords.UIKeywords;
import pages.SignInPage;
import utilities.Dataproviders;
import utilities.WaitFor;

public class SignInPageTest extends BaseClass {
	private static final Logger LOG = Logger.getLogger(SignInPageTest.class);

	//@Test
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

	@Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class)
	public void verifyLogin(Object emailId, Object password) {
		SignInPage signin = new SignInPage();
		WaitFor.elementToBeVisibile(signin.getsignuplink(), 30);
		signin.clickOnsignUpLink();
		LOG.info("Entering EmailId :"+emailId);
		signin.enterEmail((String) emailId);
		LOG.info("Entering Password :"+password);
		signin.enterPassword((String) password);
		LOG.info("Click on Signinbutton");
		signin.clickOnSignUpBtn();
		WaitFor.elementToBeVisibile(signin.getConfirmationMessage(), 30);

		String actual = signin.getConfirmationMessageText();
		Assert.assertTrue(actual.contains("Hello"));
		LOG.info("Redirect on dashboard  and dispaly : " + actual);

	}

}
