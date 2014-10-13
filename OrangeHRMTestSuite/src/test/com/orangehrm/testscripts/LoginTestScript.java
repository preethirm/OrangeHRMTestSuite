package com.orangehrm.testscripts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangehrm.actions.LoginAction;
import com.orangehrm.pageObject.LoginPage;

public class LoginTestScript {
	
	private WebDriver driver;
	private String webPageUrl;
	
	@Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    webPageUrl = "http://enterprise.demo.orangehrmlive.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(webPageUrl + "/symfony/web/index.php/auth/login");
	  }
	
	 @Test
	  public void testSuccessfulLogin() throws Exception {
		 LoginAction action = new LoginAction(driver);
		 action.performLoginAction("admin", "admin");
		 Assert.assertTrue(action.successfulLoginPageMatch());
	 }
	 @Test
	  public void testIncorrectUserNameCorrectPasswordLogin() throws Exception {
		 LoginAction action = new LoginAction(driver);
		 LoginPage loginPageObect = action.performLoginAction("admin-wrong", "admin");
		 Assert.assertTrue(action.unSuccessfulLoginPageMatch(loginPageObect));
	 }
	 
	 @Test
	  public void testIncorrectUserNameIncorrectPasswordLogin() throws Exception {
		 LoginAction action = new LoginAction(driver);
		 LoginPage loginPageObect = action.performLoginAction("admin-wrong", "admin-wrong");
		 Assert.assertTrue(action.unSuccessfulLoginPageMatch(loginPageObect));
	 }
	 
	 @Test
	  public void testEmptyUserNameLogin() throws Exception {
		 LoginAction action = new LoginAction(driver);
		 LoginPage loginPageObect = action.performLoginAction("", "admin");
		 Assert.assertTrue(action.incompleteUserNameLoginPageMatch(loginPageObect));
	 }
	 @Test
	  public void testEmptyPasswordLogin() throws Exception {
		 LoginAction action = new LoginAction(driver);
		 LoginPage loginPageObect = action.performLoginAction("admin", "");
		 Assert.assertTrue(action.incompletePasswordLoginPageMatch(loginPageObect));
	 }
	 
	 @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
	
}