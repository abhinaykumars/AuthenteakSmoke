package googlePackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReport;

public class Listeners extends Base implements ITestListener{

	ExtentReports extent = ExtentReport.getExtentReports();
	public ExtentTest test;
	//ThreadLocal class responsible to make all execution thread safe. And extentTest object will store test object now.
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();   
	
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName()+" Test is passed"); //logs to capture in report

		
	}

	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable()); //logs of error when test is failed
		
		String testMethodName= result.getMethod().getMethodName();
		WebDriver driver = null;
		
		//capture the driver. to get access to the field of any class. in this case driver is the field name
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
	
		} 
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshots(testMethodName,driver), testMethodName);
			//getScreenshots(testMethodName,driver) - this will return destPath path in above code
		}
		catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	
	

}
