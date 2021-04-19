package pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.UIKeywords;
import utilities.Constants;
import utilities.WaitFor;

public class ConferenceCallPage {
	UIKeywords key = new UIKeywords();
	@FindBy(xpath = "svg>path[fill-rule='evenodd']")
	private WebElement invitePeople;
	@FindBy(css = "div#new-toolbox div[class='jitsi-icon '] svg>path[d~='M26.688']")
	public WebElement chatLink;
	@FindBy(xpath = "//span[text()='Rajani Tighare (me)']")
	private WebElement participants;

	public WebElement getParticipants() {
		return participants;
	}

	public WebElement getChatLink() {
		return chatLink;
	}

	public WebElement getInvitePeople() {
		return invitePeople;
	}

	public void clickOnChatLink() {
		Actions action = new Actions(Constants.driver);
		Point location = chatLink.getLocation();
		int x = location.getX();
		int y = location.getY();
		action.moveByOffset(x, y).build().perform();
	/*	WebElement pageLoad = WaitFor.elementToBeLoad(chatLink, 20);
		action.moveToElement(pageLoad).click().build().perform();*/

		// key.click(chatLink);
	}

	public ConferenceCallPage() {
		PageFactory.initElements(Constants.driver, this);
	}

	public void clickOnInviteMorePeople() {
		key.click(invitePeople);
	}

}
