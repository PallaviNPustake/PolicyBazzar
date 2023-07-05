package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountProfilePage {
	
	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement userName;
	@FindBy(className = "h_l") private WebElement logOutButton;
	@FindBy(xpath = "//input[@name=\"email\"]") private WebElement emailIdField;
	//
	public MyAccountProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilizing
	
	
	public String getActualUserName()
	{
		String actualUN = userName.getText();
		return actualUN;
	}
	public String getEmailID()
	{
		String actualEmailID = emailIdField.getAttribute("value");
		return actualEmailID;
	}
	public void clickOnLogOut()
	{
		logOutButton.click();
	}

}
