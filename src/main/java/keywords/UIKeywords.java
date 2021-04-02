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
import utilities.Constance;

public class UIKeywords {
	 private Config_properties con = new Config_properties();
	 private static final Logger LOG = Logger.getLogger(UIKeywords.class);
	// private WebDriver driver ; 
	
	public void openBrowser() {
		String browserName  = con.getBrowserName();
		switch(browserName){
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Constance.driver = new ChromeDriver();
			LOG.info("ChromeBrowser Lunching Successfully. ");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			Constance.driver=new FirefoxDriver();
			LOG.info("FirefoxBrowser Lunching Successfully. ");
			
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constance.driver=new InternetExplorerDriver();
			LOG.info("IEBrowser Lunching Successfully. ");
			
			break;
		case "Opera":
			WebDriverManager.operadriver().setup();
			Constance.driver = new OperaDriver();
			LOG.info("OperaBrowser Lunching Successfully. ");
			
			default :
				System.err.println("Invalid  Browser :");
				break ;
		}
	}
	public void lunchURL() {
		Constance.driver.get(con.getUrl());
	}
	public void closeBrowserwindows() {
		Constance.driver.quit();
	}
	public void closebrowserwindow() {
		Constance.driver.close();
	}
	public  void windowMaximise() {
		Constance.driver.manage().window().maximize();
	}
	public void deletecookies() {
		Constance.driver.manage().deleteAllCookies();
	}
	public void waitFor(long time) {
		try {
		 long now = System.currentTimeMillis();
		 while(now < time) {
			 now = System.currentTimeMillis();
		 }
		
		}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void implicitWait(int timeout ) {
		Constance.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

		
	}
	public void click(By by) {
	Constance.driver.findElement(by).click();	
	}
	public void click(WebElement element) {
	 element.click();	
	}

}
