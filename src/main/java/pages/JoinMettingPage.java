package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basesetup.BaseClass;
import keywords.UIKeywords;
import utilities.Constants;

public class JoinMettingPage {
	UIKeywords key = new UIKeywords();
	@FindBy(xpath = "//button[@class='btn second-btn-warning btn-rounded btn-fw']")
	private WebElement joinMeetinglink;
	@FindBy(tagName = "h2")
	private WebElement joinMeetTxt;
	private WebElement username;
	private WebElement meetingid;
	private WebElement before_start;
	@FindBy(xpath = "//p[text()='Meeting id not found']")
	private WebElement wrongMeetId;
	@FindBy(xpath = "//p[text()='Please enter meeting id.']")
	private WebElement emptyMeeting_Id;
	@FindBy(css = "a>div[class='watermark leftwatermark']")
	private WebElement jmeettitle;
	@FindBy(css = "a.back-arrow")
	private WebElement backArrowLink;

	public void clickOnBackArrowLink() {
		key.click(backArrowLink);
	}

	public String confirmationMsgForJmeet() {
		return jmeettitle.getText();
	}

	public WebElement getEmptyMeeting_Id() {
		return emptyMeeting_Id;
	}

	public String errorMsgForEmptyMeetingId() {
		return emptyMeeting_Id.getText();
		// TODO Auto-generated method stub

	}

	public JoinMettingPage() {
		PageFactory.initElements(Constants.driver, this);
	}

	public void clickOnJoinMeetlink() {
		key.click(joinMeetinglink);
	}

	public String getJoinMeetTxt() {
		return joinMeetTxt.getText();
	}

	public String meetingPageText() {
		return joinMeetTxt.getText();
	}

	public void enterUsername(String user) {
		key.doSendKeys(username, user);
	}

	public void enetrMeetingId(String jmeet_id) {
		key.doSendKeys(meetingid, jmeet_id);
	}

	public void clickOnJoinMeetingBtn() {
		key.click(before_start);
	}

	public WebElement getWrongMeetId() {
		return wrongMeetId;
	}

	public String error_msgforWrongMeetId() {
		return wrongMeetId.getText();
		// TODO Auto-generated method stub

	}

}
