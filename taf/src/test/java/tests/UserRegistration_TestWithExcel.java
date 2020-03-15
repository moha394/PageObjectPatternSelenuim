package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.Home_Page;
import pages.Login_Page;
import pages.UserRegistration_Page;

public class UserRegistration_TestWithExcel extends TestBase {
	
	Home_Page homeObject ;
	UserRegistration_Page RegistrationPageObject ;
	Login_Page loginObjct;
	
	@DataProvider(name = "ExcelData")
	public Object [] [] UserRegisterDate() throws IOException
	{
		ExcelReader red = new ExcelReader();
		 
	
			return red.getDataExcel();
	
	}
	
	@Test(dataProvider = "ExcelData")
	public void SuccessfullyRegister(String fname , String lname , String email , String password) throws InterruptedException {
	
	homeObject = new Home_Page(driver);
	homeObject.OpenRegistrationPage();
	
	
	RegistrationPageObject = new UserRegistration_Page(driver);
	Thread.sleep(3000);

	//Test Case _1 Registration
	RegistrationPageObject.RegistrationFill(fname, lname, email, password, password);

	RegistrationPageObject.ReturnResult("Your registration completed");
	Thread.sleep(1000);


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
