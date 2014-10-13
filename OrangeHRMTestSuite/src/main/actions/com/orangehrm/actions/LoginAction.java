package com.orangehrm.actions;

import org.openqa.selenium.WebDriver;

import com.orangehrm.pageObject.DashboardPage;
import com.orangehrm.pageObject.LoginPage;
/**
 * Identifies a Login action - includes access to Login page object and Dashboard page object
 * @author preethi
 *
 */
public class LoginAction {
	private WebDriver driver;
	public LoginAction(WebDriver driver)
	{
		this.driver = driver;
	}
	/**
	 * Perform login action
	 * @param userName
	 * @param password
	 * @return
	 */
	public LoginPage performLoginAction(String userName, String password)
	{
		LoginPage loginPageObject = new LoginPage();
		loginPageObject.getUserNameElement(driver).clear();
		loginPageObject.getUserNameElement(driver).sendKeys(userName);
		loginPageObject.getPasswordElement(driver).clear();
		loginPageObject.getPasswordElement(driver).sendKeys(password);
		loginPageObject.getButtonLoginElement(driver).click();
		return loginPageObject;
	}
	
	/**
	 * Test for successful login
	 */
	public boolean successfulLoginPageMatch(){
		DashboardPage dashBoardPage = new DashboardPage();
		return dashBoardPage.getWelcomeLinkElement(driver).getText().contains("Welcome");
	}
	
	/**
	 * Test for unsuccessful login
	 * @param loginPageObject
	 * @return
	 */
	
	public boolean unSuccessfulLoginPageMatch(LoginPage loginPageObject){
		return loginPageObject.getInvalidElement(driver).getText().contains("Invalid Credentials");
	}
	/**
	 * Test for empty user name
	 * @param loginPageObject
	 * @return
	 */
	
	public boolean incompleteUserNameLoginPageMatch(LoginPage loginPageObject){
		return loginPageObject.getInvalidElement(driver).getText().contains("Username cannot be empty");
	}
	/**
	 * Test for empty password
	 * @param loginPageObject
	 * @return
	 */
	public boolean incompletePasswordLoginPageMatch(LoginPage loginPageObject){
		return loginPageObject.getInvalidElement(driver).getText().contains("Password cannot be empty");
	}
}