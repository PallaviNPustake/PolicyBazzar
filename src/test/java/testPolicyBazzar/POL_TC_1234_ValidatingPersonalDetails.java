package testPolicyBazzar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom.MyAccountProfilePage;
import pom.SignInPage;
import utility.Utility;

//@Listeners(listener.Listener.class)
public class POL_TC_1234_ValidatingPersonalDetails extends Base {
  
	SignInPage signIn;
	MyAccountProfilePage myAcc;
	String TC_ID = "POL_TC_1234";
	
	@BeforeClass
	public void openPolicyBazzarApplication() throws InterruptedException, EncryptedDocumentException, IOException
	{
		launchPolicyBazzar();
		signIn = new SignInPage(driver);
		myAcc = new MyAccountProfilePage(driver);
		Utility.imlicitWait(driver, 1000);
		signIn.clickOnSignInHomePage();
		Utility.imlicitWait(driver, 1000);
		signIn.enterMobileNumber(Utility.excelData("Sheet3", 1, 0));
		Utility.threadWait(1000);
		signIn.clickOnsignInWithPassword();
		Utility.threadWait(1000);
		signIn.enterPassword(Utility.excelData("Sheet3", 1, 1));
		signIn.clickOnSignIn();
		Utility.imlicitWait(driver, 1500);
		signIn.clickOnMyAccount();
		Utility.threadWait(1000);
		signIn.clickOnMyProfile();
		Utility.imlicitWait(driver, 2000);
		
		//handle window
		
		Set<String> allWindowID = driver.getWindowHandles();
		List<String> li = new ArrayList<>(allWindowID);
		String profilePageID = li.get(1);	
		driver.switchTo().window(profilePageID);
	}
	
	@Test(priority = -1)
	  public void validatingProfilePageURL() throws EncryptedDocumentException, IOException {
			
		String expectedURL ="https://myaccount.policybazaar.com/profile";
		String actualURL= driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL,"TC is failed");
		Reporter.log("Actual and expected url are matching - TC is passed",true);
			
	  }
	
	@Test
       public void validatingUserName() throws EncryptedDocumentException, IOException {
		
		Assert.assertEquals(myAcc.getActualUserName(), Utility.excelData("Sheet3", 1, 2),"TC is falied, Actual and Expected username are not matching");
	 
		Reporter.log("Actual and expected username are matching - TC is Passed", true);
		Utility.takeScreenshot(driver, myAcc.getActualUserName()+"-"+TC_ID);
		
      }
	@Test(priority = 1)
	 public void validatingEmailID() throws EncryptedDocumentException, IOException
	 {
		String expEmailID = Utility.excelData("Sheet3", 1, 3);
		Assert.assertEquals(myAcc.getEmailID(), expEmailID,"Actual and expected email id are not matching - TC is failed");
		Reporter.log("Actual and expected EmailID's are matching - TC is passed", true);
		
	 }
	@Test
	public void validatingFemaleRadioSelection()
	{
		Assert.assertTrue(myAcc.femaleIsSelected(),"Value is false");
		Reporter.log("Female radio button is selected - TC is passed", true);
		
	}
	
	 @AfterClass
	 public void closingBrowser() throws InterruptedException
	 {
		 myAcc.clickOnLogOut();
		 Reporter.log("Logging out from Policy Bazzar Application", true);
		 closeBrowser();
	 }
}
