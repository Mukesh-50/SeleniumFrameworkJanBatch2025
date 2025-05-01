package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;
public class signUpPage {

	WebDriver driver=null;
				
		By firstName=By.xpath("//input[@name='name']");
		By email=By.xpath("//input[@id='email']");
		By password=By.xpath("//input[@id='password']");
		By interests=By.xpath("//label[normalize-space()='C#']");
		By genderMale=By.xpath("//label[text()='Male']");
		By state=By.xpath("//select[@id='state']");
		By hobbies=By.xpath("//select[@id='hobbies']");
		By signUp=By.xpath("//button[text()='Sign up']");
	    
		public signUpPage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		public boolean isSignUpStatus()
		{	
			boolean status=Utility.checkElementPresent(driver, signUp).isEnabled();			
			return status;
	   }
	
	public boolean newUser(String name, String mailId, String paswd, String genderSelect, String stateValue, String hobbyValue) 
	  {			
		Utility.typeOnElement(driver, firstName, name);
		Utility.typeOnElement(driver, email, mailId);
		Utility.typeOnElement(driver, password, paswd);
		Utility.clickElement(driver, interests);
		Utility.clickElement(driver, genderMale);
	    Utility.selectValueFromDropdown(driver, state, stateValue);
	    Utility.selectValueFromDropdown(driver, hobbies, hobbyValue);	    
	    
	    boolean signUpStatusPostUserCreation=this.isSignUpStatus();
	    Utility.waitForSeconds(2);
	    Utility.clickElement(driver, signUp);
	    
	    return signUpStatusPostUserCreation;
	  }
}