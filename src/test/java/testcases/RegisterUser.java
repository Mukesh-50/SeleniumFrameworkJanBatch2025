package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegisterUser extends BaseClass {
	LoginPage login;
    RegistrationPage registrationPage;
	
@Test
public void registerNewUser()
{
	login=new LoginPage(driver);
	registrationPage= login.clickOnSingUpLink();
	boolean status =registrationPage.sinnUpButtonStatusCheck();
	Assert.assertFalse(status,"Sign Up is enabled");
	boolean statusAfterRegisteringUser =registrationPage.registerNewUser("Mukesh", "Mukesh1245747@gmail.com", "Learnify", "Karnataka", "Reading");
	Assert.assertTrue(statusAfterRegisteringUser,"Sign Up is disabled");
	
}
}
