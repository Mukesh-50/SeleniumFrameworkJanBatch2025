package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import base.BaseClass;

public class RegisterNewUser_Raj_Class73 extends BaseClass {
	LoginPage login;
	signUpPage signUpObj;
	
	@Test(priority=0)
	public void verifySignUpButtonDisabled() {
		login=new LoginPage(driver);
		signUpPage signUp=login.clickSignUpLink();
		boolean signUpStatus=signUp.isSignUpStatus();
		
		//verify status of signUp button.
		 Assert.assertEquals(signUpStatus, false);
	}
	
	@Test(priority=1)
	public void createUser() {				
		signUpObj=new signUpPage(driver);
		boolean signUpStatusPostUserDetail=signUpObj.newUser("user1", "testNewUser9@email.com", "pass123", "Male", "Uttar Pradesh","Reading");
	
		Assert.assertEquals(signUpStatusPostUserDetail, true);
	}
}