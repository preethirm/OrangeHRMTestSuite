package com.orangehrm.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Represents the Login page on the application
 * @author preethi
 *
 */
public class LoginPage {
	public WebElement getUserNameElement (WebDriver driver)
	{
		return driver.findElement(By.id("txtUsername"));
	}
	public WebElement getPasswordElement (WebDriver driver)
	{
		return driver.findElement(By.id("txtPassword"));
	}
	public WebElement getButtonLoginElement (WebDriver driver)
	{
		return driver.findElement(By.id("btnLogin"));
	}
	public WebElement getInvalidElement (WebDriver driver)
	{
		return driver.findElement(By.id("spanMessage"));
	}
}
