package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import net.bytebuddy.utility.RandomString;
public class Utility {
	
	//common methods
	//wait
	//screenshot
	//excelsheet
	//scrollIntoView
	
	//implicit wait
	public static void imlicitWait(WebDriver driver, long waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Waiting for complete load page, wait time-"+waitTime, true);
	}
	
	//thread wait
	
	public static void threadWait(long waitTime) throws InterruptedException
	{
		Thread.sleep(waitTime);
		Reporter.log("Waiting for,wait time-"+waitTime, true);
	}
	
	//screenshot
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException
	{
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String str = RandomString.make(2);
	    File dest = new File("C:\\Users\\palla\\EclipseWorksapce\\PolicyBazzarProject\\screenshots\\"+fileName+"-"+str+".png");            
	    
	    FileHandler.copy(src, dest);
	    Reporter.log("Taking screenshot and stored at-"+dest, true);
	}
	
	//scrollIntoVIew
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	//fetch data from excel
	
	public static String excelData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile = new FileInputStream("C:\\Users\\palla\\OneDrive\\Documents\\Automation\\ExcelSheet\\EmployeeData.xlsx");
		String data = WorkbookFactory.create(myFile).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		Reporter.log("Reading data from excel row number-"+rowNum+", cell number-"+cellNum, true);
		return data;	
	}
	
	//reading data from property file	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//creating object of properties class
		Properties prop= new Properties();
		//creating object of FileInputStream file
		FileInputStream myFile = new FileInputStream("C:\\Users\\palla\\EclipseWorksapce\\PolicyBazzarProject\\testData.properties");
		//loading prop file to fileinputstream	
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("Reading data from property file, Key-"+key+"And Value-"+value, true);
		return value;
	}
}
