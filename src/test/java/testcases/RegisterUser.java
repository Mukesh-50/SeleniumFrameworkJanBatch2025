package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviders;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegisterUser extends BaseClass {
	LoginPage login;
    RegistrationPage registrationPage;
	
@Test(dataProvider="newUserDetails",dataProviderClass = DataProviders.class)
public void registerNewUser(String name, String email , String password , String interests, String gender, String state, String hobby)
{
	login=new LoginPage(driver);
	registrationPage= login.clickOnSingUpLink();
	boolean status =registrationPage.sinnUpButtonStatusCheck();
	Assert.assertFalse(status,"Sign Up is enabled");
	boolean statusAfterRegisteringUser =registrationPage.registerNewUser(name,email,password,interests,gender,state,hobby);
	Assert.assertTrue(statusAfterRegisteringUser,"Sign Up is disabled");
	boolean successMessageStatus=login.checkSuccessMsgPresent();
	Assert.assertTrue(successMessageStatus,"Success message not displayed");
}
}
