package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import base.BaseClass;
import dataprovider.DataProviders;

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
	
	//before you run this tc go to data provider class mentioned and look for the data provider name given.
	@Test(priority=1,dataProvider="newUserDetails", dataProviderClass=DataProviders.class)
	public void createUser(String username, String emailID, String password, String interest, String gender, String state, String hobby) {
		
		signUpObj=new signUpPage(driver);
		boolean signUpStatusPostUserDetail=signUpObj.newUser(username, emailID, password, interest, gender, state, hobby);
		Assert.assertEquals(signUpStatusPostUserDetail, true);
		Assert.assertEquals(login.successMsg(), true);		
		
	}
}