package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import utilities.Constants;
import utilities.LoginDataFromExcel;

public class LoginPage {
	private static final Logger LOG = Logger.getLogger(LoginPage.class);
	private By emailIdTextBox = By.xpath("//input[@id='email']");
	private By passwordTextBox = By.xpath("//input[@id='password']");
	private By loginButn = By.xpath("//button[text()=' Sign In ']");

	public void enterEmailId(String emailid) {
		LOG.info("Entering email id");
		Constants.driver.findElement(emailIdTextBox).sendKeys(emailid)
		}

	public void enterPassword(String password) {
		LOG.info("Entering password");
		Constants.driver.findElement(passwordTextBox).sendKeys(password);

	}
	public void clickOnLogin() {
		LOG.info("clicking on login button");
		Constants.driver.findElement(loginButn).click();
	}
}
