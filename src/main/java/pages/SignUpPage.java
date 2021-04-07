package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;

public class SignUpPage {
	@FindBy(xpath = "//a[text()=' Sign Up ']")
	private WebElement signUpLink;
	private WebElement name;
	private WebElement company_name;
	private WebElement email;
	private WebElement contact;
	private WebElement password;
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	private WebElement captcha;
	@FindBy(xpath = "//button[text()=' Sign Up ']")
	private WebElement signupBtn;

	public SignUpPage() {
		PageFactory.initElements(Constants.driver, this);
	}

	public WebElement userSignUp() {
		return signUpLink;
	}

	public void clickOnSignUpLink() {
		signUpLink.click();
	}

	public void enterName() {
		name.sendKeys("swatikulkarni");
	}

	public void enterCompanyName() {
		company_name.sendKeys("Resonencia");
	}

	public void enterEmail() {
		email.sendKeys("abc@gmail.com");
	}

	public void enterContact() {
		contact.sendKeys("9823613128");
	}

	public void enterPassword() {
		password.sendKeys("Swati@1234");
	}

	public void selectCaptcha() {
		captcha.click();
	}

	public void clickOnSignUpBtn() {
		signupBtn.click();
	}
}
