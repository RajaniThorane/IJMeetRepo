package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyUtil {
	Properties prop = new Properties();
	private static final Logger LOG = Logger.getLogger(PropertyUtil.class);

	public String getKeyProperty(String key) throws IOException {
		prop = loadApplicationProperties();
		return prop.getProperty(key);
	}

	private Properties loadApplicationProperties() {
		String dir = System.getProperty("user.dir");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dir + "/src/main/resources/OR.properties");
		} catch (FileNotFoundException e) {
			LOG.info("Property File not Found ");
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			LOG.error("Unable to load Property File");
		}
		return prop;
	}
}
