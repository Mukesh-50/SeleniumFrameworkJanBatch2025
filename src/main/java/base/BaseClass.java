package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;

import dataprovider.ConfigUtility;
import factory.BrowserFactory;

public class BaseClass 
{
	public WebDriver driver;
	@Parameters("url")
	@BeforeClass
	public void setup(String url)
	{
		ChainTestListener.log("LOG:INFO - Setting up browser");
		
		driver=BrowserFactory.startBrowser(ConfigUtility.readProperty("Browser"), ConfigUtility.readProperty(url));
		
	}
	
	@AfterClass
	public void tearDown()
	{
		ChainTestListener.log("LOG:INFO - Closing the browser");
		 		
		driver.quit();
	}

}
