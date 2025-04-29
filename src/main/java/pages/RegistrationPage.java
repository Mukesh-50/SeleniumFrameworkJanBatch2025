package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class RegistrationPage 
{
	 WebDriver driver;
	
	By name=By.id("name");
	By email=By.id("email");
	By password=By.id("password");	
	// By interests=By.xpath("//label[text()='Java']");
	//By gender= By.id("gender2");
	By state=By.id("state");
	By hobbies=By.name("hobbies");
	By signUpLink=By.xpath("//button[text()='Sign up']"); // //button[normalize-space()='Sign up']

	
	RegistrationPage(WebDriver driver)
	{
	this.driver=driver;	
	}

	public boolean signUpButtonStatusCheck() 
	{
	return Utility.checkElementVisibility(driver, signUpLink).isEnabled();
	}
	public boolean registerNewuser(String UserName,String emailid,String UserPassword,String interest,String gender ,String SelectState,String SelectHobbies ) 
	{
	 Utility.typeOnElement(driver, name,UserName);
	 //Utility.typeOnElement(driver, email, emailid);
	 Utility.typeOnElement(driver, email,emailid.split("@")[0]+System.currentTimeMillis()+"@gmail.com");
	 Utility.typeOnElement(driver, password,UserPassword);
	 
	 Utility.clickElement(driver, By.xpath("//label[text()='"+interest+"']"));
	 Utility.clickElement(driver, By.xpath("//input[@value='"+gender+"']"));
	 
	 Utility.selectValueFromDropdown(driver.findElement(state),SelectState);
	 Utility.selectValueFromDropdown(driver.findElement(hobbies),SelectHobbies);
	boolean status= this.signUpButtonStatusCheck();
	Utility.clickElement(driver, signUpLink);
	 return status;
	}
	
}
