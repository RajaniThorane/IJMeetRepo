package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.UIKeywords;
import utilities.Constants;

public class SceduleMeetingPage  {
	private UIKeywords keyword = new UIKeywords();

	@FindBy(xpath="//img[@class='shedu-respo']//ancestor::button[@class='btn first-btn-warning btn-rounded btn-fw schedule-new-meet-btn']")
	private WebElement scheduleMeeting;
	@FindBy(css="ul[class='nav nav-pills'] li")
	private WebElement tabName ;
	
	@FindBy(id="edit_topic")
	private WebElement topicTxt;
	@FindBy(id="edit_description_1")
	private WebElement description;
	@FindBy(css="ul[class='multiple_emails-ul']")
	private WebElement inviteUserTxt;
	@FindBy(id="edit_start_end_date")
	private WebElement whenDateTxt;
	@FindBy(css="div[class='drp-calendar left single'] select[class='monthselect']")
	private WebElement whenMonthdropdown;
	@FindBy(css="div[class='drp-calendar left single'] select[class='yearselect']")
	private WebElement whenYearDropdown;
	@FindBy(css="div[class='drp-calendar left single'] table[class='table-condensed']")
	private WebElement whenDay;
	

	public SceduleMeetingPage() {
		PageFactory.initElements(Constants.driver, this);
	}
	
	public void enterMeetingTopic(String topic) {
		keyword.doSendKeys(topicTxt,topic);
	}
	public void enterMeetingdescription(String meetingdescription) {
	  keyword.doSendKeys(description, meetingdescription);
	}
	public void enterMeetingInvites(String emailid) {
		keyword.doSendKeys(inviteUserTxt, emailid);
	}
	public WebElement getInviteUserTxt() {
		return inviteUserTxt;
	}
	public void clickOnWhendateTextBox() {
		keyword.click(whenDateTxt);
	}
	public WebElement getScheduleMeeting() {
		return scheduleMeeting;
		
	}
	public void clickOnScheduleMeeting() {
		scheduleMeeting.click();
	}
	public WebElement getTabName() {
		return tabName;
	}
	public String getTextOfTabName() {
		return tabName.getText();
	}
}
