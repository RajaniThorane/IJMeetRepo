package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import customeexceptions.InvalideDayException;
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
	@FindBy(css="input[class='multiple_emails-input text-left']")
	private WebElement inviteUserTxt;
	@FindBy(id="edit_start_end_date")
	private WebElement whenDateTxt;
	@FindBy(css="div[class='drp-calendar left single'] select[class='monthselect']")
	private WebElement whenMonthdropdown;
	@FindBy(css="div[class='drp-calendar left single'] select[class='yearselect']")
	private WebElement whenYearDropdown;
	@FindBy(how = How.XPATH, using = "//div[@class='drp-calendar left single']//tbody[1] //td[class=contains(text(),'available')]")
    private List<WebElement> whenDay;
	
	@FindBy (css="input#m_schedule_time_n")
	private WebElement timepicker ;
	
	@FindBy(css="select#edit_hour")
	private WebElement meetingHours;
	
	@FindBy(css="select#edit_minute")
	private WebElement meetingMinute;
	
	@FindBy(css="select#edit_timezone")
	private WebElement timezone;
	
	@FindBy(css="select#email_template_language")
	private WebElement language ; 
	

    
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
	public void selectMonth(String month) {
		keyword.selectValueFromDropdown(whenMonthdropdown, month );
	}
	public void selectMonth(int month) {
		keyword.selectValueFromDropdown(whenMonthdropdown, month );
	}
	
	public void selectYear(String year) {
		keyword.selectValueFromDropdown(whenYearDropdown, year );
	}
	public void selectYear(int year) {
		keyword.selectValueFromDropdown(whenYearDropdown, year );
	}

	public void selectDay(String date) {
		for (WebElement day : whenDay) {
			System.out.println(day.getText());
			if (day.getText().equals(date)) {
				day.click();
				break;
			}
		}

	}
	
	public void enterTime(String time) {
		timepicker.clear();
		keyword.doSendKeys(timepicker, time);
	}
	
	public void selectMeetingHours(String hours) {
	 keyword.selectValueFromDropdown(meetingHours, hours);
	}
	public void selectMeetingMinute(String minute) {
		keyword.selectValueFromDropdown(meetingMinute, minute);
	}
	
	public void selectTimeZone(String zone) {
	  keyword.selectValueFromDropdown(timezone, zone);
	}
	
	public void selectLanguage(String lang) {
		keyword.selectValueFromDropdown(language, lang);
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
