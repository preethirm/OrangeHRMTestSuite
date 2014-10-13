package com.orangehrm.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Represents the Dashboard on the application
 * @author preethi
 *
 */
public class DashboardPage {
	public WebElement getWelcomeLinkElement (WebDriver driver)
	{
		return driver.findElement(By.id("welcome"));
	}
}
