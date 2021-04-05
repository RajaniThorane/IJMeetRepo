package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.UIKeywords;

import utilities.Constants;

public class SignInPage {
	UIKeywords keyword = new UIKeywords();
	@FindBy(xpath = "//a[text()=' Sign In ']")
	private WebElement signinlink;
	By signin_link = By.cssSelector("ul[class='navbar-nav ml-auto customize-right-navbar'] :nth-child(4) a");

	private WebElement email;
	private WebElement password;
	@FindBy(css = "button[type='submit']")
	private WebElement signinBtn;

	@FindBy(css = "div[class='shedule-meeting-hello-views'] h3")
	private WebElement confirmationMessage;

	// private By signinlink = By.xpath("//a[text()=' Sign In ']");

	public WebElement getsignuplink() {
		return signinlink;
	}

	public SignInPage() {
		PageFactory.initElements(Constants.driver, this);
	}

	public void clickOnsignUpLink() {
		signinlink.click();
	}

	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}

	public void enterPassword(String pswd) {
		password.sendKeys(pswd);
	}

	public void clickOnSignUpBtn() {
		signinBtn.click();
	}

	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}

	public String getConfirmationMessageText() {
		return confirmationMessage.getText();
	}

}
