package utilities;

import java.io.IOException;

import org.apache.log4j.Logger;

public class Config {
	static PropertyUtil prop = new PropertyUtil();
	private static final Logger LOG = Logger.getLogger(Config.class);

	public static String getBrowserName() throws IOException {

		String browser = prop.getKeyProperty("browser.name");
		LOG.info("Getting browser name " + browser);
		return browser;
	}

	public static String getAppUrl() throws IOException {

		String url = prop.getKeyProperty("url");
		LOG.info("Getting url" + url);
		return url;
	}
}
