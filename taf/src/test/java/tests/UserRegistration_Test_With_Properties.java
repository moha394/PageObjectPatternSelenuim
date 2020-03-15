package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.Home_Page;
import pages.Login_Page;
import pages.UserRegistration_Page;

public class UserRegistration_Test_With_Properties extends TestBase {
	
	Home_Page homeObject ;
	UserRegistration_Page RegistrationPageObject ;
	Login_Page loginObjct;
	
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");
	
	
	@DataProvider(name = "testData")
	public static Object[][] userData(){
		return new Object[][] {
			{"Mohamed","Ahmed","test1moha3@gmail.com","1234560"},
			{"Mohamed","Ahmed","test2moha3@gmail.com","1234560"}
		};
	}
	
	@Test
	public void SuccessfullyRegister() throws InterruptedException {
	
	homeObject = new Home_Page(driver);
	homeObject.OpenRegistrationPage();
	
	
	RegistrationPageObject = new UserRegistration_Page(driver);
	Thread.sleep(2000);

	//Test Case _1 Registration
	RegistrationPageObject.RegistrationFill(firstname, lastname, email, password, password);

	RegistrationPageObject.ReturnResult("Your registration completed");
	

	homeObject = new Home_Page(driver);
	homeObject.UserLogout();

	homeObject.OpenLoginPage();
	

	//Login TestCase
	loginObjct= new Login_Page(driver);
	Thread.sleep(2000);

	loginObjct.loginUser(email, password);
	loginObjct.checkRememberMe();
	loginObjct.PressLoginButton();
	loginObjct.ReturnResult("My account");

	homeObject.UserLogout();

	
	}
	@Test(dependsOnMethods = {"SuccessfullyRegister"} , enabled = false)
	public void UserLoginSucceffully() throws InterruptedException {

		homeObject = new Home_Page(driver);
		homeObject.UserLogout();
		Thread.sleep(2000);

		homeObject.OpenLoginPage();
		
		Thread.sleep(2000);

		//Login TestCase
		loginObjct= new Login_Page(driver);
		loginObjct.loginUser("vmester12@gonationmedia.com", "123456");
		loginObjct.checkRememberMe();
		loginObjct.PressLoginButton();
		loginObjct.ReturnResult("My account");
		Thread.sleep(2000);

		homeObject.UserLogout();
		Thread.sleep(2000);
	}
	
	
}
