package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import base.BaseClass;
import dataprovider.DataProviders;
import helper.Utility;

public class RegisterNewUser_Raj_Class73 extends BaseClass {
	LoginPage login;
	//signUpPage signUpObj;
	
	//before you run this Test Method go to data provider class mentioned and look for the data provider name given.
	@Test(dataProvider="newUserDetails", dataProviderClass=DataProviders.class)
	public void createUser(String username, String emailID, String password, String interest, String gender, String state, String hobby) {
		
		login=new LoginPage(driver);
		signUpPage signUp=login.clickSignUpLink();
		boolean signUpStatus=signUp.isSignUpStatus();
		
		//verify status of signUp button.
		 Assert.assertEquals(signUpStatus, false);
		
		//signUpObj=new signUpPage(driver);
		boolean signUpStatusPostUserDetail=signUp.newUser(username, emailID, password, interest, gender, state, hobby);
		Assert.assertEquals(signUpStatusPostUserDetail, true);
		Assert.assertEquals(login.successMsg(), true);
		Utility.waitForSeconds(5);
		
	}
}