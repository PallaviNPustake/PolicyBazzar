package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.Base;
import utility.Utility;

public class Listener extends Base implements ITestListener {
	
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" Execution started", true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			Utility.takeScreenshot(driver, result.getName() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Reporter.log(result.getName()+" is failed, Please check and try again", true);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" is skipped because of dependent method, please check", true);
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log(result.getName()+" is failed because of timeout", true);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" is successfully executed", true);
	}
	
	

}
