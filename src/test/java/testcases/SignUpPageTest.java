package testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import basesetup.BaseClass;
import pages.SignInPage;
import pages.SignUpPage;
import utilities.WaitFor;

public class SignUpPageTest extends BaseClass {
	private static final Logger LOG = Logger.getLogger(SignUpPageTest.class);

	@Test
	public void signUpTc() {

		SignUpPage signUp = new SignUpPage();
		WaitFor.elementToBeVisibile(signUp.userSignUp(), 30);
		signUp.clickOnSignUpLink();
		LOG.info("Entering signup link");
		signUp.enterName();
		LOG.info("Entering name");
		signUp.enterCompanyName();
		LOG.info("Entering company name");
		signUp.enterEmail();
		LOG.info("Enetring email");
		signUp.enterContact();
		LOG.info("Entering contact");
		signUp.enterPassword();
		LOG.info("entering password");
		signUp.selectCaptcha();
		LOG.info("selecting captcha");
		signUp.clickOnSignUpBtn();
		LOG.info("clicking on signup button");

	}
}
