package testPolicyBazzar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

import pom.MyAccountProfilePage;
import pom.SignInPage;
import utility.Utility;

public class POL_TC_1233_ValidatingPolicyBazzarUserNamePropertyFile extends Base {
  
	SignInPage signIn;
	MyAccountProfilePage myAcc;
	String TC_ID = "POL_TC1233";
	
	@BeforeClass
	public void openPolicyBazzarApplication()
	{
//		ValidatingPolicyBazzarUserName v = new ValidatingPolicyBazzarUserName();
//		v.launchPolicyBazzar();
		launchPolicyBazzar();
		signIn = new SignInPage(driver);
		myAcc = new MyAccountProfilePage(driver);
		Utility.imlicitWait(driver, 1000);
	}
	@BeforeMethod
	public void signInToPolicyBazzar() throws EncryptedDocumentException, IOException, InterruptedException
	{    
		Utility.threadWait(500);
		signIn.clickOnSignInHomePage();
		Utility.imlicitWait(driver, 1000);
		signIn.enterMobileNumber(Utility.readDataFromPropertyFile("mobileNumber"));
		Utility.threadWait(1000);
		signIn.clickOnsignInWithPassword();
		Utility.threadWait(1000);
		signIn.enterPassword(Utility.readDataFromPropertyFile("password"));
		signIn.clickOnSignIn();
		Utility.imlicitWait(driver, 1500);
		signIn.clickOnMyAccount();
		Utility.threadWait(1000);
		signIn.clickOnMyProfile();
		Utility.imlicitWait(driver, 1500);
		
		//handle window
		
		Set<String> allWindowID = driver.getWindowHandles();
		List<String> li = new ArrayList<>(allWindowID);
		String profilePageID = li.get(1);	
		driver.switchTo().window(profilePageID);
	
	}
	

	@Test
  public void validatingUserName() throws EncryptedDocumentException, IOException {
		
		Assert.assertEquals(myAcc.getActualUserName(), Utility.readDataFromPropertyFile("username"),"TC is falied, Actual and Expected username are not matching");
	 
		Reporter.log("Actual and expected username are matching - TC is paased", true);
		Utility.takeScreenshot(driver, myAcc.getActualUserName()+"-"+TC_ID);
		
  }

 @AfterMethod
 public void logOutFromPolicyBazzar()
 {
	myAcc.clickOnLogOut();
	Reporter.log("Logging out from Policy Bazzar Application", true);
 }
 @AfterClass
 public void closingBrowser() throws InterruptedException
 {
     
	 closeBrowser();
 }
}
