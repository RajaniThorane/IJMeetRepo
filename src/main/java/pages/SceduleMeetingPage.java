package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import utilities.Constants;

public class SceduleMeetingPage  {
	
	@FindBy(xpath="//img[@class='shedu-respo']//ancestor::button[@class='btn first-btn-warning btn-rounded btn-fw schedule-new-meet-btn']")
	private WebElement scheduleMeeting;
	@FindBy(css="ul[class='nav nav-pills'] li")
	private WebElement tabName ;
	
	
	public SceduleMeetingPage() {
		PageFactory.initElements(Constants.driver, this);
	}
	
	public WebElement getScheduleMeeting() {
		return scheduleMeeting;
		
	}
	public void clickOnScheduleMeeting() {
		scheduleMeeting.click();
	}
	public String getTextOfTabName() {
		return tabName.getText();
	}
}
