package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {
	
	public static ExtentReports extent;

public static ExtentReports getExtentReports()
{
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	
	reporter.config().setDocumentTitle("Test Results");
	reporter.config().setReportName("Web Automation Results");
	
	extent = new ExtentReports();
	
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Abhinay Kumar");
	
	return extent;
	
}

	
}
