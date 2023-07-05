package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.Utility;


public class Base {
	
	//browser and driver
	
	static protected  WebDriver driver;
	public void launchPolicyBazzar()
	{
		 driver = new ChromeDriver();
		 driver.get("https://www.policybazaar.com/");
		 driver.manage().window().maximize();
		 Reporter.log("Launching Policy Bazzar Appilcation", true);
	}
	
	public void launchingPolicyBazzarByPropertyFile() throws IOException
	{
		 driver = new ChromeDriver();
		 driver.get(Utility.readDataFromPropertyFile("url"));
		
		 driver.manage().window().maximize();
		 Reporter.log("Launching Policy Bazzar Appilcation", true);
	}
	
	public void closeBrowser()
	{	
		driver.quit();
	}

}
