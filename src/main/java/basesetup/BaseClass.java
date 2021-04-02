package basesetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;
import keywords.UIKeywords;

public class BaseClass {
	private UIKeywords keyword  = new UIKeywords();
	
	@BeforeMethod
	public void setUp()  {
		keyword.openBrowser();
		keyword.windowMaximise();
		keyword.lunchURL();
		//keyword.implicitWait(10);		
	}
	@AfterMethod
	public void tearDown()  {
		keyword.waitFor(2000);
		keyword.closeBrowserwindows();
	}

}
