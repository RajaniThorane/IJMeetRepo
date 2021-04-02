package com.uitilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
	public static  void elementToBeVisibile(WebElement element, int timeout) {
		Constance.wait =  new WebDriverWait(Constance.driver ,timeout);
		
		Constance.wait.until((ExpectedConditions.visibilityOf(element))); 
		}

}
