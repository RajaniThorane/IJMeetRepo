package utilities;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBase {
	private static final Logger LOG = Logger.getLogger(SeleniumBase.class);
	@BeforeMethod

	public void launchApplication() throws IOException {

		switch (Config.getBrowserName()) {
		case "chrome":
			LOG.info("Launching chrome browser");
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			break;
		case "firefox":
			break;
		default:
			break;
		}
		Constants.driver.get(Config.getAppUrl());
	}

}
