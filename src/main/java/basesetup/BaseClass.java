package basesetup;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import keywords.UIKeywords;



public class BaseClass {
	// private UIKeywords keyword = new UIKeywords();
	UIKeywords keyword = new UIKeywords();

	@BeforeMethod
	public void setUp() {
		keyword.openBrowser();
		keyword.windowMaximise();
		keyword.lunchURL();
		// keyword.implicitWait(10);
	}

	@AfterMethod
	public void tearDown() {
		keyword.waitFor(2000);
		keyword.closeBrowserwindows();
	}

}
