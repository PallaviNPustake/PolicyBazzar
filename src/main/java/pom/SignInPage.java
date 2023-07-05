package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SignInPage {
	//declaration

	
	@FindBy(linkText = "Sign in") private WebElement signInHomePageButton;
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobileNumberField;
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]") private WebElement signInWithPasswordButton;
    @FindBy(name = "password") private WebElement passwordField;
    @FindBy(xpath = "//span[text()='Sign in']") private WebElement signInButton;
    @FindBy(xpath = "//div[text()='My Account']") private WebElement myAccountButton;
    @FindBy(xpath = "//span[text()=' My profile ']") private WebElement myProfileButton;
    
    
    //intializing
    public SignInPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    //utilizing
     public void clickOnSignInHomePage()
     {
    	 signInHomePageButton.click();
    	 Reporter.log("Clicking on sign in home page", true);
     }
     
     public void enterMobileNumber(String mobNum )
     {
    	 mobileNumberField.sendKeys(mobNum);
    	 Reporter.log("Entering mobile number", true);
     }
     public void clickOnsignInWithPassword()
     {
    	 signInWithPasswordButton.click();
    	 Reporter.log("Clicking on sign in with password", true);
     }
    public void enterPassword(String pwd)
    {
    	passwordField.sendKeys(pwd);
    	Reporter.log("Entering password", true);
    }
    public void clickOnSignIn()
    {
    	signInButton.click();
    	Reporter.log("Clicking on sign in", true);
    }
    public void clickOnMyAccount()
    {
    	myAccountButton.click();
    	Reporter.log("Clicking on my account", true);
    }
    public void clickOnMyProfile()
    {
    	myProfileButton.click();
    	Reporter.log("Clicking on my profile", true);
    }
}
