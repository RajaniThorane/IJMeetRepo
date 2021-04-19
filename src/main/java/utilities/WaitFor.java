package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;

public class WaitFor {
	public static void elementToBeVisibile(WebElement element, int timeout) {
		Constants.wait = new WebDriverWait(Constants.driver, timeout);

		Constants.wait.until((ExpectedConditions.visibilityOf(element)));
	}

	public static void elementLocate(WebElement element, int timeout) {
		Constants.wait = new WebDriverWait(Constants.driver, timeout);

		Constants.wait.until((ExpectedConditions.visibilityOfElementLocated((By) element)));
		// Constants.wait.until(ExpectedConditions.alertIsPresent())

	}

	public static WebElement elementToBeLoad(WebElement element, int timeout) {
		Constants.wait = new WebDriverWait(Constants.driver, timeout);

		return Constants.wait.until((ExpectedConditions.elementToBeClickable(element)));
	}

	public static void untilAletIsPresent(int timeout) {
		Constants.wait = new WebDriverWait(Constants.driver, timeout);
		Constants.wait.until(ExpectedConditions.alertIsPresent());

	}
}
