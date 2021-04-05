package com.uitilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;

public class WaitFor {
	public static  void elementToBeVisibile(WebElement element, int timeout) {
		Constants.wait =  new WebDriverWait(Constants.driver ,timeout);
		
		Constants.wait.until((ExpectedConditions.visibilityOf(element))); 
		}

}
