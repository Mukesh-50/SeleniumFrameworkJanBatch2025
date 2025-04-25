package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class RegistrationPage {
	WebDriver driver;
	By name = By.id("name");
	By email = By.id("email");
	By password = By.id("password");
	//By interests = By.xpath("//label[text()='Java']");
	//By gender = By.id("gender2");
	By state = By.id("state");
	By hobbies = By.name("hobbies");
	By singUpLink = By.xpath("//button[text()='Sign up']");

	RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean sinnUpButtonStatusCheck()
	{
		return Utility.checkElementVisibility(driver, singUpLink).isEnabled();
	}
	public boolean registerNewUser(String username,String emailid, String userPass,String interest,String gender, String stateSelection, String hobbiesSelection)
	{
		Utility.typeOnElement(driver, name, username);
		Utility.typeOnElement(driver, email, emailid.split("@")[0]+System.currentTimeMillis()+"@"+emailid.split("@")[1]);
		Utility.typeOnElement(driver, password, userPass);
		Utility.clickElement(driver, By.xpath("//label[text()='"+interest+"']"));
		Utility.clickElement(driver, By.xpath("//input[@value='"+gender+"']"));
		Utility.selectValueFromDropdown(driver.findElement(state), stateSelection);
		Utility.selectValueFromDropdown(driver.findElement(hobbies),hobbiesSelection );
		boolean status = this.sinnUpButtonStatusCheck();
		Utility.clickElement(driver, singUpLink);
		return status;
		
	}

}
