package keywords;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Config_properties;
import utilities.Constants;

public class UIKeywords {
	private Config_properties con = new Config_properties();
	private static final Logger LOG = Logger.getLogger(UIKeywords.class);
	// private WebDriver driver ;

	public void openBrowser() {
		String browserName = con.getBrowserName();
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			LOG.info("ChromeBrowser Lunching Successfully. ");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			LOG.info("FirefoxBrowser Lunching Successfully. ");

			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			LOG.info("IEBrowser Lunching Successfully. ");

			break;
		case "Opera":
			WebDriverManager.operadriver().setup();
			Constants.driver = new OperaDriver();
			LOG.info("OperaBrowser Lunching Successfully. ");

		default:
			System.err.println("Invalid  Browser :");
			break;
		}
	}

	public void lunchURL() {
		Constants.driver.get(con.getUrl());
	}

	public void closeBrowserwindows() {
		Constants.driver.quit();
	}

	public void closebrowserwindow() {
		Constants.driver.close();
	}

	public void windowMaximise() {
		Constants.driver.manage().window().maximize();
	}

	public void deletecookies() {
		Constants.driver.manage().deleteAllCookies();
	}

	public void waitFor(long time) {
		try {
			long now = System.currentTimeMillis();
			while (now < time) {
				now = System.currentTimeMillis();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void implicitWait(int timeout) {
		Constants.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

	}

	public void click(By by) {
		Constants.driver.findElement(by).click();
	}

	public void click(WebElement element) {
		element.click();
	}

	public String verifyExpectedCurrentUrl() {
		return con.getActualCurrentUrl();
		
	}

	public String gettingCurrentUrl() {
		return Constants.driver.getCurrentUrl();
	}
}
