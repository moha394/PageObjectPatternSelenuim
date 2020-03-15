package tests;

import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Login_Page;

public class Login_Test extends TestBase {

	Home_Page _HomePageObject;
	Login_Page _loginPageObject;
	
	
	
	@Test
	public void loginSucceffully() throws InterruptedException {
		
		_HomePageObject = new Home_Page(driver);
		
		_HomePageObject.OpenLoginPage();
		
		
		_loginPageObject = new Login_Page(driver);
		_loginPageObject.loginUser("vmester2@gonationmedia.com", "123456");
		
		Thread.sleep(2000);
		_loginPageObject.checkRememberMe();
		Thread.sleep(2000);

		_loginPageObject.PressLoginButton();
		Thread.sleep(2000);
		
		_loginPageObject.ReturnResult("My account");
		Thread.sleep(2000);
		
	}
	
	
}
