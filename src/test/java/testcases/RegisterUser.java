package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviders;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegisterUser extends BaseClass
{
	LoginPage login;
	RegistrationPage registrationPage;
	
	@Test(dataProvider = "newUserDetails" ,dataProviderClass = DataProviders.class)
	public void registerNewUser(String name,String email,String password,String interests,String gender,String state,String hobby) 
	{
		login=new LoginPage(driver);
		registrationPage=login.clickOnSignUpLink();
		
		boolean status= registrationPage.signUpButtonStatusCheck();
		Assert.assertFalse(status, "Sign up button is enabled");
		
		boolean statusAfterRegistringUser= registrationPage.registerNewuser(name,email,password,interests,gender,state,hobby);
		Assert.assertTrue(statusAfterRegistringUser, "Sign up button is disabled");
		
		boolean successMessageStatus=login.checkSuccessMessgeIsPresent();
		Assert.assertTrue(successMessageStatus, "Success message is not displayed");
		
	}
}
